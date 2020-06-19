package com.fan.zblog.mapper;

import com.fan.zblog.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserMapperTest {

    @Autowired private UserMapper userMapper;

    @Test
    void deleteByPrimaryKey() {
         int r = userMapper.deleteByPrimaryKey("jack");
         assertEquals(1, r);
    }

    @Test
    void insert() {
        User record = new User();
        record.setUsername("test1");
        record.setEmail("aaa");
        record.setPassword("aaa");
        record.setCreateTime(new Date());
        record.setImage("aaa");
        record.setNickname("aaa");
        record.setDescription("aaa");
        int r = userMapper.insert(record);
        assertEquals(1, r);
    }

    @Test
    void insertSelective() {
        User record = new User();
        record.setUsername("test2");
        record.setEmail("bbb");
        record.setPassword("bbb");
        int r = userMapper.insertSelective(record);
        assertEquals(1, r);
    }

    @Test
    void selectByPrimaryKey() {
        User record = userMapper.selectByPrimaryKey("zoufan");
        assertEquals("Fan Zou", record.getNickname());
    }

    @Test
    void updateByPrimaryKeySelective() {
        User record = new User();
        record.setUsername("zoufan");
        record.setEmail("zf@icloud.com");
        int r = userMapper.updateByPrimaryKeySelective(record);
        assertEquals(1, r);
    }

    @Test
    void updateByPrimaryKey() {
        User record = new User();
        record.setUsername("zoufan");
        record.setEmail("aaa");
        record.setPassword("aaa");
        record.setCreateTime(new Date());
        record.setImage("aaa");
        record.setNickname("aaa");
        record.setDescription("aaa");
        int r = userMapper.updateByPrimaryKey(record);
        assertEquals(1, r);
    }

    @Test
    void findAll() {
        List<User> users = userMapper.findAll();
        assertEquals(5, users.size());
    }
}