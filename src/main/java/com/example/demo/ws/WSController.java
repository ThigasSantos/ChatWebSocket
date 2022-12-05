package com.example.demo.ws;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.faces.event.WebsocketEvent;
import jakarta.faces.event.WebsocketEvent.Opened;

import java.util.logging.Level;
import java.util.logging.Logger;


@ApplicationScoped
public class WSController {
    public static final Logger log = Logger.getLogger(WSController.class.getName());

    public void onOpen(@Observes @Opened WebsocketEvent event) {
        log.log(Level.SEVERE,"ITS OOOOOOOOOOOOOOPEEEEEEEN" );
        log.log(Level.SEVERE,"Canal:" + event.getChannel());
        log.log(Level.SEVERE,"Novo usuario:" + event.getUser());

    }

}