import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColoredBar extends JProgressBar {
	private PersonalProject p;
	private Color c;
	private int finalGrade;
	
	ColoredBar(int finalGrade, int orientation, Color c, PersonalProject p) {
		super(orientation, 25, 150);
		this.p = p;
		this.c = c;
		this.finalGrade = finalGrade;

		setStringPainted(true);
		setBorderPainted(false);
		
		setPreferredSize(new Dimension(25, 200));
	}
	
	public void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		double realGradeValue = p.resultingGrade(finalGrade);
		int displayPercent = (int) Math.round(realGradeValue);
		
		float height = (float) (realGradeValue*1.5);
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(c);
		g.fill(new RoundRectangle2D.Float(0, getHeight()-height, getWidth(), height, 15, 15));
		g.setFont(new Font("Cambria", Font.PLAIN, 18));
		
		int numberShift = 2;
		if (displayPercent < 10)
			numberShift = 8;
		else if (displayPercent > 99)
			numberShift = -4;
		
		if (displayPercent > 0)
			g.drawString(displayPercent+"", numberShift, getHeight()-height-5);
	}

}
