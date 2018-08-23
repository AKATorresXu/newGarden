package com.example.obtorres.godblessme;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitMoreAdapter extends RecyclerView.Adapter<FruitMoreAdapter.ViewHolder> {
    private List<FriutMore> mFruitlist;



    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View view) {
            super(view);
            fruitView=view;
            fruitImage = (ImageView) view.findViewById(R.id.img_fruitPage);
            fruitName = (TextView) view.findViewById(R.id.txt_name_fruitPage);
        }

    }

    public FruitMoreAdapter(List<FriutMore> fruitList) {
        mFruitlist = fruitList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
       final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                FriutMore friutMore=mFruitlist.get(position);
                Intent intent1=new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("https://baike.baidu.com/item/"+friutMore.getName().toString()));
                v.getContext().startActivity(intent1);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FriutMore fruit = mFruitlist.get(position);
        holder.fruitImage.setImageResource(fruit.getImageID());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitlist.size();
    }
    /*@Override
    public FruitAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        FruitAdapter.ViewHolder holder = new FruitAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(FruitAdapter.ViewHolder holder, int position) {
        fruit fruit = mFruitlist.get(position);
        holder.fruitImage.setImageResource(fruit.getImageID());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitlist.size();
    }*/
}
