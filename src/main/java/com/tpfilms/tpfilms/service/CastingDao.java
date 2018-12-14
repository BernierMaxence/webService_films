package com.tpfilms.tpfilms.service;

import com.tpfilms.tpfilms.domain.Casting;
import javassist.expr.Cast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastingDao extends JpaRepository<Casting, Integer> {
}
