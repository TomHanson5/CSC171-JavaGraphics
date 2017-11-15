import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Circles extends JPanel{
	// issue in here, not printing, not sure why
	
	double x, y;
	int angle;
	boolean boom = false;
	final int r = 5;
	Color c = Color.BLACK;
	
	public Circles(double x, double y, int angle) {
		this.x = x;
		this.y = y;
		this.angle = angle;
		
	} 
	
	public void Boom() {
		boom = true;
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		System.out.println("yes");
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(c);
		int x2 = 0;
		int y2 = 0;
		for (int i = 0; i < x; i++) {
			g2.fillOval(x2-r, y2-r, r*2, r*2);
			if (y2 > y) {
				y--;
				x++;
			} else if (y2 < y){
				x2++;
				y2++;
			}
			
		}
		
		if (boom) {
			// draw resulting effect
		} 
		
	}

}
