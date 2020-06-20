package com.fan.zblog.mapper;

import com.fan.zblog.model.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {

    /**
     * Delete a tag, given a tag object.
     * @param tag
     * @return
     */
    int deleteByPrimaryKey(Tag tag);

    /**
     * Insert a tag into database
     * @param record
     * @return
     */
    int insert(Tag record);

    /**
     * Select a tag as well as the blogs associated with it
     * @param record
     * @return
     */
    Tag selectTag(Tag record);


    // update tag value
    int updateTag(Tag newTag, Tag oldTag);

    List<Tag> findTagsByUsername(String username);


}