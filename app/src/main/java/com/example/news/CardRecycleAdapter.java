package com.example.news;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class CardRecycleAdapter extends RecyclerView.Adapter<CardRecycleAdapter.CardViewHolder> {

    private ArrayList<NewsObject> newsObjects;
    private FragmentActivity main_activity;


    public CardRecycleAdapter(ArrayList<NewsObject> newsObjects, FragmentActivity main_activity) {
        this.newsObjects = newsObjects;
        this.main_activity = main_activity;
    }


    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        CardView cardView = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);
        return new CardViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(CardRecycleAdapter.CardViewHolder cardViewHolder, final int i) {
        CardView cardView = cardViewHolder.cardView;
        ImageView imageView = cardView.findViewById(R.id.news_image);

        new DownImageTask(imageView).execute(newsObjects.get(i).getUrlToImage());

        TextView newTitle = cardView.findViewById(R.id.news_title);
        newTitle.setText(newsObjects.get(i).getTitle());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = newsObjects.get(i).getUrl();
                Intent intent = new Intent(main_activity, WebActivity.class);
                intent.putExtra("url",url);
                main_activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsObjects.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public CardViewHolder(CardView itemView) {
            super(itemView);
            cardView = itemView;
        }
    }

    class DownImageTask extends AsyncTask<String, Void, Drawable> {
        private Drawable drawable;
        private ImageView imageView;

        public DownImageTask(ImageView imageView) {
            this.imageView = imageView;
        }


        @Override
        protected Drawable doInBackground(String... imageUrl) {
            try {
                URL url = new URL(imageUrl[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                drawable = Drawable.createFromStream(urlConnection.getInputStream(), "image");

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return drawable;
        }

        @Override
        protected void onPostExecute(Drawable drawable) {
            super.onPostExecute(drawable);
            imageView.setImageDrawable(drawable);
        }
    }


}
