
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public abstract class Program implements Serializable {
    String uuid;
    String title;
    Integer year;
    Double rating;
    String synopsis;
    String genre;
    Actor actor1;
    Actor actor2;
    Actor actor3;
    String imagePath;

    public Program(){

        
    }
    
    public abstract ArrayList<String> getAttributes();

    public String getUUID() {
        return uuid;
    }

    public void setUUID(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
    
    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Actor getActor1() {
        return actor1;
    }

    public void setActor1(Actor actor1) {
        this.actor1 = actor1;
    }

    public Actor getActor2() {
        return actor2;
    }

    public void setActor2(Actor actor2) {
        this.actor2 = actor2;
    }

    public Actor getActor3() {
        return actor3;
    }

    public void setActor3(Actor actor3) {
        this.actor3 = actor3;
    }
}
