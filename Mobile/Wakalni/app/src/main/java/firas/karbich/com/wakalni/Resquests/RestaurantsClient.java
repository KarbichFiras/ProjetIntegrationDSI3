package firas.karbich.com.wakalni.Resquests;

import firas.karbich.com.wakalni.ApisInterfaces.RestaurantsApi;
import firas.karbich.com.wakalni.Utils.AppCredentials;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestaurantsClient {

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
            .baseUrl(AppCredentials.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static RestaurantsApi restaurantsApi = retrofit.create(RestaurantsApi.class);

    public static RestaurantsApi getRestaurantsApi(){
        return restaurantsApi;
    }

}
