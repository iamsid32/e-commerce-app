package com.example.e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity1 extends AppCompatActivity {

    private EditText etEmail,etPassword;
    private Button btn;
    private TextView tvToRegister,tv_phone_login;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        firebaseAuth = FirebaseAuth.getInstance();

        etEmail = findViewById(R.id.etLEmail);
        etPassword = findViewById(R.id.etLPassword);
        btn  = findViewById(R.id.btnL);
        tvToRegister = findViewById(R.id.tvToRegister);
        tv_phone_login = findViewById(R.id.tv_phone_login);

        tv_phone_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity1.this,PhoneNumberLogin.class);
                startActivity(intent);
            }
        });

        tvToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity1.this,RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etEmail.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity1.this, "Fill all the fields properly", Toast.LENGTH_SHORT).show();
                }
                else {
                    firebaseAuth.signInWithEmailAndPassword(etEmail.getText().toString(),etPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(LoginActivity1.this, "LoggedIn", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity1.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                            else{
                                Toast.makeText(LoginActivity1.this, "Failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }

}