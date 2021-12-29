package chmin9lewis.project.wakelni.Security;

import java.util.Date;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {

	
	private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
	
	public JwtProvider() {
		super();
	}

	public String generateJwtToken(Authentication authentication) {
		
		// Grab principal
		MyUserDetails userPrincipal = (MyUserDetails) authentication.getPrincipal(); 
		
		// Create JWT Token
		return Jwts.builder()
				.setSubject(userPrincipal.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, JwtProperties.SECRET)
				.compact()
				;
	}
	
	 public String getUserNameFromJwtToken(String token) {
	        return Jwts.parser()
	                .setSigningKey(JwtProperties.SECRET)
	                .parseClaimsJws(token)
	                .getBody().getSubject();
	}
	
	public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JwtProperties.SECRET).parseClaimsJws(authToken);
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
