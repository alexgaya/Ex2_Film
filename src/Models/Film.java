/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author m
 */
public class Film implements Serializable{
    private String title;
    private String director;
    private int year;
    private GenreType genre;
    
    public static final Film sentinel = new Film("zzz", "zzz", 999, 
            GenreType.ACTION);

    public Film() {
    }

    public Film(String title, String director, int year, GenreType genre) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.genre = genre;
    }
    
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public GenreType getGenre() {
        return genre;
    }

    public void setGenre(GenreType genre) {
        this.genre = genre;
    }
    
    public boolean isSentinel() {
        return title.equals(sentinel.title)
                && director.equals(sentinel.director)
                && year == sentinel.year
                && genre.equals(sentinel.genre);
    }

    @Override
    public String toString() {
        return "Film{" + "title=" + title + ", director=" + director + 
                ", year=" + year + ", genre=" + genre + '}';
    }
    
}
