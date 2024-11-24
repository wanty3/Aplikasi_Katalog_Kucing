package com.aswanti.aplikasikatalogkucing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> implements Filterable {
    private List<Cat> catList;
    private List<Cat> catListFull;
    private OnItemClickListener listener;

    public CatAdapter(List<Cat> catList) {
        this.catList = catList;
        this.catListFull = new ArrayList<>(catList);
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cat, parent, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat = catList.get(position);
        holder.catImage.setImageResource(cat.getImageResourceId());
        holder.catName.setText(cat.getName());
        holder.catDescription.setText(cat.getDescription());
    }

    @Override
    public int getItemCount() {
        return catList.size();
    }

    @Override
    public Filter getFilter() {
        return catFilter;
    }

    private Filter catFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Cat> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(catListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Cat cat : catListFull) {
                    if (cat.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(cat);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            catList.clear();
            catList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public class CatViewHolder extends RecyclerView.ViewHolder {
        ImageView catImage;
        TextView catName;
        TextView catDescription;

        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
            catImage = itemView.findViewById(R.id.catImage);
            catName = itemView.findViewById(R.id.catName);
            catDescription = itemView.findViewById(R.id.catDescription);

            itemView.setOnClickListener(v -> {
                if (listener != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                    listener.onItemClick(catList.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Cat cat);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}