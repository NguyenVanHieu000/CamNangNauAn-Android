package com.example.doan_appdaynauan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InformationFood extends AppCompatActivity {
    TextView namefood;
    TextView titlefood;
    TextView resourcefood;
    TextView processfood;
    ImageView imagefood,headImg;
    foodForGV f = new foodForGV(getContext());
    Utils utils;
    Context context;
    ActionBar actionBar;
    TextView idfood;
    String a;
    Button addFavorite;
    SharedPreferences sharedPreferences;
    DBHelper dbHelper;
    ArrayList<foodForGV> listFavToShared;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_food);


        dbHelper = new DBHelper(getApplicationContext());
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }



        Intent intent = getIntent();
        namefood = findViewById(R.id.titleFavorite);
        titlefood = findViewById(R.id.titlefood);
        resourcefood = findViewById(R.id.resourcefood);
        processfood = findViewById(R.id.processfood);
        imagefood = findViewById(R.id.imgfood);
        headImg = findViewById(R.id.head_Img);
        namefood.setText(intent.getStringExtra("name"));
        titlefood.setText(intent.getStringExtra("title"));
        resourcefood.setText(intent.getStringExtra("resource"));
        processfood.setText(intent.getStringExtra("process"));
        imagefood.setImageBitmap(f.convertStringToBitmapFromAccessCategories(getApplication(),intent.getStringExtra("image")));
        headImg.setImageBitmap(f.convertStringToBitmapFromAccessCategories(getApplication(),intent.getStringExtra("image")));


        loadData();
        addFavorite = findViewById(R.id.addFavorite);
        addFavorite.setOnClickListener(new View.OnClickListener() {
            int arrsize;
            @Override
            public void onClick(View view) {

                int flag = 0;

                foodForGV f = new foodForGV();
                f.id = intent.getIntExtra("id",0);
                f.name = intent.getStringExtra("name");
                f.title = intent.getStringExtra("title");
                f.resources = intent.getStringExtra("resource");
                f.processing = intent.getStringExtra("process");
                f.image = intent.getStringExtra("image");
                listFavToShared.add(f);
                dbHelper.insertFav(listFavToShared);
                saveData();
                Toast.makeText(getApplicationContext(), "Đã thêm " +  intent.getStringExtra("name") + " vao danh sach yeu thich",Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void saveData() {
        // method for saving the data in array list.
        // creating a variable for storing data in
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // creating a new variable for gson.
        Gson gson = new Gson();

        // getting data from gson and storing it in a string.
        String json = gson.toJson(listFavToShared);

        // below line is to save data in shared
        // prefs in the form of string.
        editor.putString("courses", json);

        // below line is to apply changes
        // and save data in shared prefs.
        editor.apply();

        // after saving data we are displaying a toast message.
//        Toast.makeText(this, "Saved Array List to Shared preferences. ", Toast.LENGTH_SHORT).show();
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


}