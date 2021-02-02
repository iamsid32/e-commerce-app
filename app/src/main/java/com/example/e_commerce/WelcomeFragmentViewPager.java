package com.example.e_commerce;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WelcomeFragmentViewPager extends Fragment {

    public static Fragment newInstance(String title, String desc, int image) {
        WelcomeFragmentViewPager fragmentViewPager = new WelcomeFragmentViewPager();
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        bundle.putString("desc",desc);
        bundle.putInt("image",image);
        fragmentViewPager.setArguments(bundle);
        return fragmentViewPager;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_welcome_viewpager,container,false);
        ImageView imageViewWelcome = view.findViewById(R.id.imageViewWelcome);
        TextView textViewTitle = view.findViewById(R.id.textViewTitle);
        TextView textViewDesc = view.findViewById(R.id.textViewDesc);

        textViewTitle.setText(getArguments().getString("title"));
        textViewDesc.setText(getArguments().getString("desc"));
        imageViewWelcome.setImageResource(getArguments().getInt("image"));

        return view;
    }
}
