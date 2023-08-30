package com.dylan.maven.common.util;

import java.util.UUID;

/**
 * @Author Dylan
 * @Date 2023/8/29
 */
public class UUIDUtil {
    public static String generateUUID32(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
