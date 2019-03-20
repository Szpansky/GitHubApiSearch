package com.apps.szpansky.gitsearch.loadingProviders;

import com.apps.szpansky.gitsearch.dataStructure.DataStructure;

import java.util.List;

public interface LoadingProvider {

    void loadData(CallBack callBack, String query);

    interface CallBack {
        void onSuccess(List<? extends DataStructure> data);

        void onFailed(Throwable t);
    }
}
