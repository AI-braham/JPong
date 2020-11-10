package resources;

import javax.swing.JLabel;

import main.Main;

public class Player extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5224275783684614550L;
	
	private int ID;
	private int score=0;
	private int direction=0;

	public Player(int ID) {
		this.ID=ID;
		setSize(10, 40);
		setBackground(Main.secondary_color);
		setOpaque(true);
	}
	public int getID() {
		return ID;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score=score;
	}
	public void update() {
		setBackground(Main.secondary_color);
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
}