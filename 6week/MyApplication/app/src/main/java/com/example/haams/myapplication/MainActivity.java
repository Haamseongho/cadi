package com.example.haams.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView movieView;
    private ArrayList<Movie> movieList;
    private MovieAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieView = (GridView) findViewById(R.id.movieView);
        movieList = new ArrayList<>();
        movieList.add(new Movie("http://t1.daumcdn.net/movie/097f7decd11d4a0ae39cb48eade62af63e43724d"));
        movieList.add(new Movie("http://t1.daumcdn.net/movie/c68515cc88d0227584f67deaa3d0046204ae998b"));
        movieList.add(new Movie("http://t1.daumcdn.net/movie/77746e188b1ca46a1de84b09bf78e67c5c22ce64"));
        movieList.add(new Movie("http://t1.daumcdn.net/movie/fe9da43b455db93228b5bfa74dacc78107f1eb40"));
        movieList.add(new Movie("http://img1.daumcdn.net/thumb/C155x225/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fmovie%2F39e69ad23d089d99f6702dd7d92ab915b1c44b37"));
        movieList.add(new Movie("http://movie.phinf.naver.net/20170126_214/1485408982109RyPfo_JPEG/movie_image.jpg"));
        movieList.add(new Movie("http://oneringtrailers.com/images/posters/thumb_1006660MDD92KCU4.jpg"));
        movieList.add(new Movie("http://cphoto.asiae.co.kr/listimglink/6/2017011609162299103_1.jpg"));
        movieList.add(new Movie("http://movie.phinf.naver.net/20170103_29/1483407652455ujPDI_JPEG/movie_image.jpg"));
        movieList.add(new Movie("http://cfile10.uf.tistory.com/image/263EB24F56B2318231F43B"));
        movieList.add(new Movie("http://img1.daumcdn.net/thumb/C216x312/?fname=http://t1.daumcdn.net/movie/404a1310e7b23f39d1472c9a41ac69054753f1dc"));
        movieList.add(new Movie("http://img1.daumcdn.net/thumb/C155x225/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fmovie%2F9ee4bab1a0f51fb4469b6162bad861f6d25056a7"));


        mAdapter = new MovieAdapter(movieList, MainActivity.this);

        movieView.setAdapter(mAdapter);

    }
}
