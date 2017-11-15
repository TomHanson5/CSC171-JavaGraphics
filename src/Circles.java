import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;

import javax.swing.JPanel;

public class Circles extends JPanel{
	
	int x, y;
	int angle;
	
	@Override
	public void paintComponent(Graphics g) {
		this.x = Main.x;
		this.y =  Main.y;
		this.angle = Main.angle;
		y = this.getHeight() - y;
		super.paintComponent(g);
		g.setColor(Main.colorChoice);
		
		Graphics2D g2 = (Graphics2D) g;
		QuadCurve2D.Double s = new QuadCurve2D.Double(0, getHeight(), x/2, y, x, y);
		g2.draw(s);
		
		g.drawOval((int)x-200, (int)y-200, 400, 400);
		g.drawOval((int)x-100, (int)y-100, 200, 200);
		g.drawOval((int)x-50, (int)y-50, 100, 100);
		g.drawOval((int)x-25, (int)y-25, 50, 50);
		g.fillOval(x-2, y-2, 4, 4);
	}

}
