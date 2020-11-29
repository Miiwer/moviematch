package com.earsnot.moviematch.Views.Fragments.MovieListFragment;

import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static android.content.ContentValues.TAG;

public class MovieListViewModel extends ViewModel {


    MutableLiveData<ArrayList<Movie>> movies;


    public LiveData<ArrayList<Movie>> getMovies() {
        if(movies==null){
            loadData();
        }
        return movies;
    }

    private void loadData() {
        movies = new MediatorLiveData<ArrayList<Movie>>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("movies")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot snapshot, @Nullable FirebaseFirestoreException error) {
                        ArrayList<Movie> updatedMovies = new ArrayList<>();

                        if(snapshot!=null && !snapshot.isEmpty()){
                            for(DocumentSnapshot doc: snapshot.getDocuments()){
                                Movie m = doc.toObject(Movie.class);
                                if (m != null) {
                                    updatedMovies.add(m);
                                }
                            }
                            movies.setValue(updatedMovies);
                        }
                    }
                });
    }



    public void addDummyMovies() {

        // Title, releaseYear, rating, summary, genre, platforms
        Movie m1 = new Movie("The Godfather", "1972", "87",
                "This is a summary", "Drama, Crime", "Netflix, HBO");

        Movie m2 = new Movie("The Lion King", "1994","82",
                "Lion prince Simba and his father are targeted by his bitter uncle, who wants to ascend the throne himself.",
                "Animation, Adventure, Drama","Disney Plus");

        Movie m3 = new Movie("Megan is Missing", "2011","60",
                "Two teenage girls encounter an Internet child predator.",
                "Drama, Horror, Thriller", "Netflix, HBO");

        Movie m4 = new Movie("The Shawshank Redemption", "1994","87",
                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                "Drama", "Netflix, HBO");

        Movie m5 = new Movie("The Godfather: Part II", "1974","91",
                "The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.",
                "Crime, Drama", "Netflix, HBO");

        Movie m6 = new Movie("The Dark Knight", "2008","90",
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
                "Action, Crime, Drama", "Netflix, HBO");

        Movie m7 = new Movie("13 Angry men", "1957","89",
                "Just some standard summery.",
                "Drama", "Netflix, HBO");

        Movie m8 = new Movie("Schindler's List", "1993","89",
                "Just some standard summery.",
                "History, Drama", "Netflix, HBO");

        Movie m9 = new Movie("The Lord of the Rings: The Return of the King", "2003","89",
                "Just some standard summery.",
                "Adventure, Drama", "Netflix, HBO");

        Movie m10 = new Movie("13 Angry men", "1957","89",
                "Just some standard summery.",
                "Drama", "Netflix, HBO");

        Movie m11 = new Movie("Pulp fiction", "1994","88",
                "Just some standard summery.",
                "Drama", "Netflix, HBO");


        Movie m12 = new Movie("Movie X", "1994","88",
                "Just some standard summery.",
                "Drama", "Netflix, HBO");
        Movie m13 = new Movie("Movie A", "1994","88",
                "Just some standard summery.",
                "Drama", "Netflix, HBO");
        Movie m14 = new Movie("Movie B", "1994","88",
                "Just some standard summery.",
                "Drama", "Netflix, HBO");
        Movie m15 = new Movie("Movie C", "1994","88",
                "Just some standard summery.",
                "Drama", "Netflix, HBO");
        Movie m16 = new Movie("Movie D", "1994","88",
                "Just some standard summery.",
                "Drama", "Netflix, HBO");
        Movie m17 = new Movie("Movie E", "1994","88",
                "Just some standard summery.",
                "Drama", "Netflix, HBO");
        Movie m18 = new Movie("Movie F", "1994","88",
                "Just some standard summery.",
                "Drama", "Netflix, HBO");
        Movie m19 = new Movie("Movie G", "1994","88",
                "Just some standard summery.",
                "Drama", "Netflix, HBO");
        Movie m20 = new Movie("Movie H", "1994","88",
                "Just some standard summery.",
                "Drama", "Netflix, HBO");

        Movie[] dummyMovies = new Movie[]{m1, m2, m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15,m16,m17,m18,m19,m20};

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        //foreach loop
        for (Movie m : dummyMovies) {

            addMovie(m.getMovieTitle(),m.getReleaseYear(), m.getRating(), m.getSummary(), m.getGenre(), m.getPlatform() );
        }

    }


    private void addMovie(String title, String releaseYear, String rating, String summary,
                          String genre, String platform) {

        Map<String, Object> movie = new HashMap<>();
        movie.put("title", title);
        movie.put("year", releaseYear);
        movie.put("rating", rating);
        movie.put("summary", summary);
        movie.put("genre", genre);
        movie.put("platform", platform);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("movies")
                .add(movie)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }


}
