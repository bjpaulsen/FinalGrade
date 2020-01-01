import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

public class SidewaysLabel extends JLabel {

	public SidewaysLabel(String text) {
		super(text);
		setPreferredSize(new Dimension(140, 10));
	}
	
	public void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		g.rotate(-Math.PI/2);
		g.translate(-getHeight()-70, 5);
		g.setClip(0, 0, 600, 600);
		super.paintComponent(g);
	}

}
