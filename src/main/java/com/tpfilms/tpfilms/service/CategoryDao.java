package com.tpfilms.tpfilms.service;

import com.tpfilms.tpfilms.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {
    Category findById(String id);
    Category findByName(String name); 
}
