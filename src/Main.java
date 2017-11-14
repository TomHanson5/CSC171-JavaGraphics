import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// needs classes for rendering, passing of GUI inputs to determine correct thing to render
// ec? splitting projectile?

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
	
	JSlider timeSel = new JSlider(0, 5);
	JLabel timeCount = new JLabel("3");
	JButton fire = new JButton("Fire!");
	
	// reference other canvases for instances of the different effects
	
	
	ButtonGroup effects = new ButtonGroup();
	JRadioButton star = new JRadioButton("Star");
	JRadioButton circles = new JRadioButton("Circles");
	JRadioButton square = new JRadioButton("Square");
	JRadioButton burst = new JRadioButton("Burst");
	JRadioButton bubble = new JRadioButton("Split");
	
	public Main() {
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
		
		JFrame frame = new JFrame("Main");
		JPanel colorGUI = new JPanel();
		JPanel effectGUI = new JPanel();
		JPanel speedGUI = new JPanel();
		JPanel angleGUI = new JPanel();
		JPanel topGUI = new JPanel();
		JPanel bottomGUI = new JPanel();
		
		frame.setLayout(new BorderLayout());
		frame.setSize(1280, 1000);
		
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
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// pass to some variable for render
		if (e.getSource() == timeSel) {
			timeCount.setText(Integer.toString(timeSel.getValue()));
			
		} else if (e.getSource() == fireAngle) {
			angleCount.setText(Integer.toString(fireAngle.getValue()));
		} else {
			speedCount.setText(Integer.toString(speed.getValue()));
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
