package View;

import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class MainFrame extends JFrame
{

    private MainPanel mainPanel;
    private GridBagLayout mainGridBagLayout;
    private GridBagConstraints mainConstraints;

    private ProgramPanel programPanel;
    private GridBagLayout programGridBagLayout;
    private GridBagConstraints programConstraints;

    public MainFrame()
    {
        //FORMATTING PANELS
        mainPanel = new MainPanel();
        mainGridBagLayout = new GridBagLayout();
        mainPanel.setLayout(mainGridBagLayout);
        mainConstraints = new GridBagConstraints();

        // Program Panel (Houses: Options, Sub, and Navigation)
        programPanel = new ProgramPanel();
        programGridBagLayout = new GridBagLayout();
        programConstraints = new GridBagConstraints();
        programPanel.setLayout(programGridBagLayout);

        // Program Options Panel (Top Panel)
        programConstraints.gridx = 1;
        programConstraints.gridy = 0;
        programConstraints.gridwidth = 1;
        programConstraints.ipadx = 200;
        programConstraints.ipady = 40;
        programPanel.add(programPanel.getProgramOptionsPanel(),programConstraints);

        // Program Sub Panel
        programConstraints.gridx = 1;
        programConstraints.gridy = 1;
        programConstraints.gridwidth = 1;
        programConstraints.ipadx = 300;
        programConstraints.ipady = 600;
        programPanel.add(programPanel.getProgramSubPanel(),programConstraints);

        // Program Navigation Panel
        programConstraints.gridx = 1;
        programConstraints.gridy = 2;
        programConstraints.gridwidth = 1;
        programConstraints.ipadx = 200;
        programConstraints.ipady = 40;
        programPanel.add(programPanel.getProgramNavigationPanel(),programConstraints);

        // Program Return Panel
        programConstraints.gridx = 1;
        programConstraints.gridy = 3;
        programConstraints.gridwidth = 4;
        programConstraints.ipadx = 400;
        programConstraints.ipady = 40;
        programPanel.add(programPanel.getProgramReturnPanel(),programConstraints);

        //SETTING GRID BAG CONSTRAINTS
        mainConstraints.fill = GridBagConstraints.BOTH;
        mainConstraints.gridx = 0;
        mainConstraints.gridy = 4;
        mainPanel.add(programPanel, mainConstraints);

        add(mainPanel);
        mainPanel.add(programPanel);

        //------------------------------------------------------
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 1000);
        setVisible(true);
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public GridBagLayout getMainGridBagLayout() {
        return mainGridBagLayout;
    }

    public void setMainGridBagLayout(GridBagLayout mainGridBagLayout) {
        this.mainGridBagLayout = mainGridBagLayout;
    }

    public GridBagConstraints getMainConstraints() {
        return mainConstraints;
    }

    public void setMainConstraints(GridBagConstraints mainConstraints) {
        this.mainConstraints = mainConstraints;
    }

    public ProgramPanel getProgramPanel() {
        return programPanel;
    }

    public void setProgramPanel(ProgramPanel programPanel) {
        this.programPanel = programPanel;
    }

    public GridBagLayout getProgramGridBagLayout() {
        return programGridBagLayout;
    }

    public void setProgramGridBagLayout(GridLayout programGridLayout) {
        this.programGridBagLayout = programGridBagLayout;
    }
}
