package com.example.news;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.news.databinding.FragmentDiscoverBinding;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class Discover extends Fragment {

    List<Integer> imglist = new ArrayList<>();
    FragmentDiscoverBinding binding;
    CategoriesAdapter categoriesAdapter;

    List<ModelCategories> list = new ArrayList<>();

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
        binding.slider.setScrollTimeInSec(3);
        binding.slider.setAutoCycle(true);
        binding.slider.startAutoCycle();

        categoriesAdapter = new CategoriesAdapter();
        list.add( new ModelCategories("automobile",R.drawable.automobile));
        list.add( new ModelCategories("education",R.drawable.education));
        list.add( new ModelCategories("fashion",R.drawable.fashion));
        list.add(new ModelCategories("hatke",R.drawable.hatke));
        list.add(new ModelCategories("movie",R.drawable.movie));
        list.add( new ModelCategories("science",R.drawable.science));
        list.add(new ModelCategories("startup",R.drawable.startup));
        list.add(new ModelCategories("travel",R.drawable.travel));
        list.add(new ModelCategories("world",R.drawable.world));
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),3);
        categoriesAdapter.add(list);
        binding.rcv.setLayoutManager(layoutManager);
        binding.rcv.setAdapter(categoriesAdapter);

        binding.searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });
    }

    private void filter(String newText) {

       List<ModelCategories> filteredlist = new ArrayList<>();

        for (ModelCategories item : list) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.getTitle().toLowerCase().contains(newText.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            categoriesAdapter.filterList(filteredlist);
        }

    }
}