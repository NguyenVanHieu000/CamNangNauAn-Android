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

    public class foodAdapter extends ArrayAdapter<foodForGV> {
        public foodAdapter(@NonNull  Context context, @NonNull List<foodForGV> object)
        {
            super(context,0,object);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertview, @NonNull ViewGroup parent){
            foodForGV fd = getItem(position);
            convertview = LayoutInflater.from(getContext()).inflate(R.layout.layout_gridview_itemfood2,parent,false);
            ImageView imageView;
            TextView textView,title;

            textView = convertview.findViewById(R.id.gridview_item_namefood2);
            imageView = convertview.findViewById(R.id.gridview_item_food2);
            title = convertview.findViewById(R.id.gridview_item_titlefood2);

            textView.setText(fd.getName());
            imageView.setImageBitmap(fd.convertStringToBitmapFromAccessCategories(getContext(),fd.getImage()));
            title.setText(fd.getTitle());

            return  convertview;
        }
        public interface OnNoteListener2{
            void onNoteClick2(int position);
        }
    }


