
package com.storeArticle.store.service.JwtGenerator;


import com.storeArticle.store.service.accounts.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.storeArticle.store.model.accounts.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@Repository
public class JwtGeneratorService {

    public String generate(User user) {
        Claims claims = Jwts.claims()
                .setSubject(user.getFirtNameUser());
        claims.put("userID", user.getUserID());
        claims.put("firtNameUser", user.getFirtNameUser());
        claims.put("lastNameUser", user.getLastNameUser());
        claims.put("emailUser", user.getEmailUser());
        claims.put("tokenUser", user.getTokenUser());
        claims.put("codeUser", user.getCodeUser());
        claims.put("imagenUser", user.getImagenUser());
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "tienda")
                .compact();
    }

}

