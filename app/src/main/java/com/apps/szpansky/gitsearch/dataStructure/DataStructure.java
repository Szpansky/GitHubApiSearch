package com.apps.szpansky.gitsearch.dataStructure;

import java.io.Serializable;
import java.util.Objects;

public class DataStructure implements Serializable {

    private long id;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataStructure that = (DataStructure) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
