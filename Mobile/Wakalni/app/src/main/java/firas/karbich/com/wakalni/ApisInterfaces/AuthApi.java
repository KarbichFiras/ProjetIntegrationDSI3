package firas.karbich.com.wakalni.ApisInterfaces;

import firas.karbich.com.wakalni.Models.Auth.JwtResponse;
import firas.karbich.com.wakalni.Models.Auth.LoginViewModel;
import firas.karbich.com.wakalni.Models.UserModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthApi {

    @POST("api/auth/login")
    public Call<JwtResponse> authenticate(@Body LoginViewModel credentials);

    @POST("api/auth/register")
    public Call<UserModel> register(@Body UserModel userModel);
}
