package com.jmajyo.titirify.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jmajyo.titirify.R;
import com.jmajyo.titirify.model.Hat;
import com.jmajyo.titirify.view.StadisticViewHolder;

import io.realm.RealmResults;

public class StadisticAdapter extends RecyclerView.Adapter<StadisticViewHolder>{
    private RealmResults<Hat> listOfHat;
    private LayoutInflater layoutInflater;

    public StadisticAdapter(Context context, RealmResults<Hat> listOfHat) {
        this.listOfHat = listOfHat;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public StadisticViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.row_layout, parent, false);
        return new StadisticViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StadisticViewHolder holder, int position) {
        holder.setHat(listOfHat.get(position));
    }

    @Override
    public int getItemCount() {
        return listOfHat.size();
    }
}
