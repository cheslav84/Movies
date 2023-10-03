package com.gfl.havryliuk.movies.model.repository;

import com.gfl.havryliuk.movies.model.dto.MovieSearchDto;
import com.gfl.havryliuk.movies.model.entity.Movie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomMovieRepositoryImpl implements CustomMovieRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Movie> findByOptions(MovieSearchDto options) {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);

        Root<Movie> movie = cq.from(Movie.class);

        List<Predicate> predicates = new ArrayList<>();

        if (!options.getGenre().isEmpty()) {
            predicates.add(cb.equal(movie.get("movieType").get("genre"), options.getGenre()));
        }

        if (!options.getTitle().isEmpty()) {
            predicates.add(cb.equal(movie.get("title"), options.getTitle()));
        }

//        if (!options.getDirector().isEmpty()) {
//            Predicate movieDetails = cb.equal(movie.get("movieDetails"));
//
//            predicates.add(cb.equal(movie.get("movieDetails"), options.getTitle()));
//        }






        cq.where(predicates.toArray(new Predicate[0]));




        return em.createQuery(cq).getResultList();
    }
}
