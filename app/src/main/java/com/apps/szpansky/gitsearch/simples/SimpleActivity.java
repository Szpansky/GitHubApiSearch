package com.apps.szpansky.gitsearch.simples;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public abstract class SimpleActivity extends AppCompatActivity {

    public Toolbar toolbar;

    public CollapsingToolbarLayout collapsing_toolbar;

    public AppBarLayout appbar;

    public abstract int getLayoutId();

    public abstract int getAppBarLayout();

    public abstract int getCollapsingLayout();

    public abstract Toolbar getToolBarLayout();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        toolbar = findViewById(getToolBarLayout().getId());
        setSupportActionBar(toolbar);
        collapsing_toolbar = findViewById(getCollapsingLayout());
        appbar = findViewById(getAppBarLayout());
    }
}
