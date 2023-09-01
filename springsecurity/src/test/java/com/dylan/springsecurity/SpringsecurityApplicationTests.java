package com.dylan.springsecurity;

import com.dylan.springsecurity.data.User;
import com.dylan.springsecurity.util.JwtUtil;
import io.jsonwebtoken.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;

@SpringBootTest
class SpringsecurityApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void jwtGenerate() {
        Date expirationDate = new Date(System.currentTimeMillis() + 30000);
        String secret = "askndksnad5rewg49ewr516sd51f6s5d1f84s65df6584ewf439823n";
        HashMap<String, Object> map = new HashMap<>();
        map.put("role", "ROLE_ADMIN");

        String token = Jwts.builder()
                // jwt的标识id
                .setId("Id")
                // 签发者
                .setIssuer("签发者")
                // 接受者
                .setAudience("接受者")
                // 主体内容
                .setSubject("Subject")
                .setClaims(map)
                .claim("age", 18)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                // 过期时间
                .setExpiration(expirationDate)
                // 盐和算法
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

        System.out.println(token);
        jwtParse(token, secret);
    }

    @Test
    void jwtParse(String token, String secret) {
        JwtParser build = Jwts.parserBuilder()
                .setSigningKey(secret)
                .build();

        Claims body = build.parseClaimsJws(token).getBody();
        System.out.println(body);
        System.out.println(body.getId());
        System.out.println(body.getIssuer());
        System.out.println(body.getAudience());
        System.out.println(body.getExpiration());
        System.out.println(body.getIssuedAt());
        System.out.println(body.getSubject());
        System.out.println(body.get("role"));
        System.out.println(body.get("age"));

        // 验证是否过期
        Date expiration = body.getExpiration();
        System.out.println(!expiration.after(new Date()));
    }

    @Test
    void test(){
        String token = JwtUtil.jwtGenerator("123");
        String uid = JwtUtil.jwtParser(token, JwtUtil.secret);
        System.out.println(uid);
    }

    @Test
    void test1() throws IOException {
        String filePath = "D:\\temp\\a.txt";
        User user = new User(1001L, "Joe");
        FileOutputStream fos = new FileOutputStream(filePath);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(user);
        oos.close();
    }

    @Test
    void test2() throws IOException, ClassNotFoundException {
        String filePath = "D:\\temp\\a.txt";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        Object o = ois.readObject();
        System.out.println(o);
    }


}
