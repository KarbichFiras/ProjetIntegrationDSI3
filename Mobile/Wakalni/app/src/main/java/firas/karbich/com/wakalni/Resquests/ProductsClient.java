package firas.karbich.com.wakalni.Resquests;

import firas.karbich.com.wakalni.ApisInterfaces.ProductsApi;
import firas.karbich.com.wakalni.Utils.AppCredentials;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductsClient {

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl(AppCredentials.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static ProductsApi productsApi = retrofit.create(ProductsApi.class);

    public static ProductsApi getProductsApi(){
        return productsApi;
    }

}
