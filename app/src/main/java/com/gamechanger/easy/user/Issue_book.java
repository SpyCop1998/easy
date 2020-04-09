package com.gamechanger.easy.user;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gamechanger.easy.Book;
import com.gamechanger.easy.DatabaseHandler;
import com.gamechanger.easy.R;

import java.util.ArrayList;
import java.util.List;

public class Issue_book extends AppCompatActivity {
    EditText book_name;
    Button issue_btn;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_book);
        book_name=findViewById(R.id.book_issue);
        issue_btn=findViewById(R.id.btn_issue);
        db= new DatabaseHandler(this);
        issue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookName=book_name.getText().toString().trim();
                if(check(bookName))
                {
                    db.deleteBook(new Book(bookName));
                    Toast.makeText(getApplicationContext(),"Issued",Toast.LENGTH_SHORT).show();
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
