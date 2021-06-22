package com.example.recycler;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamAdapterViewHolder> {
    ModelClass[] modelClasses;

    public TeamAdapter(ModelClass[] modelClasses) {
        this.modelClasses = modelClasses;
    }

    @NonNull
    @Override
    public TeamAdapter.TeamAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater layoutInflater=LayoutInflater.from(context);

        View view=layoutInflater.inflate(R.layout.recycle_layout,parent,false);
        return new TeamAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamAdapter.TeamAdapterViewHolder holder, int position) {

        holder.fname.setText(modelClasses[position].firstName);
        holder.lname.setText(modelClasses[position].lastName);
        holder.position.setText(modelClasses[position].position);
        int resID=holder.context.getResources().getIdentifier(modelClasses[position].smallImg,"mipmap",holder.context.getPackageName());
        holder.smalldp.setImageBitmap(BitmapFactory.decodeResource(holder.context.getResources(),resID));

    }

    @Override
    public int getItemCount() { return modelClasses.length; }



    public class TeamAdapterViewHolder extends RecyclerView.ViewHolder{
        TextView fname,lname,position;
        ImageView smalldp;
        Context context;
        public TeamAdapterViewHolder(@NonNull View itemView){
            super(itemView);
            context=itemView.getContext();
            fname=itemView.findViewById(R.id.playerFirstName);
            lname=itemView.findViewById(R.id.playerLasttName);
            position= itemView.findViewById(R.id.playerPosition);
            smalldp=itemView.findViewById(R.id.playerImg);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(context,ProfilesActivity.class);
                    i.putExtra("obj",modelClasses).putExtra("pos",getAdapterPosition());
                    itemView.getContext().startActivity(i);

                }
            });
        }
    }
}
