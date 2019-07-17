package com.apps.szpansky.gitsearch.dataStructure;

import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repos repos = (Repos) o;
        return Objects.equals(total_count, repos.total_count) &&
                Objects.equals(items, repos.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total_count, items);
    }
}
