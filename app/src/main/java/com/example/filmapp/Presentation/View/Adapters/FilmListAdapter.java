package com.example.filmapp.Presentation.View.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmapp.Domain.Model.Film;
import com.example.filmapp.databinding.FilmListElementBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FilmListAdapter extends RecyclerView.Adapter<FilmListAdapter.FilmViewHolder> {
    private List<Film> data;

    public FilmListAdapter(List<Film> data) {

        this.data = data;
    }

    @NonNull
    @NotNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        FilmListElementBinding binding = FilmListElementBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FilmViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FilmViewHolder holder, int position) {
        holder.binding.filmName.setText(data.get(position).getName());

        holder.binding.filmGenre.setText(data.get(position).getGenre());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public List<Film> getData() {
        return data;
    }

    class FilmViewHolder extends RecyclerView.ViewHolder{

        FilmListElementBinding binding;

        public FilmViewHolder(FilmListElementBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
