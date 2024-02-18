package com.ellenkniceley.bloodbowlcompanion;

public class StuntyRollListModel {
    String stuntyRollNumber;
    String stuntyRollTitle;
    String stuntyRollDescription;

    public StuntyRollListModel (String stuntyRollNumber, String stuntyRollTitle, String stuntyRollDescription) {
        this.stuntyRollNumber = stuntyRollNumber;
        this.stuntyRollTitle = stuntyRollTitle;
        this.stuntyRollDescription = stuntyRollDescription;
    }

    public String getStuntyRollNumber() {
        return stuntyRollNumber;
    }

    public String getStuntyRollTitle() {
        return stuntyRollTitle;
    }

    public String getStuntyRollDescription() {
        return stuntyRollDescription;
    }
}
