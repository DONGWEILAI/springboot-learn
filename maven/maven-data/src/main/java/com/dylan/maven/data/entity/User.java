package com.dylan.maven.data.entity;

import lombok.*;

/**
 * @Author Dylan
 * @Date 2023/8/29
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String kid;
    private String username;
    private String password;
    private Integer gender;
    private Long createTime;
    private Integer deleted;
}
