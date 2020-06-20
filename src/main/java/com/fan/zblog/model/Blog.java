package com.fan.zblog.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * Blog
 * @author Fan Zou
 */
@Data
@ToString
@EqualsAndHashCode
public class Blog implements Serializable {
    private Long blogId;

    @NotBlank
    private String username;

    @NotBlank
    private String title;

    private String category;

    private String summary;

    @NotBlank
    private String content;

    private Date createTime;

    private Date modifyTime;

    private List<Tag> tags;

    private static final long serialVersionUID = 1L;
}