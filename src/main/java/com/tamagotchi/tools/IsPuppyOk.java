package com.tamagotchi.tools;

import com.tamagotchi.entity.Puppy;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults ( level = AccessLevel.PRIVATE)
public class IsPuppyOk {

    int hunger;

    int igene;

    int energy;

    int joy;


    public String isItHungry ( Puppy puppy ){

        //if ( puppy.getEat() - Timestamp.valueOf(LocalDateTime.now()) > )
        return null;
    }
    
}
