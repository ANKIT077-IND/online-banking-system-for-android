package com.codewithankit.online;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class deposit_Activity extends AppCompatActivity {
    TextView textView21, textView22, textView23, textView24;
    EditText editText39,editText41;
    Button button15, button16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit_);

        textView21 = findViewById(R.id.textview21);
        textView22 = findViewById(R.id.textview22);
        textView23 = findViewById(R.id.textview23);
        textView24 = findViewById(R.id.textview24);
        editText39 = findViewById(R.id.edit_text39);
        //editText40 = findViewById(R.id.edit_text40);
        editText41 = findViewById(R.id.edit_text41);
        button15 = findViewById(R.id.btn15);
        button16 = findViewById(R.id.btn16);
    }


    public void Depositshowdetail(View view) {
        new openaccount(this);
        openaccount db = new openaccount(this);
        String Mobile=editText39.getText().toString();
        Cursor withdraw = db.Depositshowdetail(Mobile);
        while (withdraw.moveToNext()) {
            textView22.setText(withdraw.getString(1));
            textView23.setText(withdraw.getString(12));


        }



}

    public void Deposit(View view) {

        openaccount db=new openaccount(this);
        SQLiteDatabase db1=db.getWritableDatabase();
        final ContentValues cv=new ContentValues();

             String Mobile=editText39.getText().toString();
             String deposit=editText41.getText().toString();
             String  Balance=textView23.getText().toString();


        boolean result=db.DepositAmount(Mobile,deposit,Balance);

        Float create=Float.parseFloat(Balance);
        Float create1=Float.parseFloat(deposit);
        Float balance=create+create1;
        cv.put("balance",String.valueOf(balance));



        long update=db1.update("online",cv,"Mobile = ?",new String[] {Mobile});

        if (update==0){
            Toast.makeText(this, "Amount not updated ", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, " Deposit Amount Successfully ", Toast.LENGTH_SHORT).show();

        }

        textView24.setText(String.valueOf(balance));
        editText41.setText("");

    }
}