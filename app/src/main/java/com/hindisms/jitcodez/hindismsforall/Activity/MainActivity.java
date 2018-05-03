package com.hindisms.jitcodez.hindismsforall.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.hindisms.jitcodez.hindismsforall.Fragment.TabFragment;
import com.hindisms.jitcodez.hindismsforall.R;
import com.hindisms.jitcodez.hindismsforall.Utils.Helper;

import java.util.ArrayList;
import java.util.List;

import hotchemi.android.rate.AppRate;

public class MainActivity extends AppCompatActivity {
    private static Toolbar toolbar;
    private static ViewPager viewPager;
    private static TabLayout tabLayout;
    Helper h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        h=new Helper();


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);//setting tab over viewpager

        //Implementing tab selected listener over tablayout
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());//setting current selected item over viewpager
                switch (tab.getPosition()) {
                    case 0:
                        Log.e("TAG","TAB1");
                        break;
                    case 1:
                        Log.e("TAG","TAB2");
                        break;
                    case 2:
                        Log.e("TAG","TAB3");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }



    //Setting View Pager
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new TabFragment("Whatsapp Status",h.getWhatsappStatus(this)), "Whatsapp Status");
        adapter.addFrag(new TabFragment("Friendship",h.getFriendSMS(this)), "Friendship");
        adapter.addFrag(new TabFragment("Funny",h.getFunnySMS(this)), "Funny");
        adapter.addFrag(new TabFragment("Inspiring",h.getInspiringSMS(this)), "Inspiring");
        adapter.addFrag(new TabFragment("Birthday",h.getBirthdaySMS(this)), "Birthday");
 //       adapter.addFrag(new TabFragment("Goodluck SMS",h.getGoodluckSMS(this)), "Goodluck SMS");
        adapter.addFrag(new TabFragment("Good Morning SMS",h.getGoodMorningSMS(this)), "Good Morning SMS");
        adapter.addFrag(new TabFragment("Good Night SMS",h.getGoodNightSMS(this)), "Good Night SMS");
        adapter.addFrag(new TabFragment("Missing You SMS",h.getMissingYouSMS(this)), "Missing You SMS");
     //   adapter.addFrag(new TabFragment("Love SMS",h.getLoveSMS(this)), "Love SMS");
        adapter.addFrag(new TabFragment("Romantic SMS",h.getRomanticSMS(this)), "Romantic SMS");
      //  adapter.addFrag(new TabFragment("Valentine",h.getValentineSMS(this)), "Valentine");



        viewPager.setAdapter(adapter);
    }


    //View Pager fragments setting adapter class
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();//fragment arraylist
        private final List<String> mFragmentTitleList = new ArrayList<>();//title arraylist

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }


        //adding fragments and title method
        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
    boolean flag=true;
    @Override
    public void onBackPressed() {
        if(flag==true) {
            AppRate.with(this).showRateDialog(this);
            flag=false;
        }else
        {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
