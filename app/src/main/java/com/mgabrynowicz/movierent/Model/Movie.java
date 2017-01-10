package com.mgabrynowicz.movierent.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by RENT on 2017-01-09.
 */

@DatabaseTable(tableName = "movies")
public class Movie {


    public Movie() {

    }


    public Movie(String title, String comment, String productionDate, boolean isAvailable) {
        this.title = title;
        this.comment = comment;
        this.productionYear = productionDate;
        this.isAvailable = isAvailable;
    }

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private String title;

    @DatabaseField
    private String comment;

    @DatabaseField
    private String productionYear;

    @DatabaseField
    private boolean isAvailable;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", comment='" + comment + '\'' +
                ", productionYear='" + productionYear + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
