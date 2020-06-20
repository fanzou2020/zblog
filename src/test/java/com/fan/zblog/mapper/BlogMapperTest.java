package com.fan.zblog.mapper;

import com.fan.zblog.model.Blog;
import com.fan.zblog.model.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BlogMapperTest {

    @Autowired BlogMapper blogMapper;

    @Test
    void deleteByPrimaryKey() {
        Long id = 1L;
        int r = blogMapper.deleteByPrimaryKey(id);
        assertEquals(1, r);
    }

    @Test
    void insert() {
        Blog blog = new Blog();
        blog.setUsername("root");
        blog.setTitle("Test2");
        blog.setCategory("test2");
        blog.setSummary("test2");
        blog.setContent("test2");
        blog.setCreateTime(new Date());
        blog.setModifyTime(new Date());
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag("C++", "zoufan"));
        tags.add(new Tag("Java", "zoufan"));
        blog.setTags(tags);
        int r = blogMapper.insert(blog);
        assertEquals(1, r);
    }

    @Test
    void insertSelective() {
        Blog blog = new Blog();
        blog.setUsername("root");
        blog.setTitle("Test2");
        blog.setContent("test2");
        int r = blogMapper.insert(blog);
        assertEquals(1, r);
    }

    @Test
    void selectByPrimaryKey() {
        Blog blog = blogMapper.selectByPrimaryKey(1L);
//        assertEquals("zoufan", blog.getUsername());
        assertEquals(2, blog.getTags().size());
    }

    @Test
    void updateByPrimaryKeySelective() {
        Blog blog = new Blog();
        blog.setBlogId(1L);
        blog.setUsername("root");
        int r = blogMapper.updateByPrimaryKeySelective(blog);
        assertEquals(1, r);
    }

    @Test
    void updateByPrimaryKey() {
        Blog blog = new Blog();
        blog.setBlogId(1L);
        blog.setUsername("root");
        blog.setTitle("Test2");
        blog.setContent("test2");
        int r = blogMapper.updateByPrimaryKey(blog);
        assertEquals(1, r);
    }

    @Test
    void findAll() {
        List<Blog> blogs = blogMapper.findAll();
        assertEquals(2, blogs.size());
    }
}