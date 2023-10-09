package com.example.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.databinding.CategoriesBinding;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    List<Integer> imglistCategories;
    List<String> listCategories;

    @NonNull
    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.ViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return listCategories.size();
    }

    public void add(List<Integer> imglistCategories, List<String> listCategories) {

        this.imglistCategories = imglistCategories;
        this.listCategories = listCategories;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CategoriesBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CategoriesBinding.bind(itemView);
        }

        public void setData(int position) {
            binding.ivCategory.setImageResource(imglistCategories.get(position));
            binding.tvCategory.setText(listCategories.get(position));
        }
    }
}
