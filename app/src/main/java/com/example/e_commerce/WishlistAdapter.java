package com.example.e_commerce;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.ViewHolder> {

    private List<WishlistModel> wishlistModelList;

    public WishlistAdapter(List<WishlistModel> wishlistModelList) {
        this.wishlistModelList = wishlistModelList;
    }

    @NonNull
    @Override
    public WishlistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wishlist_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String resource = wishlistModelList.get(position).getProductImage();
        String title = wishlistModelList.get(position).getProductTitle();
        long freeCoupens = wishlistModelList.get(position).getFreeCoupens();
        String rating = wishlistModelList.get(position).getRating();
        //long totalRatings = wishlistModelList.get(position).getTotalRatings();
        String productPrice = wishlistModelList.get(position).getProductPrice();
        String cuttedPrice = wishlistModelList.get(position).getCuttedPrice();
        boolean paymentMethod = wishlistModelList.get(position).isCOD();
        holder.setData(resource,title,freeCoupens,rating,productPrice,cuttedPrice,paymentMethod);
    }

    @Override
    public int getItemCount() {
        return wishlistModelList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView productImage;
        private TextView productTitle;
        protected TextView freeCoupens;
        private ImageView coupenIcon;
        private TextView rating;
        private TextView totalRatings;
        private View priceCut;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView paymentMethod;
        private ImageButton deleteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image6);
            productTitle = itemView.findViewById(R.id.product_title6);
            freeCoupens = itemView.findViewById(R.id.free_coupen6);
            coupenIcon = itemView.findViewById(R.id.coupen_icon6);
            rating = itemView.findViewById(R.id.tv_rating_detail_product1);
            totalRatings = itemView.findViewById(R.id.total_ratings6);
            priceCut = itemView.findViewById(R.id.price_cut);
            productPrice = itemView.findViewById(R.id.product_price6);
            cuttedPrice = itemView.findViewById(R.id.cutted_price6);
            paymentMethod = itemView.findViewById(R.id.payment_method6);
            deleteBtn = itemView.findViewById(R.id.delet_btn);
        }
        private void setData(String resource, String title, long freeCoupensNo, String averageRate, /*long totalRatingsNo,*/ String price, String cuttedPriceValue,boolean COD){
            Glide.with(itemView.getContext()).load(resource).apply(new RequestOptions().placeholder(R.drawable.milk)).into(productImage);
            productTitle.setText(title);
            if (freeCoupensNo!=0){
                coupenIcon.setVisibility(View.VISIBLE);
                if (freeCoupensNo==1){
                    freeCoupens.setText("free "+freeCoupensNo+" coupen");
                }else{
                    freeCoupens.setText("free "+freeCoupensNo+" coupens");
                }
            }else {coupenIcon.setVisibility(View.INVISIBLE);
            freeCoupens.setVisibility(View.INVISIBLE);
            }
            rating.setText(averageRate);
            //totalRatings.setText(totalRatingsNo+"(ratings)");
            productPrice.setText(price);
            cuttedPrice.setText(cuttedPriceValue);
            if (COD){
                paymentMethod.setVisibility(View.VISIBLE);
            }
            else {
                paymentMethod.setVisibility(View.INVISIBLE);
            }
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Deleted Successfully", Toast.LENGTH_SHORT).show();
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(),ProductDetailsActivity.class);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}