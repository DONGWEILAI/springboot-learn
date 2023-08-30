package com.dylan.redis.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @Author Dylan
 * @Date 2023/8/29
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserVO implements Serializable {
    private String id;
    private String name;
    private Integer age;
}
