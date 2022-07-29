package com.tamagotchi.models;

import lombok.AllArgsConstructor;

/*
    With this we can assaign a status to the tamagotchi
 */
@AllArgsConstructor
public enum PuppyStatus {

    ABANDONED ( "abandoned"),
    DIED ( "died"),
    ALIVE ( "alive" ),
    ;


    @SuppressWarnings ("unused")
    private final String value;


    public String value ( ){

        return value;
    }
    
}
