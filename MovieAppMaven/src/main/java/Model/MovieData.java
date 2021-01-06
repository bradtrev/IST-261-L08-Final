/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.crypto.spec.PSource;
import javax.sql.rowset.serial.SQLOutputImpl;
import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 *
 * @author Brad
 */
public class MovieData implements Displayable, Searchable {

    private LinkedList moviesLL;
    private String listOfMoviesFileName = "listOfMovies.ser";
    private ArrayList<Movie> movies = new ArrayList<>();
    private HashSet movieSet;
    private int firstLine;
    private int lastLine;
    private int getLineToHighlight;
    private int numberOfLines;
    private int movieCounter;
    private Movie movieSearchResult;
    private Movie testMovie;
    private HashSet<Movie> movieHashSet;

    public MovieData() {

        moviesLL = new LinkedList<Movie>();

        this.readMoviesFile();
        if(movies.isEmpty() || movies == null) {
            this.createTestMoviesList();
            this.writeMoviesFile();
            this.readMoviesFile();
        }
        this.printMovies();

        movieHashSet = new HashSet<Movie>(movies);
        System.out.println("The Movies in the Hashset are: " + movieHashSet);

        testMovie = new Movie(UUID.randomUUID().toString(),"Title", 0000, "Genre", 0.0, "Synopsis",
                new Actor(UUID.randomUUID().toString(), "First", "Last", 00),
                new Actor(UUID.randomUUID().toString(), "First", "Last", 00),
                new Actor(UUID.randomUUID().toString(), "First", "Last", 00),
                "Path"
                );

//        System.out.println("NOW THE FULL LINKED LIST WILL BE PRINTED");
//        printList();
//        System.out.println("NOW THE TEST MOVIE WILL BE ADDED TO THE LINKED LIST");
//        addMovie(testMovie);
////        moviesLL.add(testMovie);
//        System.out.println("(2) NOW THE FULL LINKED LIST WILL BE PRINTED");
//        printList();
//        System.out.println("NOW WE WILL SEARCH THE LINKED LIST AND PRINT THE RESULT");
//        if (getMovie("Title")) {
//            System.out.println(movieSearchResult.toString());
//        }
//        System.out.println("NOW WE WILL REMOVE THE TEST MOVIE");
//        removeMovie(testMovie);
//        System.out.println("(3) NOW THE FULL LINKED LIST WILL BE PRINTED");
//        printList();
    }

    public void createTestMoviesList(){
        Movie TheDarkKnight = new Movie(UUID.randomUUID().toString(),"The Dark Knight", 2008, "Drama/Thriller", 9.0,
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman " +
                        "must accept one of the greatest psychological and physical tests of his ability to fight " +
                        "injustice.", new Actor(UUID.randomUUID().toString(), "Christian", "Bale", 45),
                new Actor(UUID.randomUUID().toString(), "Heath", "Ledger", 28),
                new Actor(UUID.randomUUID().toString(), "Aaron",  "Eckhart", 51),
                "E:\\OneDrive\\Documents\\Academic\\Courses\\World Campus\\Semester 2\\IST 261\\" +
                        "MovieDatabaseAppMaven\\src\\main\\java\\Model\\Movie Posters\\TheDarkKnight.jpg"
        );
        movies.add(TheDarkKnight);
        moviesLL.add(TheDarkKnight);

        Movie Gladiator = new Movie(UUID.randomUUID().toString(),"Gladiator", 2000, "Action/Adventure/Drama", 8.5,
                "A former Roman General sets out to exact vengeance against the corrupt emperor who " +
                        "murdered his family and sent him into slavery.",
                new Actor(UUID.randomUUID().toString(),"Russell", "Crowe", 55),
                new Actor(UUID.randomUUID().toString(),"Joaquin", "Phoenix", 44),
                new Actor(UUID.randomUUID().toString(),"Connie", "Nielsen", 54),
                "E:\\OneDrive\\Documents\\Academic\\Courses\\World Campus\\Semester 2\\IST 261\\" +
                        "MovieDatabaseAppMaven\\src\\main\\java\\Model\\Movie Posters\\Gladiator.jpg"
        );
        movies.add(Gladiator);
        moviesLL.add(Gladiator);

        Movie Interstellar = new Movie(UUID.randomUUID().toString(),"Interstellar", 2014, "Adventure/Drama/Sci-Fi", 8.6,
                "A team of explorers travel through a wormhole in space in an attempt to ensure " +
                        "humanity's survival.",
                new Actor(UUID.randomUUID().toString(),"Matthew", "McConaughey", 49),
                new Actor(UUID.randomUUID().toString(),"Anne", "Hathaway", 36),
                new Actor(UUID.randomUUID().toString(),"Jessica", "Chastain", 42),
                "E:\\OneDrive\\Documents\\Academic\\Courses\\World Campus\\Semester 2\\IST 261\\" +
                        "MovieDatabaseAppMaven\\src\\main\\java\\Model\\Movie Posters\\Interstellar.jpg"
        );
        movies.add(Interstellar);
        moviesLL.add(Interstellar);

        //Sort Lists/Arrays


//        System.out.println("Test MovieData created");
//        for(Movie movie : movies) {
//            System.out.println("The MovieData is:\n"+ movie.toString());
//        }
    }

