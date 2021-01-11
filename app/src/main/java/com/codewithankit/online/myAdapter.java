package com.codewithankit.online;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class myAdapter extends RecyclerView.Adapter<ViewHolder> {
List<modal> data;
    Context context;
    public myAdapter(List<modal> data, Context context) {
        this.data = data;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.singlerow,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
    final modal temp=data.get(position);

    holder.tv3.setText(data.get(position).getTextView());
    holder.img1.setImageResource(data.get(position).getImage());

    holder.c1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           Intent intent = null;
            switch (position){

               case 0:
                    intent=new Intent(context,openaccount_Activity.class);
                   break;
               case 1:
                    intent=new Intent(context,closedaccount_Activity.class);
                   break;
               case 2:
                    intent=new Intent(context,Update_Activity.class);
                   break;
               case 3:
                    intent=new Intent(context,widthdraw_Activity.class);
                   break;
               case 4:
                    intent=new Intent(context,deposit_Activity.class);
                   break;
               case 5:
                    intent=new Intent(context,check_balance_Activity.class);
                   break;

                default:
                    Toast.makeText(context, "you have wroung option", Toast.LENGTH_SHORT).show();


           }
           context.startActivity(intent);

        }
    });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
