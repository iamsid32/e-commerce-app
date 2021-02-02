package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

public class WelcomeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView textViewExistingUser,textViewLogin;
    private AppCompatButton btnChooseLocation;
    private SpringDotsIndicator dotsIndicator;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        firebaseAuth = FirebaseAuth.getInstance();

        viewPager = findViewById(R.id.viewPager);
        //textViewExistingUser = findViewById(R.id.textViewExistingUser);
        textViewLogin = findViewById(R.id.textViewLogin);
        btnChooseLocation = findViewById(R.id.btnChooseLocation);
        dotsIndicator = findViewById(R.id.dotsIndicator);

        viewPager.setAdapter(new WelcomePagerAdaptor(this,getSupportFragmentManager()));
        dotsIndicator.setViewPager(viewPager);

        btnChooseLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this,LoginActivity1.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (user!=null){
            Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
            startActivity(intent);
            finish();;
        }
    }
}