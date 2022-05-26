package com.example.mymobileproject.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymobileproject.R;
import com.example.mymobileproject.SectionFragment;
import com.example.mymobileproject.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context;
    List<Category> categories;

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryItems = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
        return new CategoryAdapter.CategoryViewHolder(categoryItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, @SuppressLint("RecyclerView") int position) {


        int imageId=context.getResources().getIdentifier(categories.get(position).getImg(), "drawable", context.getPackageName());
        holder.categoryImage.setImageResource(imageId);
        holder.categoryTitle.setText(categories.get(position).getTitle());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((FragmentActivity) view.getContext ()).getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new SectionFragment(categories.get(position).getTitle(), categories.get(position).getSectionList()))
                        .addToBackStack(null)
                        .commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static final class CategoryViewHolder extends RecyclerView.ViewHolder {

        ImageView categoryImage;
        TextView categoryTitle;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImage=itemView.findViewById(R.id.categoryImage);
            categoryTitle=itemView.findViewById(R.id.categoryTitle);
        }
    }

}
