package gui;

import javax.swing.JLabel;

import main.Main;

public class CLabel extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5051564466947688077L;
	
	public CLabel(String text, boolean title) {
		setText(text);
		setFont(Main.font.deriveFont(24.0f));
		setForeground(Main.secondary_color);
		if(title==true) {
			setFont(Main.font.deriveFont(56.0f));
		}
		
	}
	public void update() {
		setForeground(Main.secondary_color);
	}
}
