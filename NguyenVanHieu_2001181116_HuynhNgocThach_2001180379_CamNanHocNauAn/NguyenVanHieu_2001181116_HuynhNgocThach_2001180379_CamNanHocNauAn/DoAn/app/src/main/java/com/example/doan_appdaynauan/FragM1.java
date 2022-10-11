package com.example.doan_appdaynauan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Switch;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragM1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragM1 extends Fragment implements foodForGVAdapter.OnNoteListener, foodForGVAdapter2.OnNoteListener2,View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragM1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragM1.
     */
    // TODO: Rename and change types and number of parameters
    public static FragM1 newInstance(String param1, String param2) {
        FragM1 fragment = new FragM1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    Button button1,button2,button3,button4;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }
    GridView gridView;
    foodForGVAdapter foodForGVAdapter1;
    foodForGVAdapter2 foodForGVAdapter2;
    ArrayList<foodForGV> arrayList1,arrayList2,arrayList3,arrayList4;
    ArrayList<foodForGV> test1,test2,test3,test4;
    foodForGV food;
    RecyclerView recyclerView1,recyclerView2,recyclerView3,recyclerView4;
    foodForGVAdapter.OnNoteListener onNoteListener;
    DBHelper dbHelper;
    Context context;
    static String filename="database";
    Utils utils;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        food = new foodForGV(getContext());// Inflate the layout for this fragment
        dbHelper = new DBHelper(getContext());
        utils = new Utils(getContext());
        return inflater.inflate(R.layout.fragment_frag_m1, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        test1 = new ArrayList<>();
        test2 = new ArrayList<>();
        test3 = new ArrayList<>();
        test4 = new ArrayList<>();
        Random random = new Random();
        ArrayList<Integer> lstInt1, lstInt2,lstInt3,lstInt4;
        int count = 0;
//        PK1 : Món ngon mỗi ngày
        recyclerView1 = view.findViewById(R.id.recyleview1);
        arrayList1 = dbHelper.getALLFood1();
        lstInt1 = new ArrayList<>();
        do {
            int j = random.nextInt(7) + 1;
            if(test1 == null)
            {
                foodForGV f = new foodForGV();
                f.image = arrayList1.get(j).getImage();
                f.name = arrayList1.get(j).getName();
                f.title = arrayList1.get(j).getTitle();
                f.processing = arrayList1.get(j).getProcessing();
                f.resources = arrayList1.get(j).getResources();
                f.id = arrayList1.get(j).getId();
                test1.add(f);
                count++;
                lstInt1.add(j);
            }
            else
            {
                int flag = 0;
                for (int ob : lstInt1)
                {
                    if(ob == j)
                    {
                        flag = 1;
                    }
                }
                if(flag == 0)
                {
                    foodForGV f = new foodForGV();
                    f.image = arrayList1.get(j).getImage();
                    f.name = arrayList1.get(j).getName();
                    f.title = arrayList1.get(j).getTitle();
                    f.processing = arrayList1.get(j).getProcessing();
                    f.resources = arrayList1.get(j).getResources();
                    f.id = arrayList1.get(j).getId();
                    test1.add(f);
                    count++;
                    lstInt1.add(j);
                }
            }

        }
        while (count < 5);

        foodForGVAdapter1 = new foodForGVAdapter(getContext(),test1,this);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false));
        recyclerView1.setAdapter(foodForGVAdapter1);


//        PK2 : Đồ uống giải khát
        recyclerView2 = view.findViewById(R.id.recyleview2);
        arrayList2 = dbHelper.getALLFood2();
        lstInt2 = new ArrayList<>();
        int count2 = 0;
        do {
            int j = random.nextInt(6) + 1;
            if(test2 == null)
            {
                foodForGV f = new foodForGV();
                f.image = arrayList2.get(j).getImage();
                f.name = arrayList2.get(j).getName();
                f.title = arrayList2.get(j).getTitle();
                f.processing = arrayList2.get(j).getProcessing();
                f.resources = arrayList2.get(j).getResources();
                f.id = arrayList2.get(j).getId();
                test2.add(f);
                count2++;
                lstInt2.add(j);
            }
            else
            {
                int flag = 0;
                for (int ob : lstInt2)
                {
                    if(ob == j)
                    {
                        flag = 1;
                    }
                }
                if(flag == 0)
                {
                    foodForGV f = new foodForGV();
                    f.image = arrayList2.get(j).getImage();
                    f.name = arrayList2.get(j).getName();
                    f.title = arrayList2.get(j).getTitle();
                    f.processing = arrayList2.get(j).getProcessing();
                    f.resources = arrayList2.get(j).getResources();
                    f.id = arrayList2.get(j).getId();
                    test2.add(f);
                    count2++;
                    lstInt2.add(j);
                }
            }

        }
        while (count2 < 5);

        foodForGVAdapter1 = new foodForGVAdapter(getContext(),test2,this);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false));
        recyclerView2.setAdapter(foodForGVAdapter1);

