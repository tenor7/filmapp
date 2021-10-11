package com.example.filmapp.Presentation.View;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.filmapp.Domain.Model.Film;
import com.example.filmapp.Presentation.View.Adapters.FilmListAdapter;
import com.example.filmapp.Presentation.ViewModel.FilmListViewModel;
import com.example.filmapp.R;
import com.example.filmapp.databinding.FilmListFragmentBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FilmList extends Fragment {

    private FilmListViewModel mViewModel;
    private FilmListFragmentBinding mBinding;

    public static FilmList newInstance() {
        return new FilmList();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = FilmListFragmentBinding.inflate(getLayoutInflater(), container, false);

        mBinding.filmListRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        mBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_filmList_to_addFilm);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull @NotNull RecyclerView recyclerView, @NonNull @NotNull RecyclerView.ViewHolder viewHolder, @NonNull @NotNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull @NotNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                mViewModel.deleteFilm(((FilmListAdapter) mBinding.filmListRecycler.getAdapter()).getData().get(position));
            }
        }).attachToRecyclerView(mBinding.filmListRecycler);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FilmListViewModel.class);

        mViewModel.getFilmList().observe(getViewLifecycleOwner(), (List<Film> filmList) -> {
            mBinding.filmListRecycler.setAdapter(new FilmListAdapter(filmList));
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBinding = null;
        mViewModel = null;
    }
}