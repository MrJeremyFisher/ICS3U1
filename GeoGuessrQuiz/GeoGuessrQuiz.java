/*
 * Author: Jeremy Favro
 * Date:
 * Class: ICS3U1
 * Project name:
 * Description:
 */
package geoguessrquiz;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Objects;


public class GeoGuessrQuiz {

    // Border style for panels
    public static Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

    // Frames
    public static JFrame frm_nameFrame;
    public static JFrame frm_quizFrame1;
    public static JFrame frm_quizFrame2;
    public static JFrame frm_quizFrame3;
    public static JFrame frm_quizFrame4;
    public static JFrame frm_quizFrame5;
    public static JFrame frm_scoreDisplay;
    public static int xSize = 800;
    public static int ySize = 600;

    // Panels
    public static JPanel pnl_nameCollection;
    public static JPanel pnl_firstQuestion;
    public static JPanel pnl_secondQuestion;
    public static JPanel pnl_thirdQuestion;
    public static JPanel pnl_fourthQuestion;
    public static JPanel pnl_fifthQuestion;
    public static JPanel pnl_scoreDisplay;
    public static JPanel pnl_scoreAmount;

    // Global variables
    public static String userName;
    public static int userScore = 0;
    public static boolean[] userScoreArray = new boolean[7];
    public static GridBagConstraints c = new GridBagConstraints();
    public static int questionNumber = 0;
    public static String Q1;
    public static String Q2;
    public static String Q2x;
    public static String Q3;
    public static String Q3x;
    public static String Q4;
    public static String Q5;
    private static View View;

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

    // Sixth frame (fifth question - text field)
    public static JTextField txt_locationTextBox;
    public static JButton btn_answer5Submit;

    // Score frame
    public static JLabel lbl_question1;
    public static JLabel lbl_question2;
    public static JLabel lbl_question3;
    public static JLabel lbl_question4;
    public static JLabel lbl_question5;
    public static JLabel lbl_finalScoreAmount;

