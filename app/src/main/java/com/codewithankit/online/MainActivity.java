package com.codewithankit.online;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView1,textView2;
    EditText editText1,editText2;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1=findViewById(R.id.textview1);
        textView2=findViewById(R.id.textview2);
        editText1=findViewById(R.id.edit_text1);
        editText2=findViewById(R.id.edit_text2);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,register_Activity.class);
                startActivity(intent);
            }
        });
    }

    public void forgot_Password(View view) {

        Intent intent=new Intent(MainActivity.this,Forgot_password.class);
        startActivity(intent);


    }

    public void login(View view) {
        sqliteclass db=new sqliteclass(this);

        String mno=editText1.getText().toString();
        String passwd=editText2.getText().toString();

        if (mno.isEmpty()||passwd.isEmpty()){
            Toast.makeText(this, "Enter Mobile No. and Password", Toast.LENGTH_LONG).show();
        }
        else {
            Boolean checkuserpass=db.checkusernamepassword(mno,passwd);
           if (checkuserpass==true){
               Intent intent=new Intent(MainActivity.this,Frontpage_Activity.class);
               startActivity(intent);
               finish();
               Toast.makeText(this, "Login Successfully", Toast.LENGTH_LONG).show();


           }
           else{
               Toast.makeText(this, "Wrong Mobile No. And Password, Try Again", Toast.LENGTH_LONG).show();
           }

        }

    }
}
