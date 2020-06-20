package com.fan.zblog.mapper;

import com.fan.zblog.model.Blog;
import com.fan.zblog.model.BlogTagKey;
import com.fan.zblog.model.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;

import java.util.List;

@Mapper
public interface BlogTagMapper {
    /**
     * Delete a blog's tag
     * @param key
     * @return
     */
    int deleteByPrimaryKey(BlogTagKey key);

    /**
     * Insert a blog's tag
     * @param record
     * @return
     */
    int insert(BlogTagKey record);

    int insertSelective(BlogTagKey record);

    /**
     * Get Tags by blogId
     * @param blogId
     * @return A list of Tags
     */
    List<Tag> getTagsByBlogId(Long blogId);

    /**
     * Get Blogs by Tag
     * @param tag
     * @return A list of Blogs
     */
    List<Blog> getBlogsByTag(Tag tag);
}