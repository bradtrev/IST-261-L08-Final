package Controller;

import Model.Model;
import Model.Movie;
import Model.MovieActor;
import Model.Actor;
import View.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class Controller
{

    private Model model;
    private View view;
    private int movieCounter;
    private Movie selected;
    private MovieActor selectedMovieActor;
    ArrayList<MovieActorButton> movieActorButtons = new ArrayList<>();

    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;

        setMovieCounter(0);

        addProgramPanelButtonListeners();
        addListPanelButtonListener();
        addMovieActorPanelButtonListeners();

        view.programPanelSetup(model.getSdc().getMovieData().getMovies().get(getMovieCounter()).getAttributes());
        updateListPanel();
        updateMovieActorPanel();

        setupMovieActorSubPanel();
    }

    public void increaseMovieCounter(boolean increase) {
        if(!increase)
                setMovieCounter(getMovieCounter()-1);
        else
                setMovieCounter(getMovieCounter()+1);
    }

    public void compensateMovieCounter() {
        if(movieCounter >= model.getSdc().getMovieData().getMovies().size())
            setMovieCounter(model.getSdc().getMovieData().getMovies().size()-1);
        else if(movieCounter <= 0)
            setMovieCounter(0);
        else
            setMovieCounter(getMovieCounter());
    }

    public void addProgramPanelButtonListeners() {
        for(int j = 0;  j < view.getMainFrame().getProgramPanel().getProgramPanelButtons().size(); j++){
            ((JButton)this.view.getMainFrame().getProgramPanel().getProgramPanelButtons().get(j)).
                    addActionListener(
                    new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            Object source = e.getSource();

                            if(source instanceof JButton){
//                                programPanelButtonAction(((JButton)source).getText());
                                System.out.println(((JButton)source).getText());
                                if(((JButton)source).getText()== "Previous"){
                                    increaseMovieCounter(false);
                                    compensateMovieCounter();
                                    view.programPanelSetup(model.getSdc().getMovieData().getMovies().
                                    get(getMovieCounter()).getAttributes());
                                }
                                if(((JButton)source).getText()== "Next"){
                                    increaseMovieCounter(true);
                                    compensateMovieCounter();
                                    view.programPanelSetup(model.getSdc().getMovieData().
                                    getMovies().get(getMovieCounter()).getAttributes());
                                }
                                if(((JButton)source).getText()== "Undo Changes"){
                                    view.programPanelSetup(
                                            model.getSdc().getMovieData().getMovies().
                                            get(getMovieCounter()).getAttributes()
                                    );
                                }
                                if(((JButton)source).getText()== "Delete"){
//
                                    if(model.getSdc().getMovieData().getMovies().size() > 1) {
                                        model.getSdc().getMovieData().deleteMovie(getMovieCounter());
                                        view.programPanelSetup(
                                                model.getSdc().getMovieData().getMovies().
                                                get(getMovieCounter()).getAttributes()
                                        );

                                    }

                                }
                                if(((JButton)source).getText()== "Add"){
                                    view.defaultProgramPanelTextFields();
//                                    ((JButton) source).setText("Click again to Add");
//                                    if(((JButton) source).getText() == "Click again to Add"){
                                    Movie temp = model.getSdc().getMovieData().getTestMovie();
                                    model.getSdc().getMovieData().addMovie(temp);
                                    MovieButton tempMovieButton = new MovieButton(temp);
                                    tempMovieButton.addActionListener(
                                            new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    addDefaultObjectButtonColor();
                                                    tempMovieButton.setBackground(view.getMainFrame().getMainPanel().
                                                            getListPanel().getSelectionColor());
                                                    setSelected(tempMovieButton.getMovie());
                                                }
                                            }
                                    );
                                    view.getMainFrame().getMainPanel().getListPanel().getObjectButtons().add(tempMovieButton);
                                    view.getMainFrame().getMainPanel().getListPanel().add(tempMovieButton);
//                                    }
                                }
                                if(((JButton)source).getText()== "Save Edits"){
                                    model.getSdc().getMovieData().editMovie(
                                            getMovieCounter(),
                                            view.getMainFrame().getProgramPanel().
                                            getProgramSubPanel().getProgramPanelTextFields().get(0).getText(),
                                            view.getMainFrame().getProgramPanel().
                                            getProgramSubPanel().getProgramPanelTextFields().get(1).getText(),
                                            view.getMainFrame().getProgramPanel().
                                            getProgramSubPanel().getProgramPanelTextFields().get(2).getText(),
                                            view.getMainFrame().getProgramPanel().
                                            getProgramSubPanel().getProgramPanelTextFields().get(3).getText(),
                                            view.getMainFrame().getProgramPanel().
                                            getProgramSubPanel().getProgramPanelTextFields().get(4).getText(),
                                            view.getMainFrame().getProgramPanel().
                                            getProgramSubPanel().getProgramPanelTextFields().get(5).getText(),
                                            view.getMainFrame().getProgramPanel().
                                            getProgramSubPanel().getProgramPanelTextFields().get(6).getText(),
                                            view.getMainFrame().getProgramPanel().
                                            getProgramSubPanel().getProgramPanelTextFields().get(7).getText(),
                                            "Placeholder image path"
                                    );
                                    model.getSdc().getMovieData().getMovies().get(getMovieCounter());
                                }
                                if(((JButton)source).getText()== "See Movies as List") {
                                        view.getMainFrame().getProgramPanel().setVisible(false);
                                        view.getMainFrame().getMainPanel().getListPanel().setVisible(true);
                                }
                                if(((JButton)source).getText() == "See MovieActor Pairs (Collection II)") {
                                    view.getMainFrame().getProgramPanel().setVisible(false);
                                    view.getMainFrame().getMainPanel().getMovieActorPanel().setVisible(true);
                                }
                            }
                        }
                    }
            );
        }
    }

    public void updateListPanel() {
        model.getSdc().getMovieData().setLinesBeingDisplayed(view.getMainFrame().getMainPanel().
                getListPanel().getRows() - 3);

        int movieSize = model.getSdc().getMovieData().getMovies().size();
        int numLines = model.getSdc().getMovieData().getNumberOfLines();
//      Alternative (and more multi-purpose) condition statement
//      int moviesDisplayed = movieSize >= numLines ? numLines : movieSize;
        int moviesDisplayed = Math.min(movieSize, numLines);

//        view.getMainFrame().getMainPanel().getListPanel().listButtonsReset();
        for(int i = 0; i < moviesDisplayed; i++) {
            MovieButton tempButton = new MovieButton(
                    model.getSdc().getMovieData().getMovies().get(i)
            );
            tempButton.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            addDefaultObjectButtonColor();
                            tempButton.setBackground(view.getMainFrame().getMainPanel().
                                    getListPanel().getSelectionColor());
                            setSelected(tempButton.getMovie());
                        }
                    }
            );
            view.getMainFrame().getMainPanel().getListPanel().getListPanelButtons().add(tempButton);
            view.getMainFrame().getMainPanel().getListPanel().getObjectButtons().add(tempButton);
