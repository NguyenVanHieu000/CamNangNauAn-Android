package com.example.doan_appdaynauan;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class foodForGV {
    String name;
    int img,id;
    public Context context;
    String image;
    String title, processing,
            resources;

    public foodForGV(String name, String title, String resources, String processing, String image) {
        this.name = name;
        this.title = title;
        this.resources = resources;
        this.processing = processing;
        this.image = image;
    }
    public foodForGV(String name, String title, String resources, String processing, String image, int id) {
        this.name = name;
        this.title = title;
        this.resources = resources;
        this.processing = processing;
        this.image = image;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public foodForGV() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProcessing() {
        return processing;
    }

    public void setProcessing(String processing) {
        this.processing = processing;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public foodForGV(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public foodForGV(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public foodForGV(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public foodForGV(int img) {
        this.img = img;
    }

    @SuppressLint("StringFormatInvalid")

    public Bitmap convertStringToBitmapFromAccessCategories(Context context , String filename){

        AssetManager assetManager = context.getAssets();
        try {
            InputStream is = assetManager.open(filename);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
