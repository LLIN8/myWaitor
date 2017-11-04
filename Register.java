package com.example.liangminglin.mywaitor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    DBControll control = new DBControll(this);

    private Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        signUp = (Button) findViewById(R.id.rButton);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                EditText username = (EditText) findViewById(R.id.uID);
                EditText pass = (EditText) findViewById(R.id.pID);
                EditText email = (EditText) findViewById(R.id.emailID);
                EditText age = (EditText) findViewById(R.id.ageID);
                EditText pass2 = (EditText) findViewById(R.id.pass2ID);

                String uName = username.getText().toString();
                String password = pass.getText().toString();
                String emailAddress = email.getText().toString();
                String ages = age.getText().toString();
                String password2 = pass2.getText().toString();

                if(!password.equals(password2))
                {
                    Toast match = Toast.makeText(com.example.liangminglin.mywaitor.Register.this , "Password Does Not Match", Toast.LENGTH_SHORT);
                    match.show();;
                }
                else {

                    RegisterInfo person = new RegisterInfo();

                    person.setAge(ages);
                    person.setEmail(emailAddress);
                    person.setpNum(password);
                    person.setuName(uName);

                    control.insertPerson(person);
                }

                Intent fChicken = new Intent(com.example.liangminglin.mywaitor.Register.this, Login.class);
                startActivity(fChicken);


            }
        });
    }

}
