/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataObjects;

/**
 *
 * @author gteuw
 */
public class StoreGenreCount {
    String store;
    String genre;
    int number;

    public StoreGenreCount(String store, String genre, int number) {
        this.store = store;
        this.genre = genre;
        this.number = number;
    }

    public String getStore() {
        return store;
    }

    public String getGenre() {
        return genre;
    }

    public int getNumber() {
        return number;
    }
    
    
}
