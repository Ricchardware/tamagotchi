package com.tamagotchi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tamagotchi.entity.Puppy;
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



    //READ::::::::::::::::::::::::::::::::
    @GetMapping ( "/cutest")
    public Map < String, Puppy > lookForMyPuppy ( @RequestBody Puppy puppy ){

        return tamagotchiService.gimmeThePuppy(puppy);
    }


    @GetMapping ( "/howbadisit")
    public Map < String, List < String > > puppyStatus ( @RequestBody Puppy puppy ){

        return tamagotchiService.howIsThePuppy(puppy);
    }
    //;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;



    //DELETE::::::::::::::::::::::::::::::
    @DeleteMapping ( "/abandon" )
    public Map < String, String > thisTamagotchiIsHomeless ( @RequestBody Puppy puppy ){

        return tamagotchiService.murderThePuppy(puppy );
    }
    //;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    
}
