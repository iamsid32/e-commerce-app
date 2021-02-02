package com.example.e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("categoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categoryRecyclerView = findViewById(R.id.category_recyclerview);

        ///////// banner slider
        /*List<SliderModel> sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.addbanner));
        sliderModelList.add(new SliderModel(R.drawable.addbanner));

        sliderModelList.add(new SliderModel(R.drawable.addbanner));
        sliderModelList.add(new SliderModel(R.drawable.addbanner));
        sliderModelList.add(new SliderModel(R.drawable.addbanner));
        sliderModelList.add(new SliderModel(R.drawable.addbanner));
        sliderModelList.add(new SliderModel(R.drawable.addbanner));
        sliderModelList.add(new SliderModel(R.drawable.addbanner));
        sliderModelList.add(new SliderModel(R.drawable.addbanner));
        sliderModelList.add(new SliderModel(R.drawable.addbanner));

        sliderModelList.add(new SliderModel(R.drawable.addbanner));
        sliderModelList.add(new SliderModel(R.drawable.addbanner));
         */

        ///////// banner slider

        ////////// horizontal product layout

        /*List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk,"Milky Mist-Curd-Farm Fresh","500g - puch","Rs. 35"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk,"Milky Mist-Curd-Farm Fresh","500g - puch","Rs. 35"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk,"Milky Mist-Curd-Farm Fresh","500g - puch","Rs. 35"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk,"Milky Mist-Curd-Farm Fresh","500g - puch","Rs. 35"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk,"Milky Mist-Curd-Farm Fresh","500g - puch","Rs. 35"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk,"Milky Mist-Curd-Farm Fresh","500g - puch","Rs. 35"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk,"Milky Mist-Curd-Farm Fresh","500g - puch","Rs. 35"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk,"Milky Mist-Curd-Farm Fresh","500g - puch","Rs. 35"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.milk,"Milky Mist-Curd-Farm Fresh","500g - puch","Rs. 35"));
         */
        ////////// horizontal product layout

        /////////

        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        /*homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripad,"#000000"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(2,"Deal",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deal",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripad,"#000000"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(2,"Deal",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripad,"#000000"));
        */
        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id==R.id.main_search_icon){
            return true;
        }else if (id==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}