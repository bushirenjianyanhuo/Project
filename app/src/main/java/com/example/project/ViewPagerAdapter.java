package com.example.project;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.viewPagerViewHolder> {
    private List<String> centralSection = new ArrayList<String>();

    public ViewPagerAdapter(){
        centralSection.add("hello");
        centralSection.add("hello");
        centralSection.add("hello");
        centralSection.add("hello");
        centralSection.add("hello");

    }

    @NonNull
    @Override
    public viewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewPagerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.ltem_pager, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewPagerViewHolder holder, int position) {
        holder.mTv.setText(centralSection.get(position));
    }

    @Override
    public int getItemCount() {
        return 5;
    }

     class viewPagerViewHolder extends RecyclerView.ViewHolder{

        TextView mTv;
        RelativeLayout re;

        public viewPagerViewHolder(@NonNull View itemView) {
            super(itemView);
            re = itemView.findViewById(R.id.containerT);
            mTv = itemView.findViewById(R.id.tlTitle);
        }
    }
}
