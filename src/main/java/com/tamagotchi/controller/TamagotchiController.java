package com.tamagotchi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tamagotchi.entity.Puppy;
import com.tamagotchi.models.PuppyStatus;
import com.tamagotchi.service.TamagotchiService;

@RestController
@CrossOrigin
@RequestMapping ( "/tamagotchi" )
public class TamagotchiController {

    @Autowired
    TamagotchiService tamagotchiService;


    //CREATE::::::::::::::::::::::::::::::
    @PostMapping ( "/birth" )
    public Map < String, Puppy > givingABirth ( @RequestBody Puppy puppy ){

        return tamagotchiService.aNewPuppyIsBorn(puppy);
    }
    //;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;



    //DELETE::::::::::::::::::::::::::::::
    @DeleteMapping ( "/abandon" )
    public Map < String, String > thisTamagotchiIsHomeless ( @RequestBody Puppy puppy ){

        String status = PuppyStatus.ABANDONED.value();

        return tamagotchiService.murderThePuppy(puppy, status);
    }


    @DeleteMapping ( "/isdead" )
    public Map < String, String > thisTamagotchiIsNoMore ( @RequestBody Puppy puppy ){

        String status = PuppyStatus.DIED.value();

        return tamagotchiService.murderThePuppy(puppy, status);
    }
    //;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    
}
