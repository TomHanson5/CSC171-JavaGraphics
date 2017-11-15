import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;

import javax.swing.JPanel;

public class Square extends JPanel{
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
	}

}
