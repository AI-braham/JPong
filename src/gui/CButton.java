package gui;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import main.Main;

public class CButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1316280945679097104L;
	
	public CButton(String text) {
		setText(text);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorder(BorderFactory.createLineBorder(Main.secondary_color));
		setFont(Main.font.deriveFont(24.0f));
		setForeground(Main.secondary_color);
	}
	public Dimension getPreferredSize() {
		return new Dimension(40, 20);
	}
	public void update() {
		setBorder(BorderFactory.createLineBorder(Main.secondary_color));
		setForeground(Main.secondary_color);
	}
}
