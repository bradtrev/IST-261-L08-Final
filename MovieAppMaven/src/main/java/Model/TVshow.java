
package Model;

import java.util.ArrayList;

public class TVshow extends Program{

    Integer seasons;
    Integer episodes;
    
    public TVshow(String title, Integer year, String genre, Double rating, String synopsis, Actor actor1In, Actor actor2In, Actor actor3In, Integer seasons, Integer episodes){
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.synopsis = synopsis;
        this.genre = genre;
        this.actor1 = actor1In;
        this.actor2 = actor2In;
        this.actor3 = actor3In;
        this.seasons = seasons;
        this.episodes = episodes;
    }
    
    @Override
    public ArrayList<String> getAttributes() {
        ArrayList<String> attributes = new ArrayList<String>();
        
        return attributes;    
    }

    public Integer getSeasons() {
        return seasons;
    }

    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }
}
