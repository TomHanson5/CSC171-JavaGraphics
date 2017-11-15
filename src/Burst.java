import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;

import javax.swing.JPanel;

public class Burst extends JPanel{
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
		g.fillOval(x-2, y-2, 4, 4);
		
		//g2.draw(new QuadCurve2D.Double(x, y, x, y+10, ));
		g.drawArc(x, y, 20, 20, 270, 360);
	}

}
