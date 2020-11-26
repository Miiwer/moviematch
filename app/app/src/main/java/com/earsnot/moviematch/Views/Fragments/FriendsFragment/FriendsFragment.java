package com.earsnot.moviematch.Views.Fragments.FriendsFragment;

import android.app.AlertDialog;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.earsnot.moviematch.R;

import java.util.ArrayList;
import java.util.List;

public class FriendsFragment extends Fragment implements FriendsAdapter.IFriendsItemClickedListener {
    private RecyclerView mRcvList;
    private FriendsAdapter mAdapter;
    private Button mBtnAddFriend;
    private List<FriendsItem> mListFriends;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, container, false);
        mAdapter = new FriendsAdapter(this);

        mRcvList = view.findViewById(R.id.rcvFriendsList);
        mRcvList.setLayoutManager(new LinearLayoutManager(getContext()));
        mRcvList.setAdapter(mAdapter);
        FriendsItem f1 = new FriendsItem();
        f1.setEmail("jeff@jefferson.com");
        f1.setName("Jeff Jefferson");
        mListFriends = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            mListFriends.add(f1);
        }
        mBtnAddFriend = view.findViewById(R.id.btnAddFriend);
        mBtnAddFriend.setOnClickListener(v -> showAddFriendDialog());
        mAdapter.updateFriendsList(mListFriends);
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

    @Override
    public void onFriendsItemClicked(FriendsItem index) {

    }
}
