package com.example.news.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.news.CardRecycleAdapter;
import com.example.news.LoadData;
import com.example.news.NewsObject;
import com.example.news.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EntertainmentFragment extends Fragment {
    private ArrayList<NewsObject> newsObjects;
    private CardRecycleAdapter cardRecycleAdapter;
    private RecyclerView recyclerView;


    public EntertainmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String url = "https://newsapi.org/v2/top-headlines?country=tw&category=entertainment&apiKey=" + getResources().getText(R.string.key);

        newsObjects = new ArrayList<>();
        recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_business, container, false);
        cardRecycleAdapter = new CardRecycleAdapter(newsObjects,getActivity());
        recyclerView.setAdapter(cardRecycleAdapter);

        GridLayoutManager layoutManager = new GridLayoutManager(recyclerView.getContext().getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        new LoadData(newsObjects, cardRecycleAdapter).getData(inflater, url);

        return recyclerView;
    }

}
