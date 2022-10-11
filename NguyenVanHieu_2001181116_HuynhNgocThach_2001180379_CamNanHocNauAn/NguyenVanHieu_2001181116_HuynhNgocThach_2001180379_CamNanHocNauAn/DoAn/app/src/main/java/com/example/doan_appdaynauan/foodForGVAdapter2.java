package com.example.doan_appdaynauan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class foodForGVAdapter2 extends RecyclerView.Adapter<foodForGVAdapter2.FViewHolder2> {
    Context context;
    OnNoteListener2 monNoteListener;
    ArrayList<foodForGV> arrayList = new ArrayList<>();

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public foodForGVAdapter2(@NonNull ArrayList<foodForGV> arrayList, OnNoteListener2 onNoteListener) {
        this.arrayList = arrayList;
        this.monNoteListener = onNoteListener;
    }

    public foodForGVAdapter2(@NonNull Context context,@NonNull ArrayList<foodForGV> arrayList, OnNoteListener2 onNoteListener) {
        this.context = context;
        this.arrayList = arrayList;
        this.monNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public foodForGVAdapter2.FViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_gridview_itemfood2,parent,false);
        return new FViewHolder2(convertView, monNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull foodForGVAdapter2.FViewHolder2 holder, int position) {
        foodForGV fViewHolder = arrayList.get(position);
        holder.imageView.setImageBitmap(fViewHolder.convertStringToBitmapFromAccessCategories(getContext(),fViewHolder.getImage()));
        holder.textView.setText(fViewHolder.getName());
        holder.titleView.setText(fViewHolder.getTitle());
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


            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class FViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView textView;
        TextView titleView;
        Button btn;
        OnNoteListener2 onNoteListener;
        public FViewHolder2(@NonNull View itemView, OnNoteListener2 onNoteListener) {
            super(itemView);

            textView = itemView.findViewById(R.id.gridview_item_namefood2);
            imageView = itemView.findViewById(R.id.gridview_item_food2);
            titleView = itemView.findViewById(R.id.gridview_item_titlefood2);
            this.onNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick2(getAdapterPosition());
        }
    }
    public interface OnNoteListener2{
        void onNoteClick2(int position);
    }
}
