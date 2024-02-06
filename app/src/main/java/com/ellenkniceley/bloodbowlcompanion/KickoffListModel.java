package com.ellenkniceley.bloodbowlcompanion;

public class KickoffListModel {

    String kickoffNumber;
    String kickoffTitle;
    String kickoffDescription;

    public KickoffListModel (String kickoffNumber, String kickoffTitle, String kickoffDescription) {
        this.kickoffNumber = kickoffNumber;
        this.kickoffTitle = kickoffTitle;
        this.kickoffDescription = kickoffDescription;
    }

    public String getKickoffNumber() {
        return kickoffNumber;
    }

    public String getKickoffTitle() {
        return kickoffTitle;
    }

    public String getKickoffDescription() {
        return kickoffDescription;
    }
}
