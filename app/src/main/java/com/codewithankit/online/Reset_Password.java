package com.codewithankit.online;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Reset_Password extends AppCompatActivity {
    TextView textView2;
    EditText et2,et3;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset__password);

        textView2=findViewById(R.id.tv2);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
        button2=findViewById(R.id.button2);


        Intent intent=getIntent();
        textView2.setText(intent.getStringExtra("et1"));
    }

    public void Forgetpassword(View view) {
        sqliteclass db=new sqliteclass(this);

        String phone=textView2.getText().toString();
        String password=et2.getText().toString();
        String canformpasswd=et3.getText().toString();

        if (password.equals(canformpasswd)){

        Boolean checkPassword=db.updatePassword(phone,password);
        if (checkPassword==true){
            Intent intent=new Intent(Reset_Password.this,MainActivity.class);
           startActivity(intent);
           Toast.makeText(this, "Password Updated Successfully", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(this, "Password not Updated ", Toast.LENGTH_SHORT).show();

        }

        }
        else {
            Toast.makeText(this, "Password not Matching ", Toast.LENGTH_SHORT).show();

        }

    }
}