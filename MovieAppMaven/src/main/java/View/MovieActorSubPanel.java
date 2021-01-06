package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MovieActorSubPanel extends JPanel {

    private JLabel noMovie;
    private JLabel noActor;
    private JButton back;
    private JButton add;

    private ArrayList<JButton> movieActorSubPanelButtons;
    private ArrayList<JButton> objectButtons;
    private GridLayout movieActorSubPanelLayout;

    public MovieActorSubPanel() {
        movieActorSubPanelButtons = new ArrayList<>();
        objectButtons = new ArrayList<>();

        noMovie = new JLabel("No Movie Selected");
        noActor = new JLabel("No Actor Selected");
        back = new JButton("Back");
        add = new JButton("Add");

        movieActorSubPanelButtons.add(back);
        movieActorSubPanelButtons.add(add);

//        movieActorSubPanelLayout = new GridLayout(20, 1);
//        setLayout(movieActorSubPanelLayout);
        setVisible(false);

        add(noMovie);
        add(noActor);
        add(back);
        add(add);
    }

    public JLabel getNoMovie() {
        return noMovie;
    }

    public void setNoMovie(JLabel noMovie) {
        this.noMovie = noMovie;
    }

    public JLabel getNoActor() {
        return noActor;
    }

    public void setNoActor(JLabel noActor) {
        this.noActor = noActor;
    }

    public JButton getBack() {
        return back;
    }

    public void setBack(JButton back) {
        this.back = back;
    }

    public JButton getAdd() {
        return add;
    }

    public void setAdd(JButton add) {
        this.add = add;
    }

    public ArrayList<JButton> getMovieActorSubPanelButtons() {
        return movieActorSubPanelButtons;
    }

    public void setMovieActorSubPanelButtons(ArrayList<JButton> movieActorSubPanelButtons) {
        this.movieActorSubPanelButtons = movieActorSubPanelButtons;
    }

    public ArrayList<JButton> getObjectButtons() {
        return objectButtons;
    }

    public void setObjectButtons(ArrayList<JButton> objectButtons) {
        this.objectButtons = objectButtons;
    }
}
