package com.gamechanger.easy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLoginActivity extends AppCompatActivity {
    EditText id,pass;
    Button login;
    String def_id,def_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        def_id="Divya";
        def_pass="123";
        id=findViewById(R.id.admin_id);
        pass=findViewById(R.id.admi_pass);
        login=findViewById(R.id.admin_log);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String i=id.getText().toString().trim();
                String p=pass.getText().toString().trim();
                if(def_id.equals(i) && def_pass.equals(p))
                {
                    startActivity(new Intent(getApplicationContext(),Admin_Dashboard_Activity.class));
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Wrong..",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
