package com.example.testtools.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testtools.R;

import java.util.List;

public class TouchHolderAdapter extends RecyclerView.Adapter<TouchHolderAdapter.ViewHolder> {
    private List<String> list;
    private Context context;

    public TouchHolderAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_touchholder, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mBtn.setText(list.get(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return list.size() != 0 ? list.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private Button mBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mBtn = itemView.findViewById(R.id.mBtn_item);
        }
    }
}
