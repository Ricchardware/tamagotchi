package com.tamagotchi.tamagotchi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tamagotchi.tamagotchi.entity.Puppy;

public interface TamagotchiRepostitory extends JpaRepository < Puppy, Integer > {
    
}
