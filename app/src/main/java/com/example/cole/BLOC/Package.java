package com.example.cole.BLOC;

/**
 * Created by Cole on 10/24/17.
 */

public class Package {
    //may need to add more
    private String title, description;
    private int imageID, cost;

    public Package(String title, String description, int cost, int imageID) {
        this.title = title;
        this.description = description;
        this.cost = cost;
        this.imageID = imageID;
    }

    @Override
    public String toString() {
        return "" + title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
