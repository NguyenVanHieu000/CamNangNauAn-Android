package com.example.doan_appdaynauan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements foodForGVAdapter2.OnNoteListener2 {
    ActionBar actionBar;
    SearchView searchView;
    ArrayList<foodForGV> arrayList;
    Utils utils;
    ListView listView;
    foodForGVAdapter2 foodForGVAdapter2;
    foodAdapter foodAdapter;
    DBHelper dbHelper;
    List<String> listData  = new ArrayList<>();
    Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        utils = new Utils(SearchActivity.this);
        dbHelper = new DBHelper(getApplicationContext());
        arrayList = dbHelper.getALLFood();
        searchView = findViewById(R.id.search_view);

        listView = findViewById(R.id.listView_search);
        foodAdapter = new foodAdapter(SearchActivity.this, arrayList);
        listView.setAdapter(foodAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                foodForGV modelFurniture = arrayList.get((int)listView.getSelectedItemId());
                Intent intent = new Intent(SearchActivity.this,InformationFood.class);
                intent.putExtra("name", arrayList.get(position).getName());
                intent.putExtra("title", arrayList.get(position).getTitle());
                intent.putExtra("resource", arrayList.get(position).getResources());
                intent.putExtra("process", arrayList.get(position).getProcessing());
                intent.putExtra("image", arrayList.get(position).getImage());
                intent.putExtra("id", arrayList.get(position).getId());
                startActivity(intent);
            }
        });



        listView.setVisibility(View.GONE);

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        searchView.setIconifiedByDefault(true);
        searchView.setFocusable(true);
        searchView.setIconified(false);
        searchView.requestFocusFromTouch();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchFurniture(newText);
                return false;
            }
        });

    }
    private void searchFurniture(String newText) {
        ArrayList<foodForGV> tmp = new ArrayList<>();
        for (foodForGV furniture : dbHelper.getALLFood()) {
            if (furniture.getName().toLowerCase().contains(newText.toLowerCase())) {
                tmp.add(furniture);
            }
        }
//        Toast.makeText(this, tmp.size() + "", Toast.LENGTH_SHORT).show();
        if (tmp.size() > 0) {
            foodAdapter.clear();
            foodAdapter.addAll(tmp);
            foodAdapter.notifyDataSetChanged();
            listView.setVisibility(View.VISIBLE);
        }
        if (newText.isEmpty()) {
            listView.setVisibility(View.GONE);
        }
    }

    public void hideSoftKeyboard(View view) {
        InputMethodManager imm
                = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
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