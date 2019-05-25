package com.sherry.springbootweb.com.sherry.springbootweb.dao;

import com.sherry.springbootweb.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlienRepo extends JpaRepository<Alien, Integer> {
    public List<Alien> findByalang(String alang);
    List<Alien> findByAidGreaterThan(int aid);
    List<Alien> findByAidLessThanEqual(int aid);
}
