package com.ellenkniceley.bloodbowlcompanion;

public class NuffleTableListModel {
    String nuffleTableNumber;
    String nuffleTableTitle;
    String nuffleTableDescription;

    public NuffleTableListModel (String nuffleTableNumber, String nuffleTableTitle, String nuffleTableDescription){
        this.nuffleTableNumber = nuffleTableNumber;
        this.nuffleTableTitle = nuffleTableTitle;
        this.nuffleTableDescription = nuffleTableDescription;
    }

    public String getNuffleTableNumber() {
        return nuffleTableNumber;
    }

    public String getNuffleTableTitle() {
        return nuffleTableTitle;
    }

    public String getNuffleTableDescription() {
        return nuffleTableDescription;
    }
}
