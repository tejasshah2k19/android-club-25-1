package com.royal.androidclub25;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignupActivity extends AppCompatActivity {

    EditText edtFirstname;
    EditText edtEmail;
    EditText edtPassword;
    Button btnSubmit;

    RadioGroup rgGender;
    RadioButton rbGender;
    Spinner citySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //gui - java - bind
        edtFirstname = findViewById(R.id.edtSignupFirstName);
        edtEmail = findViewById(R.id.edtSignupEmail);
        edtPassword = findViewById(R.id.edtSignupPassword);
        btnSubmit = findViewById(R.id.btnSignupSubmit);
        rgGender = findViewById(R.id.rgSignupGender);
        citySpinner = findViewById(R.id.spinnerSignupCity);

        String items[] = {"Select City","Ahmedabad","Surat","Himmatnagar","Gnar","Thasa"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(adapter);

        //click event --> logic
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = edtFirstname.getText().toString();
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();

                boolean isError = false;
                //validation
                if(firstName.isEmpty()){
                    edtFirstname.setError("Firstname required");
                    isError = true;
                }

                if(email.isEmpty()){
                    edtEmail.setError("Email required");
                    isError = true;
                }

                if(password.isEmpty()){
                    edtPassword.setError("Password required");
                    isError=true;
                }

                if(!rgGender.isSelected()){
                    Toast.makeText(getApplicationContext(),"Please Select Gender",Toast.LENGTH_LONG).show();
                }

                //final
                if(isError){
                    //data miss
                    Toast.makeText(getApplicationContext(),"Please Correct Errors",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Signup success",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                    intent.putExtra("email",email);
                    intent.putExtra("password",password);


                    rbGender = findViewById(rgGender.getCheckedRadioButtonId());
                    Log.i("signup",rbGender.getText().toString());
                    citySpinner.getSelectedItem();

                    startActivity(intent);
                }

            }
        });


    }
}