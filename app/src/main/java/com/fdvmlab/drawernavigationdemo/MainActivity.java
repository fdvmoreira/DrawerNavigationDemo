package com.fdvmlab.drawernavigationdemo;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout = null;
    ActionBarDrawerToggle toggle = null;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //drawer
        drawerLayout = findViewById(R.id.drawerLayout);
        //init toggle
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        //add listener and sync state
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //Add the hamburger icon
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        //
        ((NavigationView) findViewById(R.id.navigationView)).setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                CharSequence itemName = null;

                switch (item.getItemId()) {
                    case R.id.m_item_view:
                        itemName = "Views";
                        break;
                    case R.id.m_item_like:
                        itemName = "Likes";
                        break;
                    case R.id.m_item_comment:
                        itemName = "Comments";
                        break;
                    case R.id.m_item_share:
                        itemName = "Shares";
                        break;
                    case R.id.m_item_popularity:
                        itemName = "Popularity";
                        break;
                    default:
                        itemName = "Unknown";
                }
                Toast.makeText(getApplicationContext(), itemName + " Item Selected", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) return true;

        return super.onOptionsItemSelected(item);
    }
}