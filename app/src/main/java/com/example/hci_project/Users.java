package com.example.hci_project;

import java.util.ArrayList;

public class Users {
    String name;
    ArrayList<Charities> charities;
    int profilePic;

    public Users(String name, ArrayList<Charities> charities, int profilePic) {
        this.name = name;
        this.charities = charities;
        this.profilePic = profilePic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Charities> getCharities() {
        return charities;
    }

    public void setCharities(ArrayList<Charities> charities) {
        this.charities = charities;
    }

    public int getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(int profilePic) {
        this.profilePic = profilePic;
    }
}
