package org.example;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemController {
    static ArrayList<Item> itemList = new ArrayList<>();
    public void addNewItem(Item item){
        try{
            Connection conn = DatabaseHelper.getConnection();
            String query = "INSERT INTO items(item_name, item_price) VALUES ('"+item.getItemName()+"','"+item.getItemPrice()+"') ";
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println(item.getItemName()+" Added Succesfully");
            conn.close();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void removeItem(int id){
        try{
            Connection conn = DatabaseHelper.getConnection();
            String query = "DELETE FROM items WHERE item_id ="+id+"";
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Item with ID: " +id+" Deleted Successfully");
            conn.close();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void updateItem(Item item){
        try{
               List<Item> items = itemList.stream().filter(item1 -> item1.getItemId() == item.getItemId()).toList();
                    if(items.size() > 0){
                        Connection conn = DatabaseHelper.getConnection();
                        String query = "UPDATE items SET item_name='"+item.getItemName()+"',item_price='"+item.getItemPrice()+"' WHERE item_id="+item.getItemId()+"";
                        Statement statement = conn.createStatement();
                        statement.executeUpdate(query);
                        System.out.println(item.getItemName()+"  is Successfully updated");
                        conn.close();
                    }else{
                        System.err.println("Item Not Found");
                    }

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public boolean get(String a){
        if(a.equals("success")){
            return true;
        }
        return false;
    }

    public void fetchItem(){
        try{
            Connection conn = DatabaseHelper.getConnection();
            String query = "SELECT * FROM items";
            Statement statement = conn.createStatement();

           ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                Item item = new Item(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
                itemList.add(item);

            }
            conn.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }

    }
    public void getItem(){
        for(Item item:itemList){
            System.out.println("Item Id: "+item.getItemId());
            System.out.println("Item Name: "+item.getItemName());
            System.out.println("Item Price: "+item.getItemPrice());
            System.out.println();
        }

    }
}
