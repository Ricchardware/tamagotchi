package com.tamagotchi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tamagotchi.entity.Puppy;

public interface TamagotchiRepostitory extends JpaRepository < Puppy, Integer > {
    
}
