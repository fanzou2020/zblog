package com.fan.zblog.mapper;

import com.fan.zblog.model.Comment;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CommentMapperTest {

    @Autowired CommentMapper commentMapper;

    @Test
    void deleteByPrimaryKey() {
        Long id = 1L;
        int r = commentMapper.deleteByPrimaryKey(id);
        assertEquals(1, r);
    }

    @Test
    void insert() {
        Comment record = new Comment();
        record.setBlogId(1L);
        record.setCommentId(2L);
        record.setContent("Perfect");
        record.setCreateTime(new Date());
        int r = commentMapper.insert(record);
        assertEquals(1, r);
    }

    @Test
    void insertSelective() {
        Comment record = new Comment();
        record.setBlogId(1L);
        record.setCommentId(2L);
        record.setContent("Perfect");
        int r = commentMapper.insert(record);
        assertEquals(1, r);
    }

    @Test
    void selectByPrimaryKey() {
        Comment record = commentMapper.selectByPrimaryKey(1L);
        assertEquals(record.getBlogId(), 1);
    }

    @Test
    void updateByPrimaryKeySelective() {
        Comment record = new Comment();
        record.setBlogId(1L);
        record.setCommentId(1L);
        int r = commentMapper.updateByPrimaryKeySelective(record);
        assertEquals(1, r);
    }

    @Test
    void updateByPrimaryKey() {
        Comment record = new Comment();
        record.setBlogId(1L);
        record.setCommentId(1L);
        record.setContent("very good");
        int r = commentMapper.updateByPrimaryKey(record);
        assertEquals(1, r);
    }
}