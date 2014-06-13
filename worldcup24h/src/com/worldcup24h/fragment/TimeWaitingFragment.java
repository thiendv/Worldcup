package com.worldcup24h.fragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.TextView;

import com.worldcup24h.R;
import com.worldcup24h.model.MatchItem;

public class TimeWaitingFragment extends Fragment{
	
	
    private CountDownTimer mCountDownTimer;
    private long mInitialTime = DateUtils.DAY_IN_MILLIS * 2 + 
                        DateUtils.HOUR_IN_MILLIS * 9 +
                        DateUtils.MINUTE_IN_MILLIS * 3 + 
                        DateUtils.SECOND_IN_MILLIS * 42;
    private MatchItem mMatchItem;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActivity().getIntent().getSerializableExtra("match");
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.time_waiting_fragment,container, false);
		final TextView tvTime = (TextView)v.findViewById(R.id.tv_time);
		
	       mCountDownTimer = new CountDownTimer(mInitialTime, 1000) {
	            StringBuilder time = new StringBuilder();
	            @Override
	            public void onFinish() {
	                tvTime.setText(DateUtils.formatElapsedTime(0));
	                //mTextView.setText("Times Up!");
	            }

	            @Override
	            public void onTick(long millisUntilFinished) {
	                time.setLength(0);
	                 // Use days if appropriate
	                if(millisUntilFinished > DateUtils.DAY_IN_MILLIS) {
	                    long count = millisUntilFinished / DateUtils.DAY_IN_MILLIS;
	                    if(count > 1)
	                        time.append(count).append(" days ");
	                    else
	                        time.append(count).append(" day ");

	                    millisUntilFinished %= DateUtils.DAY_IN_MILLIS;
	                }

	                time.append(DateUtils.formatElapsedTime(Math.round(millisUntilFinished / 1000d)));
	                tvTime.setText(time.toString());
	            }
	        }.start();
		return v;
	}
}
