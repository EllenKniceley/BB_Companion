package com.ellenkniceley.bloodbowlcompanion;

public class ListModel {
    String listName;
    int image;

    public ListModel(String listName, int image) {
        this.listName = listName;
        this.image = image;
    }

    public String getListName() {
        return listName;
    }

    public int getImage() {
        return image;
    }
}
