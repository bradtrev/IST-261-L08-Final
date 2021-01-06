package Model;


public class Model
{
    
//    private MovieData movieData;
//    private ActorData actorData;
    private SerializedDataCollection sdc;

    public Model(){   
        sdc = new SerializedDataCollection();
    }

    public SerializedDataCollection getSdc() {
        return sdc;
    }

    public void setSdc(SerializedDataCollection sdc) {
        this.sdc = sdc;
    }

    //    public MovieData getMovieData() {
//        return movieData;
//    }
//
//    public void setMovieData(MovieData movieData) {
//        this.movieData = movieData;
//    }

//    public ActorData getActorData() {
//        return actorData;
//    }
//
//    public void setActorData(ActorData actorData) {
//        this.actorData = actorData;
//    }
}
