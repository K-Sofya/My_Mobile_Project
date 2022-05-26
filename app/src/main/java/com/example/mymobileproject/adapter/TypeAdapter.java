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

import com.example.mymobileproject.ProductFragment;
import com.example.mymobileproject.R;
import com.example.mymobileproject.model.Type;

import java.util.List;

public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.TypeViewHolder> {

    Context context;
    List<Type> types;

    public TypeAdapter(Context context, List<Type> types) {
        this.context = context;
        this.types = types;
    }

    @NonNull
    @Override
    public TypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View typeItems = LayoutInflater.from(context).inflate(R.layout.type_item, parent, false);
        return new TypeAdapter.TypeViewHolder(typeItems);
    }

    @Override
    public void onBindViewHolder(@NonNull TypeAdapter.TypeViewHolder holder, @SuppressLint("RecyclerView") int position) {
        int imageId=context.getResources().getIdentifier(types.get(position).getImg(), "drawable", context.getPackageName());
        holder.typeImage.setImageResource(imageId);
        holder.typeTitle.setText(types.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((FragmentActivity) view.getContext ()).getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new ProductFragment(types.get(position).getTitle(), types.get(position).getProductList()))
                        .addToBackStack(null)
                        .commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return types.size();
    }

    public static final class TypeViewHolder extends RecyclerView.ViewHolder {

        ImageView typeImage;
        TextView typeTitle;

        public TypeViewHolder(@NonNull View itemView) {
            super(itemView);
            typeImage=itemView.findViewById(R.id.typeImage);
            typeTitle=itemView.findViewById(R.id.typeTitle);
        }
    }
}
