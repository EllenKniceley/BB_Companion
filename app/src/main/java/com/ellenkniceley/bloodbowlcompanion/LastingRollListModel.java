package com.ellenkniceley.bloodbowlcompanion;

public class LastingRollListModel {
    String lastingRollNumber;
    String lastingRollTitle;
    String lastingRollDescription;

    public LastingRollListModel(String lastingRollNumber, String lastingRollTitle, String lastingRollDescription){
        this.lastingRollNumber = lastingRollNumber;
        this.lastingRollTitle = lastingRollTitle;
        this.lastingRollDescription = lastingRollDescription;
    }

    public String getLastingRollNumber() {
        return lastingRollNumber;
    }

    public String getLastingRollTitle() {
        return lastingRollTitle;
    }

    public String getLastingRollDescription() {
        return lastingRollDescription;
    }
}
