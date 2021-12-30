package firas.karbich.com.wakalni;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

import firas.karbich.com.wakalni.Models.User;

public class SignupActivity extends AppCompatActivity {

    private static final String SUGNUP_URL = "http://10.0.2.2:8081/api/auth/register";
    private final Context context = SignupActivity.this;


    EditText username, email, password;
    Button signupbtn;
    String usernameErrorMessage ;
    String emailErrorMessage ;
    String passwordErrorMessage ;
    RequestQueue requestQueue;
    User user;

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
                    user = new User();
                        user.setUsername(username.getText().toString().trim());
                        user.setEmail(email.getText().toString().trim());
                        user.setPassword(password.getText().toString());
                    registerUser();
                }
            }
        });
    }

    private void registerUser(){
        requestQueue = Volley.newRequestQueue(context);
        try{
            Map<String, String> params = new HashMap<String, String>();
                params.put("username", username.getText().toString());
                params.put("email", email.getText().toString());
                params.put("password" , password.getText().toString());

            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    SUGNUP_URL, new JSONObject(params),
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

            requestQueue.add(jsonObjReq);
        }catch(Exception e){
            e.printStackTrace();
        }

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
