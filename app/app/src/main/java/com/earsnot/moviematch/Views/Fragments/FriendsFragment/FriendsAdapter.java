package com.earsnot.moviematch.Views.Fragments.FriendsFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.earsnot.moviematch.R;

import java.util.ArrayList;
import java.util.List;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder>{

    public interface IFriendsItemClickedListener{
        void onFriendsItemClicked(FriendsItem index);
    }

    private IFriendsItemClickedListener mListener;

    private List<FriendsItem> mFriendsList = new ArrayList<>();

    public FriendsAdapter(IFriendsItemClickedListener listener) {
        this.mListener = listener;
    }

    public void updateFriendsList(List<FriendsItem> friendsList) {
        mFriendsList = friendsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FriendsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friends_list, parent, false);
        FriendsViewHolder friendsViewHolder = new FriendsViewHolder(v, mListener);
        return friendsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FriendsViewHolder holder, int position) {
        holder.txtName.setText(mFriendsList.get(position).getName());
        holder.txtEmail.setText(mFriendsList.get(position).getEmail());
        holder.txtMoviesMatchesVal.setText(String.valueOf(mFriendsList.get(position).getMovieMatches()));
        holder.txtSeriesMatchesVal.setText(String.valueOf(mFriendsList.get(position).getSeriesMatches()));
    }

    @Override
    public int getItemCount() {
        return mFriendsList.size();
    }
   public class FriendsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
       TextView txtName, txtEmail, txtMoviesMatchesVal, txtSeriesMatchesVal;

       public FriendsViewHolder(@NonNull View friendsView, IFriendsItemClickedListener listener) {
           super(friendsView);
           txtName = friendsView.findViewById(R.id.txtName);
           txtEmail = friendsView.findViewById(R.id.txtEmail);
           txtMoviesMatchesVal = friendsView.findViewById(R.id.txtMovieMatchesValue);
           txtSeriesMatchesVal = friendsView.findViewById(R.id.txtSeriesMatchesValue);
           mListener = listener;

           friendsView.setOnClickListener(this);
       }

       @Override
       public void onClick(View v) {
           mListener.onFriendsItemClicked(mFriendsList.get(getAdapterPosition()));
       }
   }
}
