package com.tpfilms.tpfilms.service;

import com.tpfilms.tpfilms.domain.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorDao extends JpaRepository<Director, Integer> {
}
