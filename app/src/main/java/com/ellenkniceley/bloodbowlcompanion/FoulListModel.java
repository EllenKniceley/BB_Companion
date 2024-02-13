package com.ellenkniceley.bloodbowlcompanion;

public class FoulListModel {
    String foulNumber;
    String foulTitle;
    String foulDescription;

    public FoulListModel (String foulNumber, String foulTitle, String foulDescription) {
        this.foulNumber = foulNumber;
        this.foulTitle = foulTitle;
        this.foulDescription = foulDescription;
    }

    public String getFoulNumber() {
        return foulNumber;
    }

    public String getFoulTitle() {
        return foulTitle;
    }

    public String getFoulDescription() {
        return foulDescription;
    }
}
