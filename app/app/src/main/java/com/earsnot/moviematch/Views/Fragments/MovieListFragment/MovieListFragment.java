package com.earsnot.moviematch.Views.Fragments.MovieListFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.earsnot.moviematch.R;
import com.earsnot.moviematch.Views.Activities.LoginActivity;
import com.firebase.ui.auth.AuthUI;

public class MovieListFragment extends Fragment {

    // Just testing - Mie
    private Button mBtnLogout;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_list,container,false);
        //TODO: NB! Just a dummy-fragment! Remember to change this!

        mBtnLogout = view.findViewById(R.id.main_btn_logout);


        mBtnLogout.setOnClickListener(v -> logout());
        return view;
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