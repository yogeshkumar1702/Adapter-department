package com.example.adapterdepartment;

public class Item {

    private String itemName;
    private String itemDescription;
    private String itemPhonenumber;

    public Item(String name, String description , String ph) {
        this.itemName = name;
        this.itemDescription = description;
        this.itemPhonenumber = ph;
    }

    public String getItemName() {
        return this.itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getitemPhonenumber(){
        return this.itemPhonenumber;
    }
}