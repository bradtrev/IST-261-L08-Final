package Model;

public class SerializedDataCollection {

    MovieData movieData;
    ActorData actorData;
    MovieActorData movieActorData;

    public SerializedDataCollection() {
        movieData = new MovieData();
        actorData = new ActorData();
        movieActorData = new MovieActorData();

        movieActorData.createTestMovieActorData(movieData.getMovieIDs(), actorData.getActorIDs());

    }

    public MovieData getMovieData() {
        return movieData;
    }

    public void setMovieData(MovieData movieData) {
        this.movieData = movieData;
    }

    public ActorData getActorData() {
        return actorData;
    }

    public void setActorData(ActorData actorData) {
        this.actorData = actorData;
    }

    public MovieActorData getMovieActorData() {
        return movieActorData;
    }

    public void setMovieActorData(MovieActorData movieActorData) {
        this.movieActorData = movieActorData;
    }
}
