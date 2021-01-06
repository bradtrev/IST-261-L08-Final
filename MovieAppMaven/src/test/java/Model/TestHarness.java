/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Brad
 */
/* public class TestHarness {
    
    public TestHarness(){
        //Test Actor class
        ArrayList<Movie> array = new ArrayList<Movie>();
        ArrayList<Movie> array2 = new ArrayList<Movie>();
        Actor Steve = new Actor("Steve", "Austin", 54, array);
        if(Steve != null){
            System.out.println("Test actor created successfully");
            System.out.println("Actor info: "+Steve.getFirstName()+" "+Steve.getLastName()+" "
                    +Steve.getAge().toString()+" "+Steve.getFilmography().toString());
            
            Steve.setFirstName("Stone");
            System.out.println("Actor info: "+Steve.getFirstName()+" "+Steve.getLastName()+" "
                    +Steve.getAge().toString()+" "+Steve.getFilmography().toString());
            
            Steve.setLastName("Cold");
            System.out.println("Actor info: "+Steve.getFirstName()+" "+Steve.getLastName()+" "
                    +Steve.getAge().toString()+" "+Steve.getFilmography().toString());
            
            Steve.setAge(86);
            System.out.println("Actor info: "+Steve.getFirstName()+" "+Steve.getLastName()+" "
                    +Steve.getAge().toString()+" "+Steve.getFilmography().toString());
            
            Steve.setFilmography(array2);
            System.out.println("Actor info: "+Steve.getFirstName()+" "+Steve.getLastName()+" "
                    +Steve.getAge().toString()+" "+Steve.getFilmography().toString());
        }
        
        //Test Movie class
        Cast castOne = new Cast();
        Cast castTwo = new Cast();
        Movie exampleMovie = new Movie("Title", 2006, "Action", 7.7, "Everyone lives", castOne);
        if(exampleMovie != null){
            System.out.println("Test Movie created successfully");
            System.out.println("Movie info: "+exampleMovie.getTitle()+" "
                    +exampleMovie.getGenre()+" "+exampleMovie.getRating().toString()+" "
                    +exampleMovie.getSynopsis()+" "+exampleMovie.getCast().toString());
            
            exampleMovie.setTitle("Generic Movie");
            System.out.println("Movie info: "+exampleMovie.getTitle()+" "
                    +exampleMovie.getGenre()+" "+exampleMovie.getRating().toString()+" "
                    +exampleMovie.getSynopsis()+" "+exampleMovie.getCast().toString());
            
            exampleMovie.setYear(1996);
            System.out.println("Movie info: "+exampleMovie.getTitle()+" "
                    +exampleMovie.getGenre()+" "+exampleMovie.getRating().toString()+" "
                    +exampleMovie.getSynopsis()+" "+exampleMovie.getCast().toString());
            
            exampleMovie.setGenre("generic genre");
            System.out.println("Movie info: "+exampleMovie.getTitle()+" "
                    +exampleMovie.getGenre()+" "+exampleMovie.getRating().toString()+" "
                    +exampleMovie.getSynopsis()+" "+exampleMovie.getCast().toString());
            
            exampleMovie.setRating(2.8);
            System.out.println("Movie info: "+exampleMovie.getTitle()+" "
                    +exampleMovie.getGenre()+" "+exampleMovie.getRating().toString()+" "
                    +exampleMovie.getSynopsis()+" "+exampleMovie.getCast().toString());
            
            exampleMovie.setSynopsis("Everyone dies at the end");
            System.out.println("Movie info: "+exampleMovie.getTitle()+" "
                    +exampleMovie.getGenre()+" "+exampleMovie.getRating().toString()+" "
                    +exampleMovie.getSynopsis()+" "+exampleMovie.getCast().toString());
            
            exampleMovie.setCast(castTwo);
            System.out.println("Movie info: "+exampleMovie.getTitle()+" "
                    +exampleMovie.getGenre()+" "+exampleMovie.getRating().toString()+" "
                    +exampleMovie.getSynopsis()+" "+exampleMovie.getCast().toString());
        }

    }
    
    public void testClassHierarchy(){
        ArrayList<Program> programs = new ArrayList<Program>();
        
        Cast exCast = new Cast();
        Cast exCast2 = new Cast();
        
        Movie exMovie = new Movie("Title", 2006, "Action", 7.7, 
                "Everyone lives", exCast);
        TVshow exShow = new TVshow("TV title", 2000, "Drama", 8.9, 
                "Everyone gets married", exCast2, 6, 78);
        
        programs.add(exMovie);
        programs.add(exShow);
        
        for(int i = 0; i < programs.size() ; i++){
            ArrayList<String> printout = new ArrayList<String>();
            printout = programs.get(i).getAttributes();
            
        }
    }
    
    public void testInterface(){
        MovieData movieData = new MovieData();
        ActorData actorData = new ActorData();
        
        ArrayList<Displayable> interArray = new ArrayList<Displayable>();
        
        interArray.add(movieData);
        interArray.add(actorData);
        
        for(int i = 0; i < interArray.size() ; i++){
            interArray.get(i).getFirstLineToDisplay();
            interArray.get(i).getLastLineToDisplay();
            interArray.get(i).getLineToHighlight();
            interArray.get(i).getLinesBeingDisplayed();
            interArray.get(i).setFirstLineToDisplay(i);
            interArray.get(i).setLastLineToDisplay(i);
            interArray.get(i).setLineToHighlight(i);
            interArray.get(i).setLinesBeingDisplayed(i);
            
        }
    }
    
} */
