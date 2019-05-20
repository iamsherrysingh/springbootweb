package com.sherry.springbootweb.com.sherry.springbootweb.dao;

import com.sherry.springbootweb.model.Alien;
import org.springframework.data.repository.CrudRepository;

public interface AlienRepo extends CrudRepository<Alien, Integer> {
}
