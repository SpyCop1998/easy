package com.gamechanger.easy;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Show_book_Activity extends AppCompatActivity {
    ListView listView;
    TextView textView;
    String[] names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_book_);
        DatabaseHandler db = new DatabaseHandler(this);
        //**
        textView=findViewById(R.id.textView1);
        listView=findViewById(R.id.listView);

        List<Book> bookList=db.getALLBookName();
        names=new String[1000];
        int i=0;
        ArrayList<String> s=new ArrayList<>();
        for (Book b:bookList)
        {
            s.add(b.getBook_name());
        }

        final ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,android.R.id.text1,s);
        listView.setAdapter(adapter);



    }

}
