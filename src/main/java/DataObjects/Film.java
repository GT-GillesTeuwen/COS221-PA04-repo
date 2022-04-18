/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataObjects;

/**
 *
 * @author gteuw
 */
public class Film {
    private String title;
    private String description;
    private String releaseYear;
    private int length;
    private String rating;

    public Film(String title, String description, String releaseYear, int length, String rating) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.length = length;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public int getLength() {
        return length;
    }

    public String getRating() {
        return rating;
    }
    
    
}
