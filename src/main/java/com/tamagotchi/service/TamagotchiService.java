package com.tamagotchi.service;

import java.util.Map;

import com.tamagotchi.entity.Puppy;

public interface TamagotchiService {

    public Map < String, Puppy> aNewPuppyIsBorn ( Puppy puppy );
    
}
