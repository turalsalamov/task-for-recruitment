package com.salamov.testproject.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.salamov.testproject.CallbackFromClickedItem;
import com.salamov.testproject.R;
import com.salamov.testproject.models.ItemsAtVerticalAdapter;

import java.util.ArrayList;

public class VerticalAdapterForMainPage extends RecyclerView.Adapter<VerticalAdapterForMainPage.ViewHolder>{

    private CallbackFromClickedItem callback;
    private Context context;
    private ArrayList<ItemsAtVerticalAdapter> items = new ArrayList<>();


    public VerticalAdapterForMainPage(Context context, ArrayList<ItemsAtVerticalAdapter> items, CallbackFromClickedItem callbackFromClickedItem){
        this.context = context;
        this.items = items;
        callback = callbackFromClickedItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.vertical_recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (items.size() > 0) {
            holder.shapeableImageView.setImageResource(items.get(position).getImage());
            holder.name.setText(items.get(position).getName());
            holder.message.setText(items.get(position).getMessage());
            holder.date.setText("  Date: " + items.get(position).getDate());
            // checking if user is active
            if (items.get(position).isActive()){
                holder.active.setImageResource(R.drawable.online);
            }
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public ShapeableImageView shapeableImageView;
        public TextView name;
        public TextView message;
        public TextView date;
        public ImageView active;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            active = itemView.findViewById(R.id.active);
            shapeableImageView = itemView.findViewById(R.id.image_at_vertical);
            name = itemView.findViewById(R.id.name_at_vertical);
            message = itemView.findViewById(R.id.message_at_vertical);
            date = itemView.findViewById(R.id.date_at_vertical);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onClickItem(name.getText().toString());
                }
            });


        }

    }
}
