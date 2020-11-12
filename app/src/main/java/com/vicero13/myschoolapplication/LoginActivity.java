package com.vicero13.myschoolapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginUser(View view){
        EditText emailText = findViewById(R.id.email_editText);
        String email = emailText.getText().toString().trim();

        EditText passText = findViewById(R.id.password_editText);
        String password = passText.getText().toString().trim();

        if(!email.equals("") && !password.equals("")) {
            loginUser(email, password);

            DatabaseHandler databaseHandler = new DatabaseHandler();
            databaseHandler.signUpUser(email, password);
        }
    }

    private void loginUser(String email, String password) {

    }
}
