package firas.karbich.com.wakalni;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import firas.karbich.com.wakalni.Models.JwtResponse;

public class LoginActivity extends AppCompatActivity {

    private static final String LOGIN_URL = "http://10.0.2.2:8081/api/auth/login";
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
                    loginUser();
                    try {
                        // bil3annit bch lmethod saveJwtResponse ta5let tsajel fil sharedPreferences wta3mil commit
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    JwtResponse jwtResponse = loadJwtResponse();
                    Toast.makeText(context, "username : " + jwtResponse.getUsername(), Toast.LENGTH_SHORT).show();
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

    private boolean loginUser() {
        requestQueue = Volley.newRequestQueue(context);
        try{
            Map<String, String> params = new HashMap<String, String>();
            params.put("username", login.getText().toString());
            params.put("password" , pass.getText().toString());
            // JSONOBJECT 5ATER BCH NAB3THOU LES DONNE FIL BODY TA3 REQUEST SOUS FORMAT JSON
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    LOGIN_URL, new JSONObject(params),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("JSONPost", response.toString());
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
        sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.putString(JWT, jwtResponse.getJwt());
        editor.putString(USERNAME, jwtResponse.getUsername());
        editor.putStringSet(AUTHORITIES, (Set<String>) jwtResponse.getAuthorities());

        editor.commit();
    }

    public JwtResponse loadJwtResponse(){
        sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
            jwtResponse = new JwtResponse();
                String jwt = sharedPreferences.getString(JWT,"");
                String username = sharedPreferences.getString(USERNAME,"");
                Set<String> authorities = sharedPreferences.getStringSet(AUTHORITIES, Collections.singleton(""));
            jwtResponse.setJwt(jwt);
            jwtResponse.setUsername(username);
            jwtResponse.setAuthorities(authorities);
        return jwtResponse;
    }



}