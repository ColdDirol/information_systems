package com.backend.backend.service.impl;

import com.backend.backend.model.entities.Coordinates;
import com.backend.backend.repository.impl.CoordinatesRepositoryImpl;
import com.backend.backend.service.AbstractService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CoordinatesServiceImpl extends AbstractService<Coordinates, CoordinatesRepositoryImpl> {
}
