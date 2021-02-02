package com.example.e_commerce.ui.my_wishlist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_commerce.R;
import com.example.e_commerce.WishlistAdapter;
import com.example.e_commerce.WishlistModel;

import java.util.ArrayList;
import java.util.List;

public class MyWishListFragment extends Fragment {

    public MyWishListFragment() {
        // Required empty public constructor
    }
    private RecyclerView wishlistRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_wish_list, container, false);

        wishlistRecyclerView = view.findViewById(R.id.my_wishlist_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        wishlistRecyclerView.setLayoutManager(linearLayoutManager);

        List<WishlistModel> wishlistModelList = new ArrayList<>();
        /*wishlistModelList.add(new WishlistModel(R.drawable.milk,"Milky Milk",1,"3",145,"Rs.49,999/-","Rs.59,999/-","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.milk,"Milky Milk",5,"3",145,"Rs.49,999/-","Rs.59,999/-","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.milk,"Milky Milk",0,"3",145,"Rs.49,999/-","Rs.59,999/-","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.milk,"Milky Milk",0,"3",145,"Rs.49,999/-","Rs.59,999/-","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.milk,"Milky Milk",2,"3",145,"Rs.49,999/-","Rs.59,999/-","Cash on Delivery"));
        */
        WishlistAdapter wishlistAdapter = new WishlistAdapter(wishlistModelList);
        wishlistRecyclerView.setAdapter(wishlistAdapter);
        wishlistAdapter.notifyDataSetChanged();

        return view;
    }
}