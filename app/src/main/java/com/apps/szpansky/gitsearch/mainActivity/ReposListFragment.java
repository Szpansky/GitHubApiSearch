package com.apps.szpansky.gitsearch.mainActivity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.apps.szpansky.gitsearch.R;
import com.apps.szpansky.gitsearch.dataStructure.DataStructure;
import com.apps.szpansky.gitsearch.dataStructure.Repo;
import com.apps.szpansky.gitsearch.loadingProviders.ControlLoadingProvider;
import com.apps.szpansky.gitsearch.loadingProviders.LoadingProvider;
import com.apps.szpansky.gitsearch.simples.SimpleListFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class ReposListFragment extends SimpleListFragment implements ReposAdapter.RepoAdapterInterface, SearchView.OnQueryTextListener {

    public static final String TAG = "ReposListFragment";
    LoadingProvider loadingProvider;
    ReposViewModel reposViewModel;
    Handler handler = new Handler();
    Toast toast;
    SearchView searchView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.error_layout)
    RelativeLayout errorLayout;

    String queryStatement = "";

    @OnClick(R.id.refresh_button_dialog)
    public void setRefreshButtonDialog() {
        errorLayout.setVisibility(View.GONE);
        loadData(queryStatement);
    }


    public static ReposListFragment newInstance() {
        ReposListFragment fragment = new ReposListFragment();
        return fragment;
    }


    @Override
    public StaggeredGridLayoutManager getLayoutManager() {
        return new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadingProvider = new ControlLoadingProvider();
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(reposViewModel.getLayoutManager());
        recyclerView.setAdapter(reposViewModel.getAdapter());
        searchView = getActivity().findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(this);
        loadData(queryStatement);
    }




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        reposViewModel = ViewModelProviders.of(this).get(ReposViewModel.class);
        reposViewModel.setFragmentManager(getFragmentManager());
        reposViewModel.setLayoutManager(getLayoutManager());
        reposViewModel.setAdapter(new ReposAdapter(reposViewModel.getDataList(), this));
    }


    @Override
    public void loadData(String query) {
        progressBar.setVisibility(View.VISIBLE);
        loadingProvider.loadData(new LoadingProvider.CallBack() {
            @Override
            public void onSuccess(List<? extends DataStructure> data) {
                reposViewModel.getDataList().clear();
                reposViewModel.getDataList().addAll(data);

                reposViewModel.getAdapter().notifyDataSetChanged();
                if (swipeRefreshLayout.isRefreshing()) {
                    swipeRefreshLayout.setRefreshing(false);
                }
                if ((data.size() == 0)) {
                    emptyInfo.setVisibility(View.VISIBLE);
                } else {
                    emptyInfo.setVisibility(View.GONE);
                }
                progressBar.setVisibility(View.GONE);
                errorLayout.setVisibility(View.GONE);
            }

            @Override
            public void onFailed(Throwable t) {
                try {
                    toast.getView().isShown();
                } catch (Exception e) {
                    toast = Toast.makeText(getContext(), R.string.empty_data, Toast.LENGTH_SHORT);
                }
                toast.show();

                if (swipeRefreshLayout.isRefreshing()) {
                    swipeRefreshLayout.setRefreshing(false);
                }
                progressBar.setVisibility(View.GONE);
                errorLayout.setVisibility(View.VISIBLE);
            }
        }, query);
    }


    @Override
    public void onItemClick(Repo repo) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(repo.getHtml_url()));
        startActivity(browserIntent);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        loadData(query);
        searchView.clearFocus();
        queryStatement = query;
        return true;
    }




    @Override
    public boolean onQueryTextChange(final String query) {
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadData(query);
            }
        }, 500);
        return true;
    }

}
