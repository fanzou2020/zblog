package com.fan.zblog.mapper;

import com.fan.zblog.model.Tag;

public interface TagMapper {
    int deleteByPrimaryKey(Tag tag);

    int insert(Tag record);


}