package firas.karbich.com.wakalni.ApisInterfaces;

import firas.karbich.com.wakalni.POJO.Auth.JwtResponse;
import firas.karbich.com.wakalni.POJO.Auth.LoginViewModel;
import firas.karbich.com.wakalni.POJO.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthInterface {

    @POST("api/auth/login")
    public Call<JwtResponse> authenticate(@Body LoginViewModel credentials);

    @POST("api/auth/register")
    public Call<User> register(@Body User user);
}
