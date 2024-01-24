/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0074;

/**
 *
 * @author kinhd
 */
public class Validation {

    static boolean checkElement(String input) {
        //check if empty
        if (input.isEmpty()) {
            System.out.println("Element not empty!!!");
            return false;
        }
        //check if not integer
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Values of matrix must be the number");
            return false;
        }
        return true;
    }

    static boolean checkSizeRow(Matrix matrix, int row, int userOption) {
        //check if matrix existed
        if (matrix!=null) {
            //check valid row base on userOption
            switch (userOption) {
                //check valid row to add or sub
                case 1: case 2:
                    //check if not same row
                    if (!(row==matrix.getRow())) {
                        System.out.println("Not same row matrix 1!!!");
                        return false;
                    }
                    break;
                //check valid row to mul
                case 3:
                    //check if row not same matrix's col
                    if (row!=matrix.getCol()) {
                        System.out.println("Not same row with matrix 1's col!!!");
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
    static boolean checkSizeCol(Matrix matrix, int col, int userOption) {
        //check if matrix existed
        if (matrix!=null) {
            //check valid col to add or sub
            if (userOption==1 || userOption==2) {
                //check if col not same matrix 1 col
                if (!(col==matrix.getRow())) {
                    System.out.println("Not same col matrix 1!!!");
                    return false;
                }
            }
        }
        return true;
    }
    
    static boolean checkRow(String input) {
        //check if empty
        if (input.isEmpty()) {
            System.out.println("Row not empty!!!");
            return false;
        }
        //check if not integer
        int row;
        try {
            row = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        //check if negative
        if (row < 0) {
            System.out.println("Row not negative!!!");
            return false;
        }
        //check if not positive
        if (row == 0) {
            System.out.println("Row must negative!!!");
            return false;
        }
        return true;
    }

    static boolean checkCol(String input) {
        //check if empty
        if (input.isEmpty()) {
            System.out.println("Col not empty!!!");
            return false;
        }
        //check if not integer
        int col;
        try {
            col = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        //check if negative
        if (col < 0) {
            System.out.println("Col not negative!!!");
            return false;
        }
        //check if not positive
        if (col == 0) {
            System.out.println("Col must negative!!!");
            return false;
        }
        return true;
    }

    static boolean checkSelectOption(String choice) {
        //check if empty
        if (choice.isEmpty()) {
            System.out.println("Choice not empty!!!");
            return false;
        }
        //check if not integer
        int choiceNumber;
        try {
            choiceNumber = Integer.parseInt(choice);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        //check if not in range 1-4
        if (choiceNumber>4 || choiceNumber<1) {
            System.out.println("Choice must be in range [1,4]!!!");
            return false;
        }
        return true;
    }
    
    
}
