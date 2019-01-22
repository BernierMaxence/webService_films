package com.tpfilms.tpfilms.service;

import com.tpfilms.tpfilms.domain.Category;
import com.tpfilms.tpfilms.domain.Director;
import com.tpfilms.tpfilms.domain.Film;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmDao extends JpaRepository<Film, Integer> {
    Film findById(int id);

    List<Film> findAllByCategory(Category category);

    List<Film> findAllByDirector(Director director);

    List<Film> findAllByTitle(String title);

    Film findByTitle(String title);

}
