package com.tpfilms.tpfilms.service;

import com.tpfilms.tpfilms.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmDao extends JpaRepository<Film, Integer> {
    Film findById(int id);
}
