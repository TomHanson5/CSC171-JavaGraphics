import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Circles extends JPanel{
	// issue in here, not printing, not sure why
	
	int x, y;
	int angle;
	boolean boom = false;
	final int r = 10;
	Color c = Color.BLACK;
	
	public Circles(int W, int H, int angle) {
		this.x = W;
		this.y =  H;
		this.angle = angle;
		this.repaint();
	} 
	
	public void Boom() {
		boom = true;
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		y = this.getHeight() - y;
		super.paintComponent(g);
		//Graphics2D g2 = (Graphics2D) g;
		g.setColor(c);
		g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
		g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
		double mid = (Main.v*Math.sin(Math.toRadians(angle)))/Main.g;
		int y2 = (int) (Main.v*Math.sin(Math.toRadians(angle))*mid - ((.5)*Main.g*mid*mid)); // max height
		g.drawOval((int)x-100, (int)y-100, 200, 200);
		g.fillOval(x-2, y-2, 4, 4);
		int start;
		if (x > mid) {
			start = 90 + (int)Math.abs(Math.toDegrees(Math.atan2(x-mid, (double)y)));
		} else if (x < mid) {
			start = (int)Math.abs(Math.toDegrees(Math.atan2(mid - x, (double)y)));
		} else {
			start = 90;
		}
		System.out.println(start);
		g.drawArc(0, y2,(int) (2*(mid*Main.v*Math.cos(Math.toRadians(angle)))), 2*y2, start, 180-start);
		if (boom) {
			// draw resulting effect
		} 
		
	}

}
