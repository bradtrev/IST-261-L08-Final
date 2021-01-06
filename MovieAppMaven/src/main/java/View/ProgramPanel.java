package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProgramPanel extends JPanel {

    private ArrayList<JButton> programPanelButtons;

    // DECLARE PANELS
    private ProgramOptionsPanel programOptionsPanel;
    private GridLayout programOptionLayout;
    private ProgramSubPanel programSubPanel;
    private GridLayout programSubLayout;
    private ProgramNavigationPanel programNavigationPanel;
    private GridLayout programNavigationLayout;
    private ProgramReturnPanel programReturnPanel;
    private GridLayout programReturnLayout;

    //DECLARE OPTION PANEL COMPONENTS
    private JButton delete;
    private JButton add;


    //DECLARE NAVIGATION PANEL COMPONENTS
    private JButton previous;
    private JButton next;
    private JButton saveEdits;
    private JButton undoChanges;

    //DECLARE RETURN PANEL COMPONENTS
    private JButton movieList;
    private JButton movieActorList;

    public ProgramPanel(){

        //INSTANTIATE BUTTON AND TEXTFIELD ARRAYS
        programPanelButtons = new ArrayList<>();

        //FORMAT OPTION PANEL
        delete = new JButton("Delete");
            programPanelButtons.add(delete);
        add = new JButton("Add");
            programPanelButtons.add(add);
        saveEdits = new JButton("Save Edits");
            programPanelButtons.add(saveEdits);

        programOptionsPanel = new ProgramOptionsPanel();
        programOptionLayout = new GridLayout(1,3);
        programOptionsPanel.setLayout(programOptionLayout);

        programOptionsPanel.add(delete);
        programOptionsPanel.add(add);
        programOptionsPanel.add(saveEdits);

        //FORMAT SUB PANEL
        programSubPanel = new ProgramSubPanel();
        programSubLayout = new GridLayout(1,2);
        programSubPanel.setLayout(programSubLayout);

        //FORMAT NAVIGATION PANEL
        previous = new JButton("Previous");
            programPanelButtons.add(previous);
        next = new JButton("Next");
            programPanelButtons.add(next);
        undoChanges = new JButton("Undo Changes");
            programPanelButtons.add(undoChanges);

        programNavigationPanel = new ProgramNavigationPanel();
        programNavigationLayout = new GridLayout(1,3);
        programNavigationPanel.setLayout(programNavigationLayout);

        programNavigationPanel.add(previous);
        programNavigationPanel.add(undoChanges);
        programNavigationPanel.add(next);

        //FORMAT RETURN PANEL
        movieList = new JButton("See Movies as List");
            programPanelButtons.add(movieList);
        movieActorList = new JButton("See MovieActor Pairs (Collection II)");
            programPanelButtons.add(movieActorList);
        programReturnPanel = new ProgramReturnPanel();
        programReturnLayout = new GridLayout(1, 2);
        programReturnPanel.setLayout(programReturnLayout);

        programReturnPanel.add(movieList);
        programReturnPanel.add(movieActorList);

        //ADD PANELS
        add(programOptionsPanel);
        add(programSubPanel);
        add(programNavigationPanel);
        add(programReturnPanel);

    }

    public ArrayList<JButton> getProgramPanelButtons() {
        return programPanelButtons;
    }

    public void setProgramPanelButtons(ArrayList<JButton> programPanelButtons) {
        this.programPanelButtons = programPanelButtons;
    }

    public JButton getDelete() {
        return delete;
    }

    public void setDelete(JButton delete) {
        this.delete = delete;
    }

    public JButton getPrevious() {
        return previous;
    }

    public void setPrevious(JButton previous) {
        this.previous = previous;
    }

    public JButton getAdd() {
        return add;
    }

    public void setAdd(JButton add) {
        this.add = add;
    }

    public JButton getNext() {
        return next;
    }

    public void setNext(JButton next) {
        this.next = next;
    }

    public ProgramOptionsPanel getProgramOptionsPanel() {
        return programOptionsPanel;
    }

    public void setProgramOptionsPanel(ProgramOptionsPanel programOptionsPanel) {
        this.programOptionsPanel = programOptionsPanel;
    }

    public GridLayout getProgramOptionLayout() {
        return programOptionLayout;
    }

    public void setProgramOptionLayout(GridLayout programOptionLayout) {
        this.programOptionLayout = programOptionLayout;
    }

    public ProgramSubPanel getProgramSubPanel() {
        return programSubPanel;
    }

    public void setProgramSubPanel(ProgramSubPanel programSubPanel) {
        this.programSubPanel = programSubPanel;
    }

    public GridLayout getProgramSubLayout() {
        return programSubLayout;
    }

    public void setProgramSubLayout(GridLayout programSubLayout) {
        this.programSubLayout = programSubLayout;
    }

    public ProgramNavigationPanel getProgramNavigationPanel() {
        return programNavigationPanel;
    }

    public void setProgramNavigationPanel(ProgramNavigationPanel programNavigationPanel) {
        this.programNavigationPanel = programNavigationPanel;
    }

    public GridLayout getProgramNavigationLayout() {
        return programNavigationLayout;
    }

    public void setProgramNavigationLayout(GridLayout programNavigationLayout) {
        this.programNavigationLayout = programNavigationLayout;
    }

    public JButton getSaveEdits() {
        return saveEdits;
    }

    public void setSaveEdits(JButton saveEdits) {
        this.saveEdits = saveEdits;
    }

    public JButton getUndoChanges() {
        return undoChanges;
    }

    public void setUndoChanges(JButton undoChanges) {
        this.undoChanges = undoChanges;
    }

    public ProgramReturnPanel getProgramReturnPanel() {
        return programReturnPanel;
    }

    public void setProgramReturnPanel(ProgramReturnPanel programReturnPanel) {
        this.programReturnPanel = programReturnPanel;
    }

    public GridLayout getProgramReturnLayout() {
        return programReturnLayout;
    }

    public void setProgramReturnLayout(GridLayout programReturnLayout) {
        this.programReturnLayout = programReturnLayout;
    }
}
