package com.example.news.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class BusinessFragment extends Fragment {


    private ArrayList<NewsObject> newsObjects;
    private CardRecycleAdapter cardRecycleAdapter;
    private RecyclerView recyclerView;

    public BusinessFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        String url = "https://newsapi.org/v2/top-headlines?country=tw&category=business&apiKey="+ getResources().getText(R.string.key);

        newsObjects = new ArrayList<>();
        recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_business, container, false);
        cardRecycleAdapter = new CardRecycleAdapter(newsObjects);
        recyclerView.setAdapter(cardRecycleAdapter);

        GridLayoutManager layoutManager = new GridLayoutManager(recyclerView.getContext().getApplicationContext(), 1);
        recyclerView.setLayoutManager(layoutManager);

        new LoadData(newsObjects, cardRecycleAdapter).getData(inflater, url);

        return recyclerView;
    }

}
