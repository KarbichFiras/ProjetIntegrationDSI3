package firas.karbich.com.wakalni;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText username, email, password;
    Button signupbtn;
    String usernameErrorMessage ;
    String emailErrorMessage ;
    String passwordErrorMessage ;

    private final Context context = SignupActivity.this;

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
                    // send Data to the server and register the user
                    Toast.makeText(context, "valid form ", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
