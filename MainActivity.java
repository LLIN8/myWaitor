package com.example.liangminglin.mywaitor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    private ImageButton friedChicken;
    private Button payment_Buttom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        friedChicken = (ImageButton) findViewById(R.id.fried_Chicken);
        payment_Buttom = (Button) findViewById(R.id.payment_Button);

        friedChicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent fChicken = new Intent(com.example.liangminglin.mywaitor.MainActivity.this, NewActivity.class);
                startActivity(fChicken);
            }
        });

        payment_Buttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent payment= new Intent(com.example.liangminglin.mywaitor.MainActivity.this, paymentActivity.class);
                startActivity(payment);
            }
        });
    }


}