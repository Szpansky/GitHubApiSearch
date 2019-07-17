package com.apps.szpansky.gitsearch.simples;

import android.os.Bundle;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
