package com.app.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoRespository extends JpaRepository<Demo, Integer> {

   
    List<Demo> findByTitleContainingOrContentContaining(String text, String textAgain);    
}