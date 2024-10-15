package com.backend.backend.service.impl;

import com.backend.backend.model.entities.Movie;
import com.backend.backend.repository.impl.MovieRepositoryImpl;
import com.backend.backend.service.AbstractService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MovieServiceImpl extends AbstractService<Movie, MovieRepositoryImpl> {
}
