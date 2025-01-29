package com.royal.androidclub25;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText edtEmail;
    EditText edtPassword;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtEmail = findViewById(R.id.edtLoginEmail);
        edtPassword = findViewById(R.id.edtLoginPassword);
        btnSubmit  = findViewById(R.id.btnLoginSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    boolean isError = false;

                    String email = edtEmail.getText().toString(); //read email
                    String password = edtPassword.getText().toString(); //read password

                    if(email.isEmpty()){
                        isError=true;
                        edtEmail.setError("Email required");
                    }
                    if(password.isEmpty()){
                        isError = true;
                        edtPassword.setError("Password required");
                    }

                    if(isError){
                        Toast.makeText(getApplicationContext(),"Please correct error",Toast.LENGTH_LONG).show();
                    }else{
                        //validation

                        //get old data from previous activity...."
                        Intent intent = getIntent();
                        String oldEmail = intent.getStringExtra("email");
                        String oldPassword = intent.getStringExtra("password");

                        if(email.equalsIgnoreCase(oldEmail) && password.equals(oldPassword)){
                            //match
                            Toast.makeText(getApplicationContext(),"Login done",Toast.LENGTH_LONG).show();
                            //redirect
                            

                        }else{
                            //not match
                            Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_LONG).show();
                        }

                    }
            }
        });

    }
}