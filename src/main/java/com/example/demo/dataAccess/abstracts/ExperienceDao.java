package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.Experience;

public interface ExperienceDao extends JpaRepository<Experience , Integer>{

}
