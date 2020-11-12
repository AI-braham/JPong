package gui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

import main.Main;
import resources.Player;
import resources.ItemBall;

public class GamePanel extends CPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1138722912837084307L;
	
	private final int gameAreaWidth=684;
	private final int gameAreaHeight=421;
	
	private Player playerOne= new Player(1);
	private Player playerTwo= new Player(2);
	private ItemBall ball= new ItemBall();
	
	private boolean gameRunning=false;
	
	Stroke dotted = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
	
	private int scoreLimit=5;
	private int speedMultiplier=1;
	
	public GamePanel() {
		setLayout(null);
		
		add(playerOne);
		add(playerTwo);
		
		add(ball);
		ball.setLocation(gameAreaWidth/2 - ball.getWidth()/2, gameAreaHeight/2);
		
		playerOne.setLocation(20, (gameAreaHeight/2)-playerOne.getHeight());
		playerTwo.setLocation(gameAreaWidth-20-playerTwo.getWidth(), (gameAreaHeight/2)-playerOne.getHeight());
		
		setAction(playerOne, KeyEvent.VK_W, "w", -1);
		setAction(playerOne, KeyEvent.VK_S, "s", 1);
		setAction(playerTwo, KeyEvent.VK_O, "o", -1);
		setAction(playerTwo, KeyEvent.VK_L, "l", 1);
		
		Timer timer=new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				moveControl();
				if(gameRunning) {
					MoveBall();
				}
				
			}
			
		}, 1, 1);
	}
	public void startGame() {
		ball.setDirectX(1);
		ball.setDirectY(1);
		gameRunning=true;
	}
	public void update() {
		setBackground(Main.background_color);
		
		playerOne.update();
		playerTwo.update();
		
		ball.update();
		
		revalidate();
		repaint();
	}
	public void setSettings(int ballSize, int speedMultiplier, int scoreLimit) {
		ball.setSize(ballSize, ballSize);
		this.speedMultiplier=speedMultiplier;
		this.scoreLimit=scoreLimit;
		
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d= (Graphics2D) g.create();
		drawNet(g2d);
		drawScore(g2d);
		
	}
	private void drawNet(Graphics2D g2d) {
		g2d.setColor(Main.secondary_color);
		g2d.setStroke(dotted);
		g2d.drawLine(gameAreaWidth/2, 0, gameAreaWidth/2, gameAreaHeight);
	}
	private void drawScore(Graphics2D g2d) {
		g2d.setFont(Main.font.deriveFont(50.0f));
		g2d.drawString(String.valueOf(playerOne.getScore()), gameAreaWidth/2-100, 50);
		g2d.drawString(String.valueOf(playerTwo.getScore()), gameAreaWidth/2+75, 50);
	}
	
	private void setAction(Player player, int key, String ID, int direction) {
		
		InputMap input= player.getInputMap(WHEN_IN_FOCUSED_WINDOW);
		ActionMap action = player.getActionMap();
		
		input.put(KeyStroke.getKeyStroke(key, 0, false), ID+"_pressed");
		action.put(ID+"_pressed", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -315949207547206236L;

			@Override
			public void actionPerformed(ActionEvent e) {
				player.setDirection(direction);
			}
		});
		
		input.put(KeyStroke.getKeyStroke(key, 0, true), ID+"_released");
		action.put(ID+"_released", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -3831046136881839375L;

			@Override
			public void actionPerformed(ActionEvent e) {
				player.setDirection(0);
			}
		});
	}
	private void moveControl() {
		movePlayer(1, playerOne.getDirection());
		movePlayer(2, playerTwo.getDirection());
	}
	private void movePlayer(int ID, int direction) {
		switch(ID) {
		case 1:
			if(direction==-1) {
				if(playerOne.getY()<=0) {
					
				}else {
					playerOne.setLocation(playerOne.getX(), playerOne.getY()-1-speedMultiplier);	
				}
			}else if(direction==1){
				if(playerOne.getY()>=gameAreaHeight - playerOne.getHeight()) {
					playerOne.setLocation(playerOne.getX(), gameAreaHeight-playerOne.getHeight());
				}else {
					playerOne.setLocation(playerOne.getX(), playerOne.getY()+1+speedMultiplier);		
				}				
			}else {
				
			}
			break;
		case 2:
			if(direction==-1) {
				if(playerTwo.getY()<=0) {
					
				}else {
					playerTwo.setLocation(playerTwo.getX(), playerTwo.getY()-1-speedMultiplier);	
				}
			}else if(direction==1){
				if(playerTwo.getY()>=gameAreaHeight - playerTwo.getHeight()) {
					
				}else {
					playerTwo.setLocation(playerTwo.getX(), playerTwo.getY()+1+speedMultiplier);		
				}				
			}else {
				
			}
			break;
		}
	}
	private void MoveBall() {
			try {
				Thread.sleep(5-speedMultiplier);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(ball.getX()<=0) {
				ball.stopMovement();
				playerTwo.setScore(playerTwo.getScore()+1);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ball.setLocation(gameAreaWidth/2 - ball.getWidth()/2, gameAreaHeight/2);
				playerOne.setLocation(20, (gameAreaHeight/2)-playerOne.getHeight());
				playerTwo.setLocation(gameAreaWidth-20-playerTwo.getWidth(), (gameAreaHeight/2)-playerOne.getHeight());
				revalidate();
				repaint();
				ball.setDirectX(1);
				ball.setDirectY(1);
				
			}else if(ball.getX()>=gameAreaWidth - ball.getWidth()) {
				ball.stopMovement();
				playerOne.setScore(playerOne.getScore()+1);	
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ball.setLocation(gameAreaWidth/2 - ball.getWidth()/2, gameAreaHeight/2);
				playerOne.setLocation(20, (gameAreaHeight/2)-playerOne.getHeight());
				playerTwo.setLocation(gameAreaWidth-20-playerTwo.getWidth(), (gameAreaHeight/2)-playerOne.getHeight());
				revalidate();
				repaint();
				ball.setDirectX(-1);
				ball.setDirectY(1);
			
			}else if(ball.getY()<=0 || ball.getY()>=gameAreaHeight) {
				
				ball.setDirectY(ball.getDirectY()*-1);
				
			}else if(ball.getX()==playerOne.getX() + playerOne.getWidth() && ball.getY()>= playerOne.getY() 
			&& ball.getY()<=playerOne.getY()+playerOne.getHeight()) {
				
				ball.setDirectX(ball.getDirectX()*-1);
				
			}else if(ball.getX()==playerTwo.getX() - playerTwo.getWidth()/2 && ball.getY()>= playerTwo.getY() 
			&& ball.getY()<=playerTwo.getY()+playerTwo.getHeight()) {
				
				ball.setDirectX(ball.getDirectX()*-1);
				
			}
			if(playerOne.getScore()==scoreLimit) {
				GUI.gameOver("Player One wins");
				ball.setDirectX(0);
				ball.setDirectY(0);
				playerOne.setScore(0);
				playerTwo.setScore(0);
				return;
				
			}else if(playerTwo.getScore()==scoreLimit) {
				GUI.gameOver("Player Two wins");
				ball.setDirectX(0);
				ball.setDirectY(0);
				playerOne.setScore(0);
				playerTwo.setScore(0);
				return;
			}
			ball.setLocation(ball.getX()+ball.getDirectX(), ball.getY() + ball.getDirectY());
		
	}
}
