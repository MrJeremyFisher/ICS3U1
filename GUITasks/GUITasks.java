/*
 * Author: Jeremy Favro
 * Date: 10/3/22
 * Class: ICS3U1
 * Project name: Gui Tasks
 * Description: Using a GUI to add, subtract, multiply, and / or divide two numbers
 */
package guitasks;

import java.awt.event.ActionEvent;
import javax.swing.*;

public class GUITasks {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static JFrame Frame;
    public static JTextField TextField;
    public static JTextField TextField2;
    public static JTextField OutField;
    public static JButton Button;
    public static JButton Button2;
    public static JButton Button3;
    public static JButton Button4;

    public static void main(String[] args) {
        Frame = new JFrame("My GUI calculator");
        // Num1 text field
        TextField = new JTextField("1");
        TextField.setBounds(50, 50, 300, 20);
        // Num2 text field
        TextField2 = new JTextField("2");
        TextField2.setBounds(50, 110, 300, 20);
        // NumOut text field
        OutField = new JTextField();
        OutField.setBounds(400, 50, 300, 20);
        // Add button
        Button = new JButton("<html> Click Here to <font color='green'>add</font> your two numbers </html>");
        Button.setBounds(50, 150, 300, 30);
        // Subtract button
        Button2 = new JButton("<html> Click Here to <font color='green'>subtract</font> your two numbers </html>");
        Button2.setBounds(50, 210, 300, 30);
        // Multiply button
        Button3 = new JButton("<html> Click Here to <font color='green'>multiply</font> your two numbers </html>");
        Button3.setBounds(50, 270, 300, 30);
        // Divide button
        Button4 = new JButton("<html> Click Here to <font color='green'>divide</font> your two numbers </html>");
        Button4.setBounds(50, 330, 300, 30);

        Button.addActionListener((ActionEvent e) -> {
            String NumOutString1 = TextField.getText();
            double NumOut1 = Integer.parseInt(NumOutString1);

            String NumOutString2 = TextField2.getText();
            double NumOut2 = Double.parseDouble(NumOutString2);

            double NumOutAdd = NumOut1 + NumOut2;
            Double NumOutAdd1 = NumOutAdd;
            OutField.setText(NumOutAdd1.toString());

        });

        Button2.addActionListener((ActionEvent e) -> {
            String NumOutString1 = TextField.getText();
            double NumOut1 = Integer.parseInt(NumOutString1);

            String NumOutString2 = TextField2.getText();
            double NumOut2 = Double.parseDouble(NumOutString2);
            double NumOutSubtract = NumOut1 - NumOut2;
            Double NumOutSubtract1 = NumOutSubtract;
            OutField.setText(NumOutSubtract1.toString());

        });
        Button3.addActionListener((ActionEvent e) -> {
            String NumOutString1 = TextField.getText();
            double NumOut1 = Integer.parseInt(NumOutString1);

            String NumOutString2 = TextField2.getText();
            double NumOut2 = Double.parseDouble(NumOutString2);
            double NumOutMultiply = NumOut1 * NumOut2;
            Double NumOutMultiply1 = NumOutMultiply;
            OutField.setText(NumOutMultiply1.toString());

        });
        Button4.addActionListener((ActionEvent e) -> {
            String NumOutString1 = TextField.getText();
            double NumOut1 = Integer.parseInt(NumOutString1);

            String NumOutString2 = TextField2.getText();
            double NumOut2 = Double.parseDouble(NumOutString2);
            double NumOutDivide = NumOut1 / NumOut2;
            Double NumOutDivide1 = NumOutDivide;
            OutField.setText(NumOutDivide1.toString());

        });

        Frame.add(Button);
        Frame.add(Button2);
        Frame.add(Button3);
        Frame.add(Button4);
        Frame.add(TextField);
        Frame.add(TextField2);
        Frame.add(OutField);
        Frame.setSize(800, 800);
        Frame.setLayout(null);
        Frame.setVisible(true);
    } //EndOfMain

} // EndOfClass
