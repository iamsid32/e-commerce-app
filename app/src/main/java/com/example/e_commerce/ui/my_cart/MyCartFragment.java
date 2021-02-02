package com.example.e_commerce.ui.my_cart;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.e_commerce.CartAdapter;
import com.example.e_commerce.CartItemModel;
import com.example.e_commerce.R;

import java.util.ArrayList;
import java.util.List;

public class MyCartFragment extends Fragment {


    public MyCartFragment() {
        // Required empty public constructor
    }
    private RecyclerView cartItemsRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);
        cartItemsRecyclerView = view.findViewById(R.id.cart_items_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartItemsRecyclerView.setLayoutManager(layoutManager);
        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0,R.drawable.milk,"Milk",2,"Rs.49,999/-","Rs.59,999/-",1,0,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.milk,"Milk",2,"Rs.49,999/-","Rs.59,999/-",1,0,0));
        cartItemModelList.add(new CartItemModel(0, R.drawable.milk,"Milk",2,"Rs.49,999/-","Rs.59,999/-",1,0,0));
        cartItemModelList.add(new CartItemModel(1,"Price (3 items)","Rs.1,69,999/-","Free","Rs.1,69,999/-","Rs.5,999/-"));
        CartAdapter cartAdapter = new CartAdapter(cartItemModelList);
        cartItemsRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();
        return view;
    }
}
