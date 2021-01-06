package Controller;

import Model.MovieActor;

import javax.swing.*;
import java.awt.*;

public class MovieActorButton extends JButton {

    private MovieActor movieActor;

    public MovieActorButton(MovieActor movieActor) {
        super();
        this.movieActor = movieActor;

        setBackground(Color.white);
    }

    public MovieActor getMovieActor() {
        return movieActor;
    }

    public void setMovieActor(MovieActor movieActor) {
        this.movieActor = movieActor;
    }
}
