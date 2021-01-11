package com.codewithankit.online;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register_Activity extends AppCompatActivity {
    EditText et3,et4,et5,et6;
    Button btn3;
    boolean isAllFieldsChecked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);

        et3=findViewById(R.id.edit_text3);
        et4=findViewById(R.id.edit_text4);
        et5=findViewById(R.id.edit_text5);
        et6=findViewById(R.id.edit_text6);
        btn3=findViewById(R.id.btn3);


    }

    public void createAccount(View view) {

        isAllFieldsChecked  = checkallfields();

        if (isAllFieldsChecked) {


            new sqliteclass(this);

            sqliteclass db = new sqliteclass(this);

            String output = db.addRecord(et3.getText().toString(), et4.getText().toString(), et5.getText().toString(), et6.getText().toString());
            Toast.makeText(this, output, Toast.LENGTH_LONG).show();

            et3.setText("");
            et4.setText("");
            et5.setText("");
            et6.setText("");
        }
    }
    private Boolean checkallfields(){


        if (et3.length() == 0) {
            Toast.makeText(this, "Please Enter the Name", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!et3.getText().toString().matches("[a-z,A-Z]*")) {
                et3.setError("Enter Only Character");

        }

        if (et4.length() == 0) {
            Toast.makeText(this, "Please Enter the Email Address", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(et4.getText().toString()).matches()) {
                et4.setError("Please Enter Vailed Email");


        }



        if (!et5.getText().toString().matches("[0-9]{10}"))
          {
            et5.setError("Please Enter 10 digit Mobile no.");
              return false;
          }
        if (et6.length() < 6) {
            et6.setError("Please enter password using number,char,special symbol minimum 6 char");
            return false;
        }







        return true;
    }
}
