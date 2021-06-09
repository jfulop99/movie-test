package movie;

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

    public Movie getLatestMovie() {
        movies.stream().sorted(m->m.getReleaseDate())
    }

    public List <Movie> getMovieByName(String name) {
        return movies.stream()
                .filter(m -> m.getName().contains(name))
                .collect(Collectors.toList());
    }


}