import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Circles extends JPanel{
	int x, y, angle;
	boolean boom = false;
	final int r = 5;
	Color c;
	
	public Circles(int x, int y, int angle) {
		this.x = x;
		this.y = y;
		this.angle = angle;
		
	}
	
	public void Boom() {
		boom = false;
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(c);
		if (!boom) {
			g2.fillOval(x-r, y-r, r*2, r*2);
		} else {
			// draw resulting effect
		}
		
	}

}
