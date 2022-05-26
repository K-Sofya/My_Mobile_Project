package com.example.mymobileproject.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymobileproject.R;
import com.example.mymobileproject.TypeFragment;
import com.example.mymobileproject.model.Section;

import java.util.List;

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.SectionViewHolder> {

    Context context;
    List<Section> sections;

    public SectionAdapter(Context context, List<Section> sections) {
        this.context = context;
        this.sections = sections;
    }

    @NonNull
    @Override
    public SectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View sectionItems = LayoutInflater.from(context).inflate(R.layout.section_item, parent, false);
        return new SectionAdapter.SectionViewHolder(sectionItems);
    }

    @Override
    public void onBindViewHolder(@NonNull SectionViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.sectionTitle.setText(sections.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((FragmentActivity) view.getContext ()).getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new TypeFragment(sections.get(position).getTitle(), sections.get(position).getTypeList()))
                        .addToBackStack(null)
                        .commit();
            }
        });


    }

    @Override
    public int getItemCount() {
        return sections.size();
    }

    public static final class SectionViewHolder extends RecyclerView.ViewHolder {

        TextView sectionTitle;

        public SectionViewHolder(@NonNull View itemView) {
            super(itemView);
            sectionTitle=itemView.findViewById(R.id.sectionTitle);
        }
    }

}
