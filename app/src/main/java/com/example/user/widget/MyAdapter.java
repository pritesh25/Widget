package com.example.user.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context applicationContext;
    private List<DataModel> dataModels;

    public MyAdapter(Context applicationContext, List<DataModel> dataModels)
    {
        this.applicationContext = applicationContext;
        this.dataModels         = dataModels;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemdata,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        if(viewHolder instanceof  MyViewHolder)
        {
            MyViewHolder holder = (MyViewHolder) viewHolder;
            holder.name.setText(dataModels.get(i).getLabel());
            holder.png_name.setText(dataModels.get(i).getPkgName());


            try {
                Drawable icon = applicationContext.getPackageManager().getApplicationIcon(dataModels.get(i).getPkgName());
                holder.imageview.setImageDrawable(icon);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        TextView  name,png_name;
        ImageView imageview;

        public MyViewHolder(View view) {
            super(view);

            name        = view.findViewById(R.id.name);
            png_name    = view.findViewById(R.id.png_name);

            imageview   = view.findViewById(R.id.imageview);

        }
    }
}
