package com.example.e_commerce.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.e_commerce.CartItemModel;
import com.example.e_commerce.CategoryAdapter;
import com.example.e_commerce.CategoryModel;
import com.example.e_commerce.HomePageAdapter;
import com.example.e_commerce.HomePageModel;
import com.example.e_commerce.HorizontalProductScrollModel;
import com.example.e_commerce.R;
import com.example.e_commerce.SliderModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.e_commerce.DBqueries.categoryModelList;
import static com.example.e_commerce.DBqueries.firebaseFirestore;
import static com.example.e_commerce.DBqueries.homePageModelList;
import static com.example.e_commerce.DBqueries.loadCategories;
import static com.example.e_commerce.DBqueries.loadFragmentData;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView homePageRecyclerView;
    private HomePageAdapter adapter;
    //private List<CategoryModel> categoryModelList;
    //private FirebaseFirestore firebaseFirestore;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);
        categoryRecyclerView = view.findViewById(R.id.categoryRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        //categoryModelList = new ArrayList<CategoryModel>();

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);

        if (categoryModelList.size()==0){
            loadCategories(categoryAdapter,getContext());
        }else {
            categoryAdapter.notifyDataSetChanged();
        }

        /*firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("CATEGORIES").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot documentSnapshot:task.getResult()){
                                categoryModelList.add(new CategoryModel(documentSnapshot.get("icon").toString(),documentSnapshot.get("categoryName").toString()));
                            }
                            categoryAdapter.notifyDataSetChanged();
                        }else {
                            String error = task.getException().getMessage();
                            Toast.makeText(getContext(),error, Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/

        /*categoryModelList.add(new CategoryModel("R.drawable.categories_home_logo","Home"));
        categoryModelList.add(new CategoryModel("R.drawable.ic_baseline_category","Category"));
        categoryModelList.add(new CategoryModel("R.drawable.ic_baseline_search_icon","Search"));
        categoryModelList.add(new CategoryModel("Link","My List"));
        categoryModelList.add(new CategoryModel("Link","Basket"));*/

        ///////// banner slider
       /* List<SliderModel>sliderModelList = new ArrayList<SliderModel>();

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
        sliderModelList.add(new SliderModel(R.drawable.addbanner));*/
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

        homePageRecyclerView = view.findViewById(R.id.home_page_recyclerview);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        homePageRecyclerView.setLayoutManager(testingLayoutManager);
        //List<HomePageModel> homePageModelList = new ArrayList<>();
        /*homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripad,"#000000"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(2,"Deal",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deal",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripad,"#000000"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(2,"Deal",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripad,"#000000"));*/
        adapter = new HomePageAdapter(homePageModelList);
        homePageRecyclerView.setAdapter(adapter);

        if (homePageModelList.size()==0){
            loadFragmentData(adapter,getContext());
        }else {
            adapter.notifyDataSetChanged();
        }

        /*firebaseFirestore.collection("CATEGORIES")
                .document("HOME")
                .collection("TOP_DEALS")
                .orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot documentSnapshot:task.getResult()){
                                if ((long)documentSnapshot.get("view_type")==0){
                                    List<SliderModel> sliderModelList = new ArrayList<>();
                                    long no_of_banners = (long)documentSnapshot.get("no_of_banners");
                                    for (long x = 1;x < no_of_banners+1;x++){
                                        sliderModelList.add(new SliderModel(documentSnapshot.get("banner_"+x).toString()));
                                    }
                                    homePageModelList.add(new HomePageModel(0,sliderModelList));
                                }else if ((long)documentSnapshot.get("view_type")==1){
                                    homePageModelList.add(new HomePageModel(1,documentSnapshot.get("strip_ad_banner").toString(),"#000000"));
                                }
                                else if ((long)documentSnapshot.get("view_type")==2){
                                    List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
                                    long no_of_products = (long)documentSnapshot.get("no_of_products");
                                    for (long x = 1;x < no_of_products+1;x++){
                                        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(
                                                documentSnapshot.get("product_ID_"+x).toString(),
                                                documentSnapshot.get("product_image_"+x).toString(),
                                                documentSnapshot.get("product_title_"+x).toString(),
                                                documentSnapshot.get("product_subtitle_"+x).toString(),
                                                documentSnapshot.get("product_price_"+x).toString()));
                                    }
                                    homePageModelList.add(new HomePageModel(2,documentSnapshot.get("layout_title").toString(),documentSnapshot.get("layout_background").toString(),horizontalProductScrollModelList));
                                }else if ((long)documentSnapshot.get("view_type")==3){
                                    List<HorizontalProductScrollModel> gridLayoutModelList = new ArrayList<>();
                                    long no_of_products = (long)documentSnapshot.get("no_of_products");
                                    for (long x = 1;x < no_of_products+1;x++){
                                        gridLayoutModelList.add(new HorizontalProductScrollModel(
                                                documentSnapshot.get("product_ID_"+x).toString(),
                                                documentSnapshot.get("product_image_"+x).toString(),
                                                documentSnapshot.get("product_title_"+x).toString(),
                                                documentSnapshot.get("product_subtitle_"+x).toString(),
                                                documentSnapshot.get("product_price_"+x).toString()));
                                    }
                                    homePageModelList.add(new HomePageModel(3,documentSnapshot.get("layout_title").toString(),documentSnapshot.get("layout_background").toString(),gridLayoutModelList));
                                }
                            }
                            adapter.notifyDataSetChanged();
                        }else {
                            String error = task.getException().getMessage();
                            Toast.makeText(getContext(),error, Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/

        ////////

        return view;
    }
}