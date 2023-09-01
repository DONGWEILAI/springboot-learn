package com.dylan.springsecurity.data;

import lombok.*;

import java.io.Serializable;

/**
 * @Author Dylan
 * @Date 2023/8/31
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User implements Serializable{

    private Long id;
    /**
     * 用户名
     */
    private String userName;
}
