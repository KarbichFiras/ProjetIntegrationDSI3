package firas.karbich.com.wakalni;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
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

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private static final String LOGIN_URL = "http://10.0.2.2:8081/api/auth/login";
    private final Context context = LoginActivity.this;

    EditText login, pass;
    Button loginbtn;
    TextView registerText;
    String usernameErrorMessage ;
    String emailErrorMessage ;
    String passwordErrorMessage ;
    RequestQueue requestQueue;

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
                    // Register the user
                    boolean logedIn = loginUser();

                    if(logedIn){
                        Toast.makeText(context, "Successfully loged in :p ", Toast.LENGTH_SHORT).show();
                    }

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
                .setPositiveButton("Yes", (dialog, which) -> dialog.dismiss())
        ;
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}