package com.worldcup24h.adapter;

import java.util.List;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.worldcup24h.R;
import com.worldcup24h.model.FeedItem;

public class FeedAdapter extends ArrayAdapter<FeedItem>{
	
	private Context mContext;
	private List<FeedItem> mList;
	private MediaController media_Controller;
	private DisplayMetrics dm;
	
	public FeedAdapter(Context context, List<FeedItem> list) {
		// TODO Auto-generated constructor stub
		super(context, R.layout.feed_view, list);
		mContext = context;
		mList = list;
		media_Controller = new MediaController(mContext); 
		dm = new DisplayMetrics(); 
	}

	@Override
	public View getView(int position, View v, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		FeedItem item = mList.get(position);
		FeedHolder holder;
		if(v == null){
			holder = new FeedHolder();
			v = LayoutInflater.from(mContext).inflate(R.layout.feed_view, null);
			holder.tvTitle = (TextView)v.findViewById(R.id.tv_title);
			holder.tvContent = (TextView)v.findViewById(R.id.tv_content);
			holder.videoView = (VideoView) v.findViewById(R.id.video_view);
			v.setTag(holder);
		}else{
			holder = (FeedHolder)v.getTag();
		}
		
		holder.tvTitle.setText(item.getTitle());
		holder.tvContent.setText(item.getContent());
		if(item.getVideoUrl() !=null){
			holder.videoView.setVisibility(View.VISIBLE);
//			int height = dm.heightPixels; int width = dm.widthPixels; 
//			holder.videoView.setMinimumWidth(width); 
//			holder.videoView.setMinimumHeight(height); 
//			holder.videoView.setMediaController(media_Controller); 
//			holder.videoView.setVideoPath("http://mrbool.com/how-to-play-video-formats-in-android-using-videoview/28299#ixzz34SNgqzzq"); 
//			holder.videoView.start();

		}else{
			holder.videoView.setVisibility(View.GONE);
		}
		return v;
	}
	
	class FeedHolder{
		TextView tvTitle, tvContent;
		VideoView videoView;
	}
}
