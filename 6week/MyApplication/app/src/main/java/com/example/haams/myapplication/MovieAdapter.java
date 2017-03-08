package com.example.haams.myapplication;

import android.app.Activity;
import android.content.Context;
import android.gesture.GestureLibraries;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by haams on 2017-03-06.
 */

public class MovieAdapter extends BaseAdapter {
    private ArrayList<Movie> movieList;
    private Context context;
    private ImageView mImg;
    int position;


    public MovieAdapter(ArrayList<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.movie_items, parent, false);
        mImg = (ImageView) itemView.findViewById(R.id.movieImg);
        this.position = position;
        fillViews(mImg, position);

        return itemView;
    }

    private void fillViews(ImageView mImg, int position) {

        Glide.with(context)
                .load(movieList.get(position).getMovieImg())
                .skipMemoryCache(true).fitCenter()
                .into(mImg);

        selectViews(mImg, position);
    }

    private void selectViews(ImageView mImg, int position) {
        mImg.setOnClickListener(new movieViewListener(position));
    }


    private class movieViewListener implements View.OnClickListener {
        int position;

        public movieViewListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, position + "번 쨰", Toast.LENGTH_LONG).show();
            whatTheMoviesAre(position);
        }

        private void whatTheMoviesAre(int position) {
            final AlertDialog.Builder dlg = new AlertDialog.Builder(context);
            final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View itemtView2 = inflater.inflate(R.layout.movie_items, null, false);
            ImageView mImgs[] = new ImageView[movieList.size()];


            for (int i = 0; i < position; i++) {
                mImgs[i] = (ImageView) itemtView2.findViewById(R.id.movieImg);
                Glide.with(context)
                        .load(movieList.get(position).getMovieImg())
                        .fitCenter().skipMemoryCache(true)
                        .into(mImgs[i]);
            }


            dlg.setTitle("영화소개");
            dlg.setView(itemtView2);
            dlg.setPositiveButton("확인", null);
            dlg.show();
        }
    }
}
