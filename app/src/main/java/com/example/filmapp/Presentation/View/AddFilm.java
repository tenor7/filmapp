package com.example.filmapp.Presentation.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.filmapp.Presentation.ViewModel.AddFilmViewModel;
import com.example.filmapp.databinding.AddFilmFragmentBinding;

public class AddFilm extends Fragment {

    private AddFilmViewModel mViewModel;
    private AddFilmFragmentBinding mBinding;

    public static AddFilm newInstance() {
        return new AddFilm();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = AddFilmFragmentBinding.inflate(getLayoutInflater(), container, false);

        mBinding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).popBackStack();
            }
        });
        mBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((!mBinding.filmName.getText().toString().isEmpty())&&(!mBinding.filmGenre.getText().toString().isEmpty())&&(!mBinding.filmTime.getText().toString().isEmpty())&&(!mBinding.filmDescription.getText().toString().isEmpty())){
                    mViewModel.AddFilm(
                            mBinding.filmName.getText().toString(),
                            mBinding.filmGenre.getText().toString(),
                            mBinding.filmTime.getText().toString(),
                            mBinding.filmDescription.getText().toString()
                    );

                    Navigation.findNavController(v).popBackStack();
                } else {
                    Toast.makeText(getContext(), "Вы ввели не все данные", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AddFilmViewModel.class);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBinding = null;
        mViewModel = null;
    }
}