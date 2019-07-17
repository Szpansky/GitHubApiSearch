package com.apps.szpansky.gitsearch.loadingProviders;

import android.support.annotation.NonNull;

import com.apps.szpansky.gitsearch.Constants;
import com.apps.szpansky.gitsearch.dataStructure.Repos;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkLoadingProvider implements LoadingProvider {

    private String clientID = "private";
    private String clientSecret = "private";
    private String endURL = "&client_id=" + clientID + "&client_secret=" + clientSecret;
    private RootApi repo;


    public NetworkLoadingProvider() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.siteURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        repo = retrofit.create(RootApi.class);
    }

    @Override
    public void loadData(final CallBack callBack, @NonNull String query) {
        String urlBuilder;
        if (query.length() == 0) {
            urlBuilder = Constants.siteURL + "search/repositories?q=false+in:private" + endURL;
        } else {
            urlBuilder = Constants.siteURL + "search/repositories?q=" + query + "+in:name" + endURL;
        }

        repo.reposData(urlBuilder).enqueue(new Callback<Repos>() {
            @Override
            public void onResponse(Call<Repos> call, Response<Repos> response) {
                if (response.isSuccessful()) {
                    callBack.onSuccess(response.body().getItems());
                }
            }

            @Override
            public void onFailure(Call<Repos> call, Throwable t) {
                callBack.onFailed(t);
                System.out.println("faill" + t.getMessage());
            }

        });
    }

}
