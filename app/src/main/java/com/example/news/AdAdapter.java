package com.example.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.news.databinding.AdsliderBinding;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class AdAdapter extends SliderViewAdapter<AdAdapter.SliderAdapterViewHolder> {
    private List<Integer> imglist;

    public AdAdapter(List<Integer> imglist) {

        this.imglist = imglist;
    }

    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adslider, null);
        return new SliderAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, int position) {
        viewHolder.setData(position);
    }

    @Override
    public int getCount() {
        return imglist.size();
    }

    public class SliderAdapterViewHolder extends ViewHolder {
        AdsliderBinding binding;
        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            binding = AdsliderBinding.bind(itemView);
        }

        public void setData(int position) {
            Glide.with(itemView)
                    .load(imglist.get(position))
                    .fitCenter()
                    .into(binding.imgad);
        }
    }
}
