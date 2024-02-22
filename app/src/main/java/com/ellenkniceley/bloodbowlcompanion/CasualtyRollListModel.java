package com.ellenkniceley.bloodbowlcompanion;

public class CasualtyRollListModel {
    String casualtyRollNumber;
    String casualtyRollTitle;
    String casualtyRollDescription;

    public CasualtyRollListModel(String casualtyRollNumber, String casualtyRollTitle, String casualtyRollDescription){
        this.casualtyRollNumber = casualtyRollNumber;
        this.casualtyRollTitle = casualtyRollTitle;
        this.casualtyRollDescription = casualtyRollDescription;
    }

    public String getCasualtyRollNumber() {
        return casualtyRollNumber;
    }

    public String getCasualtyRollTitle() {
        return casualtyRollTitle;
    }

    public String getCasualtyRollDescription() {
        return casualtyRollDescription;
    }
}
