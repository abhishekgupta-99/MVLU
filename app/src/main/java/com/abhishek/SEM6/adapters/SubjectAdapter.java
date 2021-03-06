package com.abhishek.SEM6.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abhishek.SEM6.R;
import com.abhishek.SEM6.models.Subject;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * * Created by abhishek   on 3/2020.
 */

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHolder> {

    public ArrayList<Subject> subjects;
    private Context context;
    private LayoutInflater layoutInflater;

    public SubjectAdapter(ArrayList<Subject> subjects, Context context) {
        this.subjects = subjects;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.single_subject, parent, false);
        //Log.d("cg",chipGroup+"");

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.recyclerView.setAdapter(new BookAdapter(context, subjects.get(position).books));
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setHasFixedSize(true);
        holder.tvHeading.setText(subjects.get(position).subjectName);
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        TextView tvHeading;

        public ViewHolder(View itemView) {
            super(itemView);

            recyclerView = itemView.findViewById(R.id.rvChapters);
            tvHeading = itemView.findViewById(R.id.tvSubjectName);
        }
    }
}
