package gui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.Main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;

public class GUI {
	
	private static CPanel mainPanel;
	private static WinnerPanel winnerPanel;
	private static CardLayout cl;
	
	private JFrame frame;
	private GamePanel gameArea;
	private MainMenu mainMenu;
	
	private JTextField scoreField;


	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("JPong");
		frame.setResizable(false);
		
		mainPanel = new CPanel();
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		cl= new CardLayout();
		mainPanel.setLayout(cl);
		
		mainMenu = new MainMenu(); 
		mainPanel.add(mainMenu, "MAIN_MENU");
		
		SettingPanel settingsPanel = new SettingPanel();
		mainPanel.add(settingsPanel, "SETTINGS"); 
		
		CPanel gamePanel = new CPanel();
		gamePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		mainPanel.add(gamePanel, "GAME");
		gamePanel.setLayout(new BorderLayout(0, 0));
		
		gameArea = new GamePanel();
		gamePanel.add(gameArea);
		
		winnerPanel = new WinnerPanel();
		mainPanel.add(winnerPanel, "WINNER");
		
		
	}
	public void startGame() {
		gameArea.startGame();
	}
	public static void gameOver(String text) {
		winnerPanel.updateLabel(text);
		changeCard("WINNER");
	}
	public void updateAll() {
		for(int i=0;i<mainPanel.getComponentCount();i++) {
			((CPanel) mainPanel.getComponent(i)).update();
		}
	}
	public static void changeCard(String name) {
		cl.show(mainPanel, name);
	}
	public void closeApp() {
		frame.dispose();
	}
	private class MainMenu extends CPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -4271602795289367589L;

		public MainMenu() {
			setLayout(new BorderLayout(0, 0));
			
			CLabel mainTitle= new CLabel("JPong ", true);
			mainTitle.setHorizontalAlignment(SwingConstants.CENTER);
			add(mainTitle, BorderLayout.NORTH);
			
			CPanel mainOptions = new CPanel();
			add(mainOptions, BorderLayout.CENTER);
			mainOptions.setLayout(new GridLayout(0, 3));
			
			Component verticalStrut = Box.createVerticalStrut(20);
			mainOptions.add(verticalStrut);
			
			CPanel middlePanel = new CPanel();
			middlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 20));
			mainOptions.add(middlePanel);
			middlePanel.setLayout(new GridLayout(5, 0));
			
			CButton newGameBtn = new CButton("New Game");
			newGameBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					GUI.changeCard("GAME");
					startGame();
		
				}
				
			});
			middlePanel.add(newGameBtn);
			
			Component horizontalStrut = Box.createHorizontalStrut(20);
			middlePanel.add(horizontalStrut);
			
			CButton settingsBtn = new CButton("Settings");
			settingsBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					GUI.changeCard("SETTINGS");
					
				}
				
			});
			middlePanel.add(settingsBtn);
			
			Component horizontalStrut_1 = Box.createHorizontalStrut(20);
			middlePanel.add(horizontalStrut_1);
			
			CButton quitBtn = new CButton("Quit");
			quitBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					closeApp();
					
				}
				
			});
			middlePanel.add(quitBtn);
			
			Component verticalStrut_1 = Box.createVerticalStrut(20);
			mainOptions.add(verticalStrut_1);
		}
	}
	private class SettingPanel extends CPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -5877592021843322098L;

		public SettingPanel() {
			setLayout(new BorderLayout(0, 0));
			CLabel settingLbl= new CLabel("Settings", true);
			settingLbl.setHorizontalAlignment(SwingConstants.CENTER);
			add(settingLbl, BorderLayout.NORTH);
			
			CPanel setgsPanel = new CPanel();
			add(setgsPanel, BorderLayout.CENTER);
			setgsPanel.setLayout(new BorderLayout(0, 0));
			
			CPanel optionsPanel = new CPanel();
			optionsPanel.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));
			setgsPanel.add(optionsPanel);
			
			CButton backStnBtn = new CButton("Back");
			
			optionsPanel.setLayout(new BorderLayout(0, 0));
			optionsPanel.add(backStnBtn, BorderLayout.SOUTH);
			
			CPanel options = new CPanel();
			options.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			optionsPanel.add(options, BorderLayout.CENTER);
			options.setLayout(new GridLayout(4, 2, 10, 50));
			
			CLabel ballSizeLbl = new CLabel("Ball size", false);
			ballSizeLbl.setHorizontalAlignment(SwingConstants.CENTER);
			options.add(ballSizeLbl);
			
			CSlider sizeSlider = new CSlider(10, 40);
			sizeSlider.setValue(10);
			options.add(sizeSlider);
			
			CLabel speedLbl = new CLabel("Speed", false);
			speedLbl.setHorizontalAlignment(SwingConstants.CENTER);
			options.add(speedLbl);
			
			CSlider speedSlider = new CSlider(1, 4);
			speedSlider.setValue(1);
			options.add(speedSlider);
			
			CLabel scoreLbl = new CLabel("Score limit", false);
			scoreLbl.setHorizontalAlignment(SwingConstants.CENTER);
			options.add(scoreLbl);
			
			scoreField = new JTextField();
			options.add(scoreField);
			
			CLabel setColorLbl = new CLabel("Color scheme", false);
			setColorLbl.setHorizontalAlignment(SwingConstants.CENTER);
			options.add(setColorLbl);
			
			backStnBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					GUI.changeCard("MAIN_MENU");
					try {
						gameArea.setSettings(sizeSlider.getValue(), speedSlider.getValue(), Integer.valueOf(scoreField.getText()));
					}catch(Exception f) {
						gameArea.setSettings(sizeSlider.getValue(), speedSlider.getValue(), 5);
					}
				}
			});
			
			Choice choice = new Choice();
			choice.add("");
			choice.add("Black and White");
			choice.add("Dark purple and Red");
			choice.add("Gameboy theme");
			options.add(choice);
			
			choice.addItemListener( new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					switch(e.getItem().toString()) {
						case "Black and White":
							Main.colorScheme(Color.BLACK, Color.WHITE);
							updateAll();
							break;
						case "Dark purple and Red":
							Main.colorScheme(new Color(0, 0, 74), new Color(255, 0, 74));
							updateAll();
							break;
						case "Gameboy theme":
							Main.colorScheme(new Color(15, 56, 15), new Color(155, 188, 15));
							updateAll();
							break;
					}
					
				}
				
			});
		}
	}
	private class WinnerPanel extends CPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = -1806268653395477630L;
		public WinnerPanel() {
			setLayout(new BorderLayout(0, 0));
			
			CPanel centerDisplay = new CPanel();
			add(centerDisplay, BorderLayout.CENTER);
			centerDisplay.setLayout(new GridLayout(0, 3));
			
			Component verticalStrut_2 = Box.createVerticalStrut(20);
			centerDisplay.add(verticalStrut_2);
			
			CPanel middleDisplay = new CPanel();
			centerDisplay.add(middleDisplay);
			middleDisplay.setLayout(new GridLayout(5, 0));
			
			Component horizontalStrut_4 = Box.createHorizontalStrut(20);
			middleDisplay.add(horizontalStrut_4);
			
			CButton playAgainBtn = new CButton("Play again");
			playAgainBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					GUI.changeCard("GAME");
					startGame();
				}
				
			});
			middleDisplay.add(playAgainBtn);
			
			Component horizontalStrut_3 = Box.createHorizontalStrut(20);
			middleDisplay.add(horizontalStrut_3);
			
			CButton backBtn = new CButton("Back");
			backBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					GUI.changeCard("MAIN_MENU");
				
				}
				
			});
			middleDisplay.add(backBtn);
			
			Component horizontalStrut_2 = Box.createHorizontalStrut(20);
			middleDisplay.add(horizontalStrut_2);
			
			Component verticalStrut_3 = Box.createVerticalStrut(20);
			centerDisplay.add(verticalStrut_3);
		}
		private void updateLabel(String text) {
			try {
				remove(1); //  component(0) is a CPanel, this tries to remove the title, if it exists
			}catch(Exception e) {
				//Then there is no label on winnerPanel, continue.
			}
			CLabel display= new CLabel(text, true);
			display.setHorizontalAlignment(SwingConstants.CENTER);
			add(display, BorderLayout.NORTH);
		}
	}
}