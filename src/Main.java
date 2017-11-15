import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.Ellipse2D.Double;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Timer;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// needs classes for rendering, passing of GUI inputs to determine correct thing to render
// ec? splitting projectile?

// idea for line drawing: get the x and y of explosion, then go from 0 to that number incrementing by whatever value
// then each time draw a circle for the track, stop when both current x and y are equal to or greater than the explosion x and y
public class Main extends JFrame implements ActionListener, ChangeListener, ItemListener{
	Color[] colorRef = {Color.BLACK, Color.BLUE, Color.CYAN, Color.PINK, Color.GREEN, Color.ORANGE, Color.RED};
	ButtonGroup colors = new ButtonGroup();
	JRadioButton black = new JRadioButton("Black");
	JRadioButton blue = new JRadioButton("Blue");
	JRadioButton cyan = new JRadioButton("Cyan");
	JRadioButton pink = new JRadioButton("Pink");
	JRadioButton green = new JRadioButton("Green");
	JRadioButton orange = new JRadioButton("Orange");
	JRadioButton red = new JRadioButton("Red");
	
	JSlider speed = new JSlider(1);
	JLabel speedCount = new JLabel("50");
	
	JSlider fireAngle = new JSlider(1, 1, 89, 45);
	JLabel angleCount = new JLabel("45");
	
	JSlider timeSel = new JSlider(0, 4, 1);
	JLabel timeCount = new JLabel("3");
	JButton fire = new JButton("Fire!");
	
	// reference other canvases for instances of the different effects
	
	ButtonGroup effects = new ButtonGroup();
	JRadioButton star = new JRadioButton("Star");
	JRadioButton circles = new JRadioButton("Circles");
	JRadioButton square = new JRadioButton("Square");
	JRadioButton burst = new JRadioButton("Burst");
	JRadioButton bubble = new JRadioButton("Split");
	
	JFrame frame = new JFrame("Main");
	JPanel colorGUI = new JPanel();
	JPanel effectGUI = new JPanel();
	JPanel speedGUI = new JPanel();
	JPanel angleGUI = new JPanel();
	JPanel topGUI = new JPanel();
	JPanel bottomGUI = new JPanel();
	
	public int x, y;
	public static int t = 1; // Time to Boom
	public int angle = 45;
	public static int v = 1000; // speed
	public static final double g = 9.81;
	// will be used for location of drawings.
	
	Timer time = new Timer(30, this);
	
	canvas draw = new canvas();
	
	public Main() {
		time.setRepeats(true);
		
		colors.add(black);
		colors.add(blue);
		colors.add(cyan);
		colors.add(pink);
		colors.add(green);
		colors.add(orange);
		colors.add(red);

		effects.add(star);
		effects.add(circles);
		effects.add(square);
		effects.add(burst);
		effects.add(bubble);
		
		frame.setLayout(new BorderLayout());
		frame.setSize(1920, 1080);
		
		topGUI.setLayout(new BoxLayout(topGUI, BoxLayout.Y_AXIS));
		
		colorGUI.setLayout(new FlowLayout());
		colorGUI.setPreferredSize(new Dimension(frame.getWidth(), 30));
		colorGUI.add(black);
		colorGUI.add(blue);
		colorGUI.add(cyan);
		colorGUI.add(pink);
		colorGUI.add(green);
		colorGUI.add(orange);
		colorGUI.add(red);
		topGUI.add(colorGUI);
		
		effectGUI.setLayout(new FlowLayout());
		effectGUI.setPreferredSize(new Dimension(frame.getWidth(), 30));
		effectGUI.add(star);
		effectGUI.add(circles);
		effectGUI.add(square);
		effectGUI.add(burst);
		effectGUI.add(bubble);
		topGUI.add(effectGUI);
		frame.add(topGUI, BorderLayout.PAGE_START);
		
		// need set of buttons for effects
		speedGUI.setLayout(new BorderLayout());
		speedGUI.add(new JLabel("Speed"), BorderLayout.PAGE_START);
		speedGUI.add(speed, BorderLayout.CENTER);
		speedGUI.add(speedCount, BorderLayout.EAST);
		frame.add(speedGUI, BorderLayout.WEST);
		speed.addChangeListener(this);

		angleGUI.setLayout(new BorderLayout());
		angleGUI.add(fireAngle, BorderLayout.CENTER);
		angleGUI.add(new JLabel("Angle"), BorderLayout.PAGE_START);
		angleGUI.add(angleCount, BorderLayout.WEST);
		frame.add(angleGUI, BorderLayout.EAST);
		fireAngle.addChangeListener(this);
		
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

	public class canvas extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			double t2 = 0;
			Graphics2D g2 = (Graphics2D) g;
			double x2 = ( v * Math.cos(Math.toRadians((double)angle)) * t2);
			double y2 = (v * Math.sin(Math.toRadians((double)angle)) * t2) - (.5*Main.g*Math.pow(t2, 2));
			Double s = new Double(x2-20, this.getHeight() - y2-20, 20, 20);
			g2.draw(s);
			t2+=.01;
			if (t2 == t) {
				time.stop();
			}
		}
	}
	
	public static void main(String[] args) {
		new Main();

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// pass to some variable for render
		if (e.getSource() == timeSel) {
			t = timeSel.getValue();
			timeCount.setText(Integer.toString(timeSel.getValue()));
		} else if (e.getSource() == fireAngle) {
			angleCount.setText(Integer.toString(fireAngle.getValue()));
			angle = fireAngle.getValue();
		} else {
			speedCount.setText(Integer.toString(speed.getValue()));
			v =20* speed.getValue();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == fire) {
			x =(int) ( v * Math.cos(Math.toRadians((double)angle)) * t);
			y = (int) ((v * Math.sin(Math.toRadians((double)angle)) * t) - (.5*g*Math.pow(t, 2)));
			
			if(effects.getSelection() == circles.getModel()) {
				Circles c = new Circles(x, y, angle);
				c.setBackground(Color.WHITE);
				frame.add(c, BorderLayout.CENTER);
				c.setVisible(true);
				c.repaint();
			} else if (effects.getSelection() == star.getModel()) {
				Star c = new Star();
				frame.add(c);
				c.setVisible(true);
			} else if (effects.getSelection() == square.getModel()) {
				Square c = new Square();
				frame.add(c, BorderLayout.CENTER);
				c.setVisible(true);
			} else if (effects.getSelection() == burst.getModel()) {
				Burst c = new Burst();
				frame.add(c);
				c.setVisible(true);
			} else {
				Bubble c = new Bubble();
				frame.add(c);
				c.setVisible(true);
			}
			time.start();
		} else if (e.getSource() == time) {
			draw.repaint();
		}
		
	}

}
