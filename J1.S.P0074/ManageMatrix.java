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
public class ManageMatrix {
    
    
    static int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        //declare matrix result
        int[][] result = new int[matrix1.length][matrix1[0].length];
        //loop to caculate from row 1 to last row
        for (int r = 0; r < matrix1.length; r++) {
            //loop to caculate element 1 to last element in 1 row
            for (int c = 0; c < matrix1[r].length; c++) {
                result[r][c] = matrix1[r][c] + matrix2[r][c];
            }
        }
        return result;
    }

    static int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];
        //loop to caculate from row 1 to last row
        for (int r = 0; r < matrix1.length; r++) {
            //loop to caculate element 1 to last element in 1 row
            for (int c = 0; c < matrix1[r].length; c++) {
                result[r][c] = matrix1[r][c] - matrix2[r][c];
            }
        }
        return result;
    }

    static int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length; //result's row
        int col = matrix2[0].length; //result's col
        int col1 = matrix1[0].length; //matrix1's col 
        int[][] result = new int[row][col];
        //loop to caculate from row 1 to last row
        for (int r = 0; r < row; r++) {
            //loop to caculate element 1 to last element in 1 row
            for (int c = 0; c < col; c++) {
                result[r][c] = 0;
                //loop from element 1 to last element in 1 row of matrix 1
                //and element 1 to last element in 1 col of matrix 2
                for (int c1 = 0; c1 < col1; c1++) {
                    result[r][c] += matrix1[r][c1]*matrix2[c1][c];
                }
            }
        }
        return result;
    }
    
    static void display(Matrix matrix1, int userOption, Matrix matrix2, int[][] result) {
        System.out.println("-------- Result --------");
        matrix1.display();
        //display operator base on useroption
        switch (userOption) {
            //addition
            case 1:
                System.out.println("+");
                break;
            //subtraction
            case 2:
                System.out.println("-");
                break;
            //multiplication
            case 3:
                System.out.println("*");
                break;
        }
        matrix2.display();
        System.out.println("=");
        //loop to traversal from first row to last row
        for (int r = 0; r < result.length; r++) {
            //loop to traversal all element in one col
            for (int c = 0; c < result[r].length; c++) {
                System.out.print("["+result[r][c]+"]");
            }
            System.out.println("");
        }
        System.out.println("");
    }

}
