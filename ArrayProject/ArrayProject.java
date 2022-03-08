/*
 * Author: Jeremy Favro
 * Date: 8/3/22
 * Class: ICS3U1
 * Project name: Array Project
 * Description: Sorting, reversing, error checking oh my!
 */
package arrayproject;

import java.util.*;

public class ArrayProject {

    static void reverse(Integer Array3[]) { // Create the function to reverse Array
        Collections.reverse(Arrays.asList(Array3));
    }

    public static void main(String[] args) {

        double ArrayAddition = 0;

        Integer[] Array = {1, 2, 3, 4, 5, 6, 7, 8}; // Init main array for all the nonsense below
        Integer[] Array2 = new Integer[8]; // Init second array to be copied into later 
        Integer[] Array3 = new Integer[8]; // Init third array to be copied to and reversed
        
        for (int j = 0; j < Array.length; j++) { // For and if to check if array is empty
            if (Array[j] == null) {
                System.exit(0);
            }
        }
        // I will comment none of this
        // Sort array
        Arrays.sort(Array);
        //Find the min value of the array
        double ArrayMin = Array[0];

        //Find the max value of the array
        double ArrayMax = Array[Array.length - 1];

        //Find the average of the array\
        for (int i = 0; i < Array.length; i++) {

            ArrayAddition = ArrayAddition + Array[i];
        }
        double ArrayAverage = ArrayAddition / Array.length;

        //Copy the array into another aray -- ArrayCeption
        for (int j = 0; j < Array.length; j++) {
            System.out.println("Original second array at " + j + " = " + Array2[j]);
        }

        System.arraycopy(Array, 0, Array2, 0, 8); // Copy Array from 0 to Array2 from 0 to 8

        for (int j = 0; j < Array.length; j++) {
            System.out.println("New second array at " + j + " = " + Array2[j]);
        }

        //Reverse the order of the array
        System.arraycopy(Array, 0, Array3, 0, 8); // Copy Array from 0 to Array3 from 0 to 8

        reverse(Array3);

        // Prints
        System.out.println("Array Min: " + ArrayMin);
        System.out.println("Array Max: " + ArrayMax);
        System.out.println("Array Average: " + ArrayAverage);

        for (int j = 0; j < Array.length; j++) {
            System.out.println("Reversed array at " + j + ": " + Array3[j]);
        }
    } //EndOfMain

} // EndOfClass
