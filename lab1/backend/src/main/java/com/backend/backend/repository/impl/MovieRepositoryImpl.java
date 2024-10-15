package com.backend.backend.repository.impl;

import com.backend.backend.model.entities.Movie;
import com.backend.backend.repository.AbstractRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MovieRepositoryImpl extends AbstractRepository<Movie> {

    public MovieRepositoryImpl() {
        super(Movie.class);
    }
}
