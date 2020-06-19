package com.fan.zblog.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Comment
 * @author 
 */
@Data
@ToString
@EqualsAndHashCode
public class Comment implements Serializable {

    private Long commentId;

    @NotNull
    private Long blogId;

    @NotBlank
    private String username;

    @NotBlank
    private String content;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}