package com.smsaz.fitnessenthusiast.faq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smsaz.fitnessenthusiast.R;

import java.util.LinkedList;

public class FAQAdapter extends RecyclerView.Adapter<FAQAdapter.FAQViewHolder> {

    LinkedList<String> questions;
    private LayoutInflater layoutInflater;

    public FAQAdapter(Context context, LinkedList<String> questions) {
        this.questions = questions;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public FAQViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = layoutInflater.inflate(R.layout.faq_sample,parent,false);

        return new FAQViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull FAQViewHolder holder, int position) {
        String currentQuestion = questions.get(position);
        holder.question.setText(currentQuestion);
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class FAQViewHolder extends RecyclerView.ViewHolder {

        private TextView question;
        private FAQAdapter faqAdapter;

        public FAQViewHolder(@NonNull View itemView, FAQAdapter faqAdapter) {
            super(itemView);
            question = itemView.findViewById(R.id.question);
            this.faqAdapter = faqAdapter;
        }
    }
}
