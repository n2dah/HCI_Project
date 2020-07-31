package com.example.hci_project;

import android.content.Intent;
import android.view.View;

public class Charities {
    String charityName;
    int image;
    String charityDisease;
    Boolean savedCharity;

    public Charities(String charityName, int image, String charityDisease, Boolean savedCharity) {
        this.charityName = charityName;
        this.image = image;
        this.charityDisease = charityDisease;
        this.savedCharity = savedCharity;
    }

    public String getCharityName() {
        return charityName;
    }

    public int getImage() {
        return image;
    }

    public String getCharityDisease() {
        return charityDisease;
    }

    public Boolean getSavedCharity() {
        return savedCharity;
    }
}
