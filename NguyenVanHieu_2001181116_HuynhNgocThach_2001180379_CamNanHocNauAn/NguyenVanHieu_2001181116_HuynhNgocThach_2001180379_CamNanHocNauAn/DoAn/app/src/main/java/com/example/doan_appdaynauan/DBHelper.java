package com.example.doan_appdaynauan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBHelper {
    Context context;
    String dbName = "FoodDB.db";
    foodForGV food;
    Utils utils;
    public DBHelper(Context context) {
        this.context = context;
        utils = new Utils(context);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private SQLiteDatabase openDB() {
        return context.openOrCreateDatabase(dbName, Context.MODE_PRIVATE, null);
    }
    private void closeDB(SQLiteDatabase db) {
        db.close();
    }

    public  void dropTable()
    {
        SQLiteDatabase db = openDB();
        String sql1 = "DROP TABLE IF EXISTS tblFood1";
        String sql2 = "DROP TABLE IF EXISTS tblFood2";
        String sql3 = "DROP TABLE IF EXISTS tblFood3";
        String sql4 = "DROP TABLE IF EXISTS tblFood4";
        String sql5 = "DROP TABLE IF EXISTS tblFood5";
        String sql6 = "DROP TABLE IF EXISTS tblFav";
        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);
        db.execSQL(sql5);
        db.execSQL(sql6);

        closeDB(db);

    }

    public void createTable() {
        SQLiteDatabase db = openDB();
        String sqlFood1 = "CREATE TABLE IF NOT EXISTS tblFood1 (" +
                " ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " Name TEXT," +
                " Title TEXT," +
                " Resource TEXT," +
                " Proccesing TEXT," +
                " Image TEXT);";
        String sqlFood2 = "CREATE TABLE IF NOT EXISTS tblFood2 (" +
                " ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " Name TEXT," +
                " Title TEXT," +
                " Resource TEXT," +
                " Proccesing TEXT," +
                " Image TEXT);";
        String sql3 = "CREATE TABLE IF NOT EXISTS tblFood3 (" +
                " ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " Name TEXT," +
                " Title TEXT," +
                " Resource TEXT," +
                " Proccesing TEXT," +
                " Image TEXT);";
        String sqlFood4 = "CREATE TABLE IF NOT EXISTS tblFood4 (" +
                " ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " Name TEXT," +
                " Title TEXT," +
                " Resource TEXT," +
                " Proccesing TEXT," +
                " Image TEXT);";
        String sqlFood5 = "CREATE TABLE IF NOT EXISTS tblFood5 (" +
                " ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " Name TEXT," +
                " Title TEXT," +
                " Resource TEXT," +
                " Proccesing TEXT," +
                " Image TEXT);";
        String sqlFav = "CREATE TABLE IF NOT EXISTS tblFav (" +
                " ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " Name TEXT," +
                " Title TEXT," +
                " Resource TEXT," +
                " Proccesing TEXT," +
                " Image TEXT);";
        db.execSQL(sqlFood1);
        db.execSQL(sqlFood2);
        db.execSQL(sql3);
        db.execSQL(sqlFood4);
        db.execSQL(sqlFood5);
        db.execSQL(sqlFav);

        closeDB(db);
    }

    public ArrayList<foodForGV> getALLFav() {
        SQLiteDatabase db = openDB();
        ArrayList<foodForGV> arr = new ArrayList<>();
        String sql = "select * from tblFav";
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    int id = csr.getInt(0);
                    String name = csr.getString(1);
                    String title = csr.getString(2);
                    String resource = csr.getString(3);
                    String proccesing = csr.getString(4);
                    String image = csr.getString(5);
                    arr.add(new
                            foodForGV(name, title, resource, proccesing, image,id));
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }

    public void insertFav(ArrayList<foodForGV> f)
    {
        ArrayList<foodForGV> arrCa = f;
        SQLiteDatabase db = openDB();
        for (foodForGV ca : arrCa) {
            ContentValues cv = new ContentValues();
            cv.put("ID",ca.getId());
            cv.put("Name", ca.getName());
            cv.put("Title", ca.getTitle());
            cv.put("Resource", ca.getResources());
            cv.put("Proccesing", ca.getProcessing());
            cv.put("Image", ca.getImage());
            db.insert("tblFav", null, cv);
        }
        closeDB(db);
    }


    public ArrayList<foodForGV> getALLFood1() {
        SQLiteDatabase db = openDB();
        ArrayList<foodForGV> arr = new ArrayList<>();
        String sql = "select * from tblFood1";
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    int id = csr.getInt(0);
                    String name = csr.getString(1);
                    String title = csr.getString(2);
                    String resource = csr.getString(3);
                    String proccesing = csr.getString(4);
                    String image = csr.getString(5);
                    arr.add(new
                            foodForGV(name, title, resource, proccesing, image,id));
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }

    public void insertFood1()
    {
        ArrayList<foodForGV> arrCa = utils.initFoodForGV1_Ultis();
        SQLiteDatabase db = openDB();
        for (foodForGV ca : arrCa) {
            ContentValues cv = new ContentValues();
            cv.put("ID",ca.getId());
            cv.put("Name", ca.getName());
            cv.put("Title", ca.getTitle());
            cv.put("Resource", ca.getResources());
            cv.put("Proccesing", ca.getProcessing());
            cv.put("Image", ca.getImage());
            db.insert("tblFood1", null, cv);
        }
        closeDB(db);
    }

    public ArrayList<foodForGV> getALLFood2() {
        SQLiteDatabase db = openDB();
        ArrayList<foodForGV> arr = new ArrayList<>();
        String sql = "select * from tblFood2";
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    int id = csr.getInt(0);
                    String name = csr.getString(1);
                    String title = csr.getString(2);
                    String resource = csr.getString(3);
                    String proccesing = csr.getString(4);
                    String image = csr.getString(5);
                    arr.add(new
                            foodForGV(name, title, resource, proccesing, image, id));
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }

    public void insertFood2()
    {
        ArrayList<foodForGV> arrCa = utils.initFoodForGV2_Ultis();
        SQLiteDatabase db = openDB();
        for (foodForGV ca : arrCa) {
            ContentValues cv = new ContentValues();
            cv.put("ID",ca.getId());
            cv.put("Name", ca.getName());
            cv.put("Title", ca.getTitle());
            cv.put("Resource", ca.getResources());
            cv.put("Proccesing", ca.getProcessing());
            cv.put("Image", ca.getImage());
            db.insert("tblFood2", null, cv);
        }
        closeDB(db);
    }

    public ArrayList<foodForGV> getALLFood3() {
        SQLiteDatabase db = openDB();
        ArrayList<foodForGV> arr = new ArrayList<>();
        String sql = "select * from tblFood3";
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    int id = csr.getInt(0);
                    String name = csr.getString(1);
                    String title = csr.getString(2);
                    String resource = csr.getString(3);
                    String proccesing = csr.getString(4);
                    String image = csr.getString(5);
                    arr.add(new
                            foodForGV(name, title, resource, proccesing, image, id));
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }

    public void insertFood3()
    {
        ArrayList<foodForGV> arrCa = utils.initFoodForGV3_Ultis();
        SQLiteDatabase db = openDB();
        for (foodForGV ca : arrCa) {
            ContentValues cv = new ContentValues();
            cv.put("ID",ca.getId());
            cv.put("Name", ca.getName());
            cv.put("Title", ca.getTitle());
            cv.put("Resource", ca.getResources());
            cv.put("Proccesing", ca.getProcessing());
            cv.put("Image", ca.getImage());
            db.insert("tblFood3", null, cv);
        }
        closeDB(db);
    }

    public ArrayList<foodForGV> getALLFood4() {
        SQLiteDatabase db = openDB();
        ArrayList<foodForGV> arr = new ArrayList<>();
        String sql = "select * from tblFood4";
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    int id = csr.getInt(0);
                    String name = csr.getString(1);
                    String title = csr.getString(2);
                    String resource = csr.getString(3);
                    String proccesing = csr.getString(4);
                    String image = csr.getString(5);
                    arr.add(new
                            foodForGV(name, title, resource, proccesing, image, id));
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }

    public void insertFood4()
    {
        ArrayList<foodForGV> arrCa = utils.initFoodForGV4_Utils();
        SQLiteDatabase db = openDB();
        for (foodForGV ca : arrCa) {
            ContentValues cv = new ContentValues();
            cv.put("ID",ca.getId());
            cv.put("Name", ca.getName());
            cv.put("Title", ca.getTitle());
            cv.put("Resource", ca.getResources());
            cv.put("Proccesing", ca.getProcessing());
            cv.put("Image", ca.getImage());
            db.insert("tblFood4", null, cv);
        }
        closeDB(db);
    }

    ArrayList<foodForGV> arrCa;

    public void insertFood5()
    {

        arrCa = utils.initFoodForGV1_Ultis();
        SQLiteDatabase db = openDB();
        for (foodForGV ca : arrCa) {
            ContentValues cv = new ContentValues();
            cv.put("ID",ca.getId());
            cv.put("Name", ca.getName());
            cv.put("Title", ca.getTitle());
            cv.put("Resource", ca.getResources());
            cv.put("Proccesing", ca.getProcessing());
            cv.put("Image", ca.getImage());
            db.insert("tblFood5", null, cv);
        }
        //
        arrCa = utils.initFoodForGV2_Ultis();
        for (foodForGV ca : arrCa) {
            ContentValues cv = new ContentValues();
            cv.put("ID",ca.getId());
            cv.put("Name", ca.getName());
            cv.put("Title", ca.getTitle());
            cv.put("Resource", ca.getResources());
            cv.put("Proccesing", ca.getProcessing());
            cv.put("Image", ca.getImage());
            db.insert("tblFood5", null, cv);
        }
        arrCa = utils.initFoodForGV3_Ultis();
        for (foodForGV ca : arrCa) {
            ContentValues cv = new ContentValues();
            cv.put("ID",ca.getId());
            cv.put("Name", ca.getName());
            cv.put("Title", ca.getTitle());
            cv.put("Resource", ca.getResources());
            cv.put("Proccesing", ca.getProcessing());
            cv.put("Image", ca.getImage());
            db.insert("tblFood5", null, cv);
        }
        arrCa = utils.initFoodForGV4_Utils();
        for (foodForGV ca : arrCa) {
            ContentValues cv = new ContentValues();
            cv.put("ID",ca.getId());
            cv.put("Name", ca.getName());
            cv.put("Title", ca.getTitle());
            cv.put("Resource", ca.getResources());
            cv.put("Proccesing", ca.getProcessing());
            cv.put("Image", ca.getImage());
            db.insert("tblFood5", null, cv);

        }
        closeDB(db);
    }


    String sql;
    Cursor csr;

    public ArrayList<foodForGV> getALLFood() {
        SQLiteDatabase db = openDB();
        ArrayList<foodForGV> arr = new ArrayList<>();
        sql = new String();
        sql = "select * from tblFood5";
        csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    int id = csr.getInt(0);
                    String name = csr.getString(1);
                    String title = csr.getString(2);
                    String resource = csr.getString(3);
                    String proccesing = csr.getString(4);
                    String image = csr.getString(5);
                    arr.add(new
                            foodForGV(name, title, resource, proccesing, image, id));
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }

}
