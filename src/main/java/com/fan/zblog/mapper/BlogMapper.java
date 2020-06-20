package com.fan.zblog.mapper;

import com.fan.zblog.model.Blog;
import com.fan.zblog.model.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {
    /**
     * Delete blog by blogId, as well as its tag
     * @param blogId
     * @return 1 if success, 0 if failed
     */
    int deleteByPrimaryKey(Long blogId);

    /**
     * Insert a blog into database
     * @param record
     * @return 1 if success, 0 if failed
     */
    int insert(Blog record);

    /**
     * Insert selective a blog to database
     * @param record
     * @return 1 if success, 0 if failed
     */
    int insertSelective(Blog record);

    /**
     * Select a blog with blogId,
     * @param blogId
     * @return Blog instance also contains a List of Tags.
     */
    Blog selectByPrimaryKey(Long blogId);

    /**
     * Update blog information selective
     * @param record
     * @return 1 if success, 0 if failed
     */
    int updateByPrimaryKeySelective(Blog record);

    /**
     * Update blog information, provide full information of a blog
     * @param record
     * @return 1 if success, 0 if failed
     */
    int updateByPrimaryKey(Blog record);


    /**
     * Find all blogs
     * @return
     */
    List<Blog> findAll();


    /**
     * Find blogs by category
     * @param category
     * @return
     */
    List<Blog> findBlogsByCategory(String category);

    List<Tag> getTagsByBlogId(Long blogId);  // helper function

    List<Blog> findBlogsByUsername(String username);

    List<Blog> findBlogsByUsernameAndCategory(String username, String category);

    Blog findBlogByUsernameAndBlogId(String username, Long blogId);



}