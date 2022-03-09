/*
 * Author: Jeremy Favro
 * Date: 9/3/22
 * Class: ICS3U1
 * Project name: Custom GUI 
 * Description: Just messing around
 */
package guicustom;

import javax.swing.*;
import java.awt.event.*;

public class GuiCustom {

    public static JFrame Frame;

    public static JTextField TextField;
    public static JButton Button;
    public static JButton Button2;
    public static int Count = 0;

    public static void main(String[] args) {

        Frame = new JFrame("My GUI");
        TextField = new JTextField();
        TextField.setBounds(50, 100, 300, 20);
        Button = new JButton("Click Here to increase the count");
        Button.setBounds(50, 150, 300, 30);
        Button2 = new JButton("Click Here to decrease the count");
        Button2.setBounds(50, 210, 300, 30);
        Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Count++;
                Integer Count1 = Count;
                TextField.setText(Count1.toString());
            }
        });

        Button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Count--;
                Integer Count1 = Count;
                TextField.setText(Count1.toString());
            }
        });
        Frame.add(Button);
        Frame.add(Button2);
        Frame.add(TextField);
        Frame.setSize(800, 800);
        Frame.setLayout(null);
        Frame.setVisible(true);
    }

} // EndOfClass
