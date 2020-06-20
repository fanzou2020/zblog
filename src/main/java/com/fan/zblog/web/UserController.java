package com.fan.zblog.web;

import com.fan.zblog.mapper.UserMapper;
import com.fan.zblog.model.User;
import lombok.experimental.PackagePrivate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/users", produces = "application/json")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    /**
     * @return List of all users
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userMapper.findAll();
        log.info(String.valueOf(users));
        if (users != null) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
        User user = userMapper.selectByPrimaryKey(username);
        log.info(String.valueOf(user));
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<User> postUser(@RequestBody User user) {
        user.setCreateTime(new Date());
        int r = userMapper.insert(user);
        if (r == 1) {
            user = userMapper.selectByPrimaryKey(user.getUsername());
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping(path = "/{username}", consumes = "application/json")
    public ResponseEntity<User> putUser(@RequestBody User user, @PathVariable("username") String username) {
        if (!username.equals(user.getUsername())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        user.setCreateTime(new Date());
        int r = userMapper.updateByPrimaryKey(user);
        if (r == 1) {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PatchMapping(path = "/{username}", consumes = "application/json")
    public ResponseEntity<User> patchUser(@RequestBody User user, @PathVariable("username") String username) {
        if (!username.equals(user.getUsername())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        user.setCreateTime(new Date());
        int r = userMapper.updateByPrimaryKeySelective(user);
        if (r == 1) {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping(path = "/{username}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("username") String username) {
        int r = userMapper.deleteByPrimaryKey(username);
        if (r == 1) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
