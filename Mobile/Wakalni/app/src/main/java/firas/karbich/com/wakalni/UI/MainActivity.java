package firas.karbich.com.wakalni.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Collection;

import firas.karbich.com.wakalni.ApisInterfaces.RestaurantsApi;
import firas.karbich.com.wakalni.Models.RestaurantModel;
import firas.karbich.com.wakalni.R;
import firas.karbich.com.wakalni.Resquests.RestaurantsClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final Context context = MainActivity.this;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRestaurants();
            }
        });

        Intent intent = new Intent(MainActivity.this, RestaurantsListActivity.class);
        startActivity(intent);


    }


    private void getRestaurants() {

        RestaurantsApi restaurantsApi = RestaurantsClient.getRestaurantsApi();

        Call<Collection<RestaurantModel>> responseCall = restaurantsApi.getAllRestaurants();

      responseCall.enqueue(new Callback<Collection<RestaurantModel>>() {
          @Override
          public void onResponse(Call<Collection<RestaurantModel>> call, Response<Collection<RestaurantModel>> response) {
              if(response.code() == 200){
                  Toast.makeText(context, "Got Response :D " + response.body().size() ,  Toast.LENGTH_SHORT).show();
              }
          }

          @Override
          public void onFailure(Call<Collection<RestaurantModel>> call, Throwable t) {
              Toast.makeText(context, "Couldn't reach server or Coulsn't parse response " + t.getMessage() ,  Toast.LENGTH_SHORT).show();
          }
      });

    }
}