    public void writeMoviesFile() {
        try {
            FileOutputStream fos = new FileOutputStream(listOfMoviesFileName);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(movies);
            out.close();
            fos.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void readMoviesFile(){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(listOfMoviesFileName);
            in = new ObjectInputStream(fis);
            movies = (ArrayList<Movie>) in.readObject();
            in.close();
            fis.close();
            if(!movies.isEmpty()) {
                System.out.println("There are Movies in the MovieData");
            }
        }
        catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void printMovies(){
        System.out.println("The MovieData ArrayList has these Movies:");
        for(int i = 0; i < movies.size(); i++) {
            Movie temp = (Movie) movies.get(i);
            System.out.println(temp.getAttributes());
        }
    }

    public void addMovie(String titleIn, String yearIn, String genreIn, String ratingIn, String synopsisIn,
                         String actor1In, String actor2In, String actor3In, String imagePathIn){

        String[] stringArray1 = actor1In.split(" ");
//        ArrayList<String> actor1ArrayList = new ArrayList<>();

        String[] stringArray2 = actor2In.split(" ");
//        ArrayList<String> actor2ArrayList = new ArrayList<>();

        String[] stringArray3 = actor3In.split(" ");
//        ArrayList<String> actor3ArrayList = new ArrayList<>();

        Actor temporary1 = new Actor(UUID.randomUUID().toString(), (String)Array.get(stringArray1, 0), (String)Array.get(stringArray1, 1), Integer.parseInt((String)Array.get(stringArray1, 2)));
        Actor temporary2 = new Actor(UUID.randomUUID().toString(), (String)Array.get(stringArray2, 0), (String)Array.get(stringArray2, 1), Integer.parseInt((String)Array.get(stringArray2, 2)));
        Actor temporary3 = new Actor(UUID.randomUUID().toString(), (String)Array.get(stringArray3, 0), (String)Array.get(stringArray3, 1), Integer.parseInt((String)Array.get(stringArray3, 2)));

        Movie newMovie = new Movie(UUID.randomUUID().toString(), titleIn, Integer.parseInt(yearIn), genreIn, Double.parseDouble(ratingIn), synopsisIn, temporary1, temporary2, temporary3, imagePathIn);

        movies.add(newMovie);
        moviesLL.add(newMovie);
        movieHashSet.add(newMovie);
    }

    public void editMovie(Integer n, String titleIn, String yearIn, String genreIn, String ratingIn,
                          String actor1In, String actor2In, String actor3In, String synopsisIn, String imagePathIn){
        String[] stringArray1 = actor1In.split(" ");

        String[] stringArray2 = actor2In.split(" ");

        String[] stringArray3 = actor3In.split(" ");

//        Actor temporary1;
//        System.out.println(stringArray1[2]);
//        temporary1 = new Actor(stringArray1[0],stringArray1[1],
//                Integer.parseInt(stringArray1[2].substring(1, stringArray1[2].length()-1)));

//        Actor temporary2;
//        temporary2 = new Actor(stringArray2[0], stringArray2[1],
//                Integer.parseInt(stringArray2[2].substring(1, stringArray2[2].length()-1)));

//        Actor temporary3;
//        temporary3 = new Actor(stringArray3[0], stringArray3[1],
//                Integer.parseInt(stringArray3[2].substring(1, stringArray3[2].length()-1)));

        movies.get(n).setTitle(titleIn);
        movies.get(n).setYear(Integer.parseInt(yearIn));
        movies.get(n).setGenre(genreIn);
        movies.get(n).setRating(Double.parseDouble(ratingIn));
        movies.get(n).getActor1().setFirstName(stringArray1[0]);
        movies.get(n).getActor1().setLastName(stringArray1[1]);
        movies.get(n).getActor1().setAge(Integer.parseInt(stringArray1[2].substring(1, stringArray1[2].length()-1)));
//        movies.get(n).setActor1(temporary1);
        movies.get(n).getActor2().setFirstName(stringArray2[0]);
        movies.get(n).getActor2().setLastName(stringArray2[1]);
        movies.get(n).getActor2().setAge(Integer.parseInt(stringArray2[2].substring(1, stringArray2[2].length()-1)));
//        movies.get(n).setActor2(temporary2);
        movies.get(n).getActor3().setFirstName(stringArray3[0]);
        movies.get(n).getActor3().setLastName(stringArray3[1]);
        movies.get(n).getActor3().setAge(Integer.parseInt(stringArray3[2].substring(1, stringArray3[2].length()-1)));
//        movies.get(n).setActor3(temporary3);
        movies.get(n).setSynopsis(synopsisIn);
        movies.get(n).setImagePath(imagePathIn);
    }

    public void deleteMovie(int index){
        boolean deleteMovie = false;
        Movie movieToBeDeleted = movies.get(index);
        Movie temporaryMovie = new Movie(UUID.randomUUID().toString(), "Title", 0000, "Genre", 0.0, "Synopsis",
                new Actor(UUID.randomUUID().toString(), "Actor", "One", 00),
                new Actor(UUID.randomUUID().toString(), "Actor", "Two", 00),
                new Actor(UUID.randomUUID().toString(), "Actor", "Three", 00),
                "Path"
        );
        Iterator<Movie> i = movieHashSet.iterator();
        while (i.hasNext()) {
            temporaryMovie = i.next();
            for (int j = 0; j < temporaryMovie.getAttributes().size(); j++) {
                String comparisonString = temporaryMovie.getAttribute(j).toString();
                if (movieToBeDeleted.getAttribute(j).compareTo(temporaryMovie.getAttribute(j)) == 0) {
                    deleteMovie = true;
                }
            }
            if(deleteMovie) {
                movies.remove(index);
                i.remove();
            }
        }


    }

    public boolean searchMovieHashSet(String searchField) {
        boolean searchFound = false;
        Movie matchedMovie = new Movie(UUID.randomUUID().toString(),"null", 0, "null", 0.0, "null",
                new Actor(UUID.randomUUID().toString(), "null", "null", 0),
                new Actor(UUID.randomUUID().toString(), "null", "null", 0),
                new Actor(UUID.randomUUID().toString(), "null", "null", 0),
                "null"
        );
        Movie temporaryMovie = new Movie(UUID.randomUUID().toString(),"Title", 0000, "Genre", 0.0, "Synopsis",
                new Actor(UUID.randomUUID().toString(), "Actor", "One", 00),
                new Actor(UUID.randomUUID().toString(), "Actor", "Two", 00),
                new Actor(UUID.randomUUID().toString(), "Actor", "Three", 00),
                "Path"
        );
        Iterator<Movie> i = movieHashSet.iterator();
        while (i.hasNext()) {
            temporaryMovie = i.next();
            for (int j = 0; j < temporaryMovie.getAllAttributes().size(); j++) {
                String comparisonString = temporaryMovie.getAttribute(j).toString();
                if (searchField.compareTo(comparisonString) == 0) {
                    searchFound = true;
                    movieSearchResult = temporaryMovie;
                    return searchFound;
                }
            }
        }
        return searchFound;
    }

    public ArrayList<String> getMovieIDs() {
        ArrayList<String> movieIDs = new ArrayList<>();
        Iterator<Movie> i = movieHashSet.iterator();
        while (i.hasNext()) {
            String temp = i.next().getUUID();
            movieIDs.add(temp);
        }
        return movieIDs;
    }

    ///////////////////////////////////////// LinkedList<Movie> Methods ////////////////////////////////////////////////
    public void printList() {
        System.out.println("Printing LinkedList of Movies");
        ListIterator<Movie>  movieListIterator = moviesLL.listIterator();
        while (movieListIterator.hasNext()) {
            System.out.println(movieListIterator.next().toString());
        }
    }

    public void addMovie(Movie newMovie){
        boolean movieAdded = false;
        boolean insert = false;
        ListIterator<Movie> movieListIterator = moviesLL.listIterator();
        while (movieListIterator.hasNext()) {
            insert = movieListIterator.next().decideInsert(newMovie);
            if(insert) {
                int prevIndex = movieListIterator.previousIndex();
                moviesLL.add(movieListIterator.previousIndex(), newMovie);
                movieAdded = true;
                break;
            }
        }
        if (!movieAdded) {
            moviesLL.add(newMovie);
            System.out.println("Movie added to LinkedList");
        }
        movieHashSet.add(newMovie);
    }

    public void removeMovie(Movie movieToRemove){
        boolean movieRemoved = false;
        ListIterator<Movie> movieListIterator = moviesLL.listIterator();
        while (movieListIterator.hasNext()) {
            if(movieToRemove.getTitle() == movieListIterator.next().getTitle()) {
                movieListIterator.remove();
                movieRemoved = true;
            }
        }
        if(movieRemoved) {
            System.out.println("Movie was removed from LinkedList");
        }
    }

    public boolean getMovie(String searchTerm){
        boolean searchResult = false;
        Movie matchedMovie = new Movie(UUID.randomUUID().toString(),"null", 0, "null", 0.0, "null",
                new Actor(UUID.randomUUID().toString(), "null", "null", 0),
                new Actor(UUID.randomUUID().toString(), "null", "null", 0),
                new Actor(UUID.randomUUID().toString(), "null", "null", 0),
                "null"
        );
        ListIterator<Movie> movieListIterator = moviesLL.listIterator();

        Movie tempMovie = new Movie(UUID.randomUUID().toString(),"Title", 0000, "Genre", 0.0, "Synopsis",
                new Actor(UUID.randomUUID().toString(), "Actor", "One", 00),
                new Actor(UUID.randomUUID().toString(), "Actor", "Two", 00),
                new Actor(UUID.randomUUID().toString(), "Actor", "Three", 00),
                "Path"
        );

        while (movieListIterator.hasNext()) {
            tempMovie = movieListIterator.next();
            for(int i = 0; i < tempMovie.getAttributes().size(); i++) {
                if (searchTerm == tempMovie.getAttribute(i)) {
                    searchResult = true;
                    movieSearchResult = tempMovie;
                }
            }
        }
        if (searchResult) {
            System.out.println("Matching movie for search found in LinkedList");
        }
        else {
            System.out.println("Matching movie for search not found in LinkedList");
        }
        return searchResult;
    }
    ///////////////////////////////////////// LinkedList<Movie> Methods ////////////////////////////////////////////////

    public static void lexSort (int[] array)
    {
        String[] sarr = new String[array.length];
        // convent the array to a String array
        for (int i = 0; i < sarr.length; i++) {
            sarr[i] = Integer.toString (array[i]);
        }
        // sort the String array (descending lexicographical order)
        Arrays.sort (sarr);
        // assign the sorted String array back to the input int array in reverse order
        for (int i = 0; i < sarr.length; i++) {
            array[i] = Integer.parseInt (sarr[sarr.length-1-i]);
        }
    }

    public int retrieveFoundIndex(String searchTerm){
        String search = searchTerm.trim();
        int i = 0;
        for(int x = 0; x < movies.size(); x++){
            if((movies.get(x).getTitle()).equals(search)){
                i = x;
            }
        }
        return i;
    }

    public void increaseMovieCounter(boolean increase){
        if(increase == false)
            setMovieCounter(getMovieCounter()-1);
        else
            setMovieCounter(getMovieCounter()+1);
    }

    public void compensateMovieCounter(){
        if(movieCounter >= movies.size())
            setMovieCounter(movies.size()-1);
        else if(movieCounter <= 0)
            setMovieCounter(0);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // BEGIN SEARCHABLE ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean search(String searchTerm) {
        return false;
    }

    @Override
    public int getFoundIndex() {
        return 0;
    }

    @Override
    public void setFoundIndex(int tableMemberIndex) {

    }

    @Override
    public boolean getFound() {
        return false;
    }

    @Override
    public void setFound(boolean searchResult) {

    }

    @Override
    public int getSearchByField() {
        return 0;
    }

    @Override
    public void setSearchByField(int fieldIndex) {

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // END SEARCHABLE //////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public int getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(int firstLine) {
        this.firstLine = firstLine;
    }

    public int getLastLine() {
        return lastLine;
    }

    public void setLastLine(int lastLine) {
        this.lastLine = lastLine;
    }

    public int getGetLineToHighlight() {
        return getLineToHighlight;
    }

    public void setGetLineToHighlight(int getLineToHighlight) {
        this.getLineToHighlight = getLineToHighlight;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    public void setNumberOfLines(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    public HashSet getMovieSet() {
        return movieSet;
    }

    public void setMovieSet(HashSet movieSet) {
        this.movieSet = movieSet;
    }

    public int getMovieCounter() {
        return movieCounter;
    }

    public void setMovieCounter(int movieCounter) {
        this.movieCounter = movieCounter;
    }

    public Movie getMovieSearchResult() {
        return movieSearchResult;
    }

    public void setMovieSearchResult(Movie movieSearchResult) {
        this.movieSearchResult = movieSearchResult;
    }

    public HashSet<Movie> getMovieHashSet() {
        return movieHashSet;
    }

    public void setMovieHashSet(HashSet<Movie> movieHashSet) {
        this.movieHashSet = movieHashSet;
    }

    public Movie getTestMovie() {
        return testMovie;
    }

    public void setTestMovie(Movie testMovie) {
        this.testMovie = testMovie;
    }
}
