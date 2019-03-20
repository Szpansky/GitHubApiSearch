package com.apps.szpansky.gitsearch.simples;

import android.arch.lifecycle.ViewModel;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.apps.szpansky.gitsearch.dataStructure.DataStructure;

import java.util.ArrayList;
import java.util.List;

public abstract class SimpleViewModel extends ViewModel {

    private List<DataStructure> dataList = new ArrayList<>();
    private FragmentManager fragmentManager;
    private RecyclerView.Adapter adapter;
    private StaggeredGridLayoutManager linearLayoutManager;


    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }


    public void setAdapter(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
    }


    public void setLayoutManager(StaggeredGridLayoutManager linearLayoutManager) {
        this.linearLayoutManager = linearLayoutManager;
    }


    public List<DataStructure> getDataList() {
        return dataList;
    }


    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }


    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }


    public StaggeredGridLayoutManager getLayoutManager() {
        return linearLayoutManager;
    }
}
