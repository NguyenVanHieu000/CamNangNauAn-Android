package com.example.doan_appdaynauan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class AllFoodActivity extends AppCompatActivity implements foodForGVAdapter2.OnNoteListener2{
    TextView name;
    ActionBar actionBar;
    RecyclerView recyclerView;
    ArrayList<foodForGV> arrayList;
    foodForGVAdapter2 foodForGVAdapter2;
    foodForGV food;
    Context context;
    int value;
    Utils utils;
    DBHelper dbHelper;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_food);
        utils = new Utils(getContext());
        dbHelper = new DBHelper(getApplicationContext());
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        name = findViewById(R.id.titleFavorite);
        name.setText(intent.getStringExtra("name"));
        value = intent.getIntExtra("value",1);

        switch (value)
        {
            case 1:
                arrayList = new ArrayList<>();
                arrayList = dbHelper.getALLFood1();
                break;
            case 2:
                arrayList = new ArrayList<>();
                arrayList = dbHelper.getALLFood2();
                break;
            case 3:
                arrayList = new ArrayList<>();
                arrayList = dbHelper.getALLFood3();
                break;
            case 4:
                arrayList = new ArrayList<>();
                arrayList = dbHelper.getALLFood4();
                break;
        }

        recyclerView = findViewById(R.id.RecycleViewFavoriteFood);

        foodForGVAdapter2 = new foodForGVAdapter2(AllFoodActivity.this,arrayList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(AllFoodActivity.this, RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(foodForGVAdapter2);

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
    public void onNoteClick2(int position) {

    }
}


