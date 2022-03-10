/*
 * Author: Jeremy Favro
 * Date: 10/3/22
 * Class: ICS3U1
 * Project name: GuI Tasks 2
 * Description: 
 */
package guitasks2;

import java.awt.event.ActionEvent;
import javax.swing.*;

public class GUITasks2 {

    public static JFrame Frame;
    public static JLabel Label;
    public static JButton ButtonUp;
    public static JButton ButtonDown;
    public static JButton ButtonLeft;
    public static JButton ButtonRight;

    public static void main(String[] args) {
        Frame = new JFrame("Idk what to call this");
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ButtonUp = new JButton("Up");
        ButtonUp.setBounds(300, 100, 75, 30);
        ButtonDown = new JButton("Down");
        ButtonDown.setBounds(300, 200, 75, 30);
        ButtonLeft = new JButton("Left");
        ButtonLeft.setBounds(200, 150, 75, 30);
        ButtonRight = new JButton("Right");
        ButtonRight.setBounds(400, 150, 75, 30);
        Label = new JLabel("Move me!");
        Label.setBounds(10, 10, 75, 10);

        // Action listeners, + and - needs to be inverted
        ButtonUp.addActionListener((ActionEvent e) -> {
            int x = Label.getX();
            int y = Label.getY();
            Label.setLocation(x, y - 5);

        });
        ButtonDown.addActionListener((ActionEvent e) -> {
            int x = Label.getX();
            int y = Label.getY();
            Label.setLocation(x, y + 5);

        });
        ButtonLeft.addActionListener((ActionEvent e) -> {
            int x = Label.getX();
            int y = Label.getY();
            Label.setLocation(x + 5, y);

        });
        ButtonRight.addActionListener((ActionEvent e) -> {
            int x = Label.getX();
            int y = Label.getY();
            Label.setLocation(x - 5, y);

        });
        // Add elements to frame
        Frame.add(ButtonUp);
        Frame.add(ButtonDown);
        Frame.add(ButtonLeft);
        Frame.add(ButtonRight);
        Frame.add(Label);
        Frame.setSize(800, 800);
        Frame.setLayout(null);
        Frame.setVisible(true);
    } //EndOfMain

} // EndOfClass
