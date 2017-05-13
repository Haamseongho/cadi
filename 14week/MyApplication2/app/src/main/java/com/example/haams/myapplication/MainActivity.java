package com.example.haams.myapplication;

import android.content.res.Configuration;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ViewPager mainView;
    private TabLayout tabLayout;
    private MainStateAdapter mStateAdapter;
    private ActionBarDrawerToggle mainDrawerToggle;
    private DrawerLayout drawer;
    private NavigationView nav_Views;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mainView = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.mainTab);

        initTabs();
        initToolBar();
        initSlideMenu();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mainDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initTabs() {
        tabLayout.setSelectedTabIndicatorColor(Color.BLACK);
        tabLayout.setSelectedTabIndicatorHeight(10);
        tabLayout.setBackgroundColor(Color.parseColor("#cccccc"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_launcher).setText("친구찾기"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_textsms_black_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_add_a_photo_black_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_notifications_active_black_24dp));

        mStateAdapter = new MainStateAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        mainView.setOffscreenPageLimit(1);
        mainView.setBackgroundColor(Color.DKGRAY);
        mainView.setAdapter(mStateAdapter);


        mainView.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout) {
            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mainView.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Between Together");
        toolbar.setTitleMarginStart(60);
        toolbar.setTitleMarginEnd(40);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }


    private void initSlideMenu() {
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        nav_Views = (NavigationView) findViewById(R.id.nav_Views);
        mainDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawer, R.string.drawer_open, R.string.drawer_close);
        // mainDrawerToggle.setHomeAsUpIndicator();
        drawer.addDrawerListener(mainDrawerToggle);

        nav_Views.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawer.closeDrawers();
                item.setChecked(true);

                switch (item.getItemId()) {
                    case R.id.todoList:
                        Toast.makeText(MainActivity.this, "오늘 해야할 일정은?", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.foodSpot:
                        Toast.makeText(MainActivity.this, "오늘 가야할 맛집은?", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.date:
                        Toast.makeText(MainActivity.this, "오늘 가야할 데이트코스는?", Toast.LENGTH_LONG).show();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mainDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mainDrawerToggle.onConfigurationChanged(newConfig);
    }
}
