package com.example.doan_appdaynauan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity implements foodForRCVAdapter.OnNoteListener3{
    ActionBar actionBar;
    public static ArrayList<foodForGV> arrayList,listFavToShared,list;
    RecyclerView recyclerView;
    foodForRCVAdapter foodForRCVAdapter;
    DBHelper dbHelper;
    public static ArrayList<foodForGV> arrlst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        loadData();
        setContentView(R.layout.activity_favorite);
        dbHelper = new DBHelper(getApplicationContext());
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        arrayList = dbHelper.getALLFav();
        recyclerView = findViewById(R.id.RecycleViewFavoriteFood);
        foodForRCVAdapter = new foodForRCVAdapter(FavoriteActivity.this, arrayList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(FavoriteActivity.this, RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(foodForRCVAdapter);

    }


    private void loadData() {
        // method to load arraylist from shared prefs
        // initializing our shared prefs with name as
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);

        // creating a variable for gson.
        Gson gson = new Gson();

        // below line is to get to string present from our
        // shared prefs if not present setting it as null.
        String json = sharedPreferences.getString("courses", null);

        // below line is to get the type of our array list.
        Type type = new TypeToken<ArrayList<foodForGV>>() {}.getType();

        // in below line we are getting data from gson
        // and saving it to our array list
        listFavToShared = gson.fromJson(json, type);

        // checking below if the array list is empty or not
        if (listFavToShared == null) {
            // if the array list is empty
            // creating a new array list.
            listFavToShared = new ArrayList<>();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public void onNoteClick3(int position) {

    }
}