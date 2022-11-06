package com.example.lab8;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class DadJoke extends AppCompatActivity {
    DrawerLayout drawer_layout;
    NavigationView nav_view;
    Toolbar myToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dad_joke);

        drawer_layout = findViewById(R.id.drawer_layout);
        nav_view = findViewById(R.id.nav_view);
        myToolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer_layout, myToolbar, R.string.open, R.string.close);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();

        nav_view.setNavigationItemSelectedListener(item -> {
            drawer_layout.closeDrawer(GravityCompat.START);
            switch (item.getItemId()) {
                case R.id.home:
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.dadjoke:
                    Toast.makeText(DadJoke.this, "Joke Clicked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.exit:
                    finishAffinity();

            }
            return (true);
        });
    }
}
