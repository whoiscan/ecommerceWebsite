package uz.pdp.ecommersapp.security;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import uz.pdp.ecommersapp.entity.User;

import java.util.Date;

@Component
public class JwtProvider {

//    private String mySecretKey="JWTSuperSecretKey";
//
//
//private int expDate=604800000;
@Value("app.jwtSecret")
private String mySecretKey;

@Value("${app.jwtExpirationInMs}")
    private Long expDate;
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    public String generateJwtToken(Authentication authentication) {

        User userPrincipal = (User) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + expDate))
                .signWith(SignatureAlgorithm.HS512, mySecretKey)   .compact();
    }
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(mySecretKey)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(mySecretKey).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature -> Message: {} ", e);
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: {}", e);
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message: {}", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Message: {}", e);
        }

        return false;
    }
}
