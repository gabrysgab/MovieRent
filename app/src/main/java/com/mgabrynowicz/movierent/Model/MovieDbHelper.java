package com.mgabrynowicz.movierent.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by RENT on 2017-01-09.
 */

public class MovieDbHelper extends OrmLiteSqliteOpenHelper {

    private static final String DB_NAME = "mobies_db.db";
    private static final int DB_version = 1;
    private Dao<Movie, Long> movieDao;


    public Dao<Movie, Long> getMovieDao() {

         if(movieDao == null) {
             try {
                 movieDao = getDao(Movie.class);
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
        return movieDao;
    }




    public MovieDbHelper(Context context) {
        super(context, DB_NAME, null, DB_version);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, Movie.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {


        try {
            TableUtils.dropTable(connectionSource, Movie.class, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        onCreate(database, connectionSource);


    }
}
