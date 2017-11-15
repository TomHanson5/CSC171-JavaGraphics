import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;

import javax.swing.JPanel;

import java.util.Random;

public class Bubble extends JPanel{
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
		int r = 5;
		g2.fillOval(x-r, y-r, 2*r, 2*r);
		
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			int a = rand.nextInt(360);
			int x2 = (int)(100*Math.cos(Math.toRadians(a)));
			int y2 = (int)(100*Math.sin(Math.toRadians(a)));
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
