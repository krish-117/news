package com.example.news;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.news.databinding.FragmentDiscoverBinding;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class Discover extends Fragment {

    List<Integer> imglist = new ArrayList<>();
    FragmentDiscoverBinding binding;


    List<Integer> imglistCategories = new ArrayList<>();
    List<String> listCategories = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_discover, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imglist.add(R.drawable.img1);
        imglist.add(R.drawable.img2);
        imglist.add(R.drawable.img3);

        AdAdapter adapter = new AdAdapter(imglist);

        binding.slider.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        binding.slider.setSliderAdapter(adapter);
        binding.slider.setScrollTimeInSec(1);
        binding.slider.setAutoCycle(true);
        binding.slider.startAutoCycle();

        CategoriesAdapter categoriesAdapter = new CategoriesAdapter();
        imglistCategories.add(R.drawable.google);
        listCategories.add("Google");
        imglistCategories.add(R.drawable.facebook);
        listCategories.add("Facebook");
        imglistCategories.add(R.drawable.instagram);
        listCategories.add("instagram");
        imglistCategories.add(R.drawable.snapchat);
        listCategories.add("snapChat");
        imglistCategories.add(R.drawable.telegram);
        listCategories.add("telegram");
        imglistCategories.add(R.drawable.twitter);
        listCategories.add("Twitter");
        imglistCategories.add(R.drawable.whatsapp);
        listCategories.add("whatsapp");
        categoriesAdapter.add(imglistCategories,listCategories);
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),3);
        binding.rcv.setLayoutManager(layoutManager);
        binding.rcv.setAdapter(categoriesAdapter);
    }
}