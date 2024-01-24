/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kinhd
 */
public class BubbleSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //1. Input number of array
        int numberArray = inputNumber();
        //2. Generate array in range input
        //int[] array = genArray(numberArray);
        //Test case 1
        int[] array = {2, 6, 3, 6, 8, 6, 1, 2, 9, 8};
        //Test case 2
        //int[] array = {5, 1, 12, -5, 16};
        //3. Display unsorted array
        displayArray(array, "Unsorted array: ");
        //4. Sort array with bubble sort
        bubbleSortArray(array);
        //5. Display sorted array
        displayArray(array, "Sorted array: ");
    }

    private static int inputNumber() {
        Scanner sc = new Scanner(System.in);
        //loop to input number
        while (true) {
            System.out.println("Enter number of array:");
            String input = sc.nextLine();
            //check number
            if (checkNumber(input)) {
                return Integer.parseInt(input);
            }
        }
    }

    private static int[] genArray(int numberArray) {
        Random rd = new Random();
        int[] array = new int[numberArray];
        //loop to random element in range input
        for (int i = 0; i < numberArray; i++) {
            array[i] = rd.nextInt(numberArray);
        }
        return array;
    }

    private static void displayArray(int[] array, String msg) {
        System.out.print(msg + Arrays.toString(array));
        //go to next line if not end
        if (msg.equals("Unsorted array: ")) {
            System.out.println("");
        }
    }

    private static void bubbleSortArray(int[] array) {
        System.out.println(Arrays.toString(array) + "\tunsorted");
        //loop to traverse from last element down to first element, each loop sorts 1 element
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println("");
            //loop to traverse from first element to last element of unsorted part
            for (int j = 0; j < i; j++) {
                //compare two adjacent elements, placed higher to the right
                if (array[j] > array[j + 1]) {
                    System.out.print(Arrays.toString(array) + "\t");
                    System.out.println(array[j] + " > " + array[j+1] + ", swap");
                    //swap element
                    array[j] = array[j + 1] + array[j];
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] = array[j] - array[j + 1];
                }
                else {
                    // if this element < forward element
                    // not swap
                    if (array[j] < array[j+1]) {
                        System.out.print(Arrays.toString(array) + "\t");
                        System.out.println(array[j] + " < " + array[j+1] + ", ok");
                    } 
                    // if this element = forward element
                    // not swap
                    else { 
                        System.out.print(Arrays.toString(array) + "\t");
                        System.out.println(array[j] + " = " + array[j+1] + ", ok");
                    }
                }
            }
        }
        System.out.println(Arrays.toString(array) + "\tsorted\n");
    }

    private static boolean checkNumber(String input) {
        //check if empty
        if (input.isEmpty()) {
            System.out.println("Not empty number!!!");
            return false;
        }
        //if not integer
        try {
            int number = Integer.parseInt(input);
            //if negative'
            if (number < 0) {
                System.out.println("Not negative number!!!");
                return false;
            }
            //if not positive
            if (number == 0) {
                System.out.println("Must positive number!!!");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        //return if a positive decimal
        return true;
    }
}
