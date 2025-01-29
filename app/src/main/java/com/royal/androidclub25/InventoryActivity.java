package com.royal.androidclub25;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InventoryActivity extends AppCompatActivity {

    ImageView imageView;
    EditText edtName;
    EditText edtPrice;
    EditText edtQty;
    Button btnSubmit;
    TextView tvAns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        imageView = findViewById(R.id.imgInventoryLogo);
        edtName = findViewById(R.id.edtInventoryName);
        edtPrice = findViewById(R.id.edtInventoryPrice);
        edtQty = findViewById(R.id.edtInventoryQty);
        btnSubmit = findViewById(R.id.btnInventorySubmit);
        tvAns = findViewById(R.id.tvInventoryAns);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               //validation

                String productName = edtName.getText().toString();
                String productPrice = edtPrice.getText().toString();
                String productQty = edtQty.getText().toString();

                boolean isError = false;
               if(productName.isEmpty()){
                   edtName.setError("Product name required");
                   isError = true;
               }
               if(productPrice.isEmpty()){
                   edtPrice.setError("Product price required");
                   isError = true;
               }

               if(productQty.isEmpty()){
                   edtQty.setError("Product Qty is required");
                   isError = true;
               }

                if(!isError) {

                    Integer price = Integer.parseInt(productPrice);
                    Integer qty = Integer.parseInt(productQty);
                    Log.i("Inventory", productName);

                    Integer amount = price * qty;
                    Log.i("Inventory", amount + "");

                    tvAns.setText(amount.toString());

                    Toast.makeText(getApplicationContext(),"Amount Calculated",Toast.LENGTH_LONG).show();

                    //activity -> activity -> intent

                    Intent intent = new Intent(getApplicationContext(),SignupActivity.class);
                    startActivity(intent);



                }
            }
        });


    }
}