package com.backend.backend.service.impl;

import com.backend.backend.model.entities.Location;
import com.backend.backend.repository.impl.LocationRepositoryImpl;
import com.backend.backend.service.AbstractService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LocationServiceImpl extends AbstractService<Location, LocationRepositoryImpl> {
}
