package com.apps.szpansky.gitsearch.loadingProviders;

import com.apps.szpansky.gitsearch.dataStructure.Repos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RootApi {
    @GET("search/repositories")
    Call<Repos> searchRepos(@Query(value = "q") String query, @Query(value = "client_id") String user_id, @Query(value = "client_secret") String user_secret);

  //  @GET("search/repositories?{site_id}" + endURL)
   // Call<Repos> allRepos(@Path("site_id") String site_id);
}
