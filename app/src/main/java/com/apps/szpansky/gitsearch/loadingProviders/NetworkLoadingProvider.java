package com.apps.szpansky.gitsearch.loadingProviders;

import androidx.annotation.NonNull;

import com.apps.szpansky.gitsearch.Constants;
import com.apps.szpansky.gitsearch.dataStructure.Repos;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.apps.szpansky.gitsearch.Constants.clientID;
import static com.apps.szpansky.gitsearch.Constants.clientSecret;

public class NetworkLoadingProvider implements LoadingProvider {

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
        repo.searchRepos(query + "in:name", clientID, clientSecret).enqueue(new Callback<Repos>() {
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
