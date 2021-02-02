package com.example.e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class DeliveryActivity extends AppCompatActivity {

    private RecyclerView deliveryRecyclerview;
    private Button changeORaddNewAddressBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle("Delivery");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        deliveryRecyclerview = findViewById(R.id.delivery_recyclerview);
        changeORaddNewAddressBtn = findViewById(R.id.change_or_add_address_btn);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        deliveryRecyclerview.setLayoutManager(layoutManager);
        List<CartItemModel> cartItemModelList = new ArrayList<>();

        cartItemModelList.add(new CartItemModel(0,R.drawable.milk,"Milk",2,"Rs.49,999/-","Rs.59,999/-",1,0,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.milk,"Milk",2,"Rs.49,999/-","Rs.59,999/-",1,0,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.milk,"Milk",2,"Rs.49,999/-","Rs.59,999/-",1,0,0));
        cartItemModelList.add(new CartItemModel(1,"Price (3 items)","Rs.1,69,999/-","Free","Rs.1,69,999/-","Rs.5,999/-"));
        CartAdapter cartAdapter = new CartAdapter(cartItemModelList);
        deliveryRecyclerview.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        changeORaddNewAddressBtn.setVisibility(View.VISIBLE);

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}