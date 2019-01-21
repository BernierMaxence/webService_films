package com.tpfilms.tpfilms.service;

import com.tpfilms.tpfilms.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorDao extends JpaRepository<Actor, Integer> {
    public Actor findById(int id);

    public Actor findByLastName(String lastName);

    public List<Actor> findAllByFirstName(String firstName);

    public List<Actor> findAllByLastName(String lastName);
}
