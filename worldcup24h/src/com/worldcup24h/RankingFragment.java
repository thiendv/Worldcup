package com.worldcup24h;

import java.util.ArrayList;
import java.util.List;

import com.worldcup24h.adapter.GroupTeamAdapter;
import com.worldcup24h.model.TeamItem;
import com.worldcup24h.model.GroupItem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;

public final class RankingFragment extends Fragment {
    private static final String KEY_CONTENT = "TestFragment:Content";

    public static RankingFragment newInstance(String content) {
        RankingFragment fragment = new RankingFragment();

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
    	
    	View v = inflater.inflate(R.layout.data_fragment_view, container, false);
    	ExpandableListView lvListView = (ExpandableListView) v.findViewById(R.id.lv_data);
        List<GroupItem> pGroupCollection = getGroupCollection();
		GroupTeamAdapter adapter = new GroupTeamAdapter(getActivity(), lvListView, pGroupCollection );
        lvListView.setAdapter(adapter);
        return v;
    }

    private List<GroupItem> getGroupCollection() {
		// TODO Auto-generated method stub
    	List<GroupItem> result = new ArrayList<GroupItem>();
    	for(int i = 0; i < 8; i++){
    		GroupItem item = new GroupItem();
    		item.setName("GROUP "+i);
    		List<Object> childList = new ArrayList<Object>();
    		for(int j=0; j< 4; j++){
    			TeamItem childItem = new TeamItem();
    			childItem.setName("name "+j);
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
