package main;
/**
 * 
 * @author Daniel Busarello.
 * @throw Exception of invalid inputs score that are less than 0 or higher than 1000.
 * This class creates and sets the score of a game
 *
 */

public class Game {
	private int score;

	public Game(int score) throws Exception {
		setScore(score);
	}
	
	public Game() {
		
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) throws Exception {
		if(score < 0) {
			throw new IllegalArgumentException("Insira apenas valores positivos!");
		}
		else if(score > 1000) {
			throw new IllegalArgumentException("Número máximo de pontos atingido (1000)");
		} 
		else
			this.score = score;
	}
}
