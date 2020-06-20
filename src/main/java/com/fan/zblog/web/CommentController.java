package com.fan.zblog.web;

import com.fan.zblog.mapper.CommentMapper;
import com.fan.zblog.model.Comment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/comments", produces = "application/json")
@CrossOrigin(origins = "*")
public class CommentController {

    @Autowired private CommentMapper commentMapper;

    // get the comments of a blog
    @GetMapping(path = "/{blogId}")
    public ResponseEntity<List<Comment>> findCommentsByBlogId (@PathVariable String blogId) {
        Long bId = Long.parseLong(blogId);
        List<Comment> comments = commentMapper.findCommentsByBlogId(bId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    // get a comments by commentId
    @GetMapping(path = "/{blogId}/{commentId}")
    public ResponseEntity<Comment> findCommentById(@PathVariable String commentId, @PathVariable String blogId) {
        Long cId = Long.parseLong(commentId);
        Comment comment = commentMapper.selectByPrimaryKey(cId);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    // post a comment to a blog
    @PostMapping(path = "/{blogId}", consumes = "application/json")
    public ResponseEntity<Boolean> postComment(@PathVariable String blogId, @RequestBody Comment comment) {
        Long bId = Long.parseLong(blogId);
        if (!comment.getBlogId().equals(bId)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        int r = commentMapper.insert(comment);
        if (r == 1) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // put a comment
    @PutMapping(path = "/{blogId}/{commentId}", consumes = "application/json")
    public ResponseEntity<Boolean> putComment(@PathVariable String commentId, @RequestBody Comment comment) {
        Long cId = Long.parseLong(commentId);
        if (!comment.getCommentId().equals(cId)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        int r = commentMapper.updateByPrimaryKey(comment);
        if (r == 1) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // patch a comment
    @PatchMapping(path = "/{blogId}/{commentId}", consumes = "application/json")
    public ResponseEntity<Boolean> patchComment(@PathVariable String commentId, @RequestBody Comment comment) {
        Long cId = Long.parseLong(commentId);
        if (!comment.getCommentId().equals(cId)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        int r = commentMapper.updateByPrimaryKeySelective(comment);
        if (r == 1) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // delete a comment
    @DeleteMapping(path = "/{blogId}/{commentId}")
    public ResponseEntity<Boolean> deleteComment(@PathVariable String commentId) {
        Long cId = Long.parseLong(commentId);
        int r = commentMapper.deleteByPrimaryKey(cId);
        if (r == 1) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
