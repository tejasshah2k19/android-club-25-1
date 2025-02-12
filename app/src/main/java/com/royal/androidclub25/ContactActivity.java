package com.royal.androidclub25;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.royal.androidclub25.fragment.CallFragment;
import com.royal.androidclub25.fragment.ListFragment;
import com.royal.androidclub25.fragment.SearchFragment;

public class ContactActivity extends AppCompatActivity {


    ImageButton btnCall;
    ImageButton btnSearch;
    ImageButton btnUser;

    FrameLayout frameMaster;

    Drawable userFill;
    Drawable userEmpty;
    Drawable callEmpty;
    Drawable searchEmpty;
    Drawable callFill;
    Drawable searchFill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //bind
        btnCall = findViewById(R.id.imgBtnContactAdd);
        btnSearch = findViewById(R.id.imgBtnContactSearch);
        btnUser = findViewById(R.id.imgBtnContactUser);
        frameMaster = findViewById(R.id.frameMaster);

        userFill = ContextCompat.getDrawable(getApplicationContext(),R.drawable.user_24);//fill
        userEmpty = ContextCompat.getDrawable(getApplicationContext(),R.drawable.user_outline_24);

        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    btnUser.setImageDrawable(userFill);
                    btnCall.setImageDrawable(callEmpty);
                    btnSearch.setImageDrawable(searchEmpty);

                    //load list fragement
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameMaster,new ListFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

             }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnUser.setImageDrawable(userEmpty);
                btnCall.setImageDrawable(callFill);
                btnSearch.setImageDrawable(searchEmpty);
//                imgMaster.setImageDrawable(callFill);
                 FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameMaster,new CallFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameMaster,new SearchFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

    }//onCreate



}//class