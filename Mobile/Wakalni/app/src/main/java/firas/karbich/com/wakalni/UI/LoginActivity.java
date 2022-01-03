package firas.karbich.com.wakalni.UI;

import static firas.karbich.com.wakalni.Utils.AppCredentials.BASE_URL;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import firas.karbich.com.wakalni.ApisInterfaces.AuthApi;
import firas.karbich.com.wakalni.Models.Auth.JwtResponse;
import firas.karbich.com.wakalni.Models.Auth.LoginViewModel;
import firas.karbich.com.wakalni.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private static final String LOGIN_URL = "api/auth/login";
    private final Context context = LoginActivity.this;
    public static final String SHARED_PREFS= "loginInfo";
    public static final String JWT= "jwt";
    public static final String USERNAME= "username";
    public static final String AUTHORITIES = "authorities";

    EditText login, pass;
    Button loginbtn;
    TextView registerText;
    RequestQueue requestQueue;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private JwtResponse jwtResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        pass = findViewById(R.id.pass);
        loginbtn = findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( !pass.getText().toString().isEmpty() && ! login.getText().toString().isEmpty()){
                    // log in the user
                    authenticate();

                   /*JwtResponse jwtResponse = loadJwtResponse();
                    if(jwtResponse != null){
                        Toast.makeText(context, "username : " + jwtResponse.getUsername(), Toast.LENGTH_SHORT).show();
                    }*/

                }else{
                    openAlertDialog("Alert","Bad credentials ! ");
                }
            }
        });

        registerText = findViewById(R.id.registerText);
        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to sign up
                Intent intent = new Intent(context, SignupActivity.class);
                startActivity(intent);
            }
        });

    }

    // login usnig Retrofit
    private void authenticate(){
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
        Call<JwtResponse> call = authApi.authenticate(new LoginViewModel(login.getText().toString(), pass.getText().toString()));
        // add the call to the queue
        call.enqueue(new Callback<JwtResponse>() {
            @Override
            public void onResponse(Call<JwtResponse> call, retrofit2.Response<JwtResponse> response) {
                Toast.makeText(context, "Got Response :D" + response.body().getAuthorities() , Toast.LENGTH_LONG).show();
            }

            // Couldn't reach the server or Couldn't parse the response got from the server
            @Override
            public void onFailure(Call<JwtResponse> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println( "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + t.getMessage());
            }
        });
    }

    // login using volley
    private boolean loginUser() {
        requestQueue = Volley.newRequestQueue(context);
        try{
            Map<String, String> params = new HashMap<String, String>();
            params.put("username", login.getText().toString());
            params.put("password" , pass.getText().toString());
            // JSONOBJECT 5ATER BCH NAB3THOU LES DONNE FIL BODY TA3 REQUEST SOUS FORMAT JSON
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    BASE_URL + LOGIN_URL, new JSONObject(params),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                           // Log.d("JSONPost", response.toString());
                            // stock the response dans sharedPreferences
                            try {
                                jwtResponse = new JwtResponse();
                                jwtResponse.setJwt(response.getString("jwt"));
                                jwtResponse.setUsername(response.getString("username"));
                                jwtResponse.setAuthorities(getAuthoritiesCollection(response.getString("authorities")));//ism lcollection lkol ism item => authority

                                // Save data in SharedPreferences
                                saveJwtResponse(jwtResponse);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
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

    public void openSharedPreferences() {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE);
    }

    public void closeSharedPreferences(){
        sharedPreferences = null;
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

    private Collection<String> getAuthoritiesCollection(String roles){
        try{
            JSONArray jsonArray = new JSONArray(roles);
            Collection<String> authorities = new HashSet<>();

            for ( int i=0 ; i < jsonArray.length() ; i++) {
                JSONObject object = null;
                try {
                    object = jsonArray.getJSONObject(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try{
                    authorities.add(object.getString("authority"));// ism one object mil collection lkol !
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            return authorities;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void saveJwtResponse(JwtResponse jwtResponse){
        openSharedPreferences();
        editor = sharedPreferences.edit();

        // kenou fih 7ajja min 9bal nfar8ouh
        if((sharedPreferences.getString(JWT,"").isEmpty()) || (sharedPreferences.getString(USERNAME,"").isEmpty()) || (sharedPreferences.getStringSet(AUTHORITIES, null).isEmpty())){
            editor.remove(JWT);
            editor.remove(USERNAME);
            editor.remove(AUTHORITIES);
            editor.apply();
            closeSharedPreferences();
        }
        // wba3ed n3abiw fih min jdid
        openSharedPreferences();
        editor.putString(JWT, jwtResponse.getJwt());
        editor.putString(USERNAME, jwtResponse.getUsername());
        editor.putStringSet(AUTHORITIES, (Set<String>) jwtResponse.getAuthorities());

        editor.apply();
        closeSharedPreferences();
    }

    public JwtResponse loadJwtResponse(){
        openSharedPreferences();
            jwtResponse = new JwtResponse();
                String jwt = sharedPreferences.getString(JWT,"");
                String username = sharedPreferences.getString(USERNAME,"");
                Set<String> authorities = sharedPreferences.getStringSet(AUTHORITIES, null);

                if(jwt!="" && username!="" && authorities!=null){
                    jwtResponse.setJwt(jwt);
                    jwtResponse.setUsername(username);
                    jwtResponse.setAuthorities(authorities);
                    return jwtResponse;
                }
        closeSharedPreferences();
        return null;
    }



}