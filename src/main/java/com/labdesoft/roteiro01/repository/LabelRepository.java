package com.labdesoft.roteiro01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labdesoft.roteiro01.entity.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label, String> {
    Label findByName(String name);
}