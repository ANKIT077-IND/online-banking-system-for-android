package com.codewithankit.online;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class closedaccount_Activity extends AppCompatActivity {
    EditText editText22;
    Button btn9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closedaccount_);

        editText22=findViewById(R.id.edit_text22);
        btn9=findViewById(R.id.btn9);
    }

    public void closeaccount(View view) {
        new openaccount(this);

        openaccount db=new openaccount(this);
         Integer deleteRows =db.deleteRecord(editText22.getText().toString());
         if (deleteRows>0){
             Toast.makeText(closedaccount_Activity.this, "Information deleted Successfully !", Toast.LENGTH_LONG).show();
         }
         else{
             Toast.makeText(closedaccount_Activity.this, "Information is not deleted ", Toast.LENGTH_LONG).show();

         }


    }
}