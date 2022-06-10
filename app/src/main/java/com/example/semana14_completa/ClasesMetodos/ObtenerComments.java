package com.example.semana14_completa.ClasesMetodos;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.semana14_completa.Interfaz.JsonPlaceHolderApi;
import com.example.semana14_completa.Modelo.Comments;
import com.example.semana14_completa.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ObtenerComments extends AppCompatActivity {
    private TextView mJsonTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        mJsonTxtView = findViewById(R.id.jsonTextComment);
        getComments();
    }

    public void getComments() {
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Comments>> call= jsonPlaceHolderApi.getComments();

        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response){

                if (!response.isSuccessful()){
                    mJsonTxtView.setText("codigo: "+response.code());
                    return;
                }

                List<Comments> CommentsList = response.body();

                for(Comments comments: CommentsList){
                    String content ="";
                    content +="postId:"+ comments.getPostIdComm() + "\n";
                    content +="id:"+ comments.getIdComm() + "\n";
                    content +="name:"+ comments.getNameComm() + "\n";
                    content +="email:"+ comments.getEmailComm() + "\n";
                    content +="body:"+ comments.getBodyComm() + "\n\n";
                    mJsonTxtView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {
                mJsonTxtView.setText(t.getMessage());
            }
        });
    }
}
