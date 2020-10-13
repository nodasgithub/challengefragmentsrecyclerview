package com.example.challengefragmentsrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private ArrayList<Person> people;

    ItemClicked activity;

    public interface ItemClicked {
        void onItemClicked(int index);
    }

    public PersonAdapter(Context context, ArrayList<Person> list) {
        people = list;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivMake;
        TextView tvModel, tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivMake = itemView.findViewById(R.id.ivMake);
            tvModel = itemView.findViewById(R.id.tvModel);
            tvName = itemView.findViewById(R.id.tvName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onItemClicked(people.indexOf((Person) view.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(people.get(position));

        String make = people.get(position).getCar().getMake();

        if (make.equals("mercedes")) {
            holder.ivMake.setImageResource(R.drawable.mercedes);
        } else if (make.equals("volkswagen")) {
            holder.ivMake.setImageResource(R.drawable.volkswagen);
        } else if (make.equals("nissan")) {
            holder.ivMake.setImageResource(R.drawable.nissan);
        }

        holder.tvModel.setText(people.get(position).getCar().getModel());
        holder.tvName.setText(people.get(position).getFirstName() + " " + people.get(position).getLastName());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
