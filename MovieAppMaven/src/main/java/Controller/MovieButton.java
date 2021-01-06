package Controller;

import Model.Movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieButton extends JButton {

    private Movie movie;
    private String separationCharacter;

    public MovieButton(Movie movie){
        super();
        separationCharacter = " | ";

        setBackground(Color.white);

        this.movie = movie;
        this.changeText();

    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void changeText() {
        super.setText(this.movie.getTitle() + separationCharacter
                + this.movie.getYear().toString() + separationCharacter
                + this.movie.getGenre() + separationCharacter
                + this.movie.getRating().toString());
    }

    public String getSeparationCharacter() {
        return separationCharacter;
    }

    public void setSeparationCharacter(String separationCharacter) {
        this.separationCharacter = separationCharacter;
    }
}
