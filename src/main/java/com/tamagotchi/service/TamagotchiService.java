package com.tamagotchi.service;

import java.util.List;
import java.util.Map;

import com.tamagotchi.entity.Puppy;

public interface TamagotchiService {

    //CREATE
    public Map < String, Puppy> aNewPuppyIsBorn ( Puppy puppy );

    //READ
    public Map < String, Puppy > gimmeThePuppy ( Puppy puppy );

    //UPDATE
    public Map < String, List < String > > howIsThePuppy ( Puppy puppy );

    //DELETE
    public Map < String, String > murderThePuppy ( Puppy puppy, String status );


    
}
