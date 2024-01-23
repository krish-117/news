package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.news.databinding.ActivitySettingBinding;

import java.util.ArrayList;
import java.util.List;

public class Setting extends AppCompatActivity {

    ActivitySettingBinding binding;

    List<SettingModel> list = new ArrayList<SettingModel>();
    SettingAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting);

        list.add(new SettingModel(R.drawable.profile,"account"));
        list.add(new SettingModel(R.drawable.automobile,"notification"));
        list.add(new SettingModel(R.drawable.automobile,"appearence"));
        list.add(new SettingModel(R.drawable.automobile,"Privacy and sicurity"));
        list.add(new SettingModel(R.drawable.automobile,"help and support"));
        list.add(new SettingModel(R.drawable.automobile,"about"));

        adapter = new SettingAdapter(list);
        binding.recycler.setAdapter(adapter);

        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.searchView.clearFocus();

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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

        List<SettingModel> filteredlist = new ArrayList<>();

        for (SettingModel item : list) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.getName().toLowerCase().contains(newText.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            adapter.filterList(filteredlist);
        }

    }

}
