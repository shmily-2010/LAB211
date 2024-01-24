/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0105;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kinhd
 */
public class Validation {

    static boolean checkOption(String option, int from, int to) {
        //check if empty
        if (option.isEmpty()) {
            System.out.println("Option not empty!!!");
            return false;
        }
        try {
            int optionNum = Integer.parseInt(option);
            //check if not Option
            if (optionNum>to || optionNum<from) {
                System.out.println("Option must be "+from+" to "+to+"!!!");
                return false;
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage() + "!!!");
            return false;
        }
        return true;
    }

    static boolean checkString(String name) {
        //check if empty
        if (name.isEmpty()) {
            System.out.println("Name not empty!!!");
            return false;
        }
        //loop to traversal name elements
        for (int i = 0; i < name.length(); i++) {
            //check if name element not character or space
            if (!((name.charAt(i)>='a' && name.charAt(i)<='z')
                    || (name.charAt(i)>='A' && name.charAt(i)<='Z')
                    || (name.charAt(i)==' '))) {
                System.out.println("Name must character!!!");
                return false;
            }
        }
        return true;
    }

    static boolean checkId(String Id, ArrayList<Product> ProductsList) {
        //check if empty
        if (Id.isEmpty()) {
            System.out.println("Id not empty!!!");
            return false;
        }
        //loop to traverse all element of list
        for (int i = 0; i < ProductsList.size(); i++) {
            //check if exist
            if (ProductsList.get(i).getId().compareTo(Id)==0) {
                System.out.println("Duplicate Id!!!");
                return false;
            }
        }
        return true;
    }

    static boolean checkPrice(String input) {
        try {
            int price = Integer.parseInt(input);
            //check if price not positive
            if (price <= 0) {
                System.out.println("Price must positive!!!");
                return false;
            } 
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    static boolean checkDate(String input) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            sdf.setLenient(false);
            Date date = sdf.parse(input);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            System.out.println("Date format is dd/MM/yyyy!!!");
            return false;
        }
        return true;
    }

    static boolean checkStorekeeper(String storekeeper, ArrayList<Storekeeper> StorekeepersList) {
        //loop to traverse storekeeper list
        for (int i = 0; i < StorekeepersList.size(); i++) {
            //check if storekeeper exist
            if (StorekeepersList.get(i).getStorekeeper().compareTo(storekeeper)==0) {
                return true;
            }
        }
        System.out.println("Storekeeper not valid!!!");
        return false;
    }

}
