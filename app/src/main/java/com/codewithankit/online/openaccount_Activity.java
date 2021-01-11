package com.codewithankit.online;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class openaccount_Activity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    TextView textView10;
    EditText editText7,editText8,editText9,editText10,editText11,editText12,editText13,editText14;
    Button btn4,btn5;
    Spinner spinner1,spinner2,spinner3,spinner4;

    String[] addressproof={"Please select the Address proof","Aadhar Card","Passport","Ration Card","ElectricBill","Telephone Bill "};
    String[] Idproof={"Please select the id proof","Aadhar Card","Driving Licence","Pan Card","Marksheet","Voter Id"};
    String[] Profession={"Please select the Profession","Student","Business","Farmer","Service","Unemployee","Self-employee"};
    String[] accountType={"Please select the Account Type","Saving","Fixed-deposit","Current"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_openaccount_);

        textView10=findViewById(R.id.textview10);
        editText7=findViewById(R.id.edit_text7);
        editText8=findViewById(R.id.edit_text8);
        editText9=findViewById(R.id.edit_text9);
        editText10=findViewById(R.id.edit_text10);
        editText11=findViewById(R.id.edit_text11);
        editText12=findViewById(R.id.edit_text12);
        editText13=findViewById(R.id.edit_text13);
        editText14=findViewById(R.id.edit_text14);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        spinner1=findViewById(R.id.spinner1);
        spinner2=findViewById(R.id.spinner2);
        spinner3=findViewById(R.id.spinner3);
        spinner4=findViewById(R.id.spinner4);

        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           showDatePickerDialog();
            }
        });

        ArrayAdapter arrayAdapter=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item,addressproof);
       arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      spinner1.setAdapter(arrayAdapter);
      spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
           Toast.makeText(getApplicationContext(),addressproof[position],Toast.LENGTH_SHORT).show();
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {

          }
      });

      //spinner 2
        ArrayAdapter arrayAdapter1=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item,Idproof);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter1);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),Idproof[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //spinner 3
        ArrayAdapter arrayAdapter2=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item,Profession);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(arrayAdapter2);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),Profession[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //spinner 4
        ArrayAdapter arrayAdapter3=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item,accountType);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(arrayAdapter3);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),accountType[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//end Spinner


    }
    private void showDatePickerDialog(){
   DatePickerDialog datePickerDialog =new DatePickerDialog(
           this,
            this,
           Calendar.getInstance().get(Calendar.YEAR),
           Calendar.getInstance().get(Calendar.MONTH),
           Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
       datePickerDialog.show();

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
    String date=""+dayOfMonth+"/"+month+"/"+year;
    editText12.setText(date);
    }

    public void createAccount(View view) {

        new openaccount(this);
            openaccount db = new openaccount(this);
            String result = db.addRecord(editText7.getText().toString(), editText8.getText().toString(), editText9.getText().toString(), editText10.getText().toString(), editText11.getText().toString(),
                    editText12.getText().toString(), editText13.getText().toString(), spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(), spinner3.getSelectedItem().toString(), spinner4.getSelectedItem().toString(), editText14.getText().toString());

            Toast.makeText(this, result, Toast.LENGTH_LONG).show();
            editText7.setText("");
            editText8.setText("");
            editText9.setText("");
            editText10.setText("");
            editText11.setText("");
            editText12.setText("");
            editText13.setText("");
            editText14.setText("");


        }
    }
