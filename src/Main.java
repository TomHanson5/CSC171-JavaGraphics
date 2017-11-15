import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
* Thomas Hanson; thanson5; Project 3; Sec. TR 6:15-7:30
* I did not collaborate with anyone on this assignment
* This is the central class which holds most of the code and creates instances of the effects canvases
* Most things are initialized as class variables and the constructor adds them together and to the GUI
* The main method simply calls the constructor which then readies the GUI for use
*/

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener, ChangeListener{
	static Color colorChoice;
	
	// Color choosing buttons
	ButtonGroup colors = new ButtonGroup();
	JRadioButton white = new JRadioButton("White");
	JRadioButton blue = new JRadioButton("Blue");
	JRadioButton cyan = new JRadioButton("Cyan");
	JRadioButton pink = new JRadioButton("Pink");
	JRadioButton green = new JRadioButton("Green");
	JRadioButton orange = new JRadioButton("Orange");
	JRadioButton red = new JRadioButton("Red");
	
	// Parameters for Launch
	JSlider speed = new JSlider(1);
	JLabel speedCount = new JLabel("50");
	
	JSlider fireAngle = new JSlider(1, 1, 89, 45);
	JLabel angleCount = new JLabel("45");
	
	JSlider timeSel = new JSlider(0, 4, 1);
	JLabel timeCount = new JLabel("3");
	JButton fire = new JButton("Fire!");
	
	// Buttons for effects
	ButtonGroup effects = new ButtonGroup();
	JRadioButton star = new JRadioButton("Star");
	JRadioButton circles = new JRadioButton("Circles");
	JRadioButton square = new JRadioButton("Square");
	JRadioButton flower = new JRadioButton("Flower");
	JRadioButton bubble = new JRadioButton("Bubble");
	
	// GUI organization
	JFrame frame = new JFrame("Main");
	JPanel colorGUI = new JPanel();
	JPanel effectGUI = new JPanel();
	JPanel speedGUI = new JPanel();
	JPanel angleGUI = new JPanel();
	JPanel topGUI = new JPanel();
	JPanel bottomGUI = new JPanel();
	
	// vars for math
	public static int x, y;
	public static int t = 1; // Time to Boom
	public static int angle = 45;
	public static int v = 500; // speed
	public static final double g = 9.81;

	// Instances of the effect canvases
	Bubble bub = new Bubble();
	Flower flw = new Flower();
	Square squ = new Square();
	Star str = new Star();
	Circles c = new Circles();
	
	public Main() {
		// Adding color buttons to group
		colors.add(white);
		colors.add(blue);
		colors.add(cyan);
		colors.add(pink);
		colors.add(green);
		colors.add(orange);
		colors.add(red);
		
		// adding action listeners
		white.addActionListener(this);
		blue.addActionListener(this);
		cyan.addActionListener(this);
		pink.addActionListener(this);
		green.addActionListener(this);
		orange.addActionListener(this);
		red.addActionListener(this);
		
		// adding effect buttons to group
		effects.add(star);
		effects.add(circles);
		effects.add(square);
		effects.add(flower);
		effects.add(bubble);
		
		frame.setLayout(new BorderLayout());
		frame.setSize(1800, 1000);
		
		topGUI.setLayout(new BoxLayout(topGUI, BoxLayout.Y_AXIS));
		
		// adding GUI elements to top of screen
		// color buttons
		colorGUI.setLayout(new FlowLayout());
		colorGUI.setPreferredSize(new Dimension(frame.getWidth(), 30));
		colorGUI.add(white);
		colorGUI.add(blue);
		colorGUI.add(cyan);
		colorGUI.add(pink);
		colorGUI.add(green);
		colorGUI.add(orange);
		colorGUI.add(red);
		topGUI.add(colorGUI);
		
		// effect buttons
		effectGUI.setLayout(new FlowLayout());
		effectGUI.setPreferredSize(new Dimension(frame.getWidth(), 30));
		effectGUI.add(star);
		effectGUI.add(circles);
		effectGUI.add(square);
		effectGUI.add(flower);
		effectGUI.add(bubble);
		topGUI.add(effectGUI);
		frame.add(topGUI, BorderLayout.PAGE_START);
		
		// speed slider
		speedGUI.setLayout(new BorderLayout());
		speedGUI.add(new JLabel("Speed"), BorderLayout.PAGE_START);
		speedGUI.add(speed, BorderLayout.CENTER);
		speedGUI.add(speedCount, BorderLayout.EAST);
		frame.add(speedGUI, BorderLayout.WEST);
		speed.addChangeListener(this);
		
		//angle slider
		angleGUI.setLayout(new BorderLayout());
		angleGUI.add(fireAngle, BorderLayout.CENTER);
		angleGUI.add(new JLabel("Angle"), BorderLayout.PAGE_START);
		angleGUI.add(angleCount, BorderLayout.WEST);
		frame.add(angleGUI, BorderLayout.EAST);
		fireAngle.addChangeListener(this);
		
		// GUI for bottom part of screen
		//Timer and fire button
		bottomGUI.setLayout(new BorderLayout());
		bottomGUI.add(new JLabel("Fuse Timer"), BorderLayout.WEST);
		bottomGUI.add(timeCount, BorderLayout.EAST);
		bottomGUI.add(timeSel);
		timeSel.addChangeListener(this);
		bottomGUI.add(fire, BorderLayout.PAGE_END);
		fire.addActionListener(this);
		bottomGUI.setPreferredSize(new Dimension(frame.getWidth(), 75));
		frame.add(bottomGUI, BorderLayout.PAGE_END);
		
		bottomGUI.setVisible(true);
		topGUI.setVisible(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new Main();

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// set variable to slider value
		if (e.getSource() == timeSel) {
			t = timeSel.getValue();
			timeCount.setText(Integer.toString(timeSel.getValue()));
		} else if (e.getSource() == fireAngle) {
			angleCount.setText(Integer.toString(fireAngle.getValue()));
			angle = fireAngle.getValue();
		} else {
			speedCount.setText(Integer.toString(speed.getValue()));
			v =10* speed.getValue();
		}
		
		
	}

	public void removeParts() {
		// removes old effect canvas so it can add the newly selected one
		frame.setVisible(false);
		frame.remove(c);
		frame.remove(str);
		frame.remove(squ);
		frame.remove(flw);
		frame.remove(bub);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == fire) {
			// calculate location of explosion
			x = (int) ( v * Math.cos(Math.toRadians((double)angle)) * t);
			y = (int) ((v * Math.sin(Math.toRadians((double)angle)) * t) - (.5*g*Math.pow(t, 2)));
			
			removeParts();
			// add correct effect canvas
			if(effects.getSelection() == circles.getModel()) {
				frame.add(c);
				c.setVisible(true);
			} else if (effects.getSelection() == star.getModel()) {
				frame.add(str);
				str.setVisible(true);
			} else if (effects.getSelection() == square.getModel()) {
				frame.add(squ);
				squ.setVisible(true);
			} else if (effects.getSelection() == flower.getModel()) {
				frame.add(flw);
				flw.setVisible(true);
			} else {
				frame.add(bub);
				bub.setVisible(true);
			}
			frame.setVisible(true);
		// set color according to buttons
		} else if (e.getSource() == white) {
			colorChoice = Color.WHITE;
		} else if (e.getSource() == blue) {
			colorChoice = Color.BLUE;
		} else if (e.getSource() == cyan) {
			colorChoice = Color.CYAN;
		} else if (e.getSource() == pink) {
			colorChoice = Color.PINK;
		} else if (e.getSource() == green) {
			colorChoice = Color.GREEN;
		} else if (e.getSource() == orange) {
			colorChoice = Color.ORANGE;
		} else if (e.getSource() == red) {
			colorChoice = Color.RED;
		}
		
	}

}
