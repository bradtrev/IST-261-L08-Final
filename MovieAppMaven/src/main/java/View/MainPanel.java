package View;

import javax.swing.JPanel;
import java.awt.*;

public class MainPanel extends JPanel {

    private ListPanel listPanel;
    private MovieActorPanel movieActorPanel;
    private MovieActorSubPanel movieActorSubPanel;

    public MainPanel(){
        super();

        listPanel = new ListPanel();
        add(listPanel);

        movieActorPanel = new MovieActorPanel();
        add(movieActorPanel);

        movieActorSubPanel = new MovieActorSubPanel();
        add(movieActorSubPanel);
    }

    public ListPanel getListPanel() {
        return listPanel;
    }

    public void setListPanel(ListPanel listPanel) {
        this.listPanel = listPanel;
    }

    public MovieActorPanel getMovieActorPanel() {
        return movieActorPanel;
    }

    public void setMovieActorPanel(MovieActorPanel movieActorPanel) {
        this.movieActorPanel = movieActorPanel;
    }

    public MovieActorSubPanel getMovieActorSubPanel() {
        return movieActorSubPanel;
    }

    public void setMovieActorSubPanel(MovieActorSubPanel movieActorSubPanel) {
        this.movieActorSubPanel = movieActorSubPanel;
    }
}
