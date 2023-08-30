package com.dylan.maven.server.basic.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @Author Dylan
 * @Date 2023/8/26
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    private String id;
    private int number;
}
