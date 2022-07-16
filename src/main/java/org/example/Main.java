package org.example;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static User user;

    public static void main(String[] args) {

        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        Authenticate.handleLogin(scanner);

        if(user != null){
            ItemController controller = new ItemController();
            controller.fetchItem();
            System.out.println("Enter 1 to add an item, " +
                    "2 for delete an item , " +
                    "3 to update an item , " +
                    "4 to view items and" +
                    " enter 5 to filter item");
            String choice = scanner.nextLine();
            if(choice.equals("1")){
                System.out.println("Enter item name");
                String itemName = scanner.nextLine();
                System.out.println("Enter item price");
                String itemPrice = scanner.nextLine();

                controller.addNewItem(new Item(itemName,itemPrice));
            } else if (choice.equals("2")) {
                System.out.println("Enter an item id to remove");
                String id = scanner.nextLine();
                controller.removeItem(Integer.parseInt(id));
            } else if (choice.equals("3")) {
                System.out.println("Enter item id to update");
                String id = scanner.nextLine();
                System.out.println("Please provide a new item name");
                String itemName = scanner.nextLine();
                System.out.println("Please provide a new item price");
                String itemPrice = scanner.nextLine();
                controller.updateItem(new Item(
                        Integer.parseInt(id),itemName,itemPrice
                ));
            } else if (choice.equals("4")) {
            controller.getItem();
            } else if (choice.equals("5")) {
                System.out.println("Enter Item id to search");
                String id = scanner.nextLine();
                List<Item> filteredItem = ItemController.itemList.stream().filter(item -> item.getItemId() == Integer.parseInt(id)).toList();
                if(!filteredItem.isEmpty()){
                    System.out.println("Item ID: "+(filteredItem.get(0).getItemId()));
                    System.out.println("Item Name: "+(filteredItem.get(0).getItemName()));
                    System.out.println("Item Price: "+(filteredItem.get(0).getItemPrice()));

                }else{
                    System.err.println("Item id "+id+" Not Found");
                }

            }
        }else{
            System.out.println("User Not logged in");
        }
    }


}