/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0074;

import java.util.Scanner;

/**
 *
 * @author kinhd
 */
public class Matrix {
    
    int row, col;
    int[][] matrix;

    public Matrix() {
    }
    
    //require user input matrix size & value
    public void setMatrix(Matrix matrix, int userOption) {
        Scanner sc = new Scanner(System.in);
        //set order of matrix base on matrix parameter
        int order  = (matrix==null)?1:2;
        setSize(matrix, order, userOption);
        int[][] matrixInput = new int[row][col];
        //loop to traversal each row
        for (int r = 0; r < row; r++) {
            //loop to traversal each column
            for (int c = 0; c < col; c++) {
                //loop until enter valid matrix element
                while (true) {
                    System.out.print("Enter Matrix"+order+"["+(r+1)+"]["+(c+1)+"]:");
                    String input = sc.nextLine();
                    //check if matrix element valid
                    if (Validation.checkElement(input)) {
                        matrixInput[r][c] = Integer.parseInt(input);
                        break;
                    }
                }
            }
        }
        this.matrix = matrixInput;
    }
    
    //require user input valid row and column of matrix
    private void setSize(Matrix matrix, int order, int userOption) {
        //loop until enter valid row
        while (true) {
            setRow(order);
            //check if not row input valid
            if(Validation.checkSizeRow(matrix, row, userOption)) {
                break;
            }
        }
        //loop until enter valid col
        while (true) {
            setCol(order);
            //check if not col input valid
            if(Validation.checkSizeCol(matrix, col, userOption)) {
                break;
            }
        }
    }

    private void setRow(int order) {
        Scanner sc = new Scanner(System.in);
        //loop util enter valid row
        while (true) {
            System.out.print("Enter Row Matrix "+order+":");
            String input = sc.nextLine();
            //check if row valid
            if(Validation.checkRow(input)) {
                row = Integer.parseInt(input);
                break;
            }
        }
    }

    private void setCol(int order) {
        Scanner sc = new Scanner(System.in);
        //loop util enter valid column
        while (true) {
            System.out.print("Enter Column Matrix "+order+":");
            String input = sc.nextLine();
            //check if column valid
            if(Validation.checkCol(input)) {
                col = Integer.parseInt(input);
                break;
            }
        }
    }
    
    public int[][] getMatrix() {
        return matrix;
    }    

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    void display() {
        //loop to traversal from first row to last row
        for (int r = 0; r < row; r++) {
            //loop to traversal from first element to last element in one row
            for (int c = 0; c < col; c++) {
                System.out.print("["+matrix[r][c]+"]");
            }
            System.out.println("");
        }
    }
    
    
    
}
