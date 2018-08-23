package com.example.obtorres.godblessme;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FarmAdapter extends RecyclerView.Adapter<FarmAdapter.ViewHolder> {
    private List<farm> mFarmList;
    static  class ViewHolder extends RecyclerView.ViewHolder{
        View farmView;
        ImageView farmImage;
        TextView farmName;
        public ViewHolder(View view){
            super(view);
            farmView=view;
            farmImage=(ImageView) view.findViewById(R.id.farm_image);
            farmName=(TextView) view.findViewById(R.id.farm_name);
        }

    }
    public FarmAdapter(List<farm> farmList){
        mFarmList=farmList;

    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.farm_item,parent,false);
         final ViewHolder holder=new ViewHolder(view);
         holder.farmView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 int position=holder.getAdapterPosition();
                 farm farm=mFarmList.get(position);
                 Intent intent1=new Intent(v.getContext(),showContent.class);
                 intent1.putExtra("name",farm.getName());
                 intent1.putExtra("date",farm.getDate());
                 intent1.putExtra("content",farm.getContent());
                 intent1.putExtra("imageID",farm.getImageID());
                 intent1.putExtra("price",farm.getPrice());
                 v.getContext().startActivity(intent1);
             }
         });
        return holder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        farm farm=mFarmList.get(position);
        holder.farmImage.setImageResource(farm.getImageID());
        holder.farmName.setText(farm.getName());
    }

    @Override
    public int getItemCount(){
        return  mFarmList.size();
    }

}
