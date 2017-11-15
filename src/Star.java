import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;

import javax.swing.JPanel;

/**
* Thomas Hanson; thanson5; Project 3; Sec. TR 6:15-7:30
* I did not collaborate with anyone on this assignment
*/

@SuppressWarnings("serial")
public class Star extends JPanel{
	@Override
	public void paintComponent(Graphics g) {
		// found in all effect canvases. pulls variables, draws trajectory, sets background to black
		int x = Main.x;
		int y =  Main.y;
		y = this.getHeight() - y;
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		setBackground(Color.BLACK);		
		Graphics2D g2 = (Graphics2D) g;
		QuadCurve2D.Double s = new QuadCurve2D.Double(0, getHeight(), x/2, y, x, y);
		g2.draw(s);
		g.setColor(Main.colorChoice);
		g.fillOval(x-2, y-2, 4, 4);
		
		// drawing of pattern
		int r = 200;
		int angle = 0;
		for (angle = 0; angle < 360; angle+=30) {
			g2.drawLine(x, y, x+(int)(r*Math.sin(Math.toRadians(angle))), y+(int)(r*Math.cos(Math.toRadians(angle))));
		}
		for (angle = 15; angle < 360; angle+=35) {
			r=150;
			g2.drawLine(x, y, x+(int)(r*Math.sin(Math.toRadians(angle))), y+(int)(r*Math.cos(Math.toRadians(angle))));
		} 
		for (double i = 7.5; i<360; i+=12) {
			r=100;
			g2.drawLine(x, y, x+(int)(r*Math.sin(Math.toRadians(i))), y+(int)(r*Math.cos(Math.toRadians(i))));
		}
		
	}

}
