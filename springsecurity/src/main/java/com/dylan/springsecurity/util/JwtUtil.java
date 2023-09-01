package com.dylan.springsecurity.util;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

/**
 * @Author Dylan
 * @Date 2023/8/31
 */
public class JwtUtil {
    public static final Long EXPIRATION = 60 * 1000L;
    public static final String secret = "askndksnad5rewg49ewr516sd51f6s5d1f84s65df6584ewf439823n";

    public static String jwtGenerator(String uid){

        return Jwts.builder()
                // jwt的标识id
                .setId(UUID.randomUUID().toString())
                // 签发者
                .setIssuer("签发者")
                // 接受者
                .setAudience("接受者")
                // 主体内容
                .setSubject(uid)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                // 过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                // 盐和算法
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public static String jwtParser(String token, String secret){
        Claims body = Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody();
        Date expiration = body.getExpiration();
        if(expiration.before(new Date())){
            throw new RuntimeException("JWT过期");
        }
        return body.getSubject();
    }
}
