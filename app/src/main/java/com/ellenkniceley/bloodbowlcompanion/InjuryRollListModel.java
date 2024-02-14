package com.ellenkniceley.bloodbowlcompanion;

public class InjuryRollListModel {
    String injuryRollNumber;
    String injuryRollTitle;
    String injuryRollDescription;

    public InjuryRollListModel (String injuryRollNumber, String injuryRollTitle, String injuryRollDescription) {
        this.injuryRollNumber = injuryRollNumber;
        this.injuryRollTitle = injuryRollTitle;
        this.injuryRollDescription = injuryRollDescription;
    }

    public String getInjuryRollNumber() {
        return injuryRollNumber;
    }

    public String getInjuryRollTitle() {
        return injuryRollTitle;
    }

    public String getInjuryRollDescription() {
        return injuryRollDescription;
    }
}
