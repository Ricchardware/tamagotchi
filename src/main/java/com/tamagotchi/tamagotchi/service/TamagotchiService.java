package com.tamagotchi.tamagotchi.service;

import java.util.Map;

import com.tamagotchi.tamagotchi.entity.Puppy;

public interface TamagotchiService {

    public Map < String, Puppy> aNewPuppyIsBorn ( Puppy puppy );
    
}
