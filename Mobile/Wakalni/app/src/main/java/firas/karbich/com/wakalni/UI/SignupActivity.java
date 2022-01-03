package firas.karbich.com.wakalni.UI;

import static firas.karbich.com.wakalni.Utils.AppCredentials.BASE_URL;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import firas.karbich.com.wakalni.ApisInterfaces.AuthApi;
import firas.karbich.com.wakalni.Models.UserModel;
import firas.karbich.com.wakalni.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupActivity extends AppCompatActivity {

    private static final String SUGNUP_URL = "api/auth/register";
    private final Context context = SignupActivity.this;


    EditText username, email, password;
    Button signupbtn;
    String usernameErrorMessage ;
    String emailErrorMessage ;
    String passwordErrorMessage ;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signupbtn = findViewById(R.id.signupbtn);

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validForm()){
                    // Register the user
                   register();
                    /* boolean registred = registerUser();

                    if(registred){
                        Intent intent = new Intent(context, LoginActivity.class);
                        startActivity(intent);
                    }*/

                }
            }
        });
    }

    // Retrofit register
    private void register(){
        // 1st step : Builder
        Retrofit retrofit = new Retrofit.Builder()
                // base url
                .baseUrl(BASE_URL)
                // converter that we r goin to use
                .addConverterFactory(GsonConverterFactory.create())
                // build the retrofit "object"
                .build();
        // 2nd step : let retrofit knows wich interface his goin to use to make calls
        // linterface qu'il va etre utiliser pour faire les communications avec les rest Api ( .create ==> pour retrofit implemnet the body of each method that declared in that interface
        // ==> houca ili bch yitkafil bil appel ta3 lapi wil convert ta3 response w async tasks etc... )
        AuthApi authApi = retrofit.create(AuthApi.class);

        // 3rd and last step : make the call
        Call<UserModel> call = authApi.register(new UserModel(username.getText().toString(), email.getText().toString(), password.getText().toString()));
        // add the call to the queue
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, retrofit2.Response<UserModel> response) {
                Toast.makeText(context, "Got Response : " + response.body().getEmail() , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Toast.makeText(context, "Failed : " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        );
    }

    private boolean registerUser(){
        requestQueue = Volley.newRequestQueue(context);
        try{
            Map<String, String> params = new HashMap<String, String>();
                params.put("username", username.getText().toString());
                params.put("email", email.getText().toString());
                params.put("password" , password.getText().toString());
            // JSONOBJECT 5ATER BCH NAB3THOU LES DONNE FIL BODY TA3 REQUEST SOUS FORMAT JSON
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    BASE_URL + SUGNUP_URL, new JSONObject(params),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("JSONPost", response.toString());
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d("JSONPost", "Error: " + error.getMessage());
                }
            }){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String>  headers = new HashMap<String, String>();
                    headers.put("Content-Type", "application/json");
                    return headers;
                }
            };

            if(requestQueue.add(jsonObjReq) != null){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    private void openAlertDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle(title)
                .setMessage(message)
                .setIcon(android.R.drawable.alert_light_frame)
                .setPositiveButton("Ok", (dialog, which) -> dialog.dismiss())
        ;
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private boolean validForm() {
        if(!validUsername(username.getText().toString())){
            openAlertDialog("Alert", usernameErrorMessage);
            return  false;
        }else{
            if(!validEmail(email.getText().toString())){
                openAlertDialog("Alert", emailErrorMessage);
                return  false;
            }else{
                if(!validPassword(password.getText().toString())){
                    openAlertDialog("Alert", passwordErrorMessage);
                    return  false;
                }
            }
        }
        return true;
    }

    private boolean validUsername(String username) {
        usernameErrorMessage = "" ;
        if((username.isEmpty()) ){
            usernameErrorMessage+="Username required!";
            return false;
        }else{
            if((username.length()<3)){
                usernameErrorMessage+="Username least length is 3 characters!";
                return  false;
            }
        }
        return true;
    }

    private boolean validEmail(String email) {
        emailErrorMessage = "" ;
        if(email.isEmpty() ){
            emailErrorMessage += "Email required!";
            return  false;
        }else{
            if(email.length()< 3){ //Since both the name and domain may have the length of 1 character, the minimal total length of an email resolves to 3 characters.
                emailErrorMessage += "Bad email Format!";
                return  false;
            }
        }
        return true;
    }

    private boolean validPassword(String password) {
        passwordErrorMessage = "";
        if(password.isEmpty() ){
            passwordErrorMessage += "Password required";
            return  false;
        }else{
            if(password.length() < 8){
                passwordErrorMessage += "Password requires at least 8 characters";
                return  false;
            }
        }
        return  true;
    }

}
