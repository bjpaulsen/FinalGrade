import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.scene.layout.Border;

public class PersonalProject implements ChangeListener {

	private JLabel percentageLabel;
	private JTextField percentageValue;
	private MySlider finalPercentage;
	private JLabel gradeLabel;
	private JTextField gradeValue;
	private MySlider currentGrade;
	private ColoredBar[] bars = new ColoredBar[7];

	PersonalProject() {
		JFrame myFrame = new JFrame("Grade Planner");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLayout(new GridBagLayout());
		myFrame.getContentPane().setBackground(Color.WHITE);
		JPanel frame = new JPanel();
		frame.setBackground(Color.WHITE);
		frame.setSize(700, 700);
		frame.setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();

		constraints.gridy = 0;
		constraints.gridx = 0;

		JLabel title = new JLabel("Grade Planner: What Do I Need On The Final?");
		title.setFont(new Font("Cambria", Font.PLAIN, 28));
		title.setForeground(Color.DARK_GRAY);
		constraints.insets = new Insets(5, 10, 25, 10);
		constraints.gridwidth = 10;
		frame.add(title, constraints);

		constraints.insets = new Insets(5, 10, 5, 10);

		percentageLabel = new JLabel("How much the final is worth:");
		percentageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		percentageLabel.setForeground(Color.DARK_GRAY);
		constraints.gridwidth = 1;
		constraints.gridy = 1;
		constraints.gridx = 0;
		constraints.anchor = GridBagConstraints.EAST;
		frame.add(percentageLabel, constraints);

		// first slider
		finalPercentage = new MySlider(JSlider.HORIZONTAL, 0, 100, 0, "Set how much the final is worth: ");
		finalPercentage.addChangeListener(this);
		constraints.ipadx = 0;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridwidth = 7;
		constraints.gridx = 1;
		frame.add(finalPercentage, constraints);

		percentageValue = new JTextField("0%", 3);
		percentageValue.setBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0));
		percentageValue.setHorizontalAlignment(SwingConstants.RIGHT);
		percentageValue.setForeground(Color.DARK_GRAY);
		percentageValue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = percentageValue.getText();
				if (text.charAt(text.length() - 1) == ('%')) {
					text = text.substring(0, text.length() - 1);
				}
				finalPercentage.setValue(Integer.parseInt(text));
			}

		});
		constraints.gridx = 8;
		constraints.anchor = GridBagConstraints.WEST;
		frame.add(percentageValue, constraints);

		gradeLabel = new JLabel("Your current grade:");
		gradeLabel.setForeground(Color.DARK_GRAY);
//		constraints.ipadx = 100;
		constraints.gridwidth = 1;
		constraints.gridy = 2;
		constraints.gridx = 0;
		constraints.anchor = GridBagConstraints.EAST;
		frame.add(gradeLabel, constraints);

		// second slider
		currentGrade = new MySlider(JSlider.HORIZONTAL, 0, 100, 0, "Set your current grade in the class: ");
		currentGrade.addChangeListener(this);
		constraints.ipadx = 0;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridwidth = 7;
		constraints.gridx = 1;
		frame.add(currentGrade, constraints);

		gradeValue = new JTextField("0%", 3);
		gradeValue.setBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0));
		gradeValue.setHorizontalAlignment(SwingConstants.RIGHT);
		gradeValue.setForeground(Color.DARK_GRAY);
		gradeValue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				currentGrade.setValue(Integer.parseInt(gradeValue.getText()));
			}

		});
		constraints.gridx = 8;
		constraints.anchor = GridBagConstraints.WEST;
		frame.add(gradeValue, constraints);

		// Bar Graph

		JLabel xAxisLabel = new JLabel("Your Grade On The Final");
		xAxisLabel.setForeground(Color.DARK_GRAY);
		constraints.gridy = 5;
		constraints.gridx = 4;
		constraints.gridwidth = 7;
		constraints.ipady = 15;
		frame.add(xAxisLabel, constraints);

		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.ipady = 0;

		ColoredBar bar = new ColoredBar(40, JProgressBar.VERTICAL, new Color(50, 50, 50), this);
		bars[0] = bar;
		constraints.gridx = 2;
		frame.add(bar, constraints);

		JLabel barLabel5 = new JLabel("40%");
		constraints.gridy = 4;
		frame.add(barLabel5, constraints);

		bar = new ColoredBar(50, JProgressBar.VERTICAL, new Color(220, 20, 0), this);
		bars[1] = bar;
		constraints.gridy = 3;
		constraints.gridx = 3;
		frame.add(bar, constraints);

		JLabel barLabel15 = new JLabel("50%");
		constraints.gridy = 4;
		frame.add(barLabel15, constraints);

		bar = new ColoredBar(60, JProgressBar.VERTICAL, new Color(255, 80, 0), this);
		bars[2] = bar;
		constraints.gridy = 3;
		constraints.gridx = 4;
		frame.add(bar, constraints);

		JLabel barLabel25 = new JLabel("60%");
		constraints.gridy = 4;
		frame.add(barLabel25, constraints);

		bar = new ColoredBar(70, JProgressBar.VERTICAL, new Color(240, 200, 0), this);
		bars[3] = bar;
		constraints.gridy = 3;
		constraints.gridx = 5;
		frame.add(bar, constraints);

		JLabel barLabel35 = new JLabel("70%");
		constraints.gridy = 4;
		frame.add(barLabel35, constraints);

		bar = new ColoredBar(80, JProgressBar.VERTICAL, new Color(150, 210, 0), this);
		bars[4] = bar;
		constraints.gridy = 3;
		constraints.gridx = 6;
		frame.add(bar, constraints);

		JLabel barLabel45 = new JLabel("80%");
		constraints.gridy = 4;
		frame.add(barLabel45, constraints);

		bar = new ColoredBar(90, JProgressBar.VERTICAL, new Color(0, 210, 30), this);
		bars[5] = bar;
		constraints.gridy = 3;
		constraints.gridx = 7;
		frame.add(bar, constraints);

		JLabel barLabel55 = new JLabel("90%");
		constraints.gridy = 4;
		frame.add(barLabel55, constraints);

		bar = new ColoredBar(100, JProgressBar.VERTICAL, new Color(0, 160, 40), this);
		bars[6] = bar;
		constraints.gridy = 3;
		constraints.gridx = 8;
		frame.add(bar, constraints);

		JLabel barLabel65 = new JLabel("100%");
		constraints.gridy = 4;
		frame.add(barLabel65, constraints);

		SidewaysLabel yAxisLabel = new SidewaysLabel("Your Grade In The Class");
		constraints.gridy = 3;
		constraints.gridx = 9;
		frame.add(yAxisLabel, constraints);

		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(50, 50, 50, 35);

		myFrame.add(frame, constraints);
		myFrame.pack();
		myFrame.setVisible(true);
	}

	public static void main(String[] args) {
		new PersonalProject();
	}

	public double resultingGrade(int finalGrade) {
		int grade = currentGrade.getValue();
		double percentage = finalPercentage.getValue();

		double currentPercentage = 100 - percentage;
		double realGrade = grade * currentPercentage * .01;

		double realFinalGrade = finalGrade * percentage * .01;

		return realFinalGrade + realGrade;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		for (ColoredBar b : bars) {
			b.repaint();
		}

		finalPercentage.repaint();
		currentGrade.repaint();

		percentageValue.setText(finalPercentage.getValue() + "%");
		gradeValue.setText(currentGrade.getValue() + "%");
	}

}
