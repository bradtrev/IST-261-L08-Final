package Controller;

import Model.Actor;

import javax.swing.*;
import java.awt.*;

public class ActorButton extends JButton {

    private Actor actor;

    public ActorButton(Actor actor) {
        this.actor = actor;

        setBackground(Color.white);
    }
}
