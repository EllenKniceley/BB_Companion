package com.ellenkniceley.bloodbowlcompanion;

public class SkillsListModel {
    String skillsTitle;
    String skillsDescription;

    public SkillsListModel (String skillsTitle, String skillsDescription){
        this.skillsTitle = skillsTitle;
        this.skillsDescription = skillsDescription;
    }

    public String getSkillsTitle() {
        return skillsTitle;
    }

    public String getSkillsDescription() {
        return skillsDescription;
    }
}
