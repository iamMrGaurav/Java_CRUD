package org.example;

public class Item {
    private int itemId;
    private String itemName;
    private String itemPrice;

    public Item(String itemName,String itemPrice){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public Item(int itemId, String itemName,String itemPrice){
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
}
