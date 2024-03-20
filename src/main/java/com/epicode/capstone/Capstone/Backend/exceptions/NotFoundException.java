package com.epicode.capstone.Capstone.Backend.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException{

    public NotFoundException(Long id){super("Id '" + id + "' not found");}
    public NotFoundException(UUID id){super("Id '" + id + "' not found");}

    public NotFoundException(String message){super(message);}
}
