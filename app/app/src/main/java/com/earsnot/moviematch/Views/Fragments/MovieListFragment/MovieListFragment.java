package com.earsnot.moviematch.Views.Fragments.MovieListFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.earsnot.moviematch.R;
import com.earsnot.moviematch.Views.Activities.LoginActivity;
import com.firebase.ui.auth.AuthUI;

import java.util.ArrayList;

public class MovieListFragment extends Fragment {

    // Just testing - Mie
    private Button mBtn_addDB;
    ArrayList<Movie> viewMovies = new ArrayList<>();

    MovieListViewModel mlViewModel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mlViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        mlViewModel.getMovies().observe(getViewLifecycleOwner(), movies -> viewMovies = movies);


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_list,container,false);
        //TODO: NB! Just a dummy-fragment! Remember to change this!

        mBtn_addDB = view.findViewById(R.id.btn_addDB);


        mBtn_addDB.setOnClickListener(v -> add());
        UpdateUI();
        return view;
    }

    private void UpdateUI() {
        if(viewMovies.size()<1){
            Toast.makeText(getActivity(),"No movies", Toast.LENGTH_SHORT).show();
        } else {
             String display  = viewMovies.size() + "movies available\n";
             for (Movie m : viewMovies){
                 display += "\n Title: " + m.getMovieTitle() +" Year: " + m.getReleaseYear();
             }
        }
    }

    private void add() {
        mlViewModel.addDummyMovies();
    }


    private void logout() {
        AuthUI.getInstance()
                .signOut(getActivity())
                .addOnCompleteListener(task -> {
                    Toast.makeText(getActivity(),"User logged out",Toast.LENGTH_SHORT).show();
                    gotoLogin();
                });
    }

    private void gotoLogin() {
        Intent i = new Intent(getActivity(), LoginActivity.class);
        startActivity(i);
        getActivity().finish();
    }
}