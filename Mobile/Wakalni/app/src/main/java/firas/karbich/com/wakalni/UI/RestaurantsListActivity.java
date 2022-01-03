package firas.karbich.com.wakalni.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

import firas.karbich.com.wakalni.ApisInterfaces.RestaurantsApi;
import firas.karbich.com.wakalni.Asapters.OnRestaurantListener;
import firas.karbich.com.wakalni.Asapters.RestaurantsRecyclerAdapter;
import firas.karbich.com.wakalni.Models.RestaurantModel;
import firas.karbich.com.wakalni.R;
import firas.karbich.com.wakalni.Resquests.RestaurantsClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantsListActivity extends AppCompatActivity {

    private final Context context = RestaurantsListActivity.this;

    private RecyclerView restaurantsRecyclerView;
    private RestaurantsRecyclerAdapter restaurantsRecyclerAdapter;

    ArrayList<RestaurantModel> restaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants_list);

        restaurantsRecyclerView = findViewById(R.id.restaurantsRecyclerView);

        getRestaurants();

    }

    private void getRestaurants() {

        RestaurantsApi restaurantsApi = RestaurantsClient.getRestaurantsApi();

        Call<Collection<RestaurantModel>> responseCall = restaurantsApi.getAllRestaurants();

        responseCall.enqueue(new Callback<Collection<RestaurantModel>>() {
            @Override
            public void onResponse(Call<Collection<RestaurantModel>> call, Response<Collection<RestaurantModel>> response) {
                if(response.code() == 200){
                    restaurants =  new ArrayList<>();
                    restaurants.addAll(response.body());
                    ConfigureRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<Collection<RestaurantModel>> call, Throwable t) {
                Toast.makeText(context, "Couldn't reach server or Couldn't parse response " + t.getMessage() ,  Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void ConfigureRecyclerView(){
        restaurantsRecyclerAdapter = new RestaurantsRecyclerAdapter(context, restaurants, new OnRestaurantListener() {
            @Override
            public void onRestaurantClick(int position) {
                Toast.makeText(context, "Item clicked position : " + position , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSeemoreClick(String seemore) {

            }
        });
        restaurantsRecyclerView.setAdapter(restaurantsRecyclerAdapter);
        restaurantsRecyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

}