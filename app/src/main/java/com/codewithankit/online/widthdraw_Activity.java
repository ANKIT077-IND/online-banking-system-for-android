package com.codewithankit.online;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class widthdraw_Activity extends AppCompatActivity {
    TextView textView16, textView17, textView18,textView19;
    EditText editText36, editText37;
    Button button13, button14;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widthdraw_);

        textView16 = findViewById(R.id.textview16);
        textView17 = findViewById(R.id.textview17);
        textView18 = findViewById(R.id.textview18);
        textView19 = findViewById(R.id.textview19);
        editText36 = findViewById(R.id.edit_text36);
        editText37 = findViewById(R.id.edit_text37);

        button13 = findViewById(R.id.btn13);
        button14 = findViewById(R.id.btn14);
    }

    public void withdrawshowdetail(View view) {
        new openaccount(this);
        openaccount db = new openaccount(this);

        String Mobile=editText36.getText().toString();
        Cursor withdraw = db.withdrawshowdetail(Mobile);
        while (withdraw.moveToNext()) {
            textView17.setText(withdraw.getString(1));
            textView18.setText(withdraw.getString(12));


        }

    }

    public void withdrawAmount(View view) {
        openaccount db=new openaccount(this);
       SQLiteDatabase db1=db.getWritableDatabase();
        final ContentValues cv=new ContentValues();

        String Mobile=editText36.getText().toString();
        String withdraw=editText37.getText().toString();
        String Balance=textView18.getText().toString();


        boolean Withdraw=db.withdrawAccount(Mobile,withdraw,Balance);

      Float create=Float.parseFloat(Balance);
      Float create1=Float.parseFloat(withdraw);
      Float balance=create-create1;
      cv.put("Mobile",Mobile);
      cv.put("balance",String.valueOf(balance));



        long update=db1.update("online",cv,"Mobile = ?",new String[] {Mobile});

        if (update==0){
            Toast.makeText(this, "Amount not updated ", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, " Withdraw Amount  Successfully ", Toast.LENGTH_SHORT).show();

        }

      textView19.setText(String.valueOf(balance));
        editText37.setText("");

    }



}