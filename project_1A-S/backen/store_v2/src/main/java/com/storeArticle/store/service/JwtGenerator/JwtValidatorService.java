package com.storeArticle.store.service.JwtGenerator;

import com.storeArticle.store.model.accounts.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@Repository
public class JwtValidatorService {


    private String secret = "tienda";

    public User validate(String token) {

        User jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new User();
            jwtUser.setUserID((Integer)body.get("userID"));
            jwtUser.setFirtNameUser((String)body.get("firtNameUser"));
            jwtUser.setLastNameUser((String)body.get("lastNameUser"));
            jwtUser.setEmailUser((String)body.get("emailUser"));
            jwtUser.setImagenUser((String)body.get("imagenUser"));
            jwtUser.setTokenUser(token);
            jwtUser.setCodeUser((String)body.get("codeUser"));
        }
        catch (Exception e) {
            jwtUser= new User();
        }

        return jwtUser;
    }
}
