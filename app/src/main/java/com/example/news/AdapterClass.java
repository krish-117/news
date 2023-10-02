package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.news.databinding.ActivityNewsScrollBinding;

import java.util.ArrayList;
import java.util.zip.Inflater;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {
    Context context;
    ArrayList<Integer> imglist;
    ArrayList<String> titlelist;
    ArrayList<String> articlelist;

    public AdapterClass(ArrayList<Integer> imglist, ArrayList<String> titlelist, ArrayList<String> articlelist) {

        this.imglist = imglist;
        this.titlelist = titlelist;
        this.articlelist = articlelist;
    }

    @NonNull
    @Override
    public AdapterClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_news_scroll,parent,false);
        context=parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClass.ViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return imglist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ActivityNewsScrollBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=ActivityNewsScrollBinding.bind(itemView);

        }

        public void setData(int position) {
            binding.ivimg.setImageResource(imglist.get(position));
            binding.tvtitle.setText(titlelist.get(position));
            binding.tvarticle.setText(articlelist.get(position));

            Glide.with(context)
                    .load(imglist.get(position))
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .apply(RequestOptions.bitmapTransform(new BlurTransformation(15, 3)))
                    .into(binding.ivblur);

            Glide.with(context)
                    .load(imglist.get(position))
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 3)))
                    .into(binding.ivwebblur);
        }
    }
}
