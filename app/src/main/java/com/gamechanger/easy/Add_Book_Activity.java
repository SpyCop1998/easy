package com.gamechanger.easy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Add_Book_Activity extends AppCompatActivity {
    Button add;
    String book;
    EditText book_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__book_);
        add=findViewById(R.id.add_in_btn);
        book_name=findViewById(R.id.book_name);

        final DatabaseHandler databaseHandler=new DatabaseHandler(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                book=book_name.getText().toString().trim();
                if(book.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Write Something",Toast.LENGTH_SHORT).show();
                }else {
                    databaseHandler.addBook(new Book(book));
                    Toast.makeText(getApplicationContext(), "ADDED", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
