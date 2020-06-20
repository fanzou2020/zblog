package com.fan.zblog.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * Tag
 * @author 
 */
@Data
@ToString
@EqualsAndHashCode
public class Tag implements Serializable {
    @NotBlank
    private String tag;

    @NotBlank
    private String username;

    private List<Blog> blogs;

    private static final long serialVersionUID = 1L;

    public Tag(@NotBlank String tag, @NotBlank String username) {
        this.tag = tag;
        this.username = username;
    }

    public Tag() {
    }
}