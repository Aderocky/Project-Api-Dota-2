package com.example.projectapi.api;


import com.example.projectapi.models.heroess;
import com.example.projectapi.models.leagueidd;
import com.example.projectapi.models.teamss;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface apiRqstData {

    @GET("teams")
    Call<List<teamss>> getTeams();

    @GET("leagues")
    Call<List<leagueidd>> getLeagues();

    @GET("heroes")
    Call<List<heroess>> getHeroes();


}