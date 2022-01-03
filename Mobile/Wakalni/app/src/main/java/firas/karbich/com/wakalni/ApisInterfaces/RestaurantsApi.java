package firas.karbich.com.wakalni.ApisInterfaces;

import java.util.Collection;

import firas.karbich.com.wakalni.Models.RestaurantModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestaurantsApi {

    @GET("/api/restaurants/getAllRestaurants")
    Call<Collection<RestaurantModel>> getAllRestaurants();



}