    public static void firstFrame() throws IOException {

        // First frame
        frm_nameFrame = new JFrame("GeoGuessr");
        frm_nameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // User name input panel
        pnl_nameCollection = new JPanel();
        pnl_nameCollection.setLayout(new GridBagLayout()); // Center elements on this panel
        c.fill = GridBagConstraints.HORIZONTAL;
        pnl_nameCollection.setBounds(25, 25, (xSize - 75), (ySize - 75));
        pnl_nameCollection.setBorder(BorderFactory.createTitledBorder(loweredetched));

        // Logo
        BufferedImage GeoGuessrLogo = ImageIO.read(new File("src/GeoGuessrLogo.png"));
        JLabel lbl_GeoGuessrLogo = new JLabel(new ImageIcon(GeoGuessrLogo));
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        pnl_nameCollection.add(lbl_GeoGuessrLogo, c);
        // User name input box
        txt_userName = new JTextField("< Enter Name >");
        txt_userName.setHorizontalAlignment(SwingConstants.CENTER);
        c.ipadx = 165;
        c.weightx = 0;
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1;
        pnl_nameCollection.add(txt_userName, c);

        // Start button
        btn_start = new JButton("Start");
        c.ipadx = 83;
        c.weightx = 0;
        c.gridx = 2;
        c.gridy = 3;
        c.gridwidth = 1;
        pnl_nameCollection.add(btn_start, c);

        // Start button action event
        btn_start.addActionListener((ActionEvent e) -> {
            userName = txt_userName.getText();
            frm_nameFrame.dispose();
            secondFrame();
            geoguessrquiz.View.main();
            questionNumber = 1;
        });

        // Frame config
        frm_nameFrame.add(pnl_nameCollection);
        frm_nameFrame.setSize(xSize, ySize);
        frm_nameFrame.setResizable(false);
        frm_nameFrame.setLayout(null);
        frm_nameFrame.setVisible(true);
    }

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
        radioButtonGroup1 = new ButtonGroup();

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
            for (Enumeration<AbstractButton> buttons = radioButtonGroup1.getElements(); buttons.hasMoreElements(); ) {

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
            geoguessrquiz.View.frame.dispose();
            
            questionNumber = 2;
            geoguessrquiz.View.main();

        });

        // Configure frame
        frm_quizFrame1.add(pnl_firstQuestion);
        frm_quizFrame1.setSize(xSize, ySize);
        frm_quizFrame1.setResizable(false);
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

            userScoreArray[1] = chk_checkAnswer1.isSelected();

            userScoreArray[2] = chk_checkAnswer1x.isSelected();

            // Dispose of current frame and create next
            frm_quizFrame2.dispose();
            fourthFrame();
            geoguessrquiz.View.frame.dispose();
            
            questionNumber = 3;
            geoguessrquiz.View.main();
        });

        // Configure frame
        frm_quizFrame2.add(pnl_secondQuestion);
        frm_quizFrame2.setSize(xSize, ySize);
        frm_quizFrame2.setResizable(false);
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
            geoguessrquiz.View.frame.dispose();
            
            questionNumber = 4;
            geoguessrquiz.View.main();
        });

        // Configure frame
        frm_quizFrame3.add(pnl_thirdQuestion);
        frm_quizFrame3.setSize(xSize, ySize);
        frm_quizFrame3.setResizable(false);
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
            geoguessrquiz.View.frame.dispose();
            
            questionNumber = 5;
            geoguessrquiz.View.main();
        });

        // Configure frame
        frm_quizFrame4.add(pnl_fourthQuestion);
        frm_quizFrame4.setSize(xSize, ySize);
        frm_quizFrame4.setResizable(false);
        frm_quizFrame4.setLayout(null);
        frm_quizFrame4.setVisible(true);
    }

    public static void sixthFrame() {
        // Quiz frame 5 - text field (North Korea)
        frm_quizFrame5 = new JFrame("GeoGuessr: Question 5");
        frm_quizFrame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.ipadx = 0;
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 0;

        // Answer panel
        pnl_fifthQuestion = new JPanel();
        pnl_fifthQuestion.setLayout(new GridBagLayout()); // Center elements on this panel
        c.fill = GridBagConstraints.HORIZONTAL;
        pnl_fifthQuestion.setBounds(25, 400, (xSize - 75), (ySize / 4));
        pnl_fifthQuestion.setBorder(BorderFactory.createTitledBorder(loweredetched));

        // Textbox
        txt_locationTextBox = new JTextField();
        c.gridx = 0;
        c.gridy = 0;
        pnl_fifthQuestion.add(txt_locationTextBox, c);

        // Submit button
        btn_answer5Submit = new JButton("Submit");
        c.gridx = 0;
        c.gridy = 1;
        pnl_fifthQuestion.add(btn_answer5Submit, c);

        // Submit action event
        btn_answer5Submit.addActionListener((ActionEvent e) -> {
            userScoreArray[6] = Objects.equals(txt_locationTextBox.getText(), "North Korea"); // Minified if else
            frm_quizFrame5.dispose();
            seventhFrame();
        });

        // Configure frame
        frm_quizFrame5.add(pnl_fifthQuestion);
        frm_quizFrame5.setSize(xSize, ySize);
        frm_quizFrame5.setResizable(false);
        frm_quizFrame5.setLayout(null);
        frm_quizFrame5.setVisible(true);
    }

    public static void seventhFrame() {
        // Quiz frame 5 - buttons (North Korea)
        frm_scoreDisplay = new JFrame("GeoGuessr: Question 5");
        frm_scoreDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.ipadx = 0;
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 0;

        // Score display panel
        pnl_scoreDisplay = new JPanel();
        pnl_scoreDisplay.setLayout(new GridBagLayout()); // Center elements on this panel
        c.fill = GridBagConstraints.HORIZONTAL;
        pnl_scoreDisplay.setBounds(25, 25, (xSize - 75), (ySize / 4));
        pnl_scoreDisplay.setBorder(BorderFactory.createTitledBorder(loweredetched));

        // Score display panel
        pnl_scoreAmount = new JPanel();
        pnl_scoreAmount.setLayout(new GridBagLayout()); // Center elements on this panel
        c.fill = GridBagConstraints.HORIZONTAL;
        pnl_scoreAmount.setBounds(25, 175, (xSize - 75), (ySize / 4));
        pnl_scoreAmount.setBorder(BorderFactory.createTitledBorder(loweredetched));

        // Question 1 right / wrong
        lbl_question1 = new JLabel("You got question one: " + (Q1 = userScoreArray[0] ? "Correct!" : "Incorrect."));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        pnl_scoreDisplay.add(lbl_question1, c);

        // Question 2 right / wrong
        lbl_question2 = new JLabel("You got question two part one: " + (Q2 = userScoreArray[1] ? "Correct!" : "Incorrect.") + " and you got part two: " + (Q2x = userScoreArray[2] ? "Correct!" : "Incorrect."));
        c.gridx = 0;
        c.gridy = 1;
        pnl_scoreDisplay.add(lbl_question2, c);

        // Question 3 right / wrong
        lbl_question3 = new JLabel("You got question three part one: " + (Q3 = userScoreArray[3] ? "Correct!" : "Incorrect.") + " and you got part two: " + (Q3x = userScoreArray[4] ? "Correct!" : "Incorrect."));
        c.gridx = 0;
        c.gridy = 2;
        pnl_scoreDisplay.add(lbl_question3, c);

        // Question 4 right / wrong
        lbl_question4 = new JLabel("You got question four: " + (Q4 = userScoreArray[5] ? "Correct!" : "Incorrect."));
        c.gridx = 0;
        c.gridy = 3;
        pnl_scoreDisplay.add(lbl_question4, c);

        // Question 5 right / wrong
        lbl_question5 = new JLabel("You got question five: " + (Q5 = userScoreArray[6] ? "Correct!" : "Incorrect."));
        c.gridx = 0;
        c.gridy = 4;
        pnl_scoreDisplay.add(lbl_question5, c);

        // Final score amount
        int finalScoreAmount = 0;
        for (int i = 0; i <= 5; i ++) {
            finalScoreAmount += userScoreArray[i] ? 1 : 0;
        }
        lbl_finalScoreAmount = new JLabel(userName + ", " + "Your final score is: " + finalScoreAmount + "/7");
        pnl_scoreAmount.add(lbl_finalScoreAmount, c);

        // Configure frame
        frm_scoreDisplay.add(pnl_scoreDisplay);
        frm_scoreDisplay.add(pnl_scoreAmount);
        frm_scoreDisplay.setSize(xSize, ySize);
        frm_scoreDisplay.setResizable(false);
        frm_scoreDisplay.setLayout(null);
        frm_scoreDisplay.setVisible(true);
    }


    public static void main(String[] args) throws IOException {
        firstFrame();
    } //End of main


} // End of class

