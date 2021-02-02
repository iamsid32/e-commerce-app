package com.example.e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {

    private ViewPager productImageViewPager;
    private TextView productTitle;
    private TextView cuttedPrice;
    private TextView productPrice;
    private TextView averageRatingMiniView;
    private TextView totalRatingMiniView;
    private ImageView codIndicator;
    private TextView tvCodIndicator;
    private TabLayout viewpagerIndicator;
    private ViewPager productdetailsViewpager;
    private TabLayout productdetailsTablayout;
    private FloatingActionButton addToWishlistBtn;
    private static boolean ALREADY_ADDED_TO_WISHLIST = false;
    private Button buyNowBtn;
    private FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowCustomEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        productImageViewPager = findViewById(R.id.product_images_viewpager);
        viewpagerIndicator = findViewById(R.id.viewpager_indicator);
        productdetailsViewpager = findViewById(R.id.product_details_viewpager);
        productdetailsTablayout = findViewById(R.id.product_details_tablayout);
        addToWishlistBtn = findViewById(R.id.add_to_wishlist_btn);
        buyNowBtn = findViewById(R.id.buy_now_btn);
        productTitle = findViewById(R.id.product_title);
        averageRatingMiniView = findViewById(R.id.tv_product_rating_miniview);
        totalRatingMiniView.findViewById(R.id.total_ratings_miniview);
        productPrice = findViewById(R.id.product_price);
        cuttedPrice = findViewById(R.id.cutted_price);
        codIndicator = findViewById(R.id.cod_indicator_imageview);
        tvCodIndicator = findViewById(R.id.tv_cod_indicator);

        firebaseFirestore = FirebaseFirestore.getInstance();
        List<String> productImages = new ArrayList<>();
        firebaseFirestore.collection("PRODUCTS").document("ETHfdbuUuIXfCc41CnwR")
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    DocumentSnapshot documentSnapshot = task.getResult();
                    for (long x = 1;x<(long)documentSnapshot.get("no_of_product_images")+1;x++){
                        productImages.add(documentSnapshot.get("product_image_"+x).toString());
                    }
                    ProductImagesAdaptor productImagesAdaptor = new ProductImagesAdaptor(productImages);
                    productImageViewPager.setAdapter(productImagesAdaptor);
                    productTitle.setText(documentSnapshot.get("product_title").toString());
                    averageRatingMiniView.setText(documentSnapshot.get("average_rating").toString());
                    totalRatingMiniView.setText("("+(long)documentSnapshot.get("total_ratings")+") ratings");
                    productPrice.setText(documentSnapshot.get("product_price").toString());
                    cuttedPrice.setText(documentSnapshot.get("cutted_price").toString());
                }else {
                    Toast.makeText(ProductDetailsActivity.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*List<String> productImages = new ArrayList<>();
        productImages.add(R.drawable.milk);
        productImages.add(R.drawable.milk);
        productImages.add(R.drawable.milk);
        productImages.add(R.drawable.milk);
         */
        viewpagerIndicator.setupWithViewPager(productImageViewPager,true);
        addToWishlistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ALREADY_ADDED_TO_WISHLIST){
                    ALREADY_ADDED_TO_WISHLIST = false;
                addToWishlistBtn.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#B6B2B2")));
                }else {
                    ALREADY_ADDED_TO_WISHLIST = true;
                    addToWishlistBtn.setSupportImageTintList(getResources().getColorStateList(R.color.design_default_color_primary));
                }
            }
        });
        productdetailsViewpager.setAdapter(new ProductDetailsAdaptor(getSupportFragmentManager(),productdetailsTablayout.getTabCount()));
        productdetailsViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productdetailsTablayout));
        productdetailsTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productdetailsViewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        buyNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetailsActivity.this,DeliveryActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_and_cart_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id==R.id.main_search_icon){
            return true;
        }
        if (id==R.id.main_cart_icon){
            return true;
        }
        if (id==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}