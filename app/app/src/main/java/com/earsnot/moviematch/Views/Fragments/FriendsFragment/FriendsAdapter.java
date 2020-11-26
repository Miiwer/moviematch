package com.earsnot.moviematch.Views.Fragments.FriendsFragment;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FriendsAdapter {
    public interface IFriendsItemClickedListener{
        void onFriendsItemClicked(FriendsItem index);
    }
    private IFriendsItemClickedListener mListener;

    private List<Friends> mFriendsList = new ArrayList<>();
   public class FriendsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
       TextView txtName, txtEmail, txtMoviesMatchesVal, txtSeriesMatchesVal;

       public FriendsViewHolder(@NonNull View friendsView, )
   }
}
