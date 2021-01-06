package Model;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class MovieActor implements Comparable{

    String movieID;
    String actorID;

    public MovieActor(String movieID, String actorID) {
        this.movieID = movieID;
        this.actorID = actorID;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getActorID() {
        return actorID;
    }

    public void setActorID(String actorID) {
        this.actorID = actorID;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        return 0;
    }
}
