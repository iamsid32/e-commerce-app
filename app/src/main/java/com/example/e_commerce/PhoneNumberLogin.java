package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PhoneNumberLogin extends AppCompatActivity {

    private EditText tv_phone_number;
    private Button btn_continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_login);

        tv_phone_number = findViewById(R.id.tv_phone_number);
        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhoneNumberLogin.this,OTP.class);
                intent.putExtra("phoneNumber",tv_phone_number.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}