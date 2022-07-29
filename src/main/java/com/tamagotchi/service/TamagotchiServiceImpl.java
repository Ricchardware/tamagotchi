package com.tamagotchi.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tamagotchi.entity.Puppy;
import com.tamagotchi.repository.TamagotchiRepostitory;

@Service
public class TamagotchiServiceImpl implements TamagotchiService {

    @Autowired
    TamagotchiRepostitory tamagotchiRepostitory;

    //CREATE::::::::::::::::::::
    @Override
    public Map<String, Puppy> aNewPuppyIsBorn(Puppy puppy) {
        
        Map < String, Puppy > message = new HashMap<>();

        if ( isPuppyJsonFull(puppy) ) {

            message.put ( "Missing Data", puppy );
            return message;
        }

        if ( isPuppyJsonCorrectlyCompiled(puppy)){

            message.put ( "Error in user compilation", puppy );
            return message;
        }

        puppy = fillAllPuppyParameters(puppy);

        if ( tamagotchiRepostitory.findById(tamagotchiRepostitory.save(puppy).getId()) == null ){

            message.put ( "Couldn't create Tamagotchi", puppy );
            return message;
        }

        message.put ( "Tamagotchi created", puppy);
        return message;
        
    }
    //;;;;;;;;;;;;;;;;;;;;;;;;;



    //METODI DI CONTROLLO::::::
    private boolean isPuppyJsonFull ( Puppy puppy ) {

        if ( puppy.getName().isBlank() || puppy.getName().equals(""))
            return true;

        if ( puppy.getOwner().isBlank() || puppy.getOwner().equals(""))
            return true;


        return false;
    }


    private boolean isPuppyJsonCorrectlyCompiled ( Puppy puppy ){

        if ( puppy.getClothing() < 0 || puppy.getClothing() > 5 )
            return true;

        
            return false;
    }


    private Puppy fillAllPuppyParameters ( Puppy puppy ) {

        puppy.setHappiness(100);

        puppy.setBorn(Timestamp.valueOf(LocalDateTime.now()));

        puppy.setEat(Timestamp.valueOf(LocalDateTime.now()));

        puppy.setSleep(Timestamp.valueOf(LocalDateTime.now()));

        puppy.setPlay(Timestamp.valueOf(LocalDateTime.now()));

        return puppy;
    }
    //;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
}
