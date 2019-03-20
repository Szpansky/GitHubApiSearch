package com.apps.szpansky.gitsearch.loadingProviders;

import com.apps.szpansky.gitsearch.dataStructure.Repos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RootApi {
    @GET
    Call<Repos> reposData(@Url String url);
}
