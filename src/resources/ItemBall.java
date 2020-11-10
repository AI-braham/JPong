package resources;

import javax.swing.JLabel;

import main.Main;

public class ItemBall extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3226139172646753472L;
	
	private int directX=0;
	private int directY=0;
	public ItemBall() {
		setSize(10, 10);
		setBackground(Main.secondary_color);
		setOpaque(true);
	}
	public int getDirectX() {
		return directX;
	}
	public int getDirectY() {
		return directY;
	}
	public void setDirectX(int directX) {
		this.directX=directX;
	}
	public void setDirectY(int directY) {
		this.directY=directY;
	}
	public void stopMovement() {
		directX=0;
		directY=0;
	}
	public void update() {
		setBackground(Main.secondary_color);
	}
}
