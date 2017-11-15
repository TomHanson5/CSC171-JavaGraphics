import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Star extends JPanel{
	@Override
	public void paintComponent(Graphics g) {
		int x = Main.x;
		int y =  Main.y;
		y = this.getHeight() - y;
		super.paintComponent(g);
		g.setColor(Main.colorChoice);
		Graphics2D g2 = (Graphics2D) g;
		QuadCurve2D.Double s = new QuadCurve2D.Double(0, getHeight(), x/2, y, x, y);
		g2.draw(s);
		
		int r = 100;
		//Ellipse2D.Double circle = new Ellipse2D.Double(x-r, y-r, r*2, r*2);
		//g2.draw(circle);
		int angle = 0;
		for (angle = 0; angle < 360; angle+=30) {
		//	g2.draw(new Arc2D.Double(x-r, y-r, 2*r, 2*r, angle, 180, Arc2D.CHORD));
			g2.drawLine(x, y, x+(int)(r*Math.sin(Math.toRadians(angle))), y+(int)(r*Math.cos(Math.toRadians(angle))));
		}
		for (angle = 15; angle < 360; angle+=35) {
			r=75;
			g2.drawLine(x, y, x+(int)(r*Math.sin(Math.toRadians(angle))), y+(int)(r*Math.cos(Math.toRadians(angle))));
		//	g2.draw(new Arc2D.Double(x-r/2, y-r/2, r, r, angle, 180, Arc2D.CHORD));
		} 
		for (double i = 7.5; i<360; i+=12) {
			r=50;
			g2.drawLine(x, y, x+(int)(r*Math.sin(Math.toRadians(i))), y+(int)(r*Math.cos(Math.toRadians(i))));
		}
		
	}

}
