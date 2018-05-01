package com.hindisms.jitcodez.hindismsforall.Fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hindisms.jitcodez.hindismsforall.Adapter.SMSRecyclerView;
import com.hindisms.jitcodez.hindismsforall.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TabFragment extends Fragment {
    private View view;

    private String title;//String for tab title
    ArrayList<String> sms;
    private static RecyclerView recyclerView;

    public TabFragment() {
    }

    @SuppressLint("ValidFragment")
    public TabFragment(String title,ArrayList<String> sms) {
        this.title = title;//Setting tab title
        this.sms=sms;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_layout, container, false);
        setRecyclerView();
        return view;

    }

    //Setting recycler view
    private void setRecyclerView() {

        recyclerView = (RecyclerView) view
                .findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView
                .setLayoutManager(new LinearLayoutManager(getActivity()));//Linear Items



        SMSRecyclerView adapter = new SMSRecyclerView(getActivity(), sms);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview

    }
}
