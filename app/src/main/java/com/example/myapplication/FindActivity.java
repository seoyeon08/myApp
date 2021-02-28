package com.example.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class FindActivity extends Activity implements View.OnClickListener {

    private EditText editTextUserEmail;
    private Button buttonFind;
    private ProgressDialog progressDialog;
    private TextView textViewMessage;

    //define firebase object
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        editTextUserEmail = (EditText) findViewById(R.id.signUp_ID);
        buttonFind = (Button) findViewById(R.id.find_btn_find);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        buttonFind.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == buttonFind){
            progressDialog.setMessage("처리중입니다. 기다려주세요");
            progressDialog.show();

            //send reset password Email
            String emailAddress = editTextUserEmail.getText().toString().trim();
            firebaseAuth.sendPasswordResetEmail(emailAddress).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(FindActivity.this, "이메일을 전송했습니다", Toast.LENGTH_LONG).show();
                        finish();
                        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                    } else{
                        Toast.makeText(FindActivity.this, "이메일 전송에 실패했습니다", Toast.LENGTH_LONG).show();
                    }
                    progressDialog.dismiss();
                }
            });
        }
    }
}
