package movie;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

    private List<Movie> movies;

    public MovieService(List<Movie> movies) {
        this.movies = movies;
    }

    public void save(Movie movie) {
        movies.add(movie);
    }

    public Movie getLatestMovie2() {
        return movies.stream()
                .max(Comparator.comparing(Movie::getReleaseDate))
                .orElseThrow(() -> new IllegalArgumentException("Movie not found"));
    }

    public List <Movie> getMovieByName2(String name) {
        return movies.stream()
                .filter(m -> m.getName().contains(name))
                .collect(Collectors.toList());
    }


}