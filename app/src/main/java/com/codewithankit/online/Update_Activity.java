package com.codewithankit.online;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Update_Activity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    TextView textView15;
    EditText editText26,editText28,editText29,editText30,editText31,editText32,editText33,editText34,editText35;
    Button btn10,btn11,btn12;
    Spinner spinner5,spinner6,spinner7,spinner8;


    String[] uaddressproof={"Please select the Address proof","Aadhar Card","Passport","Ration Card","ElectricBill","Telephone Bill "};
    String[] uIdproof={"Please select the id proof","Aadhar Card","Driving Licence","Pan Card","Marksheet","Voter Id"};
    String[] uProfession={"Please select the Profession","Student","Business","Farmer","Service","Unemployee","Self-employee"};
    String[] uaccountType={"Please select the Account Type","Saving","Fixed-deposit","Current"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_);

        textView15=findViewById(R.id.textview15);
        editText26=findViewById(R.id.edit_text26);
        editText28=findViewById(R.id.edit_text28);
        editText29=findViewById(R.id.edit_text29);
        editText30=findViewById(R.id.edit_text30);
        editText31=findViewById(R.id.edit_text31);
        editText32=findViewById(R.id.edit_text32);
        editText33=findViewById(R.id.edit_text33);
        editText34=findViewById(R.id.edit_text34);
        editText35=findViewById(R.id.edit_text35);
        btn10=findViewById(R.id.btn10);
        btn11=findViewById(R.id.btn11);
        btn12=findViewById(R.id.btn12);
        spinner5=findViewById(R.id.spinner5);
        spinner6=findViewById(R.id.spinner6);
        spinner7=findViewById(R.id.spinner7);
        spinner8=findViewById(R.id.spinner8);




        findViewById(R.id.btn11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        ArrayAdapter arrayAdapter5=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item,uaddressproof);
        arrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(arrayAdapter5);
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),uaddressproof[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //spinner 6
        ArrayAdapter arrayAdapter6=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item,uIdproof);
        arrayAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner6.setAdapter(arrayAdapter6);
        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),uIdproof[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //spinner 7
        ArrayAdapter arrayAdapter7=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item,uProfession);
        arrayAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner7.setAdapter(arrayAdapter7);
        spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),uProfession[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //spinner 8
        ArrayAdapter arrayAdapter8=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item,uaccountType);
        arrayAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner8.setAdapter(arrayAdapter8);
        spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),uaccountType[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//end


    }

    public void update(View view) {
        new openaccount(this);

        openaccount db=new openaccount(this);

        String Mobile=editText26.getText().toString();

        Cursor update=db.Updatedata(Mobile);
        while (update.moveToNext()){
            editText28.setText(update.getString(1));
            editText29.setText(update.getString(2));
            editText30.setText(update.getString(3));
            editText31.setText(update.getString(4));
            editText32.setText(update.getString(5));
            editText33.setText(update.getString(6));
            editText34.setText(update.getString(7));
            editText35.setText(update.getString(12));

        }
    }

    public void UpdateAccount(View view) {
        new openaccount(this);
        openaccount db=new openaccount(this);
        String Mobile=editText26.getText().toString();
        boolean result=db.UpdateRecord(Mobile,
                editText28.getText().toString(),
                editText29.getText().toString(),
                editText30.getText().toString(),
                editText31.getText().toString(),
                editText32.getText().toString(),
                editText33.getText().toString(),
                editText34.getText().toString(),
                spinner5.getSelectedItem().toString(),
                spinner6.getSelectedItem().toString(),
                spinner7.getSelectedItem().toString(),
                spinner8.getSelectedItem().toString(),
                editText35.getText().toString());

        if(result){
            Toast.makeText(this, "Information Updated successfully", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Information is not Updated ", Toast.LENGTH_SHORT).show();

        }
        editText28.setText("");
        editText29.setText("");
        editText30.setText("");
        editText31.setText("");
        editText32.setText("");
        editText33.setText("");
        editText34.setText("");
        editText35.setText("");



    }

    private void showDatePickerDialog(){
        DatePickerDialog udatePickerDialog =new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        udatePickerDialog.show();

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date=""+dayOfMonth+"/"+month+"/"+year;
        editText33.setText(date);
    }

}