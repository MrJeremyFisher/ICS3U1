/*
 * Author: Jeremy Favro
 * Date: 10/3/22
 * Class: ICS3U1
 * Project name: GUI Tasks 3
 * Description: Making a randomly moving GUI element on mouseclick
 */
package guitasks3;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class GUITasks3 {

    public static JFrame Frame;
    public static JButton Button;
    public static int min = 150;
    public static int max = 650;

    public static void main(String[] args) {

        // Create frame
        Frame = new JFrame("Idk what to call this: The sequel!");

        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create label
        Button = new JButton("I bet you can't click me :p");

        Button.setBounds(20, 20, 200, 20);

        // MouseOver action listener
        Button.addActionListener((ActionEvent e) -> {
            int RandX = ThreadLocalRandom.current().nextInt(min, max + 1);
            int RandY = ThreadLocalRandom.current().nextInt(min, max + 1);
            Button.setLocation(RandX, RandY);

        });
        // Add elements to frame
        Frame.add(Button);

        Frame.setSize(1000, 800);
        Frame.setLayout(null);
        Frame.setVisible(true);
    } //EndOfMain

} // EndOfClass
