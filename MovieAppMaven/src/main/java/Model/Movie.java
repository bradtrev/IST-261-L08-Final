
package Model;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Movie extends Program {
    
    public Movie(String uuidIn, String titleIn, Integer yearIn, String genreIn, Double ratingIn,
            String synopsisIn, Actor actor1In, Actor actor2In, Actor actor3In, String imagePathIn) {
        uuid = uuidIn;
        title = titleIn;
        year = yearIn;
        genre = genreIn;
        rating = ratingIn;
        synopsis = synopsisIn;
        actor1 = actor1In;
        actor2 = actor2In;
        actor3 = actor3In;
        imagePath = imagePathIn;

        generateID();
    }

    public void generateID() {
        uuid = UUID.randomUUID().toString();
    }

    public boolean decideInsert(Movie newMovie) {
        return (newMovie.getTitle().compareTo(this.getTitle()) < 0);
    }

    @Override
    public String toString() {
        return String.format(
                "UUID: %s\n" +
                "title: %s\n" +
                "year: %s\n" +
                "genre: %s\n" +
                "rating: %.2f\n" +
                "synopsis: %s\n" +
                "actor1: %s\n" +
                "actor2: %s\n" +
                "actor3: %s\n" +
                "imagePath: %s",
                this.uuid,
                this.title,
                this.year.toString(),
                this.genre,
                this.rating,
                this.synopsis,
                this.actor1.toString(),
                this.actor2.toString(),
                this.actor3.toString(),
                this.imagePath
        );
    }

    public ArrayList<String> getAttributes() {
        ArrayList<String> attributes = new ArrayList<String>();
        for(int i = 1; i < 9; i++){
            attributes.add(getAttribute(i));
        }

        return attributes;
    }

    public ArrayList<String> getAllAttributes() {
        ArrayList<String> attributes = new ArrayList<String>();
        for(int i = 0; i < 9; i++){
            attributes.add(getAttribute(i));
        }

        return attributes;
    }

    public String getAttribute(int n) {

        switch (n) {
            case 0:
                return getUUID().toString();
            case 1:
                return getTitle();
            case 2:
                return getYear().toString();
            case 3:
                return getGenre();
            case 4:
                return getRating().toString();
            case 5:
                return getActor1().getActorString(getActor1());
            case 6:
                return getActor2().getActorString(getActor2());
            case 7:
                return getActor3().getActorString(getActor3());
            case 8:
                return getSynopsis();
            case 9:
                return getImagePath();
            default:
                return "getAttribute error";
        }
    }

}