/*
 * Author: Jeremy Favro
 * Date: 24/3/22
 * Class: ICS3U1
 * Project name: GUI Inputs 
 * Description: Combining all the GUI stuff (WITH ANNOYING HUNGARIAN CONVENTIONS)
 */
package GUIInputs;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	public static int NameTextField1 = 0;
	public static JTextField PhoneTextField;
	public static int PhoneTextField1 = 0;
	public static JTextField EmailTextField;
	public static int EmailTextField1 = 0;
	// Photo options 
	public static JPanel PhotoInfoPanel;
	public static JPanel PhotoInfoPanel1;
	public static JPanel PhotoInfoPanel2;
	public static JPanel PhotoInfoPanel3;
	public static JPanel PhotoInfoPanel4;
	public static JPanel PhotoInfoPanel5;
	public static JLabel picLabel;
	public static JLabel picLabel2;
	public static JLabel picLabel3;
	public static JLabel picLabel4;
	public static JTextField NumPrintsTextField;
	public static JCheckBox RedEyeCheckBox;
	public static JCheckBox OverExposureCheckBox;
	public static JCheckBox ColourComposureCheckBox;
	public static JCheckBox ColourCorrectionCheckBox;
	public static JCheckBox BlemishRetouchCheckBox;
	public static int PhotoSizeSelection = 0;
	// Shipping info panel
	public static JPanel ShippingInfoPanel;
	@SuppressWarnings("rawtypes")
	public static JComboBox CountryComboBox;
	@SuppressWarnings("rawtypes")
	public static JComboBox ProvinceComboBox;
	public static String[] Countries = { "<Select Country>", "Canada" };
	public static String[] Provinces = { "<Select Province>", "Alberta", "British Columbia", "Manitoba",
			"New Brunswick", "Newfoundland and Labrador", "Nova Scotia", "Ontario", "Prince Edward Island", "Quebec",
			"Saskatchewan", "Northwest Territories", "Nunavut", "Yukon" };
	public static JTextField CityTextField;
	public static JTextField AddressTextField;
	public static JButton OrderButton;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void GUI() {

		// Main frame 
		Frame = new JFrame("Photo ordering");
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Customer info input panel
		CustInfoPanel = new JPanel();
		CustInfoPanel.setLayout(null);
		CustInfoPanel.setBounds(5, 10, 487, 125);
		CustInfoPanel.setBorder(BorderFactory.createTitledBorder(loweredetched, "Customer information"));
		// Name input
		NameTextField = new JTextField("Name");
		NameTextField.setBounds(5, 25, 165, 25);
		NameTextField.setHorizontalAlignment(JLabel.CENTER);
		// Phone number input
		PhoneTextField = new JTextField("Phone number");
		PhoneTextField.setBounds(5, 50, 165, 25);
		PhoneTextField.setHorizontalAlignment(JLabel.CENTER);
		// Email input
		EmailTextField = new JTextField("Email");
		EmailTextField.setBounds(5, 75, 165, 25);
		EmailTextField.setHorizontalAlignment(JLabel.CENTER);
		// Add elements to CustInfoPanel
		CustInfoPanel.add(NameTextField);
		CustInfoPanel.add(PhoneTextField);
		CustInfoPanel.add(EmailTextField);

		


	} //EndOfGUI
	
	public static void GUI1() {
		// Photo options panel
				PhotoInfoPanel = new JPanel();
				PhotoInfoPanel.setLayout(null);
				PhotoInfoPanel.setBounds(5, 135, 487, 600);
				PhotoInfoPanel.setBorder(BorderFactory.createTitledBorder(loweredetched, "Photo information"));
				// Photo options subpanel
				PhotoInfoPanel1 = new JPanel();
				PhotoInfoPanel1.setLayout(null);
				PhotoInfoPanel1.setBounds(5, 25, 226, 176);
				PhotoInfoPanel1.setBorder(BorderFactory.createTitledBorder(loweredetched, "12x17"));

				// Photo options subpanel 2
				PhotoInfoPanel2 = new JPanel();
				PhotoInfoPanel2.setLayout(null);
				PhotoInfoPanel2.setBounds(235, 25, 226, 176);
				PhotoInfoPanel2.setBorder(BorderFactory.createTitledBorder(loweredetched, "8x10"));

				// Photo options subpanel 3
				PhotoInfoPanel3 = new JPanel();
				PhotoInfoPanel3.setLayout(null);
				PhotoInfoPanel3.setBounds(5, 201, 226, 176);
				PhotoInfoPanel3.setBorder(BorderFactory.createTitledBorder(loweredetched, "6x8"));

				// Photo options subpanel 4
				PhotoInfoPanel4 = new JPanel();
				PhotoInfoPanel4.setLayout(null);
				PhotoInfoPanel4.setBounds(235, 201, 226, 176);
				PhotoInfoPanel4.setBorder(BorderFactory.createTitledBorder(loweredetched, "4x6"));

				// Add largest image
				picLabel = new JLabel(new ImageIcon(
						"C:\\Users\\jeremyf77\\Documents\\NetBeansProjects\\GUIInputs\\src\\guiinputs\\PhotoSize4.png"));
				picLabel.setBounds(10, 20, 206, 146);

				// Add add medium-large image
				picLabel2 = new JLabel(new ImageIcon(
						"C:\\Users\\jeremyf77\\Documents\\NetBeansProjects\\GUIInputs\\src\\guiinputs\\PhotoSize3.png"));
				picLabel2.setBounds(34, 34, 154, 110);

				// Add medium-small image
				picLabel3 = new JLabel(new ImageIcon(
						"C:\\Users\\jeremyf77\\Documents\\NetBeansProjects\\GUIInputs\\src\\guiinputs\\PhotoSize2.png"));
				picLabel3.setBounds(58, 48, 103, 73);

				// Add small image
				picLabel4 = new JLabel(new ImageIcon(
						"C:\\Users\\jeremyf77\\Documents\\NetBeansProjects\\GUIInputs\\src\\guiinputs\\PhotoSize1.png"));
				picLabel4.setBounds(25, 25, 52, 37);

				// Corrections and order amount panel
				PhotoInfoPanel5 = new JPanel();
				PhotoInfoPanel5.setLayout(null);
				PhotoInfoPanel5.setBounds(5, 377, 456, 176);
				PhotoInfoPanel5.setBorder(BorderFactory.createTitledBorder(loweredetched, "Corrections and order amount"));

				// Number of prints label
				NumPrintsTextField = new JTextField("Number of photos");
				NumPrintsTextField.setBounds(5, 25, 165, 25);
				NumPrintsTextField.setHorizontalAlignment(JLabel.CENTER);

				// Red-eye checkbox
				RedEyeCheckBox = new JCheckBox("Red-eye correction");
				RedEyeCheckBox.setBounds(240, 25, 200, 15);

				// Over exposure checkbox
				OverExposureCheckBox = new JCheckBox("Over exposure correction");
				OverExposureCheckBox.setBounds(240, 45, 200, 15);

				// Colour composure checkbox
				ColourComposureCheckBox = new JCheckBox("Colour composure correction");
				ColourComposureCheckBox.setBounds(240, 65, 200, 15);

				// Colour correction checkbox
				ColourCorrectionCheckBox = new JCheckBox("Colour correction correction");
				ColourCorrectionCheckBox.setBounds(240, 85, 200, 15);

				// Blemish retouch checkbox
				BlemishRetouchCheckBox = new JCheckBox("Blemish retouch correction");
				BlemishRetouchCheckBox.setBounds(240, 105, 200, 15);

				// Add stuff to panel
				PhotoInfoPanel.add(PhotoInfoPanel1);
				PhotoInfoPanel.add(PhotoInfoPanel2);
				PhotoInfoPanel.add(PhotoInfoPanel3);
				PhotoInfoPanel.add(PhotoInfoPanel4);
				PhotoInfoPanel.add(PhotoInfoPanel5);
				PhotoInfoPanel1.add(picLabel);
				PhotoInfoPanel2.add(picLabel2);
				PhotoInfoPanel3.add(picLabel3);
				PhotoInfoPanel4.add(picLabel4);
				PhotoInfoPanel5.add(NumPrintsTextField);
				PhotoInfoPanel5.add(RedEyeCheckBox);
				PhotoInfoPanel5.add(OverExposureCheckBox);
				PhotoInfoPanel5.add(ColourComposureCheckBox);
				PhotoInfoPanel5.add(ColourCorrectionCheckBox);
				PhotoInfoPanel5.add(BlemishRetouchCheckBox);
		
	} // EndOfGUI1
	
	public static void GUI2() {
		// Shipping info and final panel
		ShippingInfoPanel = new JPanel();
		ShippingInfoPanel.setLayout(null);
		ShippingInfoPanel.setBounds(492, 10, 200, 725);
		ShippingInfoPanel.setBorder(BorderFactory.createTitledBorder(loweredetched, "Shipping info"));

		// Country combo box -- only adding Canada to this just cause 
		CountryComboBox = new JComboBox(Countries);
		CountryComboBox.setBounds(5, 25, 190, 25);

		// Province combo box
		ProvinceComboBox = new JComboBox(Provinces);
		ProvinceComboBox.setBounds(5, 55, 190, 25);

		// City text field
		CityTextField = new JTextField("<Enter City>");
		CityTextField.setBounds(5, 85, 190, 25);

		// Address text field
		AddressTextField = new JTextField("<Enter Address>");
		AddressTextField.setBounds(5, 115, 190, 25);
		
		// Order button
		OrderButton = new JButton("Order");
		OrderButton.setBounds(5, 675, 190, 25);
		// Add stuff to panel
		ShippingInfoPanel.add(CountryComboBox);
		ShippingInfoPanel.add(ProvinceComboBox);
		ShippingInfoPanel.add(CityTextField);
		ShippingInfoPanel.add(AddressTextField);
		ShippingInfoPanel.add(OrderButton);
		// Configure frame
		Frame.add(CustInfoPanel);
		Frame.add(PhotoInfoPanel);
		Frame.add(ShippingInfoPanel);
		Frame.setSize(900, 800);
		Frame.setLayout(null);
		Frame.setVisible(true);
	} // EndOfGUI2
	
	public static void GUI3() {
		// Action events!!1!1!!11
		// Clear name text field contents onclick -- only do so once
		NameTextField.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        switch (NameTextField1) {
		        case 0:
		        	NameTextField.setText("");
			        NameTextField1 = 1;
			    break;
		        case 1: 
		        break;
		        
		        }
		    }
		});
		
		// Clear phone text field contents onclick -- only do so once
		PhoneTextField.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        switch (PhoneTextField1) {
		        case 0:
		        	PhoneTextField.setText("");
		        	PhoneTextField1 = 1;
			    break;
		        case 1: 
		        break;
		        
		        }
		    }
		});
		
		// Clear email text field contents onclick -- only do so once
		EmailTextField.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        switch (EmailTextField1) {
		        case 0:
		        	EmailTextField.setText("");
		        	EmailTextField1 = 1;
			    break;
		        case 1: 
		        break;
		        
		        }
		    }
		});
		
		// Photo size selection 
		picLabel.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	PhotoSizeSelection = 1;
		    }
		});
		
		picLabel.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	PhotoSizeSelection = 2;
		    }
		});
		
		picLabel.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	PhotoSizeSelection = 3;
		    }
		});
		
		picLabel.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	PhotoSizeSelection = 4;
		    }
		});
	} // EndOfGUI3
	
	public static void main(String[] args) {
		GUI();
		GUI1();
		GUI2();
		GUI3();
	} //EndOfMain

} // EndOfClass
