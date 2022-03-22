package GUITutorial;

import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class GUITutorial {

	public static JFrame Frame;
	public static JPanel LabelSection;
	public static JPanel ButtonSection;
	public static JLabel Label;
	public static JButton ColourButton;
	public static JButton TFieldOn;
	public static JButton TFieldOff;
	
	public static int LbLSX = 300;
	public static int LbLSY = 200;
	public static void main(String[] args) {
		
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		// Frame stuff
		Frame = new JFrame("GUI");
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set up LabelSection container
		LabelSection = new JPanel();
		LabelSection.setLayout(null);
		LabelSection.setBounds(5, 10, LbLSX, LbLSY);
		LabelSection.setBorder(BorderFactory.createTitledBorder(loweredetched, "Labels"));
		// Create Label
		Label = new JLabel("This is a label", SwingConstants.CENTER);

		Label.setHorizontalAlignment(JLabel.CENTER);
		Label.setBounds((LbLSX / 3), 40, 100, 25);
		LabelSection.add(Label);
		// Create button
		ColourButton = new JButton("Click me to make the label green");
		ColourButton.setHorizontalAlignment(JLabel.CENTER);
		ColourButton.setBounds(40, 80, 220, 25);
		LabelSection.add(ColourButton);
		// Create action listener for Label colour changer
		ColourButton.addActionListener((ActionEvent e) -> {
			Label.setText("<html><font color='green'>This is a green label</font></html>");

			Label.setBounds((LbLSX / 4), 40, 150, 25);
		});
		
		// Set up ButtonSection container
		ButtonSection = new JPanel();
		ButtonSection.setLayout(null);
		ButtonSection.setBounds(5, 240, 300, 200);
		ButtonSection.setBorder(BorderFactory.createTitledBorder(loweredetched, "Buttons"));
		// Create button
		TFieldOn = new JButton("Click me to show the text field section");
		TFieldOn.setHorizontalAlignment(JLabel.CENTER);
		TFieldOn.setBounds(20, 80, 260, 25);
		ButtonSection.add(TFieldOn);
		// Create button
		TFieldOff = new JButton("Click me to hide the text field section");
		TFieldOff.setHorizontalAlignment(JLabel.CENTER);
		TFieldOff.setBounds(20, 120, 260, 25);
		ButtonSection.add(TFieldOff);
		// Create action listener for Show button
		TFieldOn.addActionListener((ActionEvent e) -> {
			
		});
		// Create action listener for Hide button
		TFieldOff.addActionListener((ActionEvent e) -> {
			
		});

		// Frame stuff
		Frame.add(LabelSection);
		Frame.add(ButtonSection);
		Frame.setSize(800, 800);
		Frame.setLayout(null);
		Frame.setVisible(true);
	} //EndOfMain

} // EndOfClass