//            for(int j = 0; j < view.getMainFrame().getMainPanel().getListPanel().getObjectButtons().size(); j++) {
//                if(view.getMainFrame().getMainPanel().getListPanel().getListPanelButtons().get(j) != tempButton) {
//                    view.getMainFrame().getMainPanel().getListPanel().add(tempButton);
//                }
//            }
            view.getMainFrame().getMainPanel().getListPanel().add(tempButton);
//                                        view.getMainFrame().getMainPanel().getListPanel().addObjectButtons();
        }
    }

    public void addListPanelButtonListener() {
        //Search Button Listener
        this.view.getMainFrame().getMainPanel().getListPanel().getSearchButton().addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        Object source = e.getSource();
                        String searchField = new String(
                                view.getMainFrame().getMainPanel().getListPanel().getSearchField().getText()
                        );
                        boolean temp = model.getSdc().getMovieData().searchMovieHashSet(searchField);
                        if(source instanceof JButton && temp){
                            view.getMainFrame().getMainPanel().getListPanel().getSearchField().setBackground(Color.GREEN);

                        }
                        else {
                            view.getMainFrame().getMainPanel().getListPanel().getSearchField().setBackground(Color.red);
                        }
                    }
                }
        );
        //View Details Button Listener
        this.view.getMainFrame().getMainPanel().getListPanel().getViewDetails().addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        Object source = e.getSource();

                        if(source instanceof JButton && getSelected() != null){
                            view.programPanelSetup(getSelected().getAttributes());
                            view.getMainFrame().getMainPanel().getListPanel().setVisible(false);
                            view.getMainFrame().getProgramPanel().setVisible(true);
                            movieCounter = model.getSdc().getMovieData().getMovies().indexOf(getSelected());
                        }
                    }
                }
        );
    }

    public void createMovieActorButtons() {
        for (int j = 0; j < view.getMainFrame().getMainPanel().getMovieActorPanel()
             .getObjectButtons().size(); j++) {
            view.getMainFrame().getMainPanel().getMovieActorPanel().remove(
                    view.getMainFrame().getMainPanel().getMovieActorPanel()
                            .getObjectButtons().get(j)
            );
        }
        view.getMainFrame().getMainPanel().getMovieActorPanel().getObjectButtons().removeAll(
                view.getMainFrame().getMainPanel().getMovieActorPanel().getObjectButtons());
        movieActorButtons.removeAll(movieActorButtons);
        int movieActorsDisplayed = model.getSdc().getMovieActorData().getMovieActorPairs().size();
        for (int i = 0; i < movieActorsDisplayed; i++) {
            MovieActorButton tempButton = new MovieActorButton(
                    model.getSdc().getMovieActorData().getMovieActorPairs().get(i)
            );
            model.getSdc().getMovieData().searchMovieHashSet(model.getSdc().getMovieActorData()
                    .getMovieActorPairs().get(i).getMovieID());
            String movie = model.getSdc().getMovieData().getMovieSearchResult().getTitle();
            model.getSdc().getActorData().searchActorHashSet(model.getSdc().getMovieActorData()
                    .getMovieActorPairs().get(i).getActorID());
            String actor = model.getSdc().getActorData().getActorSearchResult().getActorString(
                    model.getSdc().getActorData().getActorSearchResult()
            );
            tempButton.setText(movie + " | " + actor);
            movieActorButtons.add(tempButton);
            view.getMainFrame().getMainPanel().getMovieActorPanel().getObjectButtons().add(tempButton);
        }

    }

    public void updateMovieActorPanel() {
        createMovieActorButtons();
        int movieActorsDisplayed = model.getSdc().getMovieActorData().getMovieActorPairs().size();
        for (int i = 0; i < movieActorsDisplayed; i++) {
            int finalI = i;
            movieActorButtons.get(i).addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            addDefaultObjectButtonColor();
                            movieActorButtons.get(finalI).setBackground(view.getMainFrame()
                                    .getMainPanel().getMovieActorPanel().getSelectionColor());
                            setSelectedMovieActor(movieActorButtons.get(finalI).getMovieActor());
                        }
                    }
            );
            view.getMainFrame().getMainPanel().getMovieActorPanel().getMovieActorPanelButtons()
                    .add(movieActorButtons.get(finalI));
            view.getMainFrame().getMainPanel().getMovieActorPanel().getObjectButtons()
                    .add(movieActorButtons.get(finalI));
            view.getMainFrame().getMainPanel().getMovieActorPanel()
                    .add(movieActorButtons.get(finalI));
        }
    }

    public void addMovieActorPanelButtonListeners() {
        //Search Button Listener
        this.view.getMainFrame().getMainPanel().getMovieActorPanel().getSearchButton().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Object source = e.getSource();
                        String searchField = new String(
                                view.getMainFrame().getMainPanel().getMovieActorPanel().getSearchField().getText()
                        );
                        boolean tempMovieSearch = model.getSdc().getMovieData().searchMovieHashSet(searchField);
                        boolean tempActorSearch = model.getSdc().getActorData().searchActorHashSet(searchField);
                        if (source instanceof JButton && (tempMovieSearch || tempActorSearch)) {
                            view.getMainFrame().getMainPanel().getMovieActorPanel().getSearchField().
                                    setBackground(Color.green);
                        }
                        else {
                            view.getMainFrame().getMainPanel().getMovieActorPanel().getSearchField().
                                    setBackground(Color.red);
                        }
                    }
                }
        );
        //Back Button Listener
        this.view.getMainFrame().getMainPanel().getMovieActorPanel().getBackButton().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Object source = e.getSource();
                        if (source instanceof JButton) {
                            view.getMainFrame().getMainPanel().getMovieActorPanel().setVisible(false);
                            view.getMainFrame().getProgramPanel().setVisible(true);
                        }
                    }
                }
        );
        //Delete Button Listener
        this.view.getMainFrame().getMainPanel().getMovieActorPanel().getDeleteButton().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Object source = e.getSource();
                        boolean isSelected = false;
                        MovieActorButton selectedButton = null;

                        if (source instanceof JButton) {
                            for (int i = 0; i < view.getMainFrame().getMainPanel().getMovieActorPanel()
                                    .getObjectButtons().size(); i++) {
                                if (view.getMainFrame().getMainPanel().getMovieActorPanel().getObjectButtons().get(i)
                                        .getBackground() ==
                                        view.getMainFrame().getMainPanel().getMovieActorPanel().getSelectionColor()) {
                                    model.getSdc().getMovieActorData().deleteMovieActor(
                                            view.getMainFrame().getMainPanel().getMovieActorPanel()
                                                    .getObjectButtons().get(i).getMovieActor()
                                    );
                                }
                            }
                            view.getMainFrame().getMainPanel().getMovieActorPanel().setVisible(false);
                            view.getMainFrame().getMainPanel().remove(view.getMainFrame().getMainPanel().getMovieActorPanel());
                            view.getMainFrame().getMainPanel().add(view.getMainFrame().getMainPanel().getMovieActorPanel());
                            updateMovieActorPanel();
                            view.getMainFrame().getMainPanel().getMovieActorPanel().setVisible(true);
                        }
                    }
                }
        );
        //Add Button Listener
        this.view.getMainFrame().getMainPanel().getMovieActorPanel().getAddButton().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Object source = e.getSource();
                        if (source instanceof JButton) {
                            view.getMainFrame().getMainPanel().getMovieActorPanel().setVisible(false);
                            view.getMainFrame().getMainPanel().getMovieActorSubPanel().
                                    setVisible(true);
                        }
                    }
                }
        );
    }

    public void setupMovieActorSubPanel() {
        for (int i = 0; i < model.getSdc().getMovieData().getMovies().size(); i++) {
            MovieButton temp = new MovieButton(model.getSdc().getMovieData().getMovies().get(i));
            view.getMainFrame().getMainPanel().getMovieActorSubPanel().add(temp);
            view.getMainFrame().getMainPanel().getMovieActorSubPanel().getObjectButtons().add(temp);
        }
        for (int j = 0; j < model.getSdc().getActorData().getActors().size(); j++) {
            ActorButton temp = new ActorButton(model.getSdc().getActorData().getActors().get(j));
            view.getMainFrame().getMainPanel().getMovieActorSubPanel().add(temp);
            view.getMainFrame().getMainPanel().getMovieActorSubPanel().getObjectButtons().add(temp);
        }
    }

    public void addMovieActorSubPanelListeners() {
        for (int i = 0; i < view.getMainFrame().getMainPanel().getMovieActorSubPanel().getObjectButtons().size(); i++) {
            int finalI = i;
            view.getMainFrame().getMainPanel().getMovieActorSubPanel().getObjectButtons().get(i).addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Object source = e.getSource();
                            if (source instanceof MovieButton) {
                                for (int j = 0; j < view.getMainFrame().getMainPanel().getMovieActorSubPanel().getObjectButtons().size(); j++) {
                                    if (view.getMainFrame().getMainPanel().getMovieActorSubPanel().getObjectButtons().get(j) instanceof MovieButton) {
                                        view.getMainFrame().getMainPanel().getMovieActorSubPanel().getObjectButtons().get(j).setBackground(
                                                view.getMainFrame().getMainPanel().getMovieActorPanel().getDefaultColor()
                                        );
                                    }
                                }
                                ((JButton) source).setBackground(view.getMainFrame().getMainPanel().getMovieActorPanel().getSelectionColor());
                            }
                            else if (source instanceof ActorButton) {
                                for (int k = 0; k < view.getMainFrame().getMainPanel().getMovieActorSubPanel().getObjectButtons().size(); k++) {
                                    if (view.getMainFrame().getMainPanel().getMovieActorSubPanel().getObjectButtons().get(k) instanceof ActorButton) {
                                        view.getMainFrame().getMainPanel().getMovieActorSubPanel().getObjectButtons().get(k).setBackground(
                                                view.getMainFrame().getMainPanel().getMovieActorPanel().getDefaultColor()
                                        );
                                    }
                                }
                                ((JButton) source).setBackground(view.getMainFrame().getMainPanel().getMovieActorPanel().getSelectionColor());
                            }
                        }
                    }
            );
        }
    }

    public String formatSearchString(String string){
        int index = string.lastIndexOf("|");

        return string.substring(0, index);

    }

    public void addDefaultObjectButtonColor(){
        for(int i = 0; i < view.getMainFrame().getMainPanel().getListPanel().getObjectButtons().size(); i++){
            this.view.getMainFrame().getMainPanel().getListPanel().getObjectButtons().get(i).
                    setBackground(view.getMainFrame().getMainPanel().getListPanel().getDefaultColor());
        }
        for(int i = 0; i < view.getMainFrame().getMainPanel().getMovieActorPanel().getObjectButtons().size(); i++){
            this.view.getMainFrame().getMainPanel().getMovieActorPanel().getObjectButtons().get(i).
                    setBackground(view.getMainFrame().getMainPanel().getMovieActorPanel().getDefaultColor());
        }
    }

//    public static void programPanelButtonAction(String buttonString){
//        if(buttonString == "Previous"){
//
//        }
//    }

    public Model getModel()
    {
        return model;
    }

    public void setModel(Model model)
    {
        this.model = model;
    }

    public View getView()
    {
        return view;
    }

    public void setView(View view)
    {
        this.view = view;
    }

    public int getMovieCounter() {
        return movieCounter;
    }

    public void setMovieCounter(int movieCounter) {
        this.movieCounter = movieCounter;
    }

    public Movie getSelected() {
        return selected;
    }

    public void setSelected(Movie selected) {
        this.selected = selected;
    }

    public MovieActor getSelectedMovieActor() {
        return selectedMovieActor;
    }

    public void setSelectedMovieActor(MovieActor selectedMovieActor) {
        this.selectedMovieActor = selectedMovieActor;
    }
}
