package com.example.doan_appdaynauan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MenuActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle hamburger;
    DBHelper dbHelper;
    Context context;
    TextView searchView;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        dbHelper = new DBHelper(MenuActivity.this);
//        dbHelper.createTable();
//        dbHelper.dropTable();
//        dbHelper.createTable();
//        dbHelper.insertFood1();
//        dbHelper.insertFood2();
//        dbHelper.insertFood3();
//        dbHelper.insertFood4();
//        dbHelper.insertFood5();


        searchView = findViewById(R.id.search_view);
        searchView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MenuActivity.this,SearchActivity.class);
                startActivity(intent);
            }

        });

        toolbar = findViewById(R.id.toolbar3);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);



        hamburger = new ActionBarDrawerToggle(MenuActivity.this,
                drawerLayout,
                toolbar,
                R.string.open, R.string.close);

        drawerLayout.addDrawerListener(hamburger);
//        display(R.id.mnu);
        hamburger.setHomeAsUpIndicator(R.drawable.ic_baseline_format_list_bulleted_24);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                display(item.getItemId());
                return false;
            }
        });

        Fragment fragment = new FragM1();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content, fragment);
        ft.commit();
    }


    Intent intent;
    public  void display(int pos)
    {
        Fragment fragment = null;
        String title = "";


        switch (pos){
            case R.id.mnuFavorite:

                intent = new Intent(MenuActivity.this, FavoriteActivity.class);
                startActivity(intent);


                break;
            case R.id.mnuRate:

                break;
            case R.id.mnuInforApp:
                intent = new Intent(MenuActivity.this, AppInFoActivity.class);
                startActivity(intent);


                break;
        }


        drawerLayout.closeDrawers();


    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        hamburger.syncState();
    }
}