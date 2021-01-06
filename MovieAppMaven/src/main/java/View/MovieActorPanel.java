package View;

import Controller.MovieActorButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MovieActorPanel extends JPanel {

    private JTextField searchField;
    private JButton searchButton;
    private JButton deleteButton;
    private JButton addButton;
    private JButton backButton;

    private ArrayList<JButton> movieActorPanelButtons;
    private ArrayList<JButton> movieActorPanelRequisiteButtons;
    private GridLayout movieActorPanelLayout;
    private int rows;

    private ArrayList<MovieActorButton> objectButtons;
    private Color selectionColor;
    private Color defaultColor;

    public MovieActorPanel() {
        searchField = new JTextField();

        movieActorPanelButtons = new ArrayList<>();
        movieActorPanelRequisiteButtons = new ArrayList<>();

        searchButton = new JButton("Search");
            movieActorPanelButtons.add(searchButton);
            movieActorPanelRequisiteButtons.add(searchButton);
        deleteButton = new JButton("Delete");
            movieActorPanelButtons.add(deleteButton);
            movieActorPanelRequisiteButtons.add(deleteButton);
        addButton = new JButton("Add");
            movieActorPanelButtons.add(addButton);
            movieActorPanelRequisiteButtons.add(addButton);
        backButton = new JButton("Back");
            movieActorPanelButtons.add(backButton);
            movieActorPanelRequisiteButtons.add(backButton);

        objectButtons = new ArrayList<>();
        selectionColor = Color.lightGray;
        defaultColor = Color.white;

        rows = 20;
        movieActorPanelLayout = new GridLayout(rows, 1);
        setLayout(movieActorPanelLayout);

        add(searchField);
        for (int i = 0; i < movieActorPanelRequisiteButtons.size(); i++) {
            add(movieActorPanelRequisiteButtons.get(i));
        }


        setVisible(false);
    }

    public ArrayList<JButton> getMovieActorPanelButtons() {
        return movieActorPanelButtons;
    }

    public void setMovieActorPanelButtons(ArrayList<JButton> movieActorPanelButtons) {
        this.movieActorPanelButtons = movieActorPanelButtons;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public void setSearchField(JTextField searchField) {
        this.searchField = searchField;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public ArrayList<JButton> getMovieActorPanelRequisiteButtons() {
        return movieActorPanelRequisiteButtons;
    }

    public void setMovieActorPanelRequisiteButtons(ArrayList<JButton> movieActorPanelRequisiteButtons) {
        this.movieActorPanelRequisiteButtons = movieActorPanelRequisiteButtons;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public ArrayList<MovieActorButton> getObjectButtons() {
        return objectButtons;
    }

    public void setObjectButtons(ArrayList<MovieActorButton> objectButtons) {
        this.objectButtons = objectButtons;
    }

    public Color getSelectionColor() {
        return selectionColor;
    }

    public void setSelectionColor(Color selectionColor) {
        this.selectionColor = selectionColor;
    }

    public Color getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(Color defaultColor) {
        this.defaultColor = defaultColor;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }
}
