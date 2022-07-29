package com.tamagotchi.models;

import lombok.AllArgsConstructor;

/*
    With this we can assaign a status to the tamagotchi
 */
@AllArgsConstructor
public enum PuppyStatus {

    ABANDONED ( "abandoned"),
    DIED_OF_HUNGER ( "died_of_hunger"),
    DIED_OF_SADNESS ( "died_of_sadness"),
    DIED_OF_IGENE ( "died_of_igene"),
    DIED_OF_SLEEP_DEPRIVATION ( "died_of_sleep_deprivation"),
    ALIVE ( "alive" ),
    TIRED ( "tired" ),
    DIRTY ( "dirty"),
    HUNGRY ( "hungry "),
    SAD ( "sad" ),

    ;


    @SuppressWarnings ("unused")
    private final String value;


    public String value ( ){

        return value;
    }
    
}
