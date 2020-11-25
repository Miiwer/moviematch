package com.earsnot.moviematch.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.earsnot.moviematch.R;
import com.earsnot.moviematch.views.Fragments.FragmentTags;
import com.earsnot.moviematch.views.Fragments.FriendsFragment;
import com.earsnot.moviematch.views.Fragments.MovieListFragment;
import com.earsnot.moviematch.views.Fragments.MyListFragment;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button mBtnLogout;

    //To save fragments instead of creating new on navigation
    private FragmentManager fragmentManager;
    private Fragment currentFragment;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Create Fragment Manager instance
        fragmentManager = getSupportFragmentManager();

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        //Set List as default
        bottomNavigationView.setSelectedItemId(R.id.navigation_List);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MovieListFragment()).commit();



    }
    //*** https://stackoverflow.com/questions/45130713/bottomnavigationview-how-to-avoid-recreation-of-fragments-and-reuse-them ***
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.navigation_List:
                            selectedFragment = fragmentManager.findFragmentByTag(FragmentTags.TAG_FRAGMENT_NAV_LIST);
                            if (selectedFragment == null){
                                selectedFragment = new MovieListFragment();
                            }
                            replaceFragment(selectedFragment, FragmentTags.TAG_FRAGMENT_NAV_LIST);

                            break;

                        case R.id.navigation_MyList:
                            selectedFragment = fragmentManager.findFragmentByTag(FragmentTags.TAG_FRAGMENT_NAV_MYLIST);
                            if (selectedFragment == null){
                                selectedFragment = new MyListFragment();
                            }
                            replaceFragment(selectedFragment, FragmentTags.TAG_FRAGMENT_NAV_MYLIST);

                            break;

                        case R.id.navigation_Friends:
                            selectedFragment = fragmentManager.findFragmentByTag(FragmentTags.TAG_FRAGMENT_NAV_FRIENDS);
                            if (selectedFragment == null){
                                selectedFragment = new FriendsFragment();
                            }
                            replaceFragment(selectedFragment, FragmentTags.TAG_FRAGMENT_NAV_FRIENDS);

                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return  true;
                }
            };

    private void replaceFragment(@NonNull Fragment fragment, @NonNull String tag) {
        if (!fragment.equals(currentFragment)) {
            fragmentManager
                    .beginTransaction()
                    .addToBackStack(tag)
                    .replace(R.id.fragment_container, fragment, tag)
                    .commit();
            currentFragment = fragment;
        }
    }


}