//        PK3 : Món ăn đặc biệt
        recyclerView3 = view.findViewById(R.id.recyleview3);
        arrayList3 = dbHelper.getALLFood3();

        lstInt3 = new ArrayList<>();
        int count3 = 0;
        do {
            int j = random.nextInt(6) + 1;
            if(test3 == null)
            {
                foodForGV f = new foodForGV();
                f.image = arrayList3.get(j).getImage();
                f.name = arrayList3.get(j).getName();
                f.title = arrayList3.get(j).getTitle();
                f.processing = arrayList3.get(j).getProcessing();
                f.resources = arrayList3.get(j).getResources();
                f.id = arrayList3.get(j).getId();
                test3.add(f);
                count3++;
                lstInt3.add(j);
            }
            else
            {
                int flag = 0;
                for (int ob : lstInt3)
                {
                    if(ob == j)
                    {
                        flag = 1;
                    }
                }
                if(flag == 0)
                {
                    foodForGV f = new foodForGV();
                    f.image = arrayList3.get(j).getImage();
                    f.name = arrayList3.get(j).getName();
                    f.title = arrayList3.get(j).getTitle();
                    f.processing = arrayList3.get(j).getProcessing();
                    f.resources = arrayList3.get(j).getResources();
                    f.id = arrayList3.get(j).getId();
                    test3.add(f);
                    count3++;
                    lstInt3.add(j);
                }
            }

        }
        while (count3 < 5);

        foodForGVAdapter2 = new foodForGVAdapter2(getContext(),test3,this);
        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
        recyclerView3.setAdapter(foodForGVAdapter2);

//        PK4 : Món tráng miệng
        recyclerView4 = view.findViewById(R.id.recyleview4);
        arrayList4 = dbHelper.getALLFood4();

        lstInt4 = new ArrayList<>();
        int count4 = 0;
        do {
            int j = random.nextInt(6) + 1;
            if(test4 == null)
            {
                foodForGV f = new foodForGV();
                f.image = arrayList4.get(j).getImage();
                f.name = arrayList4.get(j).getName();
                f.title = arrayList4.get(j).getTitle();
                f.processing = arrayList4.get(j).getProcessing();
                f.resources = arrayList4.get(j).getResources();
                f.id = arrayList4.get(j).getId();
                test4.add(f);
                count4++;
                lstInt4.add(j);
            }
            else
            {
                int flag = 0;
                for (int ob : lstInt4)
                {
                    if(ob == j)
                    {
                        flag = 1;
                    }
                }
                if(flag == 0)
                {
                    foodForGV f = new foodForGV();
                    f.image = arrayList4.get(j).getImage();
                    f.name = arrayList4.get(j).getName();
                    f.title = arrayList4.get(j).getTitle();
                    f.processing = arrayList4.get(j).getProcessing();
                    f.resources = arrayList4.get(j).getResources();
                    f.id = arrayList4.get(j).getId();
                    test4.add(f);
                    count4++;
                    lstInt4.add(j);
                }
            }

        }
        while (count4 < 5);

        foodForGVAdapter2 = new foodForGVAdapter2(getContext(),test4,this);
        recyclerView4.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
        recyclerView4.setAdapter(foodForGVAdapter2);


        Button btn1 = (Button)view.findViewById(R.id.button_allFood_PK1);
        Button btn2 = (Button)view.findViewById(R.id.button_allFood_PK2);
        Button btn3 = (Button)view.findViewById(R.id.button_allFood_PK3);
        Button btn4 = (Button)view.findViewById(R.id.button_allFood_PK4);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId())
        {
            case R.id.button_allFood_PK1 :
                intent = new Intent(getActivity(), AllFoodActivity.class);
                intent.putExtra("name", "Món ngon mỗi ngày");
                intent.putExtra("value",1);
                startActivity(intent);
                break;
            case R.id.button_allFood_PK2 :
                intent = new Intent(getActivity(), AllFoodActivity.class);
                intent.putExtra("name", "Đồ uống giải khát");
                intent.putExtra("value",2);
                startActivity(intent);
                break;
            case R.id.button_allFood_PK3 :
                intent = new Intent(getActivity(), AllFoodActivity.class);
                intent.putExtra("name", "Món ăn đặc biệt");
                intent.putExtra("value",3);
                startActivity(intent);
                break;
            case R.id.button_allFood_PK4 :
                intent = new Intent(getActivity(), AllFoodActivity.class);
                intent.putExtra("name", "Tráng miêng");
                intent.putExtra("value",4);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onNoteClick(int position) {


    }

    @Override
    public void onNoteClick2(int position) {


    }

    public void WriteToFileInternal(ArrayList<foodForGV> arrayList){
        try {
            File file = new File(context.getFilesDir(), filename);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new
                    ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(arrayList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<foodForGV> LoadFileInternal(){
        ArrayList<foodForGV> arrayList = new ArrayList<>();
        try {
            File file = new File(context.getFilesDir(), filename);
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new
                    ObjectInputStream(fileInputStream);
            arrayList = (ArrayList<foodForGV>)
                    objectInputStream.readObject();
            Log.d("FurnitureApp", arrayList.size()+"");
            return arrayList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}