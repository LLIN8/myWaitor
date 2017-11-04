package com.example.liangminglin.mywaitor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    DBControll controls = new DBControll(this);
    private Button registerB;
    private Button loginB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        registerB = (Button) findViewById(R.id.registerButton);

        registerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent fChicken = new Intent(com.example.liangminglin.mywaitor.Login.this, Register.class);
                startActivity(fChicken);
            }
        });

        loginB = (Button) findViewById(R.id.loginButton);

        loginB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText user = (EditText) findViewById(R.id.userEdit);
                EditText passd = (EditText) findViewById(R.id.passEdit);

                String userID = user.getText().toString();
                String passID = passd.getText().toString();

                String passwordID = controls.searchPass(userID);

                if(passID.equals(passwordID))
                {
                    Intent log = new Intent(com.example.liangminglin.mywaitor.Login.this, MainActivity.class);
                    log.putExtra("Username", userID);
                    startActivity(log);

                }
                else
                {
                    Toast search = Toast.makeText(com.example.liangminglin.mywaitor.Login.this, "NO MATCHING ID FOUND", Toast.LENGTH_SHORT);
                    search.show();
                }
            }
        });
    }


}
