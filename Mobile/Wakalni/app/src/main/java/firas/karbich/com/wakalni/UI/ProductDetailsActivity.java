package firas.karbich.com.wakalni.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import firas.karbich.com.wakalni.ApisInterfaces.ProductsApi;
import firas.karbich.com.wakalni.Models.Auth.JwtResponse;
import firas.karbich.com.wakalni.Models.ExtrasModel;
import firas.karbich.com.wakalni.Models.OrderModel;
import firas.karbich.com.wakalni.Models.ProductModel;
import firas.karbich.com.wakalni.R;
import firas.karbich.com.wakalni.Resquests.ProductsClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends AppCompatActivity {

    public static final String SHARED_PREFS= "loginInfo";
    public static final String SHARED_CART= "Cart";
    public static final String JWT= "jwt";
    public static final String USERNAME= "username";

    private final Context context = ProductDetailsActivity.this;

    ProductModel product;
    TextView price, extras;
    Button addToCart;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private JwtResponse jwtResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent intent = getIntent();
        ProductModel product = intent.getParcelableExtra("product");

        price = findViewById(R.id.productDetailsPrice);
        extras = findViewById(R.id.extras);
        addToCart = findViewById(R.id.addToCart);

        getProductDetails(product.getCode());

        // after gating data we et the clickListener :p
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProductToCart(product);
            }
        });
    }

    private void getProductDetails(String code) {
        ProductsApi productsApi = ProductsClient.getProductsApi();

        Call<ProductModel> responseCall = productsApi.getProductDetails(code);

        responseCall.enqueue(new Callback<ProductModel>() {
            @Override
            public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {
                if(response.code() == 200){
                    product = response.body();
                    DisplayProductDetails(product);
                }
            }

            @Override
            public void onFailure(Call<ProductModel> call, Throwable t) {
                Toast.makeText(context, "Couldn't reach server or Couldn't parse response " + t.getMessage() ,  Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void DisplayProductDetails(ProductModel product) {
        price.setText(String.valueOf(product.getFoodWithExtras().getFood().getPrix()));

        String extrasHtmlList = "";

        for(ExtrasModel e : product.getFoodWithExtras().getExtras()){
            extrasHtmlList+= "* " + e.getName() + "  " + String.format("%.3f", e.getPrixUnitaire()/1000)+ "DT\n";
        }

        extras.setText(extrasHtmlList);
    }

    public void openSharedPreferences() {
        sharedPreferences = getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE);
    }

    public void closeSharedPreferences(){
        sharedPreferences = null;
    }

    private void addProductToCart(ProductModel product) {
        OrderModel order = new OrderModel();

        openSharedPreferences();
        jwtResponse = new JwtResponse();
        String jwt = sharedPreferences.getString(JWT,"");
        String username = sharedPreferences.getString(USERNAME,"");

        if(jwt!="" && username!=""){ // user is autheticated
            jwtResponse.setJwt(jwt);
            jwtResponse.setUsername(username);

            order.setClientUsername(jwtResponse.getUsername());

            /*if(order.getProducts().contains(product)){ // if product already exist we increase quantite
                //ToDo
                // tzid lquntite ta3 ili deja mawjoud

            }else{
                // tzidou lil list ta3 lproducts
                Toast.makeText(context, "aaaaa", Toast.LENGTH_SHORT).show();
                order.getProducts().add(product);
            }*/

            closeSharedPreferences();

            Toast.makeText(context, "order owner : " + order.getClientUsername(), Toast.LENGTH_SHORT).show();


            // now we save this order into sharedPref
            openSharedPreferences();
            editor = sharedPreferences.edit();

            // convertir le order object to an JSONObject
            JSONObject orderJsonObject = new JSONObject();

            try {
                orderJsonObject.put("ClientUsername", order.getClientUsername());
                // Am not goin to put the whole model tree one by one idc
                orderJsonObject.put("products", order.getProducts());

            } catch (JSONException e) {
                e.printStackTrace();
            }

            // save the JSONObject
            editor.putString(SHARED_CART, orderJsonObject.toString());

            editor.apply();

            closeSharedPreferences();

            openSharedPreferences();

            if(sharedPreferences.getString(SHARED_CART,"").isEmpty()){
                Toast.makeText(context, "Couldn't add to Cart. Try again later", Toast.LENGTH_SHORT).show();
            }else{
                // Toast added succesfully to cart

                Toast.makeText(context, "Succesfully added to Cart : "+sharedPreferences.getString(SHARED_CART,"").toString(), Toast.LENGTH_SHORT).show();

            }

            closeSharedPreferences();

        }else{// user is not autheticated
            Intent intent = new Intent(context, LoginActivity.class);
            startActivity(intent);
        }


    }
}