package View;

import javax.swing.*;
import java.util.ArrayList;


public class View
{
    MainFrame mainFrame;


    public View()
    {
       mainFrame = new MainFrame();
    }

    public void programPanelSetup(ArrayList<String> programAttributes){
        for(int i = 0; i < programAttributes.size(); i++){
            mainFrame.getProgramPanel().getProgramSubPanel().getProgramPanelTextFields().get(i).setText(programAttributes.get(i));
//            System.out.println(programAttributes.size());
//            System.out.println(mainFrame.getProgramPanel().getProgramSubPanel().getProgramPanelTextFields().size());
        }
    }

    public void defaultProgramPanelTextFields(){
        ArrayList<String> defaults = new ArrayList<>();
        defaults.add("Title");
        defaults.add("0000");
        defaults.add("Genre");
        defaults.add("0.0");
        defaults.add("Synopsis");
        defaults.add("First Last 01");
        defaults.add("First Last 02");
        defaults.add("First Last 03");
        for (int j = 0; j < mainFrame.getProgramPanel().getProgramSubPanel().getProgramPanelTextFields().size(); j++){
            mainFrame.getProgramPanel().getProgramSubPanel().getProgramPanelTextFields().get(j).setText(
                    defaults.get(j)
            );
        }
    }

//    public void addListPanelObjectButton(ArrayList<String> programAttributes){
//        for(int i = 0; i < programAttributes.size(); i++){
//            getMainFrame().getMainPanel().getListPanel().add(new JButton(programAttributes.get(i).get))
//        }
//    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
}
