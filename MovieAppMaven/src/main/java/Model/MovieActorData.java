package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;
import java.util.UUID;

public class MovieActorData implements Displayable{

    ArrayList<MovieActor> movieActorPairs = new ArrayList<MovieActor>();
    TreeSet<MovieActor> movieActorTreeSet = new TreeSet<MovieActor>();

    public MovieActorData() {

    }

    public void createTestMovieActorData(ArrayList<String> movieIDs, ArrayList<String> actorIDs) {
        Integer movieIdArraySize = movieIDs.size();
        Integer actorIdArraySize = actorIDs.size();
        Integer larger = actorIdArraySize;
        Random r = new Random();
        for (int i = 0; i < larger; i++) {
            //Pick Random Movie to pair with actor;
            String tempMovieID = movieIDs.get(r.nextInt(movieIdArraySize));
            String tempActorID = actorIDs.get(i);
            MovieActor temp = new MovieActor(tempMovieID, tempActorID);
            movieActorPairs.add(temp);
            movieActorTreeSet.add(temp);
        }
    }

    public void deleteMovieActor(MovieActor movieActor) {
        if (movieActorTreeSet.contains(movieActor)) {
            movieActorTreeSet.remove(movieActor);
            movieActorPairs.remove(movieActor);
        }
    }

    public ArrayList<MovieActor> getMovieActorPairs() {
        return movieActorPairs;
    }

    public void setMovieActorPairs(ArrayList<MovieActor> movieActorPairs) {
        this.movieActorPairs = movieActorPairs;
    }

    public TreeSet<MovieActor> getMovieActorTreeSet() {
        return movieActorTreeSet;
    }

    public void setMovieActorTreeSet(TreeSet<MovieActor> movieActorTreeSet) {
        this.movieActorTreeSet = movieActorTreeSet;
    }

    @Override
    public int getFirstLineToDisplay() {
        return 0;
    }

    @Override
    public int getLineToHighlight() {
        return 0;
    }

    @Override
    public int getLastLineToDisplay() {
        return 0;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return 0;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {

    }

    @Override
    public void setLineToHighlight(int highlightedLine) {

    }

    @Override
    public void setLastLineToDisplay(int lastLine) {

    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {

    }
}
