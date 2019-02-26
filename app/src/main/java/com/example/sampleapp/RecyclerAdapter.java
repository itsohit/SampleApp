package com.example.sampleapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sampleapp.databinding.LayoutItemBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHolder> {

    LayoutItemBinding item;
    LayoutInflater inflater=null;
    List<String> list ;
    public RecyclerAdapter(List<String> list){
        this.list = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       if(inflater== null){
           inflater = LayoutInflater.from(parent.getContext());
       }
       item = DataBindingUtil.inflate(inflater,R.layout.layout_item,parent,false);
        return new MyHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.binding.itemTv.setText("asdfasdf");
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        LayoutItemBinding binding;
        public MyHolder(@NonNull LayoutItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
