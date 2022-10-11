package com.example.doan_appdaynauan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    public static ArrayList<foodForGV> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData();
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        dbHelper = new DBHelper(MainActivity.this);
        dbHelper.dropTable();
        dbHelper.createTable();
        dbHelper.insertFood1();
        dbHelper.insertFood2();
        dbHelper.insertFood3();
        dbHelper.insertFood4();
        dbHelper.insertFood5();
        dbHelper.insertFav(arrayList);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);
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
        arrayList = gson.fromJson(json, type);

        // checking below if the array list is empty or not
        if (arrayList == null) {
            // if the array list is empty
            // creating a new array list.
            arrayList = new ArrayList<>();
        }
    }
}