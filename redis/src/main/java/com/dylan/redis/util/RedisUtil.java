package com.dylan.redis.util;

/**
 * @Author Dylan
 * @Date 2023/8/29
 */
public class RedisUtil {
    public static String getKeyNameWithColumn(String tableName, String PKName, String PKValue, String ColumnName) {
        return new StringBuffer()
                .append(tableName).append(":")
                .append(PKName).append(":")
                .append(PKValue).append(":")
                .append(ColumnName).toString();
    }

    public static String getKeyName(String tableName, String PKName, String PKValue) {
        return new StringBuffer()
                .append(tableName).append(":")
                .append(PKName).append(":")
                .append(PKValue).toString();
    }
}
