//package com.example.doan_appdaynauan;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//
//import java.util.List;
//
//public class foodListViewAdapter extends ArrayAdapter<foodForGV> {
//    public foodListViewAdapter(@NonNull  Context context, @NonNull List<foodForGV> object)
//    {
//        super(context,0,object);
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//        foodForGV fd = getItem(position);
//        convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_listview_itemfood,parent,false);
//        ImageView imageView;
//        TextView textView,title;
//        Button btnXoa;
//
//        textView = convertView.findViewById(R.id.listview_item_namefood);
//        imageView = convertView.findViewById(R.id.list_item_food);
//        title = convertView.findViewById(R.id.listview_item_titlefood);
//        btnXoa = convertView.findViewById(R.id.btnXoaFav);
//
//        textView.setText(fd.getName());
//        imageView.setImageBitmap(fd.convertStringToBitmapFromAccessCategories(getContext(),fd.getImage()));
//        title.setText(fd.getTitle());
//
//        return  convertView;
//    }
//    public interface OnNoteListener2{
//        void onNoteClick2(int position);
//    }
//}

package com.example.doan_appdaynauan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class foodListViewAdapter extends ArrayAdapter<foodForGV> {
    public foodListViewAdapter(@NonNull  Context context, @NonNull List<foodForGV> object)
    {
        super(context,0,object);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertview, @NonNull ViewGroup parent){
        foodForGV fd = getItem(position);
        convertview = LayoutInflater.from(getContext()).inflate(R.layout.layout_listview_itemfood,parent,false);
        ImageView imageView;
        TextView textView,title;

        textView = convertview.findViewById(R.id.listview_item_namefood);
        imageView = convertview.findViewById(R.id.listview_item_food);
        title = convertview.findViewById(R.id.listview_item_titlefood);

        textView.setText(fd.getName());
        imageView.setImageBitmap(fd.convertStringToBitmapFromAccessCategories(getContext(),fd.getImage()));
        title.setText(fd.getTitle());

        return  convertview;
    }
    public interface OnNoteListener2{
        void onNoteClick2(int position);
    }
}
