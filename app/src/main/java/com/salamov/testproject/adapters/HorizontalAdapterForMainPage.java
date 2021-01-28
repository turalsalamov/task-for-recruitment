package com.salamov.testproject.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.salamov.testproject.R;
import com.salamov.testproject.models.ItemsAtHorizontalAdapter;

import java.util.ArrayList;

public class HorizontalAdapterForMainPage extends RecyclerView.Adapter<HorizontalAdapterForMainPage.ViewHolder> {


    private Context context;
    ArrayList<ItemsAtHorizontalAdapter> items = new ArrayList<>();

    public HorizontalAdapterForMainPage(Context context, ArrayList<ItemsAtHorizontalAdapter> items){
        this.context = context;
        this.items = new ArrayList<>(items);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.horizontal_recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (items.size() > 0) {
            holder.imageView.setImageResource(items.get(position).getImage());
            holder.name.setText(items.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ShapeableImageView imageView;
        public TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_at_horizontal);
            name = itemView.findViewById(R.id.name_at_horizontal);

        }


    }
}
