package com.tamagotchi.service;

import java.util.Map;

import com.tamagotchi.entity.Puppy;

public interface TamagotchiService {

    //CREATE
    public Map < String, Puppy> aNewPuppyIsBorn ( Puppy puppy );

    //DELETE
    public Map < String, String > murderThePuppy ( Puppy puppy, String status );
    
}
