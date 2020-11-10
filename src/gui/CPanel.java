package gui;

import javax.swing.JPanel;

import main.Main;

public class CPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4817203630635236140L;
	
	public CPanel() {
		setBackground(Main.background_color);
	}
	public void update() {
		setBackground(Main.background_color);
		for(int i=0;i<getComponentCount();i++) {
			if(getComponent(i) instanceof CPanel) {
				( (CPanel) getComponent(i)).update();
			}
			else if(getComponent(i) instanceof GamePanel) {
				( (GamePanel) getComponent(i)).update();
			}
			else if(getComponent(i) instanceof CLabel) {
				( (CLabel) getComponent(i)).update();
			}
			else if(getComponent(i) instanceof CButton) {
				( (CButton) getComponent(i)).update();
			}
		}
	}
}
	