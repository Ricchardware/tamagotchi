package com.tamagotchi.tamagotchi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tamagotchi.tamagotchi.entity.Puppy;
import com.tamagotchi.tamagotchi.service.TamagotchiService;

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
    
}
