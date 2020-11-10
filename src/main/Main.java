package main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gui.GUI;

public class Main {
	public static Color background_color= Color.BLACK;
	public static Color secondary_color= Color.WHITE;
	public static Font font = new Font(Font.DIALOG, Font.BOLD, 26);
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		GUI.start();

	}
	public static void colorScheme(Color color1, Color color2) {
		background_color=color1;
		secondary_color= color2;
	}
}
