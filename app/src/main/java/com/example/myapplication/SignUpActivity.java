package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends Activity {

    //define firebase object
    FirebaseAuth firebaseAuth;

    //define View object
    EditText signUp_name;
    EditText signUp_age;
    EditText signUp_ID;
    EditText signUp_PW;
    EditText signUp_PW2;
    Button signUp_btn_signUp;
    Button signUp_btn_back;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //initializing Views
        signUp_name = (EditText) findViewById(R.id.signUp_name);
        signUp_age = (EditText) findViewById(R.id.signUp_age);
        signUp_ID = (EditText) findViewById(R.id.signUp_ID);
        signUp_PW = (EditText) findViewById(R.id.signUp_PW);
        signUp_PW2 = (EditText) findViewById(R.id.signUp_PW2);
        signUp_btn_signUp = (Button) findViewById(R.id.signUp_btn_signUp);
        signUp_btn_back = (Button) findViewById(R.id.signUp_btn_back);

        //back to Login button Activity
        signUp_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        //initializing firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();

        //if already login
        if(firebaseAuth.getCurrentUser() != null){
            finish();
        }
    }

    //Firebase creating a new user
    private void createUser(){

    }
}
