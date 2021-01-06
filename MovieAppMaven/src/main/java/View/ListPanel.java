package View;

import Controller.MovieButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ListPanel extends JPanel {

    private JTextField searchField;
    private JButton searchButton;

    private JButton viewDetails;

    private ArrayList<MovieButton> objectButtons;
    private Color selectionColor;
    private Color defaultColor;

    private ArrayList<JButton> listPanelButtons;
    private GridLayout listLayout;
    private int rows;

    private ArrayList<JButton> listPanelRequisiteButtons;

    private MovieButton referenceMovieButton;

    public ListPanel(){

        searchField = new JTextField();

        listPanelButtons = new ArrayList<>();
        listPanelRequisiteButtons = new ArrayList<>();

        searchButton = new JButton("Search Movies");
            listPanelButtons.add(searchButton);
            listPanelRequisiteButtons.add(searchButton);
        viewDetails = new JButton("View Selection Details");
            listPanelButtons.add(viewDetails);
            listPanelRequisiteButtons.add(viewDetails);

        objectButtons = new ArrayList<>();
        selectionColor = Color.lightGray;
        defaultColor = Color.white;

        rows = 30;
        listLayout = new GridLayout(rows,1);
        setLayout(listLayout);

        //Adding panel components
        add(searchField);
        for(int j = 0; j < listPanelRequisiteButtons.size(); j++) {
            add(listPanelRequisiteButtons.get(j));
        }

        setVisible(false);
    }

    public void listButtonsReset() {
        listPanelButtons.clear();
        for(int i = 0; i < listPanelRequisiteButtons.size(); i++) {
            listPanelButtons.add(listPanelRequisiteButtons.get(i));
        }
    }

    public void addObjectButtons(){
        for(int i = 0; i < rows - 1; i++){
            add(objectButtons.get(i));
        }
    }

    public GridLayout getListLayout() {
        return listLayout;
    }

    public void setListLayout(GridLayout listLayout) {
        this.listLayout = listLayout;
    }

    public JButton getViewDetails() {
        return viewDetails;
    }

    public void setViewDetails(JButton viewDetails) {
        this.viewDetails = viewDetails;
    }

    public ArrayList<MovieButton> getObjectButtons() {
        return objectButtons;
    }

    public void setObjectButtons(ArrayList<MovieButton> objectButtons) {
        this.objectButtons = objectButtons;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public ArrayList<JButton> getListPanelButtons() {
        return listPanelButtons;
    }

    public void setListPanelButtons(ArrayList<JButton> listPanelButtons) {
        this.listPanelButtons = listPanelButtons;
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

    public MovieButton getReferenceMovieButton() {
        return referenceMovieButton;
    }

    public void setReferenceMovieButton(MovieButton referenceMovieButton) {
        this.referenceMovieButton = referenceMovieButton;
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
}
