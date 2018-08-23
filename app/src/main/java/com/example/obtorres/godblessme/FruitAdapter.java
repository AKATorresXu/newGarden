package com.example.obtorres.godblessme;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<fruit> mFruitlist;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
        View farmView;
        public ViewHolder(View view) {
            super(view);
            farmView=view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }

    }

    public FruitAdapter(List<fruit> fruitList) {
        mFruitlist = fruitList;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.farmView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                fruit fruit1=mFruitlist.get(position);
                Intent intent1=new Intent(v.getContext(),FruitPage.class);
                intent1.putExtra("family",fruit1.getFamily());

                v.getContext().startActivity(intent1);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        fruit fruit = mFruitlist.get(position);
        holder.fruitImage.setImageResource(fruit.getImageID());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitlist.size();
    }
}
