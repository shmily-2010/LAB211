/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0105;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author kinhd
 */
public class Manage {

    static void addStorekeeper(ArrayList<Storekeeper> StorekeepersList) {
        Scanner sc = new Scanner(System.in);
        //loop until enter valid storekeeper name
        while (true) {
            System.out.println("ADD STOREKEEPER: ");
            System.out.print("Enter Storekeeper Name: ");
            String storekeeperName = sc.nextLine();
            //check if storekeeperName valid 
            if (Validation.checkString(storekeeperName)) {
                int id = StorekeepersList.size();
                StorekeepersList.add(new Storekeeper(id, storekeeperName));
                System.out.println("");
                return;
            }
        }

    }

    static void addProduct(ArrayList<Product> ProductsList, ArrayList<Storekeeper> StorekeepersList) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Product product = new Product();
        //check if storekeeper list empty
        if (StorekeepersList.isEmpty()) {
            System.out.println("Can not add product!!!");
            return;
        }
        System.out.println("ADD PRODUCT: ");
        //loop until enter valid product Id
        while (true) {
            System.out.print("Enter Id: ");
            String Id = sc.nextLine();
            //check if Id valid
            if (Validation.checkId(Id, ProductsList)) {
                product.setId(Id);
                break;
            }
        }
        //loop until enter valid product Name
        while (true) {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            //check if Name valid
            if (Validation.checkString(name)) {
                product.setName(name);
                break;
            }
        }
        //loop until enter valid product location
        while (true) {
            System.out.print("Enter Location: ");
            String location = sc.nextLine();
            //check if location valid
            if (Validation.checkString(location)) {
                product.setLocation(location);
                break;
            }
        }
        //loop until enter valid product price
        while (true) {
            System.out.print("Enter Price: ");
            String price = sc.nextLine();
            //check if price valid
            if (Validation.checkPrice(price)) {
                product.setPrice(Integer.parseInt(price));
                break;
            }
        }
        //loop until enter valid product expiry date
        while (true) {
            System.out.print("Enter Expiry Date: ");
            String date = sc.nextLine();
            //check if date valid 
            if (Validation.checkDate(date)) {
                try {
                    product.setExpiryDate(sdf.parse(date));
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        //loop until enter valid product date of manufacture
        while (true) {
            System.out.print("Enter Date of Manufacture: ");
            String date = sc.nextLine();
            //check if date valid
            if (Validation.checkDate(date)) {
                try {
                    //check if manufactorDate before expiryDate
                    if (sdf.parse(date).before(product.getExpiryDate())) {
                        System.out.println("Manufacture Date must after Expiry Date!!!");
                        continue;
                    }
                    product.setDateOfManufacture(sdf.parse(date));
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        //loop until enter valid product category
        while (true) {
            System.out.print("Enter Category: ");
            String category = sc.nextLine();
            //check if category valid
            if (Validation.checkString(category)) {
                product.setCategory(category);
                break;
            }
        }
        //loop until enter valid storekeeper
        while (true) {
            System.out.print("Enter Storekeeper: ");
            String storekeeper = sc.nextLine();
            //check if storekeeper valid
            if (Validation.checkString(storekeeper)) {
                //check if storekeeper not exist in storekeeper list
                if (!Validation.checkStorekeeper(storekeeper, StorekeepersList)) {
                    continue;
                }
                product.setStorekeeper(storekeeper);
                break;
            }
        }
        //loop until enter valid receipt date
        while (true) {
            System.out.print("Enter Receipt Date: ");
            String receiptDate = sc.nextLine();
            //check if receiptDate valid
            if (Validation.checkDate(receiptDate)) {
                try {
                    //check if receiptDate before expiryDate
                    if (sdf.parse(receiptDate).before(product.getExpiryDate())) {
                        System.out.println("Receipt Date must after Expiry Date!!!");
                        continue;
                    }
                    product.setReceiptDate(sdf.parse(receiptDate));
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        ProductsList.add(product);
        System.out.println("Add successfully >~<");
        System.out.println("");
    }

    static void updateProduct(ArrayList<Product> ProductsList, ArrayList<Storekeeper> StorekeepersList) {
        //check if product list is empty
        if (ProductsList.isEmpty()) {
            System.out.println("Cannot update!!!");
            return;
        }
        System.out.println("UPDATE PRODUCT: ");
        showProduct(ProductsList);
        String id;
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //loop until enter valid id
        while (true) {
            System.out.print("Enter product id to update: ");
            id = sc.nextLine();
            //check if id not empty
            if (!id.isEmpty()) {
                break;
            }
        }
        int indexUpdate;
        //loop to traverse Product List
        for (indexUpdate = 0; indexUpdate < ProductsList.size(); indexUpdate++) {
            //check if id of indexUpdate equals id user update
            if (ProductsList.get(indexUpdate).getId().equals(id)) {
                break;
            }
        }
        //check if id user update not in list
        if (indexUpdate == ProductsList.size()) {
            System.out.println("Id not exist!!!");
            System.out.println("");
            return;
        }
        Product product = new Product();
        product.setId(id);
        //loop until enter valid product Name
        while (true) {
            System.out.print("Enter Update Name: ");
            String name = sc.nextLine();
            //check if Name valid
            if (Validation.checkString(name)) {
                product.setName(name);
                break;
            }
        }
        //loop until enter valid product location
        while (true) {
            System.out.print("Enter Update Location: ");
            String location = sc.nextLine();
            //check if location valid
            if (Validation.checkString(location)) {
                product.setLocation(location);
                break;
            }
        }
        //loop until enter valid product price
        while (true) {
            System.out.print("Enter Update Price: ");
            String price = sc.nextLine();
            //check if price valid
            if (Validation.checkPrice(price)) {
                product.setPrice(Integer.parseInt(price));
                break;
            }
        }
        //loop until enter valid product expiry date
        while (true) {
            System.out.print("Enter Update Expiry Date: ");
            String date = sc.nextLine();
            //check if date valid 
            if (Validation.checkDate(date)) {
                try {
                    product.setExpiryDate(sdf.parse(date));
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        //loop until enter valid product date of manufacture
        while (true) {
            System.out.print("Enter Update Date of Manufacture: ");
            String date = sc.nextLine();
            //check if date valid
            if (Validation.checkDate(date)) {
                try {
                    //check if manufactorDate before expiryDate
                    if (sdf.parse(date).before(product.getExpiryDate())) {
                        System.out.println("Manufacture Date must after Expiry Date!!!");
                        continue;
                    }
                    product.setDateOfManufacture(sdf.parse(date));
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        //loop until enter valid product category
        while (true) {
            System.out.print("Enter Update Category: ");
            String category = sc.nextLine();
            //check if category valid
            if (Validation.checkString(category)) {
                product.setCategory(category);
                break;
            }
        }
        //loop until enter valid storekeeper
        while (true) {
            System.out.print("Enter Update Storekeeper: ");
            String storekeeper = sc.nextLine();
            //check if storekeeper valid
            if (Validation.checkString(storekeeper)) {
                //check if storekeeper not exist in storekeeper list
                if (Validation.checkStorekeeper(storekeeper, StorekeepersList)) {
                    int idKeeper = StorekeepersList.size();
                    StorekeepersList.add(new Storekeeper(idKeeper, storekeeper));
                }
                product.setStorekeeper(storekeeper);
                break;
            }
        }
        //loop until enter valid receipt date
        while (true) {
            System.out.print("Enter Update Receipt Date: ");
            String receiptDate = sc.nextLine();
            //check if receiptDate valid
            if (Validation.checkDate(receiptDate)) {
                try {
                    //check if receiptDate before expiryDate
                    if (sdf.parse(receiptDate).before(product.getExpiryDate())) {
                        System.out.println("Receipt Date must after Expiry Date!!!");
                        continue;
                    }
                    product.setReceiptDate(sdf.parse(receiptDate));
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        ProductsList.set(indexUpdate, product);
        System.out.println("Update successfully >~<");
        System.out.println("");
    }

    static void sortProduct(ArrayList<Product> ProductsList) {
        //check if product list is empty
        if (ProductsList.isEmpty()) {
            System.out.println("Product List is empty!!!");
            return;
        }
        System.out.println("SORT PRODUCT: ");
        //loop to traverse from first element to last element
        for (int i = 0; i < ProductsList.size(); i++) {
            //loop to traverse from first element to last element
            for (int j = 0; j < ProductsList.size() - 1; j++) {
                //check if left expiry date after right expiry date
                if (ProductsList.get(j).getExpiryDate().after(ProductsList.get(j + 1).getExpiryDate())) {
                    Product productTemp = ProductsList.get(j);
                    ProductsList.set(j, ProductsList.get(j + 1));
                    ProductsList.set(j + 1, productTemp);
                }
                //check if left expiry date equal right expiry date
                if (ProductsList.get(j).getExpiryDate().equals(ProductsList.get(j + 1).getExpiryDate())) {
                    //check if left manufactor date after right manufactor date
                    if (ProductsList.get(j).getDateOfManufacture().after(ProductsList.get(j + 1).getDateOfManufacture())) {
                        Product productTemp = ProductsList.get(j);
                        ProductsList.set(j, ProductsList.get(j + 1));
                        ProductsList.set(j + 1, productTemp);
                    }
                }
            }
        }
        showProduct(ProductsList);
        System.out.println("");
    }

    static void showProduct(ArrayList<Product> ProductsList) {
        System.out.println("Your product list: ");
        System.out.println(" Id |    Name    | Location | Price | ExpiryDate | ManuOfDate | Category | Storekeeper | ReceiptDate");
        //loop to traverse element in ProductsList
        for (Product product : ProductsList) {
            product.displayProduct();
        }
    }

    static void searchProduct(ArrayList<Product> ProductsList) {
        //check if product list is empty
        if (ProductsList.isEmpty()) {
            System.out.println("Product List is empty!!!");
            return;
        }
        Scanner sc = new Scanner(System.in);
        //choose to search
        System.out.println("You want to search by:");
        System.out.println("1. Name");
        System.out.println("2. Category");
        System.out.println("3. Storekeeper");
        System.out.println("4. Receipr Date");
        int select;
        //loop until user enter valid selection
        while (true) {
            System.out.print("Enter your select: ");
            String selection = sc.nextLine();
            //check if selection valid
            if (Validation.checkOption(selection, 1, 4)) {
                select = Integer.parseInt(selection);
                break;
            }
        }
        switch (select) {
            //search by name
            case 1:
                System.out.println("SEARCH BY NAME: ");
                searchByName(ProductsList);
                break;
            //search by category
            case 2:
                System.out.println("SEARCH BY CATEGORY:");
                searchByCategory(ProductsList);
                break;
            //search by storekeeper
            case 3:
                System.out.println("SEARCH BY STOREKEEPER:");
                searchByStoreKeeper(ProductsList);
                break;
            //search by receipt date
            case 4:
                System.out.println("SEARCH BY RECEIPT DATE:");
                searchByReceiptDate(ProductsList);
                break;
        }
        System.out.println("");
    }

    private static void searchByName(ArrayList<Product> ProductsList) {
        Scanner sc = new Scanner(System.in);
        int index;
        boolean check = false;
        String searchName;
        //loop until enter valid product Name
        while (true) {
            System.out.print("Enter Search Name: ");
            String name = sc.nextLine();
            //check if Name valid
            if (Validation.checkString(name)) {
                searchName = name;
                break;
            }
        }
        //loop to traverse element in product list
        for (index = 0; index < ProductsList.size(); index++) {
            //check if find product
            if (ProductsList.get(index).getName().equals(searchName)) {
                //check if not found other product
                if (!check) {
                    System.out.println("Your search list:");
                    System.out.println(" Id |    Name    | Location | Price | ExpiryDate | ManuOfDate | Category | Storekeeper | ReceiptDate");
                    ProductsList.get(index).displayProduct();
                    check = true;
                } else {
                    ProductsList.get(index).displayProduct();
                }
            }
        }
        //check if not found any product
        if (!check) {
            System.out.println("Your name you enter not exist >~<");
        }
    }

    private static void searchByCategory(ArrayList<Product> ProductsList) {
        Scanner sc = new Scanner(System.in);
        int index;
        boolean check = false;
        String searchCategory;
        //loop until enter valid product category
        while (true) {
            System.out.print("Enter Search Category: ");
            String category = sc.nextLine();
            //check if Name valid
            if (Validation.checkString(category)) {
                searchCategory = category;
                break;
            }
        }
        //loop to traverse element in product list
        for (index = 0; index < ProductsList.size(); index++) {
            //check if find product
            if (ProductsList.get(index).getCategory().equals(searchCategory)) {
                //check if not found other product
                if (!check) {
                    System.out.println("Your search list:");
                    System.out.println(" Id |    Name    | Location | Price | ExpiryDate | ManuOfDate | Category | Storekeeper | ReceiptDate");
                    ProductsList.get(index).displayProduct();
                    check = true;
                } else {
                    ProductsList.get(index).displayProduct();
                }
            }
        }
        //check if not found any product
        if (!check) {
            System.out.println("Your category you enter not exist >~<");
        }
    }

    private static void searchByStoreKeeper(ArrayList<Product> ProductsList) {
        Scanner sc = new Scanner(System.in);
        int index;
        boolean check = false;
        String searchStoreKeeper;
        //loop until enter valid product storekeeper
        while (true) {
            System.out.print("Enter Search Category: ");
            String storekeeper = sc.nextLine();
            //check if Name valid
            if (Validation.checkString(storekeeper)) {
                searchStoreKeeper = storekeeper;
                break;
            }
        }
        //loop to traverse element in product list
        for (index = 0; index < ProductsList.size(); index++) {
            //check if find product
            if (ProductsList.get(index).getStorekeeper().equals(searchStoreKeeper)) {
                //check if not found other product
                if (!check) {
                    System.out.println("Your search list:");
                    System.out.println(" Id |    Name    | Location | Price | ExpiryDate | ManuOfDate | Category | Storekeeper | ReceiptDate");
                    ProductsList.get(index).displayProduct();
                    check = true;
                } else {
                    ProductsList.get(index).displayProduct();
                }
            }
        }
        //check if not found any product
        if (!check) {
            System.out.println("Your storekeeper you enter not exist >~<");
        }
    }

    private static void searchByReceiptDate(ArrayList<Product> ProductsList) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int index;
        boolean check = false;
        String searchDate;
        //loop until enter valid receipt date
        while (true) {
            System.out.print("Enter Search Receipt Date: ");
            String receiptDate = sc.nextLine();
            //check if receiptDate valid
            if (Validation.checkDate(receiptDate)) {
                searchDate = receiptDate;
                break;
            }
        }
        //loop to traverse element in product list
        for (index = 0; index < ProductsList.size(); index++) {
            String expiryDate = sdf.format(ProductsList.get(index).getExpiryDate());
            //check if find product
            if (searchDate.equals(expiryDate)) {
                //check if not found other product
                if (!check) {
                    System.out.println("Your search list:");
                    System.out.println(" Id |    Name    | Location | Price | ExpiryDate | ManuOfDate | Category | Storekeeper | ReceiptDate");
                    ProductsList.get(index).displayProduct();
                    check = true;
                } else {
                    ProductsList.get(index).displayProduct();
                }
            }
        }
        //check if not found any product
        if (!check) {
            System.out.println("Your storekeeper you enter not exist >~<");
        }
    }
}
