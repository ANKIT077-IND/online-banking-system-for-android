package com.codewithankit.online;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Forgot_password extends AppCompatActivity {
    EditText et1;
    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        et1 = findViewById(R.id.et1);
        button1 = findViewById(R.id.button1);
    }

    public void reset_password(View view) {
        String mno = et1.getText().toString();
        sqliteclass db=new sqliteclass(this);

        Boolean checkuser=db.checkusername(mno);

        if (checkuser==true){
            Intent intent=new Intent(Forgot_password.this,Reset_Password.class);
            intent.putExtra("et1",mno);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "User Does Not Exists", Toast.LENGTH_SHORT).show();
        }



    }
}