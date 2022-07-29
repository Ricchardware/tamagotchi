package com.tamagotchi.tools;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.tamagotchi.entity.Puppy;
import com.tamagotchi.models.PuppyStatus;


public class IsPuppyOk {



    public static String isItHungry ( Puppy puppy ){

        @SuppressWarnings ( "deprecation" )
        int hours = puppy.getEat().getHours() - Timestamp.valueOf(LocalDateTime.now()).getHours();

        if ( hours * 8 >= 100 )
            return PuppyStatus.DIED_OF_HUNGER.value();

        if ( hours * 8 >= 70 && hours * 8 < 100 )
            return PuppyStatus.HUNGRY.value();
            

        return "";
    }



    public static String isItDirty ( Puppy puppy ) {

        @SuppressWarnings ( "deprecation" )
        int hours = puppy.getWash().getHours() - Timestamp.valueOf(LocalDateTime.now()).getHours();

        if ( hours * 8 >= 100 )
            return PuppyStatus.DIED_OF_IGENE.value();

        if ( hours * 8 >= 70 && hours * 8 < 100 )
            return PuppyStatus.DIRTY.value();


        return "";
    }


    
    public static String isItTired( Puppy puppy ) {

        @SuppressWarnings ( "deprecation" )
        int hours = ( puppy.getSleep().getHours() - Timestamp.valueOf(LocalDateTime.now()).getHours() ) - 8;

        if ( hours * 8 >= 100 )
            return PuppyStatus.DIED_OF_SLEEP_DEPRIVATION.value();

        if ( hours * 8 >= 70 && hours * 8 < 100 )
            return PuppyStatus.TIRED.value();


        return "";
    }



    public static String isItSad ( Puppy puppy ) {

        @SuppressWarnings ( "deprecation" )
        int hours = puppy.getPlay().getHours() - Timestamp.valueOf(LocalDateTime.now()).getHours();

       if ( hours * 8 - puppy.getHappiness() <= 0 )
            return PuppyStatus.DIED_OF_SADNESS.value();

        if ( hours * 8 - puppy.getHappiness() <= 30 && hours * 8 - puppy.getHappiness() > 0 )
            return PuppyStatus.SAD.value();

    
        return "";
    }
    
}
