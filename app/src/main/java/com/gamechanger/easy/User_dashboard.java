package com.gamechanger.easy;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gamechanger.easy.user.Issue_book;
import com.gamechanger.easy.user.Submit_book;

public class User_dashboard extends AppCompatActivity {
    Button see_btn,iss_btn,sub_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        see_btn=findViewById(R.id.seeBooks_btn);
        iss_btn=findViewById(R.id.issue_btn);
        sub_btn=findViewById(R.id.submit_btn);

        see_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Show_book_Activity.class));
            }
        });

        iss_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Issue_book.class));
            }
        });

        sub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Submit_book.class));
            }
        });

    }
}
