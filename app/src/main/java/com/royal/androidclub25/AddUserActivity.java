package com.royal.androidclub25;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddUserActivity extends AppCompatActivity {

    Button btnAddUser;
    EditText edtFirstName;
    EditText edtEmail;
    EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        btnAddUser = findViewById(R.id.btnAddUserSubmit);//link UI -> btn
        edtFirstName = findViewById(R.id.edtAddUserFirstname);
        edtEmail = findViewById(R.id.edtAddUserEmail);
        edtPassword = findViewById(R.id.edtAddUserPassword);

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("AddUser","click done");
            }
        });


    }
}