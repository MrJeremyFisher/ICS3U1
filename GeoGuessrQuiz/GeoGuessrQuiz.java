/*
 * Author: Jeremy Favro
 * Date: 
 * Class: ICS3U1
 * Project name: 
 * Description: 
 */
package geoguessrquiz;

import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class GeoGuessrQuiz {

    // Border style for panels
    public static Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

    // Frames
    public static JFrame frm_nameFrame;
    public static JFrame frm_quizFrame1;
    public static JFrame frm_quizFrame2;
    public static JFrame frm_quizFrame3;
    public static JFrame frm_quizFrame4;
    public static int xSize = 800;
    public static int ySize = 600;

    // Panels
    public static JPanel pnl_nameCollection;
    public static JPanel pnl_firstQuestion;
    public static JPanel pnl_secondQuestion;
    public static JPanel pnl_thirdQuestion;
    public static JPanel pnl_fourthQuestion;

    // Global variables
    public static String userName;
    public static int userScore = 0;
    public static boolean[] userScoreArray = new boolean[11];
    public static GridBagConstraints c = new GridBagConstraints();

    // First frame
    public static JTextField txt_userName;
    public static JButton btn_start;

    // Second frame (first question - radio buttons)
    public static ButtonGroup radioButtonGroup1;
    public static JRadioButton rad_radioAnswer1;
    public static JRadioButton rad_radioAnswer2;
    public static JRadioButton rad_radioAnswer3;
    public static JRadioButton rad_radioAnswer4;
    public static JButton btn_answer1Submit;

    // Third frame (second question - check boxes)
    public static JCheckBox chk_checkAnswer1;
    public static JCheckBox chk_checkAnswer1x;
    public static JCheckBox chk_checkAnswer2;
    public static JCheckBox chk_checkAnswer2x;
    public static JCheckBox chk_checkAnswer3;
    public static JCheckBox chk_checkAnswer3x;
    public static JCheckBox chk_checkAnswer4;
    public static JCheckBox chk_checkAnswer4x;
    public static JButton btn_answer2Submit;
    public static JLabel lbl_cityLabel;
    public static JLabel lbl_countryLabel;

    // Fourth frame (third question - combo boxes)
    public static String[] Countries = {"< Select Country >", "Egypt", "India", "Russia", "Germany", "Brazil"};
    public static JComboBox cbo_countryComboBox;
    public static String[] Continents = {"< Select Continent>", "North America", "South America", "Africa", "Europe", "Asia", "Oceania", "Antarctica"};
    public static JComboBox cbo_continentComboBox;
    public static JButton btn_answer3Submit;

    // Fifth frame (fourth question - buttons)
    public static JButton btn_cityOption1;
    public static JButton btn_cityOption2;
    public static JButton btn_cityOption3;
    public static JButton btn_cityOption4;
    public static JButton btn_answer4Submit;
    public static JLabel lbl_citySelection;
    public static int selection = 0;

    // Sixth frame
    public static JTextField txt_locationTextBox;
    
    public static void firstFrame() {

        // First frame
        frm_nameFrame = new JFrame("GeoGuessr");
        frm_nameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // User name input panel
        pnl_nameCollection = new JPanel();
        pnl_nameCollection.setLayout(new GridBagLayout()); // Center elements on this panel
        c.fill = GridBagConstraints.HORIZONTAL;
        pnl_nameCollection.setBounds(25, 400, (xSize - 75), (ySize / 4));
        pnl_nameCollection.setBorder(BorderFactory.createTitledBorder(loweredetched));

        // User name input box
        txt_userName = new JTextField("< Enter Name >");
        txt_userName.setHorizontalAlignment(SwingConstants.CENTER);
        c.ipadx = 165;
        c.weightx = 0;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 3;
        pnl_nameCollection.add(txt_userName, c);

        // Start button
        btn_start = new JButton("Start");
        c.ipadx = 83;
        c.weightx = 0;
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 2;
        pnl_nameCollection.add(btn_start, c);

        // Start button action event
        btn_start.addActionListener((ActionEvent e) -> {
            userName = txt_userName.getText();
            frm_nameFrame.dispose();
            secondFrame();
        });

        // Add panels to frame
        frm_nameFrame.add(pnl_nameCollection);

        // Configure frame
        frm_nameFrame.setSize(xSize, ySize);
        frm_nameFrame.setLayout(null);
        frm_nameFrame.setVisible(true);
    } // End of first frame

    public static void secondFrame() {

        // Quiz frame 1 - radio buttons (Eiffel tower gardens)
        frm_quizFrame1 = new JFrame("GeoGuessr: Question 1");
        frm_quizFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.ipadx = 0;
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 0;

        // Answer panel
        pnl_firstQuestion = new JPanel();
        pnl_firstQuestion.setLayout(new GridBagLayout()); // Center elements on this panel
        c.fill = GridBagConstraints.HORIZONTAL;
        pnl_firstQuestion.setBounds(25, 400, (xSize - 75), (ySize / 4));
        pnl_firstQuestion.setBorder(BorderFactory.createTitledBorder(loweredetched));

        // Radio button group
        ButtonGroup radioButtonGroup1 = new ButtonGroup();

        // Radio button 1
        rad_radioAnswer1 = new JRadioButton("Paris, France");
        c.ipadx = 0;
        c.weightx = 0;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        radioButtonGroup1.add(rad_radioAnswer1);
        pnl_firstQuestion.add(rad_radioAnswer1, c);

        // Radio button 2
        rad_radioAnswer2 = new JRadioButton("Berlin, Germany");
        c.ipadx = 0;
        c.weightx = 0;
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 1;
        radioButtonGroup1.add(rad_radioAnswer2);
        pnl_firstQuestion.add(rad_radioAnswer2, c);

        // Radio button 3
        rad_radioAnswer3 = new JRadioButton("Bejing, China");
        c.ipadx = 0;
        c.weightx = 0;
        c.gridx = 3;
        c.gridy = 0;
        c.gridwidth = 1;
        radioButtonGroup1.add(rad_radioAnswer3);
        pnl_firstQuestion.add(rad_radioAnswer3, c);

        // Radio button 4
        rad_radioAnswer4 = new JRadioButton("Bali, Indonesia");
        c.ipadx = 0;
        c.weightx = 0;
        c.gridx = 4;
        c.gridy = 0;
        c.gridwidth = 1;
        radioButtonGroup1.add(rad_radioAnswer4);
        pnl_firstQuestion.add(rad_radioAnswer4, c);

        // Submit answer button
        btn_answer1Submit = new JButton("Submit");
        c.ipadx = 0;
        c.weightx = 0;
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 2;
        pnl_firstQuestion.add(btn_answer1Submit, c);

        btn_answer1Submit.addActionListener((ActionEvent e) -> {

            // Get which button is selected and set truefalse in the answer array
            for (Enumeration<AbstractButton> buttons = radioButtonGroup1.getElements(); buttons.hasMoreElements();) {

                AbstractButton button = buttons.nextElement();

                if (button.isSelected()) {

                    String btntxt = button.getText();

                    if (btntxt == "Paris, France") {
                        userScoreArray[0] = true;

                    } else {
                        userScoreArray[0] = false;
                    }
                }
            }

            // Dispose of current frame and create next
            frm_quizFrame1.dispose();
            thirdFrame();

        });

        // Configure frame
        frm_quizFrame1.add(pnl_firstQuestion);
        frm_quizFrame1.setSize(xSize, ySize);
        frm_quizFrame1.setLayout(null);
        frm_quizFrame1.setVisible(true);
    }

    public static void thirdFrame() {

        // Quiz frame 2 - check boxes (Statue of liberty and NY skyline)
        frm_quizFrame2 = new JFrame("GeoGuessr: Question 2");
        frm_quizFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.ipadx = 0;
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 0;

        // Answer panel
        pnl_secondQuestion = new JPanel();
        pnl_secondQuestion.setLayout(new GridBagLayout()); // Center elements on this panel
        c.fill = GridBagConstraints.HORIZONTAL;
        pnl_secondQuestion.setBounds(25, 400, (xSize - 75), (ySize / 4));
        pnl_secondQuestion.setBorder(BorderFactory.createTitledBorder(loweredetched));

        // Radio button group
        ButtonGroup chk_buttonGroupCity = new ButtonGroup();

        // Radio button group
        ButtonGroup chk_buttonGroupCountry = new ButtonGroup();

        // City checkbox 1
        chk_checkAnswer1 = new JCheckBox("New York City");
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        chk_buttonGroupCity.add(chk_checkAnswer1);
        pnl_secondQuestion.add(chk_checkAnswer1, c);

        // City label
        lbl_cityLabel = new JLabel("City:");
        c.gridy = 0;
        pnl_secondQuestion.add(lbl_cityLabel, c);

        // Country checkbox 1
        chk_checkAnswer1x = new JCheckBox("United States of America");
        c.gridx = 2;
        c.gridy = 1;
        chk_buttonGroupCountry.add(chk_checkAnswer1x);
        pnl_secondQuestion.add(chk_checkAnswer1x, c);

        // Country label
        lbl_countryLabel = new JLabel("Country:");
        c.gridx = 2;
        c.gridy = 0;
        pnl_secondQuestion.add(lbl_countryLabel, c);

        // City checkbox 2
        chk_checkAnswer2 = new JCheckBox("Pristina");
        c.gridx = 1;
        c.gridy = 2;
        chk_buttonGroupCity.add(chk_checkAnswer2);
        pnl_secondQuestion.add(chk_checkAnswer2, c);

        // Country checkbox 2
        chk_checkAnswer2x = new JCheckBox("Kosovo");
        c.gridy = 2;
        c.gridx = 2;
        chk_buttonGroupCountry.add(chk_checkAnswer2x);
        pnl_secondQuestion.add(chk_checkAnswer2x, c);

        // Submit answer button
        btn_answer2Submit = new JButton("Submit");
        c.ipadx = 0;
        c.weightx = 0;
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 2;
        pnl_secondQuestion.add(btn_answer2Submit, c);

        btn_answer2Submit.addActionListener((ActionEvent e) -> {

            // Get which button is selected (in country section) and set truefalse in the answer array
            for (Enumeration<AbstractButton> buttons = chk_buttonGroupCountry.getElements(); buttons.hasMoreElements();) {

                AbstractButton button = buttons.nextElement();

                if (button.isSelected()) {

                    String btntxt = button.getText();

                    if (btntxt == "New York City") {
                        userScoreArray[1] = true;

                    } else {
                        userScoreArray[1] = false;
                    }
                }
            }

            // Get which button is selected (in city section) and set truefalse in the answer array
            for (Enumeration<AbstractButton> buttons = chk_buttonGroupCity.getElements(); buttons.hasMoreElements();) {

                AbstractButton button = buttons.nextElement();

                if (button.isSelected()) {

                    String btntxt = button.getText();

                    if (btntxt == "United States of America") {
                        userScoreArray[2] = true;

                    } else {
                        userScoreArray[2] = false;
                    }
                }
            }

            // Dispose of current frame and create next
            frm_quizFrame2.dispose();
            fourthFrame();

        });

        // Configure frame
        frm_quizFrame2.add(pnl_secondQuestion);
        frm_quizFrame2.setSize(xSize, ySize);
        frm_quizFrame2.setLayout(null);
        frm_quizFrame2.setVisible(true);
    }

    public static void fourthFrame() {

        // Quiz frame 3 - combo boxes (Great pyramids)
        frm_quizFrame3 = new JFrame("GeoGuessr: Question 3");
        frm_quizFrame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.ipadx = 0;
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 0;

        // Answer panel
        pnl_thirdQuestion = new JPanel();
        pnl_thirdQuestion.setLayout(new GridBagLayout()); // Center elements on this panel
        c.fill = GridBagConstraints.HORIZONTAL;
        pnl_thirdQuestion.setBounds(25, 400, (xSize - 75), (ySize / 4));
        pnl_thirdQuestion.setBorder(BorderFactory.createTitledBorder(loweredetched));

        // Country combo box
        cbo_countryComboBox = new JComboBox(Countries);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        pnl_thirdQuestion.add(cbo_countryComboBox);

        // Continent combo box
        cbo_continentComboBox = new JComboBox(Continents);
        c.gridx = 2;
        pnl_thirdQuestion.add(cbo_continentComboBox);

        // Submit answer button
        btn_answer3Submit = new JButton("Submit");
        c.ipadx = 0;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        pnl_thirdQuestion.add(btn_answer3Submit, c);

        btn_answer3Submit.addActionListener((ActionEvent e) -> {
            int continentInt = cbo_continentComboBox.getSelectedIndex();
            int countryInt = cbo_countryComboBox.getSelectedIndex();

            if (continentInt == 3) {
                userScoreArray[3] = true;
            } else {
                userScoreArray[3] = false;
            }

            if (countryInt == 1) {
                userScoreArray[4] = true;
            } else {
                userScoreArray[4] = false;
            }
            frm_quizFrame3.dispose();
            fifthFrame();
        });

        // Configure frame
        frm_quizFrame3.add(pnl_thirdQuestion);
        frm_quizFrame3.setSize(xSize, ySize);
        frm_quizFrame3.setLayout(null);
        frm_quizFrame3.setVisible(true);
    }

    public static void fifthFrame() {
        // Quiz frame 4 - buttons (CN Tower)
        frm_quizFrame4 = new JFrame("GeoGuessr: Question 4");
        frm_quizFrame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.ipadx = 0;
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 0;

        // Answer panel
        pnl_fourthQuestion = new JPanel();
        pnl_fourthQuestion.setLayout(new GridBagLayout()); // Center elements on this panel
        c.fill = GridBagConstraints.HORIZONTAL;
        pnl_fourthQuestion.setBounds(25, 400, (xSize - 75), (ySize / 4));
        pnl_fourthQuestion.setBorder(BorderFactory.createTitledBorder(loweredetched));

        // Selection label
        lbl_citySelection = new JLabel("Current Selection: ");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 0;
        pnl_fourthQuestion.add(lbl_citySelection, c);

        // Button 1
        btn_cityOption1 = new JButton("Toronto, Canada");
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        pnl_fourthQuestion.add(btn_cityOption1, c);

        // Selection update actionevent 
        btn_cityOption1.addActionListener((ActionEvent e) -> {
            lbl_citySelection.setText("Current Selection: " + btn_cityOption1.getText());
            selection = 1;
        });

        // Button 2
        btn_cityOption2 = new JButton("Sydney, Australia");
        c.gridy = 2;
        pnl_fourthQuestion.add(btn_cityOption2, c);

        // Selection update actionevent 2
        btn_cityOption2.addActionListener((ActionEvent e) -> {
            lbl_citySelection.setText("Current Selection: " + btn_cityOption2.getText());
            selection = 2;
        });

        // Button 3
        btn_cityOption3 = new JButton("Tokyo, Japan");
        c.gridx = 2;
        c.gridy = 1;
        pnl_fourthQuestion.add(btn_cityOption3, c);

        // Selection update actionevent 3
        btn_cityOption3.addActionListener((ActionEvent e) -> {
            lbl_citySelection.setText("Current Selection: " + btn_cityOption3.getText());
            selection = 3;
        });

        // Button 4
        btn_cityOption4 = new JButton("Warsaw, Poland");
        c.gridy = 2;
        pnl_fourthQuestion.add(btn_cityOption4, c);

        // Selection update actionevent 4
        btn_cityOption4.addActionListener((ActionEvent e) -> {
            lbl_citySelection.setText("Current Selection: " + btn_cityOption4.getText());
            selection = 4;
        });

        // Submit button
        btn_answer4Submit = new JButton("Submit");
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 3;
        pnl_fourthQuestion.add(btn_answer4Submit, c);

        // Submit button actionevent
        btn_answer4Submit.addActionListener((ActionEvent e) -> {
            switch (selection) {
                case 1:
                    userScoreArray[5] = true;
                    break;
                case 2:
                    userScoreArray[5] = false;
                    break;
                case 3:
                    userScoreArray[5] = false;
                    break;
                case 4:
                    userScoreArray[5] = false;
                    break;
                default:
                    userScoreArray[5] = false;
                    break;
            }
            frm_quizFrame4.dispose();
            sixthFrame();
        });

        // Configure frame
        frm_quizFrame4.add(pnl_fourthQuestion);
        frm_quizFrame4.setSize(xSize, ySize);
        frm_quizFrame4.setLayout(null);
        frm_quizFrame4.setVisible(true);
    }

    public static void sixthFrame() {
        // Quiz frame 5 - buttons (North Korea)
        frm_quizFrame4 = new JFrame("GeoGuessr: Question 4");
        frm_quizFrame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.ipadx = 0;
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 0;

        // Answer panel
        pnl_fourthQuestion = new JPanel();
        pnl_fourthQuestion.setLayout(new GridBagLayout()); // Center elements on this panel
        c.fill = GridBagConstraints.HORIZONTAL;
        pnl_fourthQuestion.setBounds(25, 400, (xSize - 75), (ySize / 4));
        pnl_fourthQuestion.setBorder(BorderFactory.createTitledBorder(loweredetched));

        // Textbox
        
        
        // Configure frame
        frm_quizFrame4.add(pnl_fourthQuestion);
        frm_quizFrame4.setSize(xSize, ySize);
        frm_quizFrame4.setLayout(null);
        frm_quizFrame4.setVisible(true);
    }

    public static void main(String[] args) {
        firstFrame();
    } //End of main

} // End of class
