package chmin9lewis.Restaurants.feane.Security;

public class JwtProperties {

	public static final String SECRET = "chmin9lewesSecret";
    public static final int EXPIRATION_TIME = 1728000000;// 20 days : 1728000000 ; // 10 days = 864000000
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
	
}
