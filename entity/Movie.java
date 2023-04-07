package entity;

import java.util.List;

public class Movie {
    private final long id;
    private String movieCaption;
    private Director director;
    private final List<Cast>casts;
    private final String releaseDate;
    private final String explanaton;
    private MovieType movieType;

    public Movie(long id, String movieCaption, Director director, List<Cast> casts, String releaseDate, String explanaton,MovieType movieType) {
        this.id = id;
        this.movieCaption = movieCaption;
        this.director = director;
        this.casts = casts;
        this.releaseDate = releaseDate;
        this.explanaton = explanaton;
        this.movieType=movieType;
    }
    //region Setter-Getter
    public long getId() {
        return id;
    }

    public String getMovieCaption() {
        return movieCaption;
    }

    public void setMovieCaption(String movieCaption) {
        this.movieCaption = movieCaption;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Cast> getCasts() {
        return casts;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getExplanaton() {
        return explanaton;
    }
    public MovieType getMovieType() {
        return movieType;
    }
    //endregion



}
