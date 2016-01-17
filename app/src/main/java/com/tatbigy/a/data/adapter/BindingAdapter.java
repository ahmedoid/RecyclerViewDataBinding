package com.tatbigy.a.data.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tatbigy.a.data.BR;
import com.tatbigy.a.data.R;
import com.tatbigy.a.data.model.FlickrResults;
import com.tatbigy.a.data.model.ItemsEntity;

/**
 * Created by Ahmed on 1/17/16.
 * 00
 * RecyclerViewDataBinding
 */
public class BindingAdapter extends RecyclerView.Adapter<BindingAdapter.BindingViewHolder> {
    private static final String TAG = "BindingAdapter";
    FlickrResults photos;

    public BindingAdapter(FlickrResults photos) {
        this.photos = photos;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.listitem_recycler, parent, false);
        return new BindingViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        ItemsEntity photo = photos.items.get(position);
        holder.getBinding().setVariable(BR.flickr, photo);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return photos.items.size();
    }

    public class BindingViewHolder extends RecyclerView.ViewHolder {

        public BindingViewHolder(View itemView) {
            super(itemView);
        }
        ViewDataBinding getBinding() {
            return DataBindingUtil.getBinding(itemView);
        }
    }
}
