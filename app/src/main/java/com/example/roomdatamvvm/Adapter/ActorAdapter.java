package com.example.roomdatamvvm.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatamvvm.Model.REPORT;
import com.example.roomdatamvvm.R;

import java.util.List;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder> {

private Context context;
private List<REPORT> actorList;

    public ActorAdapter(Context context, List<REPORT> actorList) {
        this.context =  context;
        this.actorList = actorList;
    }

    @NonNull
    @Override
    public ActorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ActorViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.each_roe,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ActorViewHolder holder, int position) {
      REPORT actor=actorList.get(position);
      holder.id.setText("Id "+actor.getRechargeID());
      holder.name.setText("Name "+actor.getFullName());
      holder.age.setText("Age "+actor.getAmount());

//        Glide.with(context)
//                .load(actor.getImage())
//                .into(holder.image);

    }

    public void getAllActors(List<REPORT> actorList)
    {
        this.actorList=actorList;
    }

    @Override
    public int getItemCount() {
        return actorList.size();
    }

    public static class ActorViewHolder extends RecyclerView.ViewHolder{
      public TextView id,name,age;
      public ImageView image;

        public ActorViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.id);
            name=itemView.findViewById(R.id.name);
            age=itemView.findViewById(R.id.age);
            image=itemView.findViewById(R.id.image);
        }
    }
}
