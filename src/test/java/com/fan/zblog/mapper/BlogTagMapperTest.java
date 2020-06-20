package com.fan.zblog.mapper;

import com.fan.zblog.model.Blog;
import com.fan.zblog.model.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BlogTagMapperTest {
    @Autowired BlogTagMapper blogTagMapper;

    @Test
    void getTagsByBlogId() {
        List<Tag> tagList = blogTagMapper.getTagsByBlogId(1L);
        assertEquals(2, tagList.size());
    }

    @Test
    void getBlogsByTag() {
        List<Blog> blogs = blogTagMapper.getBlogsByTag(new Tag("Java", "zoufan"));
        assertEquals(2, blogs.size());
    }
}