/*
 * Author: Jeremy Favro
 * Date: 24/3/22
 * Class: ICS3U1
 * Project name: GUI Inputs 
 * Description: Combining all the GUI stuff (WITH ANNOYING HUNGARIAN CONVENTIONS)
 */
package guiinputs;

import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.JPanel;

public class GUIInputs {

    public static Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED); // Border style for the panels
    // Main frame
    public static JFrame Frame;
    // Customer info collection
    public static JPanel CustInfoPanel;
    public static JTextField NameTextField;
    public static JTextField PhoneTextField;
    public static JTextField EmailTextField;
    // Photo options 
    public static JPanel PhotoInfoPanel;
    public static JLabel picLabel;

    public static void GUI() {

        // Main frame 
        Frame = new JFrame("Photo ordering");
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Customer info input panel
        CustInfoPanel = new JPanel();
        CustInfoPanel.setLayout(null);
        CustInfoPanel.setBounds(5, 10, 400, 125);
        CustInfoPanel.setBorder(BorderFactory.createTitledBorder(loweredetched, "Customer information"));
        // Name input
        NameTextField = new JTextField("Name");
        NameTextField.setBounds(25, 25, 165, 25);
        NameTextField.setHorizontalAlignment(JLabel.CENTER);
        // Phone number input
        PhoneTextField = new JTextField("Phone number");
        PhoneTextField.setBounds(25, 50, 165, 25);
        PhoneTextField.setHorizontalAlignment(JLabel.CENTER);
        // Email input
        EmailTextField = new JTextField("Email");
        EmailTextField.setBounds(25, 75, 165, 25);
        EmailTextField.setHorizontalAlignment(JLabel.CENTER);
        // Add elements to CustInfoPanel
        CustInfoPanel.add(NameTextField);
        CustInfoPanel.add(PhoneTextField);
        CustInfoPanel.add(EmailTextField);
        // Photo options panel
        PhotoInfoPanel = new JPanel();
        PhotoInfoPanel.setLayout(null);
        PhotoInfoPanel.setBounds(5, 135, 400, 300);
        PhotoInfoPanel.setBorder(BorderFactory.createTitledBorder(loweredetched, "Photo information"));
        // Add images for size selection
        picLabel = new JLabel(new ImageIcon("image_path.png"));
        picLabel.setBounds(25, 25, 205, 146);
        PhotoInfoPanel.add(picLabel);
        // Configure frame
        Frame.add(CustInfoPanel);
        Frame.add(PhotoInfoPanel);
        Frame.setSize(425, 750);
        Frame.setLayout(null);
        Frame.setVisible(true);
    }

    public static void main(String[] args) {
        GUI();
    } //EndOfMain

} // EndOfClass
