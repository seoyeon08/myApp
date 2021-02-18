package com.example.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends Activity implements View.OnClickListener{

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

//        //button click event
//        signUp_btn_signUp.setOnClickListener();
//        signUp_btn_back.setOnClickListener(view);

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
        String ID = signUp_ID.getText().toString().trim();
        String PW = signUp_PW.getText().toString().trim();
        String PW2 = signUp_PW2.getText().toString().trim();
        String name = signUp_name.getText().toString().trim();
        String age = signUp_age.getText().toString().trim();


        //if empty
        if(TextUtils.isEmpty(ID)){
            Toast.makeText(this, "E-mail을 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(PW)){
            Toast.makeText(this, "Password를 입력해 주세요", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(name)){
            Toast.makeText(this, "닉네임을 입력해주세요", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(PW2)){
            Toast.makeText(this, "Password를 확인해주세요", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(age)){
            Toast.makeText(this, "연령대를 입력해주세요", Toast.LENGTH_SHORT).show();
        }

        //비밀번호 중복 테스트 작성해야함

        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(ID, PW).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    finish();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
                else {
                    Toast.makeText(SignUpActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v == signUp_btn_signUp){
            createUser();
        }
    }
}
