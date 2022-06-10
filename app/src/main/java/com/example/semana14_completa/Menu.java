package com.example.semana14_completa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.semana14_completa.ClasesMetodos.ObtenerAlbums;
import com.example.semana14_completa.ClasesMetodos.ObtenerComments;
import com.example.semana14_completa.ClasesMetodos.ObtenerPosts;
import com.example.semana14_completa.ClasesMetodos.ObtenerUsers;

public class Menu extends AppCompatActivity {


    Button bt_post;
    Button bt_comment;
    Button bt_album;
    Button bt_user;
    Button bt_salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        bt_post = findViewById(R.id.btPost);
        bt_comment = findViewById(R.id.btComent);
        bt_album = findViewById(R.id.btAlbum);
        bt_user = findViewById(R.id.btUsuario);
        bt_salir = findViewById(R.id.btSalir);

        bt_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irPost = new Intent(Menu.this, ObtenerPosts.class);
                startActivity(irPost);
            }
        });

        bt_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irComment = new Intent(Menu.this, ObtenerComments.class);
                startActivity(irComment);
            }
        });

        bt_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irAlbum = new Intent(Menu.this, ObtenerAlbums.class);
                startActivity(irAlbum);
            }
        });

        bt_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irUser = new Intent(Menu.this, ObtenerUsers.class);
                startActivity(irUser);
            }
        });

        bt_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}