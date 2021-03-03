package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    private TextView profile_UserEmail;
    private Button buttonLogout;
    private Button buttonDelete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //initializing Views
        profile_UserEmail = (TextView) findViewById(R.id.profile_UserEmail);
        buttonLogout = (Button) findViewById(R.id.profile_btn_logout);
        buttonDelete = (Button) findViewById(R.id.profile_btn_signOut);

        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        profile_UserEmail.setText("안녕하세요.\n"+user.getEmail()+"으로 로그인 하였습니다.");

        //logout button event
        buttonLogout.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

    }
}
