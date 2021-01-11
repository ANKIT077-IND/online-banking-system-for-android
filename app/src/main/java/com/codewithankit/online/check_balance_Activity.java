package com.codewithankit.online;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class check_balance_Activity extends AppCompatActivity {
    Button btn8;
    EditText editText26;
    TextView textView13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_balance_);

        btn8=findViewById(R.id.btn8);
        editText26=findViewById(R.id.edit_text26);
        textView13=findViewById(R.id.textview13);
    }

    public void checkbalance(View view) {
        new openaccount(this);
         String Mobile=editText26.getText().toString();
        openaccount db = new openaccount(this);
          Cursor result=db.balance(Mobile);
          while (result.moveToNext()){

            textView13.setText(result.getString(12));
        }

    }

}