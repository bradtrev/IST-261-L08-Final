/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Brad
 */
public class Cast {
    private ArrayList<Actor> actors;

    private Actor actor1;
    private Actor actor2;
    private Actor actor3;

    public Cast(Actor actor1In, Actor actor2In, Actor actor3In){
        actor1 = new Actor(UUID.randomUUID().toString(), "Default", "Default", 0);
        actor2 = new Actor(UUID.randomUUID().toString(), "Default", "Default", 0);
        actor3 = new Actor(UUID.randomUUID().toString(), "Default", "Default", 0);
        actor1 = actor1In;
        actor2 = actor2In;
        actor3 = actor3In;

    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }
    
}
