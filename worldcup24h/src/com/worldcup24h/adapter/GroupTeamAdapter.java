package com.worldcup24h.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.worldcup24h.R;
import com.worldcup24h.model.TeamItem;
import com.worldcup24h.model.GroupItem;

public class GroupTeamAdapter extends BaseExpandableListAdapter implements OnClickListener {

	@Override
	public void notifyDataSetChanged() {
		// TODO Auto-generated method stub
		super.notifyDataSetChanged();
	}

	private Context mContext;
	private ExpandableListView mExpandableListView;
	private List<GroupItem> mGroupCollection;

	public List<GroupItem> getmGroupCollection() {
		return mGroupCollection;
	}

	public void setmGroupCollection(List<GroupItem> mGroupCollection) {
		this.mGroupCollection = mGroupCollection;
	}

	private int[] groupStatus;
	private int mFocusColor;
	private int mNormalColor;

	public static Map<String, String> noteList = new HashMap<String, String>();
	
	public GroupTeamAdapter(Context pContext, ExpandableListView pExpandableListView,
			List<GroupItem> pGroupCollection) {
		mContext = pContext;
		mGroupCollection = pGroupCollection;
		mExpandableListView = pExpandableListView;
		groupStatus = new int[mGroupCollection.size()];
		setListEvent();
	}

	private class DoubleOnCollapseListener implements ExpandableListView.OnGroupCollapseListener {
		private View currentView;

		public DoubleOnCollapseListener(View view) {
			currentView = view;
		}

		public void onGroupCollapse(int groupPosition) {
			currentView.getLayoutParams().height = 300;
			currentView.requestLayout();
		}
	}

	private void setListEvent() {

		mExpandableListView.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int arg0) {
				// TODO Auto-generated method stub
				groupStatus[arg0] = 1;
			}
		});

		mExpandableListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

			@Override
			public void onGroupCollapse(int arg0) {
				// TODO Auto-generated method stub
				groupStatus[arg0] = 0;

			}
		});
	}

	@Override
	public Object getChild(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return mGroupCollection.get(arg0).getChildList().get(arg1);
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return arg1;
	}

	@Override
	public int getChildrenCount(int arg0) {
		// TODO Auto-generated method stub
		Log.d("getChildrenCount", "size: " + mGroupCollection.get(arg0).getChildList().size());
		return mGroupCollection.get(arg0).getChildList().size();
	}

	Map<String, View> viewList = new HashMap<String, View>();
	@Override
	public View getChildView(int arg0, int arg1, boolean arg2, View view, ViewGroup arg4) {
		// TODO Auto-generated method stub
	
		final TeamItem item = (TeamItem)mGroupCollection.get(arg0).getChildList().get(arg1);
		if(view ==null){
			view = LayoutInflater.from(mContext).inflate(R.layout.child_view, null);
			TextView tvName = (TextView) view.findViewById(R.id.tv_name);
			tvName.setText(item.getName());
		}
		return view;
	}


	
	private void setViewVisibility(View v, boolean b) {
		// TODO Auto-generated method stub
		v.setVisibility(b ? View.VISIBLE : View.GONE);
	}

	@Override
	public Object getGroup(int arg0) {
		// TODO Auto-generated method stub
		return mGroupCollection.get(arg0);
	}

	
	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return mGroupCollection.size();
	}

	
	@Override
	public long getGroupId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getGroupView(int arg0, boolean arg1, View arg2, ViewGroup arg3) {

		// TODO Auto-generated method stub
		GroupHolder groupHolder;
		if (arg2 == null) {
			arg2 = LayoutInflater.from(mContext).inflate(R.layout.list_group, null);
			groupHolder = new GroupHolder();
			groupHolder.imgThumnail = (ImageView) arg2.findViewById(R.id.img_thumbnail);
			groupHolder.tvName = (TextView) arg2.findViewById(R.id.tv_name);
			arg2.setTag(groupHolder);
		} else {
			groupHolder = (GroupHolder) arg2.getTag();
		}
		if (groupStatus[arg0] == 0) {
			groupHolder.imgThumnail.setImageResource(R.drawable.group_down);
		} else {
			groupHolder.imgThumnail.setImageResource(R.drawable.group_up);
		}

		groupHolder.tvName.setText(Html.fromHtml(mGroupCollection.get(arg0).getName()));
		return arg2;

	}

	class GroupHolder {
		ImageView imgThumnail;
		TextView tvName;
	}

	class ChildHolder {
		TextView tvName;
		ImageView imgThumnail;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		Log.d("onClick", "onClick");
		int id = v.getId();
		switch (id) {
		default:
			break;
		}
	}



	

	


	public List<GroupItem> getData() {
		return mGroupCollection;
	}
	
}
