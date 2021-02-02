package com.example.e_commerce.ui.my_orders;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_commerce.MyOrderAdapter;
import com.example.e_commerce.MyOrderItemModel;
import com.example.e_commerce.R;

import java.util.ArrayList;
import java.util.List;

public class MyOrdersFragment extends Fragment {

    private RecyclerView myOrderRecyclerView;

    public MyOrdersFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_orders, container, false);
        myOrderRecyclerView = view.findViewById(R.id.my_oredrs_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        myOrderRecyclerView.setLayoutManager(linearLayoutManager);
        List<MyOrderItemModel> myOrderItemModelList = new ArrayList<>();
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.milk,2,"Milky Milk","Delivered on 19 Jan 2021"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.milk,2,"Milky Milk","Delivered on 19 Jan 2021"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.milk,2,"Milky Milk","Cancelled"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.milk,2,"Milky Milk","Delivered on 19 Jan 2021"));
        MyOrderAdapter myOrderAdapter = new MyOrderAdapter(myOrderItemModelList);
        myOrderRecyclerView.setAdapter(myOrderAdapter);
        myOrderAdapter.notifyDataSetChanged();
        return view;
    }
}