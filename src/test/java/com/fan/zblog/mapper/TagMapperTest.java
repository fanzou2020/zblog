package com.fan.zblog.mapper;

import com.fan.zblog.model.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

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

}