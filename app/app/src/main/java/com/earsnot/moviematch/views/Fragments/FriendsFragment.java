package com.earsnot.moviematch.views.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.earsnot.moviematch.R;

public class FriendsFragment extends Fragment {
    private Button mBtnAddFriend;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, container, false);
        mBtnAddFriend = view.findViewById(R.id.btnAddFriend);
        
        mBtnAddFriend.setOnClickListener(v -> showAddFriendDialog());
        
        return view;
    }

    private void showAddFriendDialog() {
        final EditText edtAddFriend = new EditText(getContext());
        AlertDialog dialog = new AlertDialog.Builder(getContext())
                .setTitle(R.string.add_friend)
                .setMessage(R.string.add_friend_dialog_msg)
                .setView(edtAddFriend)
                .setPositiveButton(getString(R.string.add), (dialog1, which) -> {
                    addFriend();
                })
                .setNegativeButton(R.string.cancel, null)
                .create();
        dialog.show();
    }

    private void addFriend() {
        Toast.makeText(getActivity(),"Friend added",Toast.LENGTH_SHORT).show();
    }
}
