package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProgramSubPanel extends JPanel{

    private ArrayList<JTextField> programPanelTextFields;

    private ProgramLeftPanel programLeftPanel;
    private GridLayout programLeftLayout;
    private ProgramRightPanel programRightPanel;
    private GridLayout programRightLayout;

    //DECLARE LEFT PANEL COMPONENTS
    private ImagePanel imagePanel;
    private GridLayout imageGridLayout;

    //DECLARE RIGHT PANEL COMPONENTS
    private JTextField title;
    private JTextField year;
    private JTextField genre;
    private JTextField rating;
    private JTextField synopsis;
    private JTextField actor1;
    private JTextField actor2;
    private JTextField actor3;

    public ProgramSubPanel(){
        programPanelTextFields = new ArrayList<>();

        //INSTANTIATE LEFT PANEL COMPONENTS
        imagePanel = new ImagePanel();
        imageGridLayout = new GridLayout(1,1);
        //INSTANTIATE LEFT PANEL
        programLeftPanel = new ProgramLeftPanel();
        programLeftLayout = new GridLayout();
        programLeftLayout.setRows(1);
        programLeftLayout.setColumns(1);
        programLeftPanel.setLayout(programLeftLayout);
        //ADD LEFT PANEL COMPONENTS
        programLeftPanel.add(imagePanel);


        //INSTANTIATE RIGHT PANEL COMPONENTS
        title = new JTextField("Title");
        programPanelTextFields.add(title);
        year = new JTextField("Year");
        programPanelTextFields.add(year);
        genre = new JTextField("Genre");
        programPanelTextFields.add(genre);
        rating = new JTextField("Rating");
        programPanelTextFields.add(rating);
        synopsis = new JTextField("Synopsis");
        programPanelTextFields.add(synopsis);
        actor1 = new JTextField("Actor 1");
        programPanelTextFields.add(actor1);
        actor2 = new JTextField("Actor 2");
        programPanelTextFields.add(actor2);
        actor3 = new JTextField("Actor 3");
        programPanelTextFields.add(actor3);

        //INSTANTIATE RIGHT PANEL
        programRightPanel = new ProgramRightPanel();
        programRightLayout = new GridLayout();
        programRightLayout.setColumns(1);
        programRightLayout.setRows(8);
        programRightPanel.setLayout(programRightLayout);
        //ADD RIGHT PANEL COMPONENTS
        programRightPanel.add(title);
        programRightPanel.add(year);
        programRightPanel.add(genre);
        programRightPanel.add(rating);
        programRightPanel.add(synopsis);
        programRightPanel.add(actor1);
        programRightPanel.add(actor2);
        programRightPanel.add(actor3);

        add(programLeftPanel);
        add(programRightPanel);
    }

    public ArrayList<JTextField> getProgramPanelTextFields() {
        return programPanelTextFields;
    }

    public void setProgramPanelTextFields(ArrayList<JTextField> programPanelTextFields) {
        this.programPanelTextFields = programPanelTextFields;
    }

    public ProgramRightPanel getProgramRightPanel() {
        return programRightPanel;
    }

    public void setProgramRightPanel(ProgramRightPanel programRightPanel) {
        this.programRightPanel = programRightPanel;
    }

    public GridLayout getProgramRightLayout() {
        return programRightLayout;
    }

    public void setProgramRightLayout(GridLayout programRightLayout) {
        this.programRightLayout = programRightLayout;
    }

    public ProgramLeftPanel getProgramLeftPanel() {
        return programLeftPanel;
    }

    public void setProgramLeftPanel(ProgramLeftPanel programLeftPanel) {
        this.programLeftPanel = programLeftPanel;
    }

    public GridLayout getProgramLeftLayout() {
        return programLeftLayout;
    }

    public void setProgramLeftLayout(GridLayout programLeftLayout) {
        this.programLeftLayout = programLeftLayout;
    }

    public JTextField getTitle() {
        return title;
    }

    public void setTitle(JTextField title) {
        this.title = title;
    }

    public JTextField getYear() {
        return year;
    }

    public void setYear(JTextField year) {
        this.year = year;
    }

    public JTextField getGenre() {
        return genre;
    }

    public void setGenre(JTextField genre) {
        this.genre = genre;
    }

    public JTextField getRating() {
        return rating;
    }

    public void setRating(JTextField rating) {
        this.rating = rating;
    }

    public JTextField getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(JTextField synopsis) {
        this.synopsis = synopsis;
    }

    public ImagePanel getImagePanel() {
        return imagePanel;
    }

    public void setImagePanel(ImagePanel imagePanel) {
        this.imagePanel = imagePanel;
    }

    public GridLayout getImageGridLayout() {
        return imageGridLayout;
    }

    public void setImageGridLayout(GridLayout imageGridLayout) {
        this.imageGridLayout = imageGridLayout;
    }

    public JTextField getActor1() {
        return actor1;
    }

    public void setActor1(JTextField actor1) {
        this.actor1 = actor1;
    }

    public JTextField getActor2() {
        return actor2;
    }

    public void setActor2(JTextField actor2) {
        this.actor2 = actor2;
    }

    public JTextField getActor3() {
        return actor3;
    }

    public void setActor3(JTextField actor3) {
        this.actor3 = actor3;
    }
}
