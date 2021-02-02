package com.example.e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OTP extends AppCompatActivity {

    private EditText tv_otp;
    private Button btn_ok;
    String verificationCodeBySystem;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p);

        firebaseAuth = FirebaseAuth.getInstance();

        tv_otp = findViewById(R.id.tv_otp);
        btn_ok = findViewById(R.id.btn_ok);
        String phone = getIntent().getStringExtra("phoneNumber");
        
        sendVerificationCodeToUser(phone);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!tv_otp.getText().toString().trim().isEmpty()){
                    Intent intent = new Intent(OTP.this,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(OTP.this, "fill the otp", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void sendVerificationCodeToUser(String phone) {
        /*PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "91"+phone,
                60,
                TimeUnit.SECONDS,
                (Activity) TaskExecutors.MAIN_THREAD,
                mCallbacks);*/
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(firebaseAuth)
                        .setPhoneNumber("+91"+phone)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationCodeBySystem = s;
        }

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if (code!=null){
                verifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(OTP.this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };

    private void verifyCode(String codeByUser) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCodeBySystem,codeByUser);
        signInTheUserByCredential(credential);
    }

    private void signInTheUserByCredential(PhoneAuthCredential credential) {
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(OTP.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Intent intent = new Intent(OTP.this,MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            finish();
                        }else {
                            Log.d("error",task.getException().getMessage());
                            Toast.makeText(OTP.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}