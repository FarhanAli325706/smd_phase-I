package com.smsaz.fitnessenthusiast;
//TODO recycler issue
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>{
    private final LinkedList<dataValues> exercise_Name_List;

    private LayoutInflater mInflater;
    private Context context;
    public ExerciseAdapter(Context context,
                           LinkedList<dataValues> wordList) {
        mInflater = LayoutInflater.from(context);
        this.exercise_Name_List = wordList;
        this.context=context;
    }
    @NonNull
    @Override
    public ExerciseAdapter.ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.exercise_names,
                parent, false);
        return new ExerciseViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseAdapter.ExerciseViewHolder holder, final int position) {
        dataValues mCurrent = exercise_Name_List.get(position);
        String name=mCurrent.getName();
        int image=mCurrent.getImages();
        holder.button.setText(name);
        holder.image_View.setImageResource(image);
        holder.button.setOnClickListener((view)->{
            Intent intent=new Intent(context,BodyPartActivity.class);
            intent.putExtra("e_name",this.exercise_Name_List.get(position).getName());
            context.startActivity(intent);
        });
        holder.image_View.setOnClickListener((view)->{
            Intent intent=new Intent(context,BodyPartActivity.class);
            intent.putExtra("e_name",this.exercise_Name_List.get(position).getName());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return exercise_Name_List.size();
    }
    class ExerciseViewHolder extends RecyclerView.ViewHolder
    {
        public final Button button;
        public final ImageView image_View;
        final ExerciseAdapter exercise_Adapter;
        public ExerciseViewHolder(View itemView, ExerciseAdapter adapter) {
            super(itemView);
            button = itemView.findViewById(R.id.exercise_button);       //hold my button id
            image_View=itemView.findViewById(R.id.image_sample);
            this.exercise_Adapter = adapter;
        }
    }
}
