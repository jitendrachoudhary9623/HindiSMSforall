package com.hindisms.jitcodez.hindismsforall.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hindisms.jitcodez.hindismsforall.R;
import com.hindisms.jitcodez.hindismsforall.ViewHolder.SMSViewHolder;

import java.util.ArrayList;

public class SMSRecyclerView extends
        RecyclerView.Adapter<SMSViewHolder> {
    private ArrayList<String> arrayList;
    private Context context;


    public SMSRecyclerView(Context context,
                                ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }


    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);

    }

    @Override
    public void onBindViewHolder(SMSViewHolder holder,
                                 int position) {


        final SMSViewHolder mainHolder = (SMSViewHolder) holder;
        //Setting text over textview
        mainHolder.title.setText(arrayList.get(position));

    }

    @Override
    public SMSViewHolder onCreateViewHolder(
            ViewGroup viewGroup, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(
                R.layout.rc_row, viewGroup, false);
        SMSViewHolder mainHolder = new SMSViewHolder(mainGroup) {
            @Override
            public String toString() {
                return super.toString();
            }
        };


        return mainHolder;

    }


}