package com.worldcup24h;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.worldcup24h.adapter.FeedAdapter;
import com.worldcup24h.model.FeedItem;
import com.worldcup24h.model.GroupItem;
import com.worldcup24h.model.MatchItem;
import com.worldcup24h.model.TeamItem;

public final class TimelineFragment extends Fragment {
    private static final String KEY_CONTENT = "TimelineFragment:Content";

    public static TimelineFragment newInstance(String content) {
        TimelineFragment fragment = new TimelineFragment();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            builder.append(content).append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        fragment.mContent = builder.toString();

        return fragment;
    }

    private String mContent = "???";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
            mContent = savedInstanceState.getString(KEY_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	
    	View view = inflater.inflate(R.layout.timeline_view, container, false);
		final ChildHolder holder = new ChildHolder();
		holder.tvTeam1 = (TextView) view.findViewById(R.id.tv_team1);
		holder.tvTeam2 = (TextView) view.findViewById(R.id.tv_team2);
		holder.imgTeam1 = (ImageView)view.findViewById(R.id.img_team1);
		holder.imgTeam2 = (ImageView)view.findViewById(R.id.img_team2);
		holder.tvMatchTime = (TextView)view.findViewById(R.id.tv_match_time);
		holder.lvFeed = (ListView)view.findViewById(R.id.lv_feed);
		List<FeedItem> list = getList();
		FeedAdapter adapter = new FeedAdapter(getActivity(), list);
		holder.lvFeed.setAdapter(adapter);
		com.worldcup24h.Util.Utils.setListViewHeightBasedOnChildren(holder.lvFeed);
		getActivity().runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				holder.lvFeed.setSelection(0);
			}
		});
        return view;
    }

	private List<FeedItem> getList() {
		// TODO Auto-generated method stub
		List<FeedItem> result = new ArrayList<FeedItem>();
		for(int i=0;i< 30; i++){
			FeedItem item = new FeedItem();
			item.setTitle("Title "+ 0);
			item.setContent("Content: "+i);
			item.setVideoUrl("");
			result.add(item);
		}
		return result;
	}

	class ChildHolder {
		TextView tvTeam1, tvTeam2;
		ImageView imgTeam1, imgTeam2;
		TextView tvMatchTime;
		ListView lvFeed;
	}

    private List<GroupItem> getGroupCollection() {
		// TODO Auto-generated method stub
    	List<GroupItem> result = new ArrayList<GroupItem>();
    	for(int i = 0; i < 8; i++){
    		GroupItem item = new GroupItem();
    		item.setName("GROUP "+i);
    		List<Object> childList = new ArrayList<Object>();
    		for(int j=0; j< 4; j++){
    			MatchItem childItem = new MatchItem();
    			TeamItem team1 = new TeamItem();
    			team1.setName("Team1:"+j);
    			childItem.setTeam1(team1);
    			
    			TeamItem team2 = new TeamItem();
    			team2.setName("Team2:"+(j+10));
    			childItem.setTeam2(team2);
    			
    			
    			childList.add(childItem);
    		}
    		item.setChildList(childList);
    		result.add(item);
    	}
		return result;
	}

	@Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CONTENT, mContent);
    }
}
