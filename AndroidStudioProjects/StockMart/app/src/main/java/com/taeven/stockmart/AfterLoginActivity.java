package com.taeven.stockmart;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.taeven.stockmart.fragments.myTransaction;
import com.taeven.stockmart.fragments.scoreBoard;
import com.taeven.stockmart.fragments.stockDetails;

import java.util.ArrayList;
import java.util.List;

public class AfterLoginActivity extends AppCompatActivity {
    private ViewPager pager;
    private TabLayout tabs;
    private static int sel_color=Color.parseColor("#FFE7ECF6"),unsel_color = Color.parseColor("#a1d0cb");
    private static final int NUM_PAGES = 3;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        
        setViews();
        setSupportActionBar(toolbar);
    }
    public void setViews()
    {
        pager=(ViewPager)findViewById(R.id.mainPager);
        ScreenSlidePagerAdapter slide = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        slide.addFragment(new myTransaction(),"My Transaction");
        slide.addFragment(new stockDetails(),"Stocks");
        slide.addFragment(new scoreBoard(),"Scoreboard");
        pager.setAdapter(slide);
        tabs=(TabLayout)findViewById(R.id.tab);
        tabs.setupWithViewPager(pager);
        tabs.setSelectedTabIndicatorHeight(7);
        toolbar = (Toolbar)findViewById(R.id.toolbarAfterLogin);


    }


    private class ScreenSlidePagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList=new ArrayList<>();
        private final List<String> fragmentTitleList = new ArrayList<>();

        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment,String title)
        {
            fragmentList.add(fragment);
            fragmentTitleList.add(title);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
           return fragmentList.get(position);

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitleList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int item_id = item.getItemId();
        switch (item_id)
        {
            case R.id.messege:
                Intent i = new Intent("android.intent.action.messege");
                startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menustart,menu);
        return true;

    }
}


