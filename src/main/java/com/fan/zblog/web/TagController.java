package com.fan.zblog.web;

import com.fan.zblog.mapper.TagMapper;
import com.fan.zblog.model.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/tags", produces = "application/json")
@CrossOrigin(origins = "*")
public class TagController {

    @Autowired private TagMapper tagMapper;

    // find tags by username
    @GetMapping(path = "/{username}")
    public ResponseEntity<List<Tag>> findTagsByUsername(@PathVariable String username) {
        List<Tag> tags = tagMapper.findTagsByUsername(username);
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    // post a new tag for a user
    @PostMapping(path = "/{username}", consumes = "application/json")
    public ResponseEntity<Boolean> postTag(@PathVariable String username, @RequestBody Tag tag) {
        if (!username.equals(tag.getUsername())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        int r = tagMapper.insert(tag);
        if (r == 1) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    // update a tag
    @PutMapping(path = "/{username}/{tag}", consumes = "application/json")
    public ResponseEntity<Boolean> putTag(@PathVariable String username, @PathVariable("tag") String oldTag,
                                          @RequestBody Tag newT) {
        Tag oldT = new Tag(oldTag, username);
        int r = tagMapper.updateTag(newT, oldT);
        if (r == 1) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // delete a tag
    @DeleteMapping(path = "/{username}/{tag}")
    public ResponseEntity<Boolean> deleteTag(@PathVariable String username, @PathVariable String tag) {
        Tag t = new Tag(tag, username);
        int r = tagMapper.deleteByPrimaryKey(t);
        if (r == 1) return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
