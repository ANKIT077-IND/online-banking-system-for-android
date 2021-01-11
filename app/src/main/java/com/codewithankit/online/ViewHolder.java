package com.codewithankit.online;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
     ImageView img1;
     TextView tv3;
     CardView c1;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        img1=itemView.findViewById(R.id.img1);
        tv3=itemView.findViewById(R.id.tv3);
        c1 = itemView.findViewById(R.id.cardView);
    }
}
