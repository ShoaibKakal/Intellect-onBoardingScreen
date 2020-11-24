package com.shoaib.intellectonboardingscreens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.shoaib.intellectonboardingscreens.databinding.ItemContainerBinding;

import java.util.List;

public class ModelClassAdapter extends RecyclerView.Adapter<ModelClassAdapter.MyViewHolder> {
    private List<ModelClass> modelClassList;
    private LayoutInflater layoutInflater;

    public ModelClassAdapter(List<ModelClass> modelClassList) {
        this.modelClassList = modelClassList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemContainerBinding containerBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_container, parent, false);
        return new MyViewHolder(containerBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setBinding(modelClassList.get(position));
    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemContainerBinding itemContainerBinding;

        public MyViewHolder(@NonNull ItemContainerBinding itemContainerBinding) {
            super(itemContainerBinding.getRoot());
            this.itemContainerBinding = itemContainerBinding;
        }

        public void setBinding(ModelClass modelClass){
            itemContainerBinding.setData(modelClass);
        }
    }
}
