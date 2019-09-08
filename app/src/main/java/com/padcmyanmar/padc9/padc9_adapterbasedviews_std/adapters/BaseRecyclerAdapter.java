package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.views.holders.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

//T = ViewHolder Type
//W = Data Type
public abstract class BaseRecyclerAdapter<T extends BaseViewHolder<W>, W> extends RecyclerView.Adapter<T> {

    private List<W> mData;

    public BaseRecyclerAdapter() {
        this.mData = new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(@NonNull T viewHolder, int position) {
        viewHolder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setNewData(List<W> data){
        mData = data;
        notifyDataSetChanged();
    }
}
