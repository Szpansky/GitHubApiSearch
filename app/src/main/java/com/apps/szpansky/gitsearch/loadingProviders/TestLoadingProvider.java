package com.apps.szpansky.gitsearch.loadingProviders;

import android.os.Handler;

import com.apps.szpansky.gitsearch.dataStructure.Repo;

import java.util.ArrayList;
import java.util.List;

public class TestLoadingProvider implements LoadingProvider {
    @Override
    public void loadData(final CallBack callBack, String query) {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                List<Repo> data = new ArrayList<>();
                data.add(new Repo(1, "Basia"));
                data.add(new Repo(2, "Basia"));
                data.add(new Repo(3, "Basia"));
                data.add(new Repo(4, "Basia"));
                data.add(new Repo(5, "Basia"));
                data.add(new Repo(6, "Basia"));
                data.add(new Repo(7, "Basia"));
                data.add(new Repo(8, "Basia"));
                data.add(new Repo(9, "Basia"));
                data.add(new Repo(10, "Basia"));
                data.add(new Repo(11, "Basia"));
                data.add(new Repo(12, "Basia"));
                data.add(new Repo(13, "Basia"));

                callBack.onSuccess(data);

                int random = (int) (Math.random() * 100);
                if (random % 2 == 0) {
                    callBack.onSuccess(data);
                } else {
                    callBack.onFailed(new RuntimeException());
                }

            }


        }, 1000);
    }
}
