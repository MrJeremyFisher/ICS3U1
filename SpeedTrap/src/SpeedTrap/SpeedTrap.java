/*
 * Author: Jeremy Favro
 * Date: 
 * Class: ICS3U1
 * Project name: 
 * Description: 
 */
package speedtrap09;

import java.util.Scanner;

public class SpeedTrap09 {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static int SP1 = 50;
    public static int SP2 = 58;
    public static int SP3 = 68;
    public static int SP4 = 80;

    public static String WarnLevel = "N/a";
    public static int DemeritPoints = 0;
    public static int SpeedIn = 0;
    public static double Fine = 0;

    public static void main(String[] args) {

        Scanner NameIn = new Scanner(System.in); // Create scanner
        System.out.println("Driver name: "); // prompt question
        String NameOut = NameIn.nextLine();// Listen for input

        Scanner DriverIDIn = new Scanner(System.in); // Create scanner
        System.out.println("What is the drivers license ID: "); // prompt question
        String DriverIDOut = DriverIDIn.nextLine();// Listen for input

        Scanner SpeedIn = new Scanner(System.in); // Create scanner
        System.out.println("What was the vehicles speed: "); // prompt question
        int SpeedOut = SpeedIn.nextInt();// Listen for input

        if (SpeedOut >= SP1 && SpeedOut < SP2) {
            WarnLevel = "Warning";
        } else if (SpeedOut >= SP2 && SpeedOut < SP3) {
            WarnLevel = "Minimum";
        } else if (SpeedOut >= SP3 && SpeedOut < SP4) {
            WarnLevel = "Maximum";
        } else if (SpeedOut >= SP4) {
            WarnLevel = "Severe";
        }

        switch (WarnLevel) {
            case "Warning":
                DemeritPoints = 0;
                break;
            case "Minimum":
                DemeritPoints = 3;
                break;
            case "Maximum":
                DemeritPoints = 4;
                break;
            case "Severe":
                DemeritPoints = 4;
                break;

        }

        switch (WarnLevel) {
            case "Warning":
                Fine = 0.00;
                break;
            case "Minimum":
                Fine = 250.00;
                break;
            case "Maximum":
                Fine = 500.00;
                break;
            case "Severe":
                Fine = 1000.00;
                break;

        }

        System.out.println("Driver name: " + ANSI_RED + NameOut + ANSI_RESET);
        System.out.println("Driver ID:  " + ANSI_RED + DriverIDOut + ANSI_RESET);
        System.out.println("Vehicle speed: " + ANSI_RED + SpeedOut + ANSI_RESET);

        System.out.println("Offense: " + ANSI_BLUE + WarnLevel + ANSI_RESET);
        System.out.println("Fine: " + ANSI_BLUE + Fine + ANSI_RESET);
        System.out.println("Demerit points taken: " + ANSI_BLUE + DemeritPoints + ANSI_RESET);

    } //EndOfMain

} // EndOfClass
