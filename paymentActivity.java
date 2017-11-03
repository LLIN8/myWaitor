package com.example.liangminglin.mywaitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.text.*;
import android.widget.*;
import android.content.Intent;


public class paymentActivity extends AppCompatActivity {

    TextView name;
    String FoodName;
    String number;
    Button paymentConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        paymentConfirm = (Button) findViewById(R.id.confirmPayButton);
        paymentConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent payment= new Intent(paymentActivity.this, payActivity.class);
                startActivity(payment);
            }
        });


    Intent intent = this.getIntent();
    if(intent != null)
    {
        FoodName = intent.getStringExtra("FOODNAME");
        number = intent.getStringExtra("NUMBEROFORDER");
    }




        name = (TextView) findViewById(R.id.summaryText);
            name.setText("Food Name" +" " +FoodName + '\n'+  "Number of Order: " + " " + number + '\n');

    }


}
