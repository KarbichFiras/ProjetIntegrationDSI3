package firas.karbich.com.wakalni.ApisInterfaces;

import java.util.Collection;

import firas.karbich.com.wakalni.Models.ProductModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProductsApi {

    @GET("/api/restaurants/getProductsByRestaurantName")
    Call<Collection<ProductModel>> getProductsByRestaurantName(@Query("restaurantName") String restaurantName);

    @GET("/api/restaurants/getProductByCode")
    Call<ProductModel> getProductDetails(@Query("code")String code);
}
