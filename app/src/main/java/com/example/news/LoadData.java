package com.example.news;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.news.NewsObject;

import java.util.ArrayList;

public class LoadData {
    private ArrayList<NewsObject> newsObjects;
    private CardRecycleAdapter cardRecycleAdapter;

    public LoadData(ArrayList<NewsObject> newsObjects, CardRecycleAdapter cardRecycleAdapter) {
        this.newsObjects = newsObjects;
        this.cardRecycleAdapter = cardRecycleAdapter;
    }


    public void getData(LayoutInflater inflater, String url) {
        RequestQueue queue = Volley.newRequestQueue(inflater.getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Gson gson = new Gson();
                    JSONArray jsonArray = jsonObject.getJSONArray("articles");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        NewsObject newsObject = gson.fromJson(jsonArray.get(i).toString(), NewsObject.class);
                        newsObjects.add(newsObject);
                        cardRecycleAdapter.notifyDataSetChanged();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onErrorResponse", error.toString());
            }
        });

        queue.add(stringRequest);

    }
}
