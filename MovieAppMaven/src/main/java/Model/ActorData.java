/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;
import java.util.*;

public class ActorData implements Displayable{

    ArrayList<Actor> actors = new ArrayList<>();
    HashSet actorSet;
    private int firstLine;
    private int getLineToHighlight;
    private int lastLine;
    private int numberOfLines;
    private Actor actorSearchResult;
    
    public ActorData(){
        actorSearchResult = new Actor(UUID.randomUUID().toString(), "null", "null", 0);

        createTestActorData();
        actorSet = new HashSet(actors);
    }

    private void createTestActorData() {
        String firstNameTemp = "FirstName";
        String lastNameTemp = "LastName";
        Integer ageTemp = 0;

        Actor tempActor = new Actor(UUID.randomUUID().toString(), firstNameTemp, lastNameTemp, ageTemp);

        for(int i = 0; i < 10; i++) {
            //Generate First Name
            firstNameTemp = "First" + i;
            //Generate Last Name
            lastNameTemp = "Last" + i;
            //Randomize Age
            Random random = new Random();
            ageTemp = random.nextInt(99);
            //Add Generated Actor
            tempActor = new Actor(UUID.randomUUID().toString(), firstNameTemp, lastNameTemp, ageTemp);
            actors.add(tempActor);
        }

    }

    public ArrayList<String> getActorIDs() {
        ArrayList<String> actorIDs = new ArrayList<>();
        Iterator<Actor> i = actorSet.iterator();
        while (i.hasNext()) {
            String temp = i.next().getUuid();
            actorIDs.add(temp);
        }
        return actorIDs;
    }

    public boolean searchActorHashSet(String searchField) {
        boolean searchFound = false;
        Actor matchedActor = new Actor(UUID.randomUUID().toString(), "null", "null", 0);
        Actor temporaryActor = new Actor(UUID.randomUUID().toString(), "first", "last", 0);
        Iterator<Actor> i = actorSet.iterator();
        while (i.hasNext()) {
            temporaryActor = i.next();
            for (int j = 0; j < temporaryActor.getAllAttributes().size(); j++) {
                String comparisonString = temporaryActor.getAttribute(j).toString();
                if (searchField.compareTo(comparisonString) == 0) {
                    searchFound = true;
                    actorSearchResult = temporaryActor;
                    return searchFound;
                }
            }
        }
        return searchFound;
    }

    @Override
    public int getLinesBeingDisplayed(){
        return getLastLineToDisplay() - getFirstLineToDisplay();
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLine;
    }

    @Override
    public int getLineToHighlight() {
       return getLineToHighlight;
    }

    @Override
    public int getLastLineToDisplay() 
    {
        return lastLine;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        this.firstLine = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        this.getLineToHighlight = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLine = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    public Actor getActorSearchResult() {
        return actorSearchResult;
    }

    public void setActorSearchResult(Actor actorSearchResult) {
        this.actorSearchResult = actorSearchResult;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public HashSet getActorSet() {
        return actorSet;
    }

    public void setActorSet(HashSet actorSet) {
        this.actorSet = actorSet;
    }
}
