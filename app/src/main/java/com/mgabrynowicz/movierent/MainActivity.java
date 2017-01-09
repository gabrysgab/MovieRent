package com.mgabrynowicz.movierent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.mgabrynowicz.movierent.Model.Movie;
import com.mgabrynowicz.movierent.Model.MovieDbHelper;

import java.sql.SQLException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.available)
    RadioButton available;

    @BindView(R.id.not_available)
    RadioButton notAvailable;

    @BindView(R.id.titleEditText)
    EditText titlEditText;

    @BindView(R.id.plotEditText)
    EditText plotEditText;

    @BindView(R.id.productionYearEditText)
    EditText productionYearEditText;

    private boolean isAvailable;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MovieDbHelper movieDbHelper = OpenHelperManager.getHelper(this, MovieDbHelper.class);

        try {
            Dao<Movie, Long> movieDao = movieDbHelper.getDao(Movie.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }


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







    }
}
