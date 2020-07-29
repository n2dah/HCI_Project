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
}
