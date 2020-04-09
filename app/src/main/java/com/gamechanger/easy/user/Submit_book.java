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

public class Submit_book extends AppCompatActivity {
    EditText nameBook;
    Button sub_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_book);
        nameBook=findViewById(R.id.subName);
        sub_btn=findViewById(R.id.Submit);
        final DatabaseHandler databaseHandler=new DatabaseHandler(this);
        sub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String book=nameBook.getText().toString().trim();
                if (book.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Write Something",Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseHandler.addBook(new Book(book));
                    Toast.makeText(getApplicationContext(), "Submitted..", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
