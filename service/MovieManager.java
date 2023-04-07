package service;
import entity.Cast;
import entity.Director;
import entity.Movie;
import entity.MovieType;

import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    public static List<Movie> moviesList = new ArrayList<>();

    public static void generateMovie() {
        List<Cast> casts = new ArrayList<>();
        Cast cast = new Cast("Marion Brando");
        casts.add(cast);
        cast = new Cast("Al Pacino");
        casts.add(cast);
        moviesList.add(new Movie(1, "The GodFather", new Director("Francis Ford Coppola"), casts, "1972",
                "The Godfather Don Vito Corleone is the head of the Corleone mafia family in New York. He is at the event of his daughter's wedding. Michael, Vito's youngest son and a decorated WW II Marine is also present at the wedding. ", MovieType.DRAMEDY));

        casts = new ArrayList<>();
        cast = new Cast("İsmail Hacioğlu");
        casts.add(cast);
        cast = new Cast("Rahman Besel");
        casts.add(cast);
        moviesList.add(new Movie(2, "Kesişme:İyi ki varsın Eren", new Director("Özer Feyzioğlu"), casts, "2022",
                "Hayatı mücadelelerle dolu Karadeniz tepelerinde yaşayan genç bir delikanlı, kahraman asker Ferhat ve ötelerden gelen davetsiz bir ziyaretçinin gerçek bir kesişme hikayesi. ", MovieType.DRAMEDY));
    }

    public static boolean addMovie(Movie movie) {
        return moviesList.add(new Movie(movie.getId(), movie.getMovieCaption(), movie.getDirector(), movie.getCasts(), movie.getReleaseDate(), movie.getExplanaton(), movie.getMovieType()));
    }

    public static Boolean deleteMovie(long no) {
        return moviesList.remove(searchMovieByNo(no));
    }

    public static Movie searchMovieByNo(long no) {
        Movie movie = null;
        for (Movie m : moviesList) {
            if (m.getId() == no) {
                movie = m;
                break;
            }
        }
        return movie;
    }
    public  static Movie searchMovieByName(String moviename)
    {
        Movie movie = null;
        for (Movie m : moviesList) {
            if (m.getMovieCaption().equalsIgnoreCase(moviename)) {
                movie = m;
                break;
            }
        }
        return movie;
    }
}
