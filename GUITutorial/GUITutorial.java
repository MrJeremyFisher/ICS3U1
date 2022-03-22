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

    // Super vars
    public static Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    public static int LbLSX = 300;
    public static int LbLSY = 200;
    // Part 1 vars
    public static JFrame Frame;
    public static JFrame Frame2;
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

    // Part 2 vars
    public static JPanel RadBoxSection;
    public static JPanel CoBoxSection;
    public static JPanel CBoxSection;
    public static JRadioButton RadS;
    public static JRadioButton RadM;
    public static JRadioButton RadL;
    public static JLabel SLabel;
    public static JLabel SizeLabel;
    public static JLabel AmountLabel;
    public static JLabel CheckLabel;
    public static JComboBox SizeSelect;
    public static JComboBox AmountSelect;
    public static JCheckBox CheckS;
    public static JCheckBox CheckM;
    public static JCheckBox CheckL;
    public static String[] Sizes = {"Small", "Medium", "Large"};
    public static String[] Amount = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    public static void Frame1(String[] args) {

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

    }

    public static void Frame2(String[] args) {

        // Frame stuff
        Frame2 = new JFrame("GUI 2");
        Frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Rad button container
        RadBoxSection = new JPanel();
        RadBoxSection.setLayout(null);
        RadBoxSection.setBounds(5, 10, 400, LbLSY);
        RadBoxSection.setBorder(BorderFactory.createTitledBorder(loweredetched, "Radio boxes"));
        /*
        * This doesnt work exactly as I'd like it to, but who cares
         */
        // Set up radio button 1
        RadS = new JRadioButton("Small");
        RadS.setBounds(40, 25, 220, 25);
        RadBoxSection.add(RadS);
        // Rad1 Action listener
        RadS.addActionListener((ActionEvent e) -> {
            SLabel.setText("Size: small"); // I know that hardcoding these is bad practice but I do not care
        });
        // Set up radio button 2
        RadM = new JRadioButton("Medium");
        RadM.setBounds(40, 50, 220, 25);
        RadBoxSection.add(RadM);
        // Rad1 Action listener
        RadM.addActionListener((ActionEvent e) -> {
            SLabel.setText("Size: medium");
        });
        // Set up radio button 3
        RadL = new JRadioButton("Large");
        RadL.setBounds(40, 75, 220, 25);
        RadBoxSection.add(RadL);
        // Rad1 Action listener
        RadL.addActionListener((ActionEvent e) -> {
            SLabel.setText("Size: large");
        });
        // Set up size label
        SLabel = new JLabel("Size: ");
        SLabel.setBounds(40, 100, 220, 25);
        RadBoxSection.add(SLabel);
        // Set up combo box container
        CoBoxSection = new JPanel();
        CoBoxSection.setLayout(null);
        CoBoxSection.setBounds(5, 240, 400, LbLSY);
        CoBoxSection.setBorder(BorderFactory.createTitledBorder(loweredetched, "Combo boxes"));
        // Set up combo box 1
        SizeSelect = new JComboBox(Sizes);
        SizeSelect.setBounds(40, 25, 220, 25);
        CoBoxSection.add(SizeSelect);
        // Set up combo box 2
        AmountSelect = new JComboBox(Amount);
        AmountSelect.setBounds(40, 75, 220, 25);
        CoBoxSection.add(AmountSelect);
        // Set up size label
        SizeLabel = new JLabel("Size: ");
        SizeLabel.setBounds(280, 25, 220, 25);
        CoBoxSection.add(SizeLabel);
        // Set up amount label
        AmountLabel = new JLabel("Amount: ");
        AmountLabel.setBounds(280, 75, 220, 25);
        CoBoxSection.add(AmountLabel);
        // Set up combo box action listener 1
        SizeSelect.addActionListener((ActionEvent e) -> {
            int selection = SizeSelect.getSelectedIndex();
            switch (selection) {
                case 0:
                    SizeLabel.setText("Size: Small");
                    break;
                case 1:
                    SizeLabel.setText("Size: Medium");
                    break;
                case 2:
                    SizeLabel.setText("Size: Large");
                    break;
                default:
                    break;
            }
        });
        // Set up combo box action listener 2
        AmountSelect.addActionListener((ActionEvent e) -> {
            int selection = AmountSelect.getSelectedIndex();
            switch (selection) {
                case 0:
                    AmountLabel.setText("Amount: " + (selection + 1)); // This takes the array pos and adds 1, giving us the amount selected
                    break;
                case 1:
                    AmountLabel.setText("Amount: " + (selection + 1));
                    break;
                case 2:
                    AmountLabel.setText("Amount: " + (selection + 1));
                    break;
                case 3:
                    AmountLabel.setText("Amount: " + (selection + 1));
                    break;
                case 4:
                    AmountLabel.setText("Amount: " + (selection + 1));
                    break;
                case 5:
                    AmountLabel.setText("Amount: " + (selection + 1));
                    break;
                case 6:
                    AmountLabel.setText("Amount: " + (selection + 1));
                    break;
                case 7:
                    AmountLabel.setText("Amount: " + (selection + 1));
                    break;
                case 8:
                    AmountLabel.setText("Amount: " + (selection + 1));
                    break;
                case 9:
                    AmountLabel.setText("Amount: " + (selection + 1));
                    break;
                default:
                    break;
            }
        }); // yuck

        // Set up check box container
        CBoxSection = new JPanel();
        CBoxSection.setLayout(null);
        CBoxSection.setBounds(5, 470, 400, LbLSY);
        CBoxSection.setBorder(BorderFactory.createTitledBorder(loweredetched, "Check boxes"));
        // Set up checkbox 1
        CheckS = new JCheckBox("Small");
        CheckS.setBounds(40, 25, 220, 25);
        CBoxSection.add(CheckS);
        // Set up checkbox 2
        CheckM = new JCheckBox("Medium");
        CheckM.setBounds(40, 75, 220, 25);
        CBoxSection.add(CheckM);
        // Set up checkbox 3
        CheckL = new JCheckBox("Large");
        CheckL.setBounds(40, 125, 220, 25);
        CBoxSection.add(CheckL);
        // Set up checkbox Label
        CheckLabel = new JLabel("Size: ");
        CheckLabel.setBounds(280, 75, 220, 25);
        CBoxSection.add(CheckLabel);
        //Set up checkbox 1 ActionListener
        CheckS.addActionListener((ActionEvent e) -> {
            CheckLabel.setText("Size: Small");
        });
        //Set up checkbox 1 ActionListener
        CheckM.addActionListener((ActionEvent e) -> {
            CheckLabel.setText("Size: Medium");
        });
        //Set up checkbox 1 ActionListener
        CheckL.addActionListener((ActionEvent e) -> {
            CheckLabel.setText("Size: Large");
        });
        // Frame stuff 2
        Frame2.add(RadBoxSection);
        Frame2.add(CoBoxSection);
        Frame2.add(CBoxSection);
        Frame2.setSize(425, 750);
        Frame2.setLayout(null);
        Frame2.setVisible(true);
    }

    public static void main(String[] args) {
        Frame1(args);
        Frame2(args);
    } //EndOfMain

} // EndOfClass
