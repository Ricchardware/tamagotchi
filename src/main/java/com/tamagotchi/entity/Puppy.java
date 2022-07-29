package com.tamagotchi.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults ( level = AccessLevel.PRIVATE)
public class Puppy {

/*  
        * JSON
    {
        "name" : "",
        "owner" : "",
        "clothing": 0
    }
*/   
    
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    @Column ( name = "puppy_id", nullable = false)
    int id;

    @Column ( name = "puppy_name", nullable = false )
    String name;

    @Column ( name = "owner_name", nullable = false )
    String owner;

    @Column ( name = "clothing_id", nullable = false )
    int clothing;

    @Column ( name = "happiness" )
    int happiness;

    @Column ( name = "moment_of_birth" )
    Timestamp born;

    @Column ( name = "moment_that_it_ate" )
    Timestamp eat;

    @Column ( name = "moment_that_it_slept" )
    Timestamp sleep;

    @Column ( name = "moment_that_it_played" )
    Timestamp play;
    
    @Column ( name = "moment_that_it_washed" )
    Timestamp wash;
}
