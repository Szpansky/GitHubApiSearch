package com.apps.szpansky.gitsearch.loadingProviders;

import com.apps.szpansky.gitsearch.dataStructure.DataStructure;

import java.util.List;

public class ControlLoadingProvider implements LoadingProvider {

    LocalLoadingProvider localLoadingProvider;
    NetworkLoadingProvider networkLoadingProvider;


    public ControlLoadingProvider() {
        localLoadingProvider = new LocalLoadingProvider();
        networkLoadingProvider = new NetworkLoadingProvider();
    }


    @Override
    public void loadData(final CallBack callBack, String query) {
        networkLoadingProvider.loadData(new CallBack() {
            @Override
            public void onSuccess(List<? extends DataStructure> repos) {
                callBack.onSuccess(repos);
            }

            @Override
            public void onFailed(Throwable t) {
                callBack.onFailed(t);
            }
        }, query);

        //TODO pagination and local cash
    }
}
