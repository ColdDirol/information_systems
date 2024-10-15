package com.backend.backend.service.impl;

import com.backend.backend.model.entities.Person;
import com.backend.backend.repository.impl.PersonRepositoryImpl;
import com.backend.backend.service.AbstractService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonServiceImpl extends AbstractService<Person, PersonRepositoryImpl> {
}
