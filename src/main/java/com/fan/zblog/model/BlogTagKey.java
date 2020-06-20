package com.fan.zblog.model;

import java.io.Serializable;
import lombok.Data;

/**
 * Blog_Tag
 * @author 
 */
@Data
public class BlogTagKey implements Serializable {
    private Long blogId;

    private String username;

    private String tag;

    private static final long serialVersionUID = 1L;
}