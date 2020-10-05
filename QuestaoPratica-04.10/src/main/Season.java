package main;
/**
 * 
 * This class saves the games and execute all their operations
 * 
 */

import java.util.ArrayList;

public class Season {
	private ArrayList<Game> matches = new ArrayList<Game>();
	private int maxSeasonScore = 0, minSeasonScore = 1001, maxRecordCount = 0, minRecordCount = 0;
	
	public void addNewGame(Game match) {
		this.matches.add(match);
		checkMaxRecordCount(match);
		checkMinRecordCount(match);
	}
	
	//Getters
	public int getMaxScore() {
		for(Game match : this.matches) {
			int score = match.getScore();
			if(score > maxSeasonScore)
				maxSeasonScore = score;
		}
		return maxSeasonScore;
	}
	public int getMinScore() {
		for(Game match : this.matches) {
			int score = match.getScore();
			if(score < minSeasonScore )
				minSeasonScore = score;
		}
		return minSeasonScore;
	}
	public int getMaxRecordCount() {
		return this.maxRecordCount;
	}
	public int getMinRecordCount() {
		return this.minRecordCount;
	}
	public ArrayList<Game> getMatches(){
		return this.matches;
	}
	
	// Checks if current match breaks the record
	private void checkMaxRecordCount(Game match) {
		int score = match.getScore();
		if(score > maxSeasonScore && matches.size() > 1) {
			this.maxRecordCount++;
			this.maxSeasonScore = score;
		}
	}
	private void checkMinRecordCount(Game match) {
		int score = match.getScore();
		if(score < minSeasonScore && matches.size() > 1) {
			this.minRecordCount++;
			this.minSeasonScore = score;
		}
	}
}
