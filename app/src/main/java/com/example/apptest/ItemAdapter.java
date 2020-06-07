package com.example.apptest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.apptest.databinding.IncomeViewBinding;
import com.example.apptest.databinding.OutcomeViewBinding;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {
    private ArrayList<String> logs;
    private LayoutInflater inflater;

    public ItemAdapter(ArrayList<String> logs, LayoutInflater inflater) {
        this.logs = logs;
        this.inflater = inflater;
    }

    public void addItem(String item){
        logs.add(item);
    }

    @Override
    public int getCount() {
        return logs.size();
    }

    @Override
    public String getItem(int position) {
        return logs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (position%2==0){
            IncomeViewBinding binding= IncomeViewBinding.inflate(inflater);
            binding.text.setText(logs.get(position));
            return binding.getRoot();
        }else{
            OutcomeViewBinding binding= OutcomeViewBinding.inflate(inflater);
            binding.text.setText(logs.get(position));
            return binding.getRoot();
        }
    }
}
