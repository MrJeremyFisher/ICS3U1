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

public class GeoGuessrQuiz {

    // Border style for panels
    public static Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

    // Frames
    public static JFrame frm_nameFrame;
    public static int xSize = 800;
    public static int ySize = 600;

    // Panels
    public static JPanel pnl_nameCollection;
    public static JPanel pnl_firstQuestion;

    // Global variables
    public static String userName;
    public static int userScore = 0;
    public static boolean[] userScoreArray;

    // First frame / global vars
    public static JTextField txt_userName;
    public static JButton btn_start;
    

    public static void firstFrame() {
        
        GridBagConstraints c = new GridBagConstraints();
        
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
        c.ipadx = 165;
        c.weightx = 0;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;   

        pnl_nameCollection.add(txt_userName, c);
        
        // Start button
        btn_start = new JButton("Start");
        c.ipadx = 83;
        c.weightx = 0;
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;   
        pnl_nameCollection.add(btn_start, c);

        // Add panels to frame
        frm_nameFrame.add(pnl_nameCollection);

        // Confirgure frame
        frm_nameFrame.setSize(xSize, ySize);
        frm_nameFrame.setLayout(null);
        frm_nameFrame.setVisible(true);
    } // End of first frame

    public static void secondFrame() {

    }

    public static void main(String[] args) {
        firstFrame();
    } //End of main

} // End of class
