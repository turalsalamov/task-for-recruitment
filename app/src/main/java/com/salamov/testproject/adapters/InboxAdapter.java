package com.salamov.testproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.salamov.testproject.R;
import com.salamov.testproject.models.Messages;

import java.util.ArrayList;

public class InboxAdapter extends RecyclerView.Adapter<InboxAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Messages> messages;
    private int senderProfile;
    private int hostProfile;
    private boolean isActive;

    public InboxAdapter(Context context, ArrayList<Messages> messages, int sender, int host, boolean isActive) {
        this.context = context;
        this.messages = messages;
        this.senderProfile = sender;
        this.hostProfile = host;
        this.isActive = isActive;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.message_recycler_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (messages.get(position).getMessageFrom() == 0){
            holder.hostPhotoMessageLayout.setVisibility(View.GONE);
            holder.hostTextMessageLayout.setVisibility(View.GONE);

            if(messages.get(position).getMessage() == null){
                holder.senderTextMessageLayout.setVisibility(View.GONE);
                holder.senderPhoto.setImageResource(messages.get(position).getPhoto());
                holder.senderPhotoMessagePP.setImageResource(senderProfile);
                if (isActive){
                    holder.senderPhotoActive.setImageResource(R.drawable.online);
                }
            }else{
                holder.senderPhotoMessageLayout.setVisibility(View.GONE);
                holder.senderText.setText(messages.get(position).getMessage());
                holder.senderTextMessagePP.setImageResource(senderProfile);
                if (isActive){
                    holder.senderTextActive.setImageResource(R.drawable.online);
                }
            }
        }else{
            holder.senderPhotoMessageLayout.setVisibility(View.GONE);
            holder.senderTextMessageLayout.setVisibility(View.GONE);
            if(messages.get(position).getMessage() == null){
                holder.hostTextMessageLayout.setVisibility(View.GONE);
                holder.hostPhoto.setImageResource(messages.get(position).getPhoto());
                holder.hostPhotoMessagePP.setImageResource(hostProfile);
                holder.hostPhotoActive.setImageResource(R.drawable.online);

            }else{
                holder.hostPhotoMessageLayout.setVisibility(View.GONE);
                holder.hostText.setText(messages.get(position).getMessage());
                holder.hostTextMessagePP.setImageResource(hostProfile);
                holder.hostTextActive.setImageResource(R.drawable.online);

            }
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public LinearLayout senderTextMessageLayout;
        public LinearLayout hostTextMessageLayout;
        public LinearLayout senderPhotoMessageLayout;
        public LinearLayout hostPhotoMessageLayout;
        public ShapeableImageView senderTextMessagePP;
        public ShapeableImageView hostTextMessagePP;
        public ShapeableImageView senderPhotoMessagePP;
        public ShapeableImageView hostPhotoMessagePP;
        public TextView senderText;
        public TextView hostText;
        public ImageView senderPhoto;
        public ImageView hostPhoto;
        public ImageView senderTextActive;
        public ImageView hostTextActive;
        public ImageView senderPhotoActive;
        public ImageView hostPhotoActive;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            senderTextMessageLayout = itemView.findViewById(R.id.sender_message_layout);
            hostTextMessageLayout = itemView.findViewById(R.id.host_message_layout);
            senderPhotoMessageLayout = itemView.findViewById(R.id.sender_message_photo_layout);
            hostPhotoMessageLayout = itemView.findViewById(R.id.host_message_photo_layout);

            senderTextMessagePP = itemView.findViewById(R.id.sender_message_photo);
            hostTextMessagePP = itemView.findViewById(R.id.host_message_photo);
            senderPhotoMessagePP = itemView.findViewById(R.id.sender_message_pp);
            hostPhotoMessagePP = itemView.findViewById(R.id.host_message_pp);

            senderText = itemView.findViewById(R.id.sender_message_text);
            hostText = itemView.findViewById(R.id.host_message_text);
            senderPhoto = itemView.findViewById(R.id.sender_message_inbox_photo);
            hostPhoto = itemView.findViewById(R.id.host_message_photo_inbox);

            senderTextActive = itemView.findViewById(R.id.active_sender);
            hostTextActive = itemView.findViewById(R.id.active_host);
            senderPhotoActive = itemView.findViewById(R.id.active_sender_image);
            hostPhotoActive = itemView.findViewById(R.id.active_host_image);

        }
    }
}
