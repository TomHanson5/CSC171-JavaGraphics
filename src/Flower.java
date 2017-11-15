import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Flower extends JPanel{
	
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
		g.fillOval(x-2, y-2, 4, 4);
		
		int r = 100;
		g2.draw(new QuadCurve2D.Double((double)x, (double)y, (double)x+r, (double)y, (double)x, (double)y+r));
		g2.draw(new QuadCurve2D.Double((double)x, (double)y, (double)x-r, (double)y, (double)x, (double)y+r));
		
		g2.draw(new QuadCurve2D.Double((double)x, (double)y, (double)x-r, (double)y, (double)x, (double)y-r));
		g2.draw(new QuadCurve2D.Double((double)x, (double)y, (double)x+r, (double)y, (double)x, (double)y-r));
		
		g2.draw(new QuadCurve2D.Double((double)x, (double)y, (double)x, (double)y-r, (double)x+r, (double)y));
		g2.draw(new QuadCurve2D.Double((double)x, (double)y, (double)x, (double)y+r, (double)x+r, (double)y));
		
		g2.draw(new QuadCurve2D.Double((double)x, (double)y, (double)x, (double)y+r, (double)x-r, (double)y));
		g2.draw(new QuadCurve2D.Double((double)x, (double)y, (double)x, (double)y-r, (double)x-r, (double)y));
		
		g2.draw(new Ellipse2D.Double(x-r, y-r, r*2, r*2));
	}

}
