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
    public static int xSize = 800;
    public static int ySize = 600;

    // Panels
    public static JPanel pnl_nameCollection;
    public static JPanel pnl_firstQuestion;
    public static JPanel pnl_secondQuestion;

    // Global variables
    public static String userName;
    public static int userScore = 0;
    public static boolean[] userScoreArray = new boolean[9];
    public static GridBagConstraints c = new GridBagConstraints();

    // First frame
    public static JTextField txt_userName;
    public static JButton btn_start;

    // Second frame (first question)
    public static ButtonGroup radioButtonGroup1;
    public static JRadioButton rad_radioAnswer1;
    public static JRadioButton rad_radioAnswer2;
    public static JRadioButton rad_radioAnswer3;
    public static JRadioButton rad_radioAnswer4;
    public static JButton btn_answer1Submit;

    // Third frame (second question)
    public static JCheckBox chk_checkAnswer1;
    public static JCheckBox chk_checkAnswer1x;
    public static JCheckBox chk_checkAnswer2;
    public static JCheckBox chk_checkAnswer2x;
    public static JCheckBox chk_checkAnswer3;
    public static JCheckBox chk_checkAnswer3x;
    public static JCheckBox chk_checkAnswer4;
    public static JCheckBox chk_checkAnswer4x;
    public static JButton btn_answer2Submit;

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

        // Confirgure frame
        frm_nameFrame.setSize(xSize, ySize);
        frm_nameFrame.setLayout(null);
        frm_nameFrame.setVisible(true);
    } // End of first frame

    public static void secondFrame() {

        // Quiz frame 1 - radio buttons
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

        // Quiz frame 2 - check boxes
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

        // Country checkbox 1
        chk_checkAnswer1x = new JCheckBox("United States of America");
        c.gridx = 2;
        c.gridy = 1;
        chk_buttonGroupCountry.add(chk_checkAnswer1x);
        pnl_secondQuestion.add(chk_checkAnswer1x, c);

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
        c.gridy = 2;
        c.gridwidth = 2;
        pnl_secondQuestion.add(btn_answer2Submit, c);

        // Configure frame
        frm_quizFrame2.add(pnl_secondQuestion);
        frm_quizFrame2.setSize(xSize, ySize);
        frm_quizFrame2.setLayout(null);
        frm_quizFrame2.setVisible(true);
    }

    public static void main(String[] args) {
        firstFrame();
    } //End of main

} // End of class
