package com.example.semana14_completa.ClasesMetodos;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.semana14_completa.Interfaz.JsonPlaceHolderApi;
import com.example.semana14_completa.Modelo.Posts;
import com.example.semana14_completa.R;
import com.example.semana14_completa.Interfaz.JsonPlaceHolderApi;
import com.example.semana14_completa.Modelo.Posts;
import com.example.semana14_completa.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ObtenerPosts extends AppCompatActivity {
    private TextView mJsonTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        mJsonTxtView = findViewById(R.id.jsonTextPost);
        getPosts();
    }

    public void getPosts() {
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Posts>> call= jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response){

                if (!response.isSuccessful()){
                    mJsonTxtView.setText("codigo: "+response.code());
                    return;
                }

                List<Posts> PostList = response.body();

                for(Posts post: PostList){
                    String content ="";
                    content +="userId:"+ post.getUserIdPost() + "\n";
                    content +="id:"+ post.getIdPost() + "\n";
                    content +="title:"+ post.getTitlePost() + "\n";
                    content +="body:"+ post.getBodyPost() + "\n\n";
                    mJsonTxtView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                mJsonTxtView.setText(t.getMessage());
            }
        });
    }
}
