package com.example.semana14_completa.ClasesMetodos;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.semana14_completa.Interfaz.JsonPlaceHolderApi;
import com.example.semana14_completa.Modelo.Users;
import com.example.semana14_completa.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ObtenerUsers extends AppCompatActivity {
    private TextView mJsonTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        mJsonTxtView = findViewById(R.id.jsonTextUser);
        getUsers();
    }

    public void getUsers() {
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Users>> call= jsonPlaceHolderApi.getUsers();

        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response){

                if (!response.isSuccessful()){
                    mJsonTxtView.setText("codigo: "+response.code());
                    return;
                }

                List<Users> UsersList = response.body();

                for(Users users: UsersList){
                    String content ="";
                    content +="id:"+ users.getIdUs() + "\n";
                    content +="name:"+ users.getNameUs() + "\n";
                    content +="username:"+ users.getUsernameUs() + "\n";
                    content +="email:"+ users.getEmailUs() + "\n\n";
                    mJsonTxtView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                mJsonTxtView.setText(t.getMessage());
            }
        });
    }
}
