import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JSlider;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class MySlider extends JSlider {
	private String text;

	public MySlider(int o, int min, int max, int val, String text) {
		super(o, min, max, val);
		
		this.text = text;
		
		setOpaque(true);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(250, 50));
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		g.clearRect(0, 0, getWidth(), getHeight()+100);
		
		g.setColor(Color.DARK_GRAY);
		g.fill(new RoundRectangle2D.Float(0, 25, getWidth(), 4, 2, 4));
		g.setColor(Color.MAGENTA);
		g.fillOval(Integer.valueOf((int) (getValue()*2.32+2)), 20, 15, 15);
	}

}
