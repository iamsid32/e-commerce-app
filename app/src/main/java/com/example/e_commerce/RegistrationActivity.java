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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {

    private EditText etName,etEmail,etPassword,etConfPassword;
    private Button btn;
    private TextView tvToLogin;

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfPassword = findViewById(R.id.etConfPassword);
        btn = findViewById(R.id.btn);
        tvToLogin = findViewById(R.id.tvToLogin);

        tvToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this,LoginActivity1.class);
                startActivity(intent);
                finish();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = etEmail.getText().toString();
                final String password = etPassword.getText().toString();
                final String name = etName.getText().toString();
                if (etName.getText().toString().isEmpty() || etEmail.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty() || !etConfPassword.getText().toString().equals(etPassword.getText().toString())){
                    Toast.makeText(RegistrationActivity.this, "Fill all the fields properly", Toast.LENGTH_SHORT).show();
                }else{
                    createUserAccount(email,password,name);
                }
            }
        });

    }

    private void createUserAccount(String email, String password, String name) {
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Map<Object,String> useradta = new HashMap<>();
                            useradta.put("name",name);
                            firebaseFirestore.collection("USERS")
                                    .add(useradta)
                                    .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                        @Override
                                        public void onComplete(@NonNull Task<DocumentReference> task) {
                                            if (task.isSuccessful()){
                                                Toast.makeText(RegistrationActivity.this, "Name saved", Toast.LENGTH_SHORT).show();
                                            }else {
                                                Toast.makeText(RegistrationActivity.this, "Error", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                            Toast.makeText(RegistrationActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(RegistrationActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}