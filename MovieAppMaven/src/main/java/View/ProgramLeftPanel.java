package View;

import javax.swing.*;

public class ProgramLeftPanel extends JPanel {

    private ImagePanel imagePanel;
    private JLabel placeholder;

    public ProgramLeftPanel(){

        imagePanel = new ImagePanel();
        imagePanel.add(placeholder = new JLabel("This is placeholder text."));

        add(imagePanel);
    }
}
