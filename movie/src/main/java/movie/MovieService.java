package movie;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class MovieService {

    private List<Movie> movies;

    public MovieService(List<Movie> movies) {
        this.movies = movies;
    }

    public void save(Movie movie) {
        movies.add(movie);
    }

    public Movie getLatestMovie() {
        return movies.stream()
                .sorted(Comparator.comparing(Movie::getReleaseDate).reversed())
                .limit(1)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Nincs ilyen elem!"));
    }

    public List <Movie> getMovieByName(String name) {
        return movies.stream()
                .filter(m -> m.getName().contains(name))
                .collect(Collectors.toList());
    }


}