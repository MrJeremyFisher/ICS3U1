/*
 * Author: Jeremy Favro
 * Date: 3/21/22
 * Class: ICS3U1
 * Project name: GUI Tutorial
 * Description: Combining all the GUI crud to do some stuff
 */
package guitutorial;

import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class GUITutorial {

    public static JFrame Frame;
    public static JPanel LabelSection;
    public static JPanel ButtonSection;
    public static JPanel TBoxSection;
    public static JLabel Label;
    public static JLabel CLabel;
    public static JButton ColourButton;
    public static JButton TFieldOn;
    public static JButton TFieldOff;
    public static JButton TFieldChange;
    public static JTextField TField;

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
        ButtonSection.setBounds(5, 240, LbLSX, LbLSY);
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
            TBoxSection.setVisible(true);
        });
        // Create action listener for Hide button
        TFieldOff.addActionListener((ActionEvent e) -> {
            TBoxSection.setVisible(false);

        });
        // Text field section container
        TBoxSection = new JPanel();
        TBoxSection.setLayout(null);
        TBoxSection.setBounds(5, 470, LbLSX, LbLSY);
        TBoxSection.setBorder(BorderFactory.createTitledBorder(loweredetched, "Text boxes"));
        // Set up textfield
        TField = new JTextField();
        TField.setHorizontalAlignment(JLabel.CENTER);
        TField.setBounds(20, 125, 260, 25);
        TBoxSection.add(TField);
        // Set up label
        CLabel = new JLabel("This label will change");
        CLabel.setHorizontalAlignment(JLabel.CENTER);
        CLabel.setBounds(20, 25, 260, 25);
        TBoxSection.add(CLabel);
        // Set up label button
        TFieldChange = new JButton("Press me to update the label");
        TFieldChange.setHorizontalAlignment(JLabel.CENTER);
        TFieldChange.setBounds(20, 75, 260, 25);
        TBoxSection.add(TFieldChange);
        // Label button action listener
        TFieldChange.addActionListener((ActionEvent e) -> {
            String TextFieldContent = TField.getText();
            CLabel.setText(TextFieldContent);
        });
        // Frame stuff
        Frame.add(LabelSection);
        Frame.add(ButtonSection);
        Frame.add(TBoxSection);
        Frame.setSize(LbLSX + 25, 750);
        Frame.setLayout(null);
        Frame.setVisible(true);
    } //EndOfMain

} // EndOfClass
