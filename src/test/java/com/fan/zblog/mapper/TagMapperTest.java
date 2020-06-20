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
class TagMapperTest {
    @Autowired TagMapper tagMapper;

    @Test
    void deleteByPrimaryKey() {
        Tag tag = new Tag();
        tag.setTag("C++");
        tag.setUsername("zoufan");
        int r = tagMapper.deleteByPrimaryKey(tag);
        assertEquals(1,r);
    }

    @Test
    void insert() {
        Tag tag = new Tag();
        tag.setTag("Java");
        tag.setUsername("zoufan");
        int r = tagMapper.insert(tag);
        assertEquals(1, r);

    }

    @Test
    void selectTag() {
        Tag tag = new Tag("Java", "zoufan");
        Tag r = tagMapper.selectTag(tag);
        assertEquals(2, r.getBlogs().size());
    }

    @Test
    void updateTag() {
        Tag old = new Tag("C++", "zoufan");
        Tag newTag = new Tag("C", "zoufan");
        int r = tagMapper.updateTag(newTag, old);
        assertEquals(1, r);
    }

}