package com.example.doan_appdaynauan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class foodForRCVAdapter extends RecyclerView.Adapter<foodForRCVAdapter.FViewHolder3> {
    Context context;
    foodForRCVAdapter.OnNoteListener3 monNoteListener;
    ArrayList<foodForGV> arrayList;
    FavoriteActivity favoriteActivity;
    DBHelper dbHelper;
    private ViewBinderHelper viewBinderHelper = new ViewBinderHelper();

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public foodForRCVAdapter(@NonNull ArrayList<foodForGV> arrayList, foodForRCVAdapter.OnNoteListener3 onNoteListener) {
        this.arrayList = arrayList;
        this.monNoteListener = onNoteListener;
    }

    public foodForRCVAdapter(@NonNull Context context,@NonNull ArrayList<foodForGV> arrayList, foodForRCVAdapter.OnNoteListener3 onNoteListener) {
        this.context = context;
        this.arrayList = arrayList;
        this.monNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public foodForRCVAdapter.FViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listview_itemfood,parent,false);
        return new foodForRCVAdapter.FViewHolder3(convertView, monNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull foodForRCVAdapter.FViewHolder3 holder, int position) {
        foodForGV fViewHolder = arrayList.get(position);
        holder.imageView.setImageBitmap(fViewHolder.convertStringToBitmapFromAccessCategories(getContext(),fViewHolder.getImage()));
        holder.textView.setText(fViewHolder.getName());
        holder.titleView.setText(fViewHolder.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(), InformationFood.class);
//                intent.putExtra("name", arrayList.get(position).getName());
//                intent.putExtra("title", arrayList.get(position).getTitle());
//                intent.putExtra("resource", arrayList.get(position).getResources());
//                intent.putExtra("process", arrayList.get(position).getProcessing());
//                intent.putExtra("image", arrayList.get(position).getImage());
//                intent.putExtra("id", arrayList.get(position).getId());
//                view.getContext().startActivity(intent);
//
////        Toast.makeText(getContext(), arrayList.get(position).getName()+"", Toast.LENGTH_SHORT).show();

            }
        });


        viewBinderHelper.bind(holder.swipeRevealLayout, String.valueOf(fViewHolder.getId()));

        holder.btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                arrayList.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                dbHelper = new DBHelper(getContext());
                dbHelper.insertFav(arrayList);
                saveData(arrayList);
            }
        });
        holder.btnXem.setOnClickListener(new View.OnClickListener() {
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

    public void saveData(ArrayList<foodForGV> arr) {

//        arrlst = dbHelper.getALLFav();
        // method for saving the data in array list.
        // creating a variable for storing data in
        // shared preferences.
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences", context.MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // creating a new variable for gson.
        Gson gson = new Gson();

        // getting data from gson and storing it in a string.
        String json = gson.toJson(arr);

        // below line is to save data in shared
        // prefs in the form of string.
        editor.putString("courses", json);

        // below line is to apply changes
        // and save data in shared prefs.
        editor.apply();

        // after saving data we are displaying a toast message.
        // Toast.makeText(this, "Saved Array List to Shared preferences. ", Toast.LENGTH_SHORT).show();
    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class FViewHolder3 extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView textView;
        TextView titleView;
        SwipeRevealLayout swipeRevealLayout;
        ConstraintLayout constraintLayout;
        Button btnXoa,btnXem;
        foodForRCVAdapter.OnNoteListener3 onNoteListener;
        public FViewHolder3(@NonNull View itemView, foodForRCVAdapter.OnNoteListener3 onNoteListener) {
            super(itemView);

            textView = itemView.findViewById(R.id.listview_item_namefood);
            imageView = itemView.findViewById(R.id.listview_item_food);
            titleView = itemView.findViewById(R.id.listview_item_titlefood);
            btnXoa = itemView.findViewById(R.id.btnXoaFav);
            btnXem = itemView.findViewById(R.id.btnXemFav);
            swipeRevealLayout = itemView.findViewById(R.id.Swipe_layout);
            constraintLayout = itemView.findViewById(R.id.main_swipe);
            this.onNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick3(getAdapterPosition());
        }
    }
    public interface OnNoteListener3{
        void onNoteClick3(int position);
    }
}


