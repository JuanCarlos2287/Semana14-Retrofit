package com.example.semana14_completa.Interfaz;

import com.example.semana14_completa.Modelo.Albums;
import com.example.semana14_completa.Modelo.Comments;
import com.example.semana14_completa.Modelo.Posts;
import com.example.semana14_completa.Modelo.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("posts") Call<List<Posts>> getPosts();
    @GET("comments") Call<List<Comments>> getComments();
    @GET("albums") Call<List<Albums>> getAlbums();
    @GET("users") Call<List<Users>> getUsers();
}