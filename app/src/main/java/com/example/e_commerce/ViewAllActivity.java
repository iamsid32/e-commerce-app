package com.example.e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridView gridView;
    public static List<WishlistModel> wishlistModelList;
    public static List<HorizontalProductScrollModel> horizontalProductScrollModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle("Delivery");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycler_view);
        gridView = findViewById(R.id.grid_view);

        int layout_code = getIntent().getIntExtra("layout_code",-1);

        if (layout_code==0) {
            recyclerView.setVisibility(View.VISIBLE);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);

            /*List<WishlistModel> wishlistModelList = new ArrayList<>();
            wishlistModelList.add(new WishlistModel(R.drawable.milk, "Milky Milk", 1, "3", 145, "Rs.49,999/-", "Rs.59,999/-", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.milk, "Milky Milk", 5, "3", 145, "Rs.49,999/-", "Rs.59,999/-", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.milk, "Milky Milk", 0, "3", 145, "Rs.49,999/-", "Rs.59,999/-", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.milk, "Milky Milk", 0, "3", 145, "Rs.49,999/-", "Rs.59,999/-", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.milk, "Milky Milk", 2, "3", 145, "Rs.49,999/-", "Rs.59,999/-", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.milk, "Milky Milk", 1, "3", 145, "Rs.49,999/-", "Rs.59,999/-", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.milk, "Milky Milk", 5, "3", 145, "Rs.49,999/-", "Rs.59,999/-", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.milk, "Milky Milk", 0, "3", 145, "Rs.49,999/-", "Rs.59,999/-", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.milk, "Milky Milk", 0, "3", 145, "Rs.49,999/-", "Rs.59,999/-", "Cash on Delivery"));
            */
            WishlistAdapter wishlistAdapter = new WishlistAdapter(wishlistModelList);
            recyclerView.setAdapter(wishlistAdapter);
            wishlistAdapter.notifyDataSetChanged();
        }else if(layout_code==1) {
            gridView.setVisibility(View.VISIBLE);
            List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
            /*
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk, "Milky Mist-Curd-Farm Fresh", "500g - puch", "Rs. 35"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk, "Milky Mist-Curd-Farm Fresh", "500g - puch", "Rs. 35"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk, "Milky Mist-Curd-Farm Fresh", "500g - puch", "Rs. 35"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk, "Milky Mist-Curd-Farm Fresh", "500g - puch", "Rs. 35"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk, "Milky Mist-Curd-Farm Fresh", "500g - puch", "Rs. 35"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk, "Milky Mist-Curd-Farm Fresh", "500g - puch", "Rs. 35"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk, "Milky Mist-Curd-Farm Fresh", "500g - puch", "Rs. 35"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk, "Milky Mist-Curd-Farm Fresh", "500g - puch", "Rs. 35"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk, "Milky Mist-Curd-Farm Fresh", "500g - puch", "Rs. 35"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk, "Milky Mist-Curd-Farm Fresh", "500g - puch", "Rs. 35"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk, "Milky Mist-Curd-Farm Fresh", "500g - puch", "Rs. 35"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk, "Milky Mist-Curd-Farm Fresh", "500g - puch", "Rs. 35"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk, "Milky Mist-Curd-Farm Fresh", "500g - puch", "Rs. 35"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk, "Milky Mist-Curd-Farm Fresh", "500g - puch", "Rs. 35"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk, "Milky Mist-Curd-Farm Fresh", "500g - puch", "Rs. 35"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk, "Milky Mist-Curd-Farm Fresh", "500g - puch", "Rs. 35"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk, "Milky Mist-Curd-Farm Fresh", "500g - puch", "Rs. 35"));
             */
            GridProductLayoutAdapter gridProductLayoutAdapter = new GridProductLayoutAdapter(horizontalProductScrollModelList);
            gridView.setAdapter(gridProductLayoutAdapter);
        }
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