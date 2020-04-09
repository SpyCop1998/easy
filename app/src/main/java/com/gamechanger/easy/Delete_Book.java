package com.gamechanger.easy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Delete_Book extends AppCompatActivity {
    EditText book_name;
    Button issue_btn;
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete__book);
        book_name=findViewById(R.id.book_del);
        issue_btn=findViewById(R.id.del_btn);
        db= new DatabaseHandler(this);
        issue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookName=book_name.getText().toString().trim();
                if(check(bookName))
                {
                    db.deleteBook(new Book(bookName));
                    Toast.makeText(getApplicationContext(),"Book Deleted",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Not found",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    boolean check(String bookName)
    {
        ArrayList<String> s=new ArrayList<>();
        List<Book> bookList=db.getALLBookName();
        for (Book b:bookList)
        {
            if(b.getBook_name().equals(bookName))
            {
                return true;
            }
        }
        return false;

    }
}
