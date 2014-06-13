package com.worldcup24h.model;

import java.io.Serializable;

public class ScoreItem implements Serializable{

	private String id;
	private long time;
	private String player;
	/***
	 * Type: 0: binh thuong 1: da phat 2: danh dau 3: pen
	 */

	private int type;

}
