package com.example.doan_appdaynauan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class foodForGVAdapter extends RecyclerView.Adapter<foodForGVAdapter.FViewHolder> {


    Context context;
    OnNoteListener monNoteListener;
    ArrayList<foodForGV> arrayList = new ArrayList<>();


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public foodForGVAdapter(@NonNull ArrayList<foodForGV> arrayList, OnNoteListener onNoteListener) {
        this.arrayList = arrayList;
        this.monNoteListener = onNoteListener;
    }

    public foodForGVAdapter(@NonNull Context context,@NonNull ArrayList<foodForGV> arrayList, OnNoteListener onNoteListener) {
        this.context = context;
        this.arrayList = arrayList;
        this.monNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public FViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_girdview_itemfood,parent,false);
        return new FViewHolder(convertView, monNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull FViewHolder holder, int position) {

        foodForGV fViewHolder = arrayList.get(position);
        holder.imageView.setImageBitmap(fViewHolder.convertStringToBitmapFromAccessCategories(getContext(),fViewHolder.getImage()));
        holder.textView.setText(fViewHolder.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), InformationFood.class);
                intent.putExtra("name", arrayList.get(position).getName());
                intent.putExtra("title", arrayList.get(position).getTitle());
                intent.putExtra("resource", arrayList.get(position).getResources());
                intent.putExtra("process", arrayList.get(position).getProcessing());
                intent.putExtra("image", arrayList.get(position).getImage());
                intent.putExtra("id", arrayList.get(position).getId());
                view.getContext().startActivity(intent);

//        Toast.makeText(getContext(), random+"", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    class FViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView;
        OnNoteListener onNoteListener;
        public FViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);

            textView = itemView.findViewById(R.id.gridview_item_namefood);
            imageView = itemView.findViewById(R.id.gridview_item_food);
            this.onNoteListener = onNoteListener;
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }



}
