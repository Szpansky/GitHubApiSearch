package com.apps.szpansky.gitsearch.mainActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import com.apps.szpansky.gitsearch.Constants;
import com.apps.szpansky.gitsearch.R;
import com.apps.szpansky.gitsearch.simples.SimpleActivity;

import butterknife.ButterKnife;

public class MainActivity extends SimpleActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public int getAppBarLayout() {
        return R.id.appbar;
    }

    @Override
    public int getCollapsingLayout() {
        return R.id.collapsing_toolbar;
    }

    @Override
    public Toolbar getToolBarLayout() {
        return findViewById(R.id.toolbar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_list_refresh, ReposListFragment.newInstance(), ReposListFragment.TAG).commit();
        }
        collapsing_toolbar.setTitle(Constants.collapsingBarTitle);
    }

}
