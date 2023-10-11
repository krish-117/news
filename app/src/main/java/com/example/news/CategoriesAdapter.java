package com.example.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.databinding.CategoriesBinding;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    List<ModelCategories> list=new ArrayList<>();

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
        return list.size();
    }

    public void add(List<ModelCategories> list) {
        this.list.addAll(list);
        notifyItemRangeInserted(this.list.size(),list.size());
    }

    public void filterList(List<ModelCategories> filteredlist) {

        list = filteredlist;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CategoriesBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CategoriesBinding.bind(itemView);
        }

        public void setData(int position) {
            binding.ivCategory.setImageResource(list.get(position).getImg());
            binding.tvCategory.setText(list.get(position).getTitle());
        }
    }
}
