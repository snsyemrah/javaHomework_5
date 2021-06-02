package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.Profession;

public interface ProfessionDao extends JpaRepository<Profession, Integer>{

}
