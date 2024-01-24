
package j1.s.p0074;

import java.util.Scanner;

public class J1SP0074 {

    public static void main(String[] args) {
        int userOption;
        //loop util user choose quit
        do {
            //1. Display menu
            displayMenu();
            //2. User select option
            userOption = selectOption();
            //3. Perform function based on selected option
            performFunct(userOption);
        } while (userOption!=4);
    }

    private static void displayMenu() {
        System.out.println("=======Calculator program======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    private static int selectOption() {
        Scanner sc = new Scanner(System.in);
        //loop util enter available option
        while (true) {
            System.out.print("Your choice: ");
            String choice = sc.nextLine();
            //check if enter available option
            if (Validation.checkSelectOption(choice)) {
                System.out.println("");
                return Integer.parseInt(choice);
            }
        }
    }

    private static void performFunct(int userOption) {
        Matrix matrix1 = new Matrix();
        Matrix matrix2 = new Matrix();
        int[][] result;
        //perform function based on user option
        switch (userOption) {
            //add 2 matrix
            case 1:
                System.out.println("-------- Addition ---------");
                matrix1.setMatrix(null, userOption);
                matrix2.setMatrix(matrix1, userOption);
                result = ManageMatrix.additionMatrix(matrix1.getMatrix(), matrix2.getMatrix());
                ManageMatrix.display(matrix1, userOption, matrix2, result);
                break;
            //sub 2 matrix
            case 2:
                System.out.println("----- Subtraction ------");
                matrix1.setMatrix(null, userOption);
                matrix2.setMatrix(matrix1, userOption);
                result = ManageMatrix.subtractionMatrix(matrix1.getMatrix(), matrix2.getMatrix());
                ManageMatrix.display(matrix1, userOption, matrix2, result);
                break;
            //mul 2 matrix
            case 3:
                System.out.println("-------- Multiplication --------");
                matrix1.setMatrix(null, userOption);
                matrix2.setMatrix(matrix1, userOption);
                result = ManageMatrix.multiplicationMatrix(matrix1.getMatrix(), matrix2.getMatrix());
                ManageMatrix.display(matrix1, userOption, matrix2, result);
                break;
            //exit
            case 4:
                System.out.println("----- Exit program -----");
                break;
        }
    }
    
}
