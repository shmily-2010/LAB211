package j1.s.p0105;

import java.util.ArrayList;
import java.util.Scanner;

public class J1SP0105 {

    public static void main(String[] args) {
        ArrayList<Product> ProductsList = new ArrayList<>();
        ArrayList<Storekeeper> StorekeepersList = new ArrayList<>();
        //loop until user exit program
        do {
            //1. Display menu
            displayMenu();
            //2. Ask users to select an option
            int option = getOption();
            switch (option) {
                //3. Add storekeeper
                case 1:
                    Manage.addStorekeeper(StorekeepersList);
                    break;
                //4. Add product
                case 2:
                    Manage.addProduct(ProductsList, StorekeepersList);
                    break;
                //5. Update product
                case 3:
                    Manage.updateProduct(ProductsList, StorekeepersList);
                    break;
                //6. Search product
                case 4:
                    Manage.searchProduct(ProductsList);
                    break;
                //7. Sort product
                case 5:
                    Manage.sortProduct(ProductsList);
                    break;
            }
        } while (true);
    }

    private static void displayMenu() {
        System.out.println("MAIN MENU: ");
        System.out.println("\t1. Add Storekeeper");
        System.out.println("\t2. Add Product");
        System.out.println("\t3. Update Product");
        System.out.println("\t4. Search product by Name, Category, Storekeeper, Receipt Date");
        System.out.println("\t5. Sort product by ExpiryDate, Date of manufacture");
    }

    private static int getOption() {
        Scanner sc = new Scanner(System.in);
        //loop until user enter valid option
        while (true) {
            System.out.print("ENTER OPTION: ");
            String option = sc.nextLine();
            //check if option valid
            if (Validation.checkOption(option,1,5)) {
                return Integer.parseInt(option);
            }
        }
    }

}
