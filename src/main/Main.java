package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gui.GUI;

public class Main {
	public static Color background_color= Color.BLACK;
	public static Color secondary_color= Color.WHITE;
	public static Font font;
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		try {
		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     font=Font.createFont(Font.TRUETYPE_FONT, new File("fonts\\terminal-grotesque.ttf"));
		     ge.registerFont(font);
		} catch (IOException|FontFormatException e) {
		     //Handle exception
		}
		GUI.start();

	}
	public static void colorScheme(Color color1, Color color2) {
		background_color=color1;
		secondary_color= color2;
	}
}
