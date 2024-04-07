package com.labdesoft.roteiro01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labdesoft.roteiro01.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    Category findByName(String name);
}