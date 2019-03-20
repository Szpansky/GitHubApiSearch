package com.apps.szpansky.gitsearch.dataStructure;

import java.util.ArrayList;

public class Repos {

    private String total_count;
    private ArrayList<Repo> items;


    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }

    public ArrayList<Repo> getItems() {
        return items;
    }

    public void setItems(ArrayList<Repo> items) {
        this.items = items;
    }

}
