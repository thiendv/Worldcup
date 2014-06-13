package com.worldcup24h;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.TabPageIndicator;

public class SampleTabsStyled extends FragmentActivity {
	private static final String[] CONTENT = new String[] {"TimeLine", "Matches", "Groups", "Ranking" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_tabs);

        FragmentPagerAdapter adapter = new GoogleMusicAdapter(getSupportFragmentManager());

        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);

        TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(pager);
    }

    class GoogleMusicAdapter extends FragmentPagerAdapter {
        public GoogleMusicAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
        	Fragment fragment = null;
        	if(position == 0){
        		fragment = TimelineFragment.newInstance(CONTENT[position % CONTENT.length]);
        	}else if(position == 1){
        		fragment = MatchesFragment.newInstance(CONTENT[position % CONTENT.length]);
        	}else if(position == 2){
        		fragment = GroupsFragment.newInstance(CONTENT[position % CONTENT.length]);
        	}else if(position == 3){
        		fragment = RankingFragment.newInstance(CONTENT[position % CONTENT.length]);
        	}
            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return CONTENT[position % CONTENT.length].toUpperCase();
        }

        @Override
        public int getCount() {
            return CONTENT.length;
        }
    }
}
