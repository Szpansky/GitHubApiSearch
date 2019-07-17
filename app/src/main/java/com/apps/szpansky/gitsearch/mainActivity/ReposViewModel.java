package com.apps.szpansky.gitsearch.mainActivity;

import androidx.recyclerview.widget.RecyclerView;

import com.apps.szpansky.gitsearch.simples.SimpleViewModel;

public class ReposViewModel extends SimpleViewModel {
    private RecyclerView.Adapter adapter = new ReposAdapter(getDataList());

    @Override
    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }
}
