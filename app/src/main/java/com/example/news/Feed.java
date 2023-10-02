package com.example.news;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.PagerSnapHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.news.databinding.FragmentFeedBinding;

import java.util.ArrayList;

public class Feed extends Fragment {

    FragmentFeedBinding binding;
    ArrayList<Integer> imglist = new ArrayList<>();
    ArrayList<String> titlelist = new ArrayList<>();
    ArrayList<String> articlelist = new ArrayList<>();
    String title,article;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_feed, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imglist.add(R.drawable.img1);
        title = "\"Shameful\": Elon Musk Accuses Justin Trudeau Of \"Crushing Free Speech\"";
        titlelist.add(title);
        article = "'Shameful': Elon Musk Accuses Justin Trudeau Of 'Crushing Free Speech'\n" +
                "Elon Musk's remark came after Canada made it must for streaming services to register with government\n" +
                "\n" +
                "\n" +
                "Ottawa: SpaceX founder and CEO Elon Musk slammed the Justin Trudeau government in Canada for \"crushing free speech\" in the country.\n" +
                "His remark came in the wake of a recent order of the Canadian government which makes it compulsory for online streaming services to formally register with the government for 'regulatory controls'.\n" +
                "\n";
        articlelist.add(article);

        imglist.add(R.drawable.img2);
        title = "Bugs, Apps, Software: Apple Lists Reasons Behind iPhone 15 Overheating";
        titlelist.add(title);
        article ="Apple Inc. on Saturday said that recent claims of new iPhones getting too hot to the touch are due to software and app-related bugs and that fixes are coming soon. \n" +
                "The company said the device can get warm in the first few days as the device works overtime to get set up and restore a user's data, due to a bug in the latest iOS 17 software, and because of some third-party apps overloading the system. Bloomberg News reported on the issue last week.\n" +
                "\n" +
                "\"The device may feel warmer during the first few days after setting up or restoring the device because of increased background activity,\" Apple said in a statement.";
        articlelist.add(article);

        imglist.add(R.drawable.img3);
        title = "‘Scam 2003 - The Telgi Story’ series review: A real fake";
        titlelist.add(title);
        article ="Scam 1992 (2020) was a sensational 10-part series about the making and unmaking of a financial fraudster. A lot separates its protagonist, Harshad Mehta, from Abdul Karim Telgi, the hero of a stand-alone second season. The former excelled in insidious market manipulation; the latter sold counterfeit stamp papers to a margin of thousands of crores. One was a Mumbai-bred Gujarati; the other was a Muslim migrant from Karnataka. Mehta’s vices, if I remember correctly, were limited to expensive cars, cricket games, and a brief flirtation with golf. By contrast, Telgi, a non-smoking, non-drinking prude, once famously splurged lakhs of rupees on a bar dancer he adored. As played by Gagan Dev Riar, he’s an equally colourful — and compelling — character as Mehta. Why, then, does he pack the weaker punch?\n\n" ;
        articlelist.add(article);

        AdapterClass adapterClass = new AdapterClass(imglist,titlelist,articlelist);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(binding.rv);
        binding.rv.setAdapter(adapterClass);
    }
}