package com.fan.zblog.web;

import com.fan.zblog.mapper.BlogMapper;
import com.fan.zblog.mapper.BlogTagMapper;
import com.fan.zblog.model.Blog;
import com.fan.zblog.model.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/blogs", produces = "application/json")
@CrossOrigin(origins = "*")
public class BlogController {

    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private BlogTagMapper blogTagMapper;


    // get all blogs
    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = blogMapper.findAll();
        if (blogs != null) {
            return new ResponseEntity<>(blogs, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    // post blog under username
    @PostMapping(path = "/{username}", consumes = "application/json")
    public ResponseEntity<Boolean> postBlog(@RequestBody Blog blog, @PathVariable("username") String username) {
        if (!username.equals(blog.getUsername())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        int r = blogMapper.insertSelective(blog);
        if (r == 1) {
            blog = blogMapper.selectByPrimaryKey(blog.getBlogId());
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // put blog under username and blogId
    @PutMapping(path = "/{username}/{blogId}", consumes = "application/json")
    public ResponseEntity<Boolean> putBlog(@RequestBody Blog blog, @PathVariable("username") String username,
                                        @PathVariable("blogId") Long blogId) {
        if (!(blog.getBlogId().equals(blogId) && blog.getUsername().equals(username))) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        int r = blogMapper.updateByPrimaryKey(blog);
        if (r == 1) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    // patch blog under username and blogId
    @PatchMapping(path = "/{username}/{blogId}", consumes = "application/json")
    public ResponseEntity<Boolean> patchBlog(@RequestBody Blog blog, @PathVariable("username") String username,
                                        @PathVariable("blogId") Long blogId) {
        if (!(blog.getBlogId().equals(blogId) && blog.getUsername().equals(username))) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        int r = blogMapper.updateByPrimaryKeySelective(blog);
        if (r == 1) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // delete blog under username and blogId
    @DeleteMapping(path = "/{username}/{blogId}")
    public ResponseEntity<Boolean> deleteBlog(@PathVariable("username") String username,
                                              @PathVariable("blogId") Long blogId) {
        int r = blogMapper.deleteByPrimaryKey(blogId);
        if (r == 1) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Different different select patterns
    // get blog under username and category
    @GetMapping(path = "/{username}/category/{category}")
    public ResponseEntity<List<Blog>> getBlogsByUsernameAndCategory(@PathVariable("username") String username,
                                                                    @PathVariable("category") String category) {
        List<Blog> blogs = blogMapper.findBlogsByUsernameAndCategory(username, category);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    // get blog under username
    @GetMapping(path = "/{username}")
    public ResponseEntity<List<Blog>> getBlogsByUsername(@PathVariable("username") String username) {
        List<Blog> blogs = blogMapper.findBlogsByUsername(username);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    // get blog under username and tag
    @GetMapping(path = "/{username}/tag/{tagName}")
    public ResponseEntity<List<Blog>> getBlogsByUsernameAndTag(@PathVariable("username") String username,
                                                               @PathVariable("tagName") String tagName) {
        Tag tag = new Tag(tagName, username);
        List<Blog> blogs = blogTagMapper.getBlogsByTag(tag);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    // get blog under username and blogId
    @GetMapping(path = "/{username}/{blogId}")
    public ResponseEntity<Blog> getBlogByBlogId(@PathVariable String username, @PathVariable String blogId) {
        Long id = Long.parseLong(blogId);
        Blog blog = blogMapper.findBlogByUsernameAndBlogId(username, id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

}
