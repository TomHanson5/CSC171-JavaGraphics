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
public class Square extends JPanel{
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
		
		// drawing of geometric pattern
		int r = 25;
		for (int i = 0; i < 3; i++) {
			r*=2;
			g2.draw(new QuadCurve2D.Double(x, y-r, x, y, x+r, y));
			g2.drawLine(x+r, y, x, y-r);
			g2.draw(new QuadCurve2D.Double(x, y-r, x, y, x-r, y));
			g2.drawLine(x-r, y, x, y+r);
			g2.draw(new QuadCurve2D.Double(x, y+r, x, y, x+r, y));
			g2.drawLine(x+r, y, x, y+r);
			g2.draw(new QuadCurve2D.Double(x, y+r, x, y, x-r, y));
			g2.drawLine(x-r, y, x, y-r);
			g2.drawRect(x-r, y-r, 2*r, 2*r);
			
		}
		g2.drawLine(x-r, y-r, x+r, y+r);
		g2.drawLine(x-r, y+r, x+r, y-r);
		r*=2;
		g2.draw(new QuadCurve2D.Double(x, y-r, x, y, x+r, y));
		g2.draw(new QuadCurve2D.Double(x, y-r, x, y, x-r, y));
		g2.draw(new QuadCurve2D.Double(x, y+r, x, y, x+r, y));
		g2.draw(new QuadCurve2D.Double(x, y+r, x, y, x-r, y));
	}

}
