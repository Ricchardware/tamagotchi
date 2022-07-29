package com.tamagotchi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tamagotchi.entity.Puppy;

public interface TamagotchiRepostitory extends JpaRepository < Puppy, Integer > {

    // With this we can delete a specic puppy without the id
    @Transactional
    void deleteByNameAndOwner(String name, String owner);

    Puppy findByNameAndOwner(String name, String owner );
    
}
