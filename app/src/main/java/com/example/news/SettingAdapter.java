package com.example.news;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.databinding.ListSettingBinding;

import java.util.List;


public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.ViewHolder>  {

    List<SettingModel> list;
    Context context;
    public SettingAdapter(List list) {
        this.list=list;
    }

    @NonNull
    @Override
    public SettingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_setting,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingAdapter.ViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void filterList(List<SettingModel> filteredlist) {
        this.list=filteredlist;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ListSettingBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            binding = ListSettingBinding.bind(itemView);
        }

        public void setData(int position) {

            binding.profile.setImageResource(list.get(position).getImg());
            binding.text.setText(list.get(position).getName());

            binding.ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(position==0)
                    {
                        context.startActivity(new Intent(context, Account.class));
                    }

                }
            });
        }
    }
}
