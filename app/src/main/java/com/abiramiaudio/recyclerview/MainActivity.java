package com.abiramiaudio.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Book> list = new ArrayList<Book>();
    RecyclerView recyclerView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list.add(new Book("32Mnz5bOY70", R.drawable.playicon));
        list.add(new Book("XdTozH06RfU", R.drawable.playicon));
        list.add(new Book("khnnaXzSl4M", R.drawable.playicon));
        list.add(new Book("HdiK3VmSlPo", R.drawable.playicon));
        list.add(new Book("3PVy4tFjITY", R.drawable.playicon));
        list.add(new Book("aKZELKrZP8U", R.drawable.playicon));


     //   list.add(new Book("sN8Mrexoi9Q", R.drawable.playicon));
//        list.add(new Book("xgMlXQ5Hk3Y", R.drawable.playicon));
//        list.add(new Book("63Ipzp9U_bU", R.drawable.playicon));
//        list.add(new Book("A2_6mI7drVQ", R.drawable.playicon));
//        list.add(new Book("om42hY4A5Qg", R.drawable.playicon));
//        list.add(new Book("XMh3nbkd-hg", R.drawable.playicon));


        recyclerView = (RecyclerView)findViewById(R.id.rc);
        MyAdapter myAdapter = new MyAdapter(this,list);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(myAdapter);


    }
}
