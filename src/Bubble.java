import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;

import javax.swing.JPanel;

import java.util.Random;

/**
* Thomas Hanson; thanson5; Project 3; Sec. TR 6:15-7:30
* I did not collaborate with anyone on this assignment
*/

@SuppressWarnings("serial")
public class Bubble extends JPanel{
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
		int r = 5;
		
		// drawing of random dots
		Random rand = new Random();
		for (int i = 0; i < 400; i++) {
			r = rand.nextInt(8);
			int a = rand.nextInt(360);
			int v = rand.nextInt(200);
			int x2 = (int)(v*Math.cos(Math.toRadians(a)));
			int y2 = (int)(v*Math.sin(Math.toRadians(a)));
			if (i%4 == 0) {
				x2*=-1;
			} else if (i%4 == 1) {
				y2*=-1;
			} else if (i%4 == 2) {
				x2*=-1;
				y2*=-1;
			}
			g2.fillOval(x+x2-r, y+y2-r, 2*r, 2*r);
			
			
		}
	}

}
