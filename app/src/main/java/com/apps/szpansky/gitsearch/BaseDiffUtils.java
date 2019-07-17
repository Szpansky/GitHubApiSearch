package com.apps.szpansky.gitsearch;


import android.support.v7.util.DiffUtil;

import com.apps.szpansky.gitsearch.dataStructure.DataStructure;

import java.util.List;

public class BaseDiffUtils extends DiffUtil.Callback {
    protected List<DataStructure> newData;
    protected List<DataStructure> oldData;

    public BaseDiffUtils(List<DataStructure> oldData, List<DataStructure> newData) {
        this.newData = newData;
        this.oldData = oldData;
    }

    @Override
    public int getOldListSize() {
        return oldData.size();
    }

    @Override
    public int getNewListSize() {
        return newData.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return (oldData.get(oldItemPosition)).getId() == (newData.get(newItemPosition)).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldData.get(oldItemPosition).equals(newData.get(newItemPosition));
    }


    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
