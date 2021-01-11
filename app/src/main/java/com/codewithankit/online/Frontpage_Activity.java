package com.codewithankit.online;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Frontpage_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<modal> data1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage_);

        recyclerView=findViewById(R.id.recyclerView);
        data1 = new ArrayList<modal>();
        data1.add(new modal("Open Account",R.drawable.adduser));
        data1.add(new modal("Closed Account",R.drawable.close_account));
        data1.add(new modal("Update Account",R.drawable.update));
        data1.add(new modal("Withdraw",R.drawable.withdraw));
        data1.add(new modal("Deposit",R.drawable.deposit));
        data1.add(new modal("Check Balance",R.drawable.balance));

        myAdapter adapter=new myAdapter(data1,this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);
    }
}