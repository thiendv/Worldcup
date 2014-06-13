package com.worldcup24h.model;

import java.io.Serializable;
import java.util.List;

public class MatchItem implements Serializable{

	private TeamItem team1;
	private TeamItem team2;
	private long timeMatch;
	private String id;
	private List<ScoreItem> scoreList;
	private List<CardItem> cardList;
	private String ruler;
	
	public List<CardItem> getCardList() {
		return cardList;
	}

	public void setCardList(List<CardItem> cardList) {
		this.cardList = cardList;
	}

	public List<ScoreItem> getScoreList() {
		return scoreList;
	}

	public void setScoreList(List<ScoreItem> scoreList) {
		this.scoreList = scoreList;
	}

	public TeamItem getTeam1() {
		return team1;
	}

	public void setTeam1(TeamItem team1) {
		this.team1 = team1;
	}

	public TeamItem getTeam2() {
		return team2;
	}

	public void setTeam2(TeamItem team2) {
		this.team2 = team2;
	}

	public long getTimeMatch() {
		return timeMatch;
	}

	public void setTimeMatch(long timeMatch) {
		this.timeMatch = timeMatch;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRuler() {
		return ruler;
	}

	public void setRuler(String ruler) {
		this.ruler = ruler;
	}
}
