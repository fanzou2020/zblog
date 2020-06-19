package com.fan.zblog.model;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.*;

/**
 * User
 * @author Fan Zou
 */
@Data
@ToString
@EqualsAndHashCode
public class User implements Serializable {

    @NotBlank(message="username is required")
    private String username;

    @NotBlank(message="email is required")
    private String email;

    @NotBlank
    private String password;

    private Date createTime;

    private String image;

    private String nickname;

    private String description;

    private static final long serialVersionUID = 1L;

}