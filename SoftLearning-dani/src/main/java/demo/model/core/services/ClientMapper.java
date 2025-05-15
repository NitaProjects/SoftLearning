package demo.model.core.services;

import demo.exceptions.BuildException;
import demo.model.persons.Client;

public class ClientMapper {
    public static Client clientFromDTO(ClientDTO cdto) throws BuildException {
        return Client.getInstantClient(
                cdto.getNif(),
                cdto.getName(),
                cdto.getEmail(),
                cdto.getDirection(),
                cdto.getPhoneNumber(),
                cdto.getCardNum(),
                cdto.getZipCode(),
                cdto.getPopulation()
                );
    }

    public static ClientDTO dtoFromClient(Client c){
        return new ClientDTO(
            c.getNif(), 
            c.getName(), 
            c.getEmail(), 
            c.getDirection(), 
            c.getPhoneNumber(), 
            c.getCardNum(), 
            c.getZipCode(), 
            c.getPopulation()
            );
    }




}


