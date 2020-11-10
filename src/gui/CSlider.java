package gui;

import javax.swing.JSlider;

public class CSlider extends JSlider {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7812555835954685210L;
	
	private int min=0;
	private int max=100;
	public CSlider() {
		setOpaque(false);
		setMinimum(min);
		setMaximum(max);
		// custom BasicSliderUI
	}
	public CSlider(int min, int max) {
		this.min=min;
		this.max=max;
		setMinimum(min);
		setMaximum(max);
		setOpaque(false);
		// custom BasicSliderUI
	}
}
