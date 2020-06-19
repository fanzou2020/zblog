package com.fan.zblog.model;

import java.io.Serializable;
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

    private static final long serialVersionUID = 1L;
}