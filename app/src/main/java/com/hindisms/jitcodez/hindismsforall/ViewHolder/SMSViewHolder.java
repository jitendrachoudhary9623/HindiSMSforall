package com.hindisms.jitcodez.hindismsforall.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hindisms.jitcodez.hindismsforall.R;

public abstract class SMSViewHolder extends RecyclerView.ViewHolder {


    public TextView title;


    public SMSViewHolder(View view) {
        super(view);


        this.title = (TextView) view.findViewById(R.id.cardTitle);

    }


}