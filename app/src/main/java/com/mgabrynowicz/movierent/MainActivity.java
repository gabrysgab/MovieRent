package com.mgabrynowicz.movierent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.mgabrynowicz.movierent.Model.Movie;
import com.mgabrynowicz.movierent.Model.MovieDbHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.available)
    RadioButton available;

    @BindView(R.id.not_available)
    RadioButton notAvailable;

    @BindView(R.id.titleEditText)
    EditText titleEditText;

    @BindView(R.id.commentEditText)
    EditText commentEditText;

    @BindView(R.id.productionYearEditText)
    EditText productionYearEditText;

    @BindView(R.id.moviesListView)
    ListView moviesListView;

    private boolean isAvailable = true;
    private Dao<Movie, Long> movieDao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MovieDbHelper movieDbHelper = OpenHelperManager.getHelper(this, MovieDbHelper.class);



        try {
            movieDao = movieDbHelper.getDao(Movie.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        refreshTask();




    }

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.available:
                if (checked)

                    isAvailable = true;

                    break;
            case R.id.not_available:
                if (checked)

                    isAvailable = false;

                    break;
        }


    }

    @OnClick(R.id.add_movie_button)
    public void addMovie() {

        String title = titleEditText.getText().toString();
        String comment = commentEditText.getText().toString();
        String productionYear = productionYearEditText.getText().toString();
        Movie tmpMovie = new Movie(title, comment, productionYear, isAvailable);
        try {
            movieDao.create(tmpMovie);
            refreshTask();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void refreshTask() {

        try {
            List<Movie> moviesList = movieDao.queryForAll();
            List<String> values = getTextFromMovies(moviesList);
            ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
            moviesListView.setAdapter(adapter);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<String> getTextFromMovies(List<Movie> moviesList) {

        List<String> values = new ArrayList<>();

        for(Movie tmpMovie : moviesList) {

            values.add(tmpMovie.toString());
        }

        return values;




    }


}
