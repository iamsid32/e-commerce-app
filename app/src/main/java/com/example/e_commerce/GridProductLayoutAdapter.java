package com.example.e_commerce;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

import java.util.List;

public class GridProductLayoutAdapter extends BaseAdapter {

    List<HorizontalProductScrollModel> horizontalProductScrollModelList;

    public GridProductLayoutAdapter(List<HorizontalProductScrollModel> horizontalProductScrollModelList) {
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    @Override
    public int getCount() {
        return horizontalProductScrollModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView==null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout,null);
            ImageView productImage = view.findViewById(R.id.h_s_product_image);
            TextView productTitle = view.findViewById(R.id.h_s_product_title);
            TextView productDescription = view.findViewById(R.id.h_s_product_description);
            TextView productPrice = view.findViewById(R.id.h_s_product_price);

            Glide.with(parent.getContext()).load(horizontalProductScrollModelList.get(position).getProductImage()).apply(new RequestOptions().placeholder(R.drawable.milk)).into(productImage);
            productTitle.setText(horizontalProductScrollModelList.get(position).getProductTitle());
            productDescription.setText(horizontalProductScrollModelList.get(position).getProductDescription());
            productPrice.setText(horizontalProductScrollModelList.get(position).getProductPrice());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productDetailsIntent = new Intent(view.getContext(),ProductDetailsActivity.class);
                    view.getContext().startActivity(productDetailsIntent);
                }
            });
        }else {
            view = convertView;
        }
        return view;
    }
}
