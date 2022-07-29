package com.tamagotchi.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tamagotchi.entity.Puppy;
import com.tamagotchi.models.PuppyStatus;
import com.tamagotchi.repository.TamagotchiRepostitory;
import com.tamagotchi.tools.IsPuppyOk;

@Service
public class TamagotchiServiceImpl implements TamagotchiService {

    @Autowired
    TamagotchiRepostitory tamagotchiRepostitory;

    //CREATE::::::::::::::::::::
    @Override
    public Map<String, Puppy> aNewPuppyIsBorn(Puppy puppy) {
        
        Map < String, Puppy > message = new HashMap<>();


        //Checks if Json has all we need
        if ( isPuppyJsonFull(puppy) ) {

            message.put ( "Missing Data", puppy );
            return message;
        }


        //Checks if Json has data written in given standards
        if ( isPuppyJsonCorrectlyCompiled(puppy)){

            message.put ( "Error in user compilation", puppy );
            return message;
        }



        // ? If the owner already has a puppy, this condition will inform the user of the situation
        // ?  to manage this front end needs to ask for confirm and if its confirmed, needs to call
        // ?  thisTamagotchiIsHomeless to delete the current puppy and then call givingABirth again
        if ( tamagotchiRepostitory.findByOwner( puppy.getOwner()) != null){

            message.put ( "This owner already has a puppy: ask for connfirm on overwrting", puppy );
            return message;
        }
        

        //The puppy gets ready to be saved
        puppy = fillAllPuppyParameters(puppy);


        //Saves the puppy while checking if it exists after the save; if its not saved this conditon will
        // not find it, assaigning this as an error during saving
        if ( tamagotchiRepostitory.findById(tamagotchiRepostitory.save(puppy).getId()) == null ){

            message.put ( "Couldn't create Tamagotchi", puppy );
            return message;
        }

        //If everything went well we re saying to the user that the tamagotchi is created
        message.put ( "Tamagotchi created", puppy);
        return message;
    }
    //;;;;;;;;;;;;;;;;;;;;;;;;;



    //READ:::::::::::::::::::::
    @Override
    public Map < String, Puppy > gimmeThePuppy ( Puppy puppy ){

        Map < String, Puppy > message = new HashMap<>();

        Puppy tamagotchi = tamagotchiRepostitory.findByNameAndOwner(puppy.getName(), puppy.getOwner());

        if ( tamagotchi == null ) {

            message.put ( "Your Tamagotchi couldn t be found", tamagotchi );
            return message;
        }

        message.put ( "Your Tamagotchi:", tamagotchi ); 
        return message;
    }
    

    

    @Override 
    public Map < String, List < String > > howIsThePuppy ( Puppy puppy ){

        Map < String, List <String > > message = new HashMap<>();

        Puppy tamagotchi = tamagotchiRepostitory.findByNameAndOwner(puppy.getName(), puppy.getOwner());

        List < String > statuses = new ArrayList<>();


        
        String status = IsPuppyOk.isItHungry ( tamagotchi ) ;
        if ( !status.equals("") || !status.isBlank() )
            statuses.add ( status );
            
        status = IsPuppyOk.isItDirty(tamagotchi);
        if ( !status.equals("") || !status.isBlank() )
            statuses.add ( status );

        status = IsPuppyOk.isItTired ( tamagotchi );
        if ( !status.equals("") || !status.isBlank() )
            statuses.add ( status );

        status = IsPuppyOk.isItSad(tamagotchi);
        if ( !status.equals("") || !status.isBlank() )
            statuses.add ( status );


        for ( String heDead : statuses )
            if ( heDead.equals(PuppyStatus.DIED_OF_HUNGER.value()) ||
                 heDead.equals(PuppyStatus.DIED_OF_IGENE.value()) ||
                 heDead.equals(PuppyStatus.DIED_OF_SADNESS.value()) ||
                 heDead.equals(PuppyStatus.DIED_OF_SLEEP_DEPRIVATION.value())) {

                    tamagotchiRepostitory.deleteById(tamagotchi.getId());

                    message.put ( tamagotchi.getName() + " has perished and been deleted from database", statuses);
                    return message;
                 }

        message.put ( tamagotchi.getName(), statuses );
        return message;

    }
    //;;;;;;;;;;;;;;;;;;;;;;;;;

    //DELETE:::::::::::::::::::
    @Override
    public Map < String, String > murderThePuppy ( Puppy puppy, String status ) {

        Map < String, String > message = new HashMap<>();


        //Checks if Json has all we need
        if ( isPuppyJsonFull(puppy) ) {

            message.put ( "delition", "" + puppy.getOwner() + "'s tamagotchi missing data");
            return message;
        }


        //Checks if given puppy exists in the database
        if ( tamagotchiRepostitory.findByNameAndOwner( puppy.getName(), puppy.getOwner() ) == null ){

            message.put ( "delition", "" + puppy.getOwner() + "'s tamagotchi not found - couldn t delete" );
            return message;
        }
        

        //If given puppy exists we go on and delete it
        tamagotchiRepostitory.deleteByNameAndOwner (puppy.getName(), puppy.getOwner());


        //Checks if delition went well
        if ( tamagotchiRepostitory.findByNameAndOwner( puppy.getName(), puppy.getOwner() ) != null ){

            message.put ( "delition", "" + puppy.getOwner() + "'s tamagotchi still in database - delition unsuccesfull" );
            return message;
        }


        //Dynamic message based on state
        if ( status.equals(PuppyStatus.ABANDONED.value()) ) 
            message.put ( "delition", "" + puppy.getOwner() + "'s tamagotchi is homeless" );
        
            
        /*if ( status.equals(PuppyStatus.DIED.value()) )
            message.put ( "delition", "" + puppy.getOwner() + "'s tamagotchi has perished" );*/
           
         return message;
    }
    //;;;;;;;;;;;;;;;;;;;;;;;;


    //METODI DI CONTROLLO::::::
    private boolean isPuppyJsonFull ( Puppy puppy ) {  

        //Checks name and owner to see if they re empty

        if ( puppy.getName().isBlank() || puppy.getName().equals(""))
            return true;

        if ( puppy.getOwner().isBlank() || puppy.getOwner().equals(""))
            return true;


        return false;
    }


    private boolean isPuppyJsonCorrectlyCompiled ( Puppy puppy ){

        //Checks if clothing exists

        if ( puppy.getClothing() < 0 || puppy.getClothing() > 5 )
            return true;

        
            return false;
    }


    private Puppy fillAllPuppyParameters ( Puppy puppy ) {

        //Fills all not customizable parameters in puppy

        puppy.setHappiness(100);

        puppy.setStatus(PuppyStatus.ALIVE.value());

        puppy.setBorn(Timestamp.valueOf(LocalDateTime.now()));

        puppy.setEat(Timestamp.valueOf(LocalDateTime.now()));

        puppy.setSleep(Timestamp.valueOf(LocalDateTime.now()));

        puppy.setPlay(Timestamp.valueOf(LocalDateTime.now()));

        return puppy;
    }
    //;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
}
