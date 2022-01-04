package firas.karbich.com.wakalni.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

import firas.karbich.com.wakalni.ApisInterfaces.ProductsApi;
import firas.karbich.com.wakalni.Adapters.OnProductListener;
import firas.karbich.com.wakalni.Adapters.ProductsRecyclerAdapter;
import firas.karbich.com.wakalni.Models.ProductModel;
import firas.karbich.com.wakalni.R;
import firas.karbich.com.wakalni.Resquests.ProductsClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsListActivity extends AppCompatActivity {

    private final Context context = ProductsListActivity.this;
    private RecyclerView foodsRecyclerView;
    private ProductsRecyclerAdapter productsRecyclerAdapter;
    ArrayList<ProductModel> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        foodsRecyclerView = findViewById(R.id.foodsRecyclerView);

        // Normalment t3adih fil putExtra ta3 lintent min 3and RestaurantsActivity
        Intent intent = getIntent();
        String restaurantName = intent.getStringExtra("restaurantName");

        getProducts(restaurantName);

    }

    private void getProducts(String restaurantName) {

        ProductsApi productsApi = ProductsClient.getProductsApi();

        Call<Collection<ProductModel>> responseCall = productsApi.getProductsByRestaurantName(restaurantName);

        responseCall.enqueue(new Callback<Collection<ProductModel>>() {
            @Override
            public void onResponse(Call<Collection<ProductModel>> call, Response<Collection<ProductModel>> response) {
                if(response.code() == 200){
                    products = new ArrayList<>();
                    products.addAll(response.body());
                    ConfigureRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<Collection<ProductModel>> call, Throwable t) {
                Toast.makeText(context, "Couldn't reach server or Couldn't parse response " + t.getMessage() ,  Toast.LENGTH_SHORT).show();
            }
        });

    }
    
    private void ConfigureRecyclerView(){
        productsRecyclerAdapter = new ProductsRecyclerAdapter(context, products, new OnProductListener() {
            @Override
            public void onProductClick(int position) {

                Intent intent = new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("product", products.get(position));
                startActivity(intent);

            }
        });

        foodsRecyclerView.setAdapter(productsRecyclerAdapter);
        foodsRecyclerView.setLayoutManager(new LinearLayoutManager(context));
    }
}