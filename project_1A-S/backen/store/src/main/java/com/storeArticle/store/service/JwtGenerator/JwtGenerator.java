package com.storeArticle.store.service.JwtGenerator;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import com.storeArticle.store.model.accounts.User;
@Component
public class JwtGenerator {


    public String generate(User user) {


        Claims claims = Jwts.claims()
                .setSubject(user.getFirtNameUser());
        claims.put("password", String.valueOf(user.getPassword()));

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "tienda")
                .compact();
    }
}
