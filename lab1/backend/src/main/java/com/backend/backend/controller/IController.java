package com.backend.backend.controller;

import jakarta.ws.rs.core.Response;

import java.util.List;

public interface IController<T, D> {

    Response create(T t);

    Response findById(D id);

    List<T> findAll();

    Response update(T t);

    Response deleteById(D id);
}
