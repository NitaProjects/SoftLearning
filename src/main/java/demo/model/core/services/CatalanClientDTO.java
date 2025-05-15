package demo.model.core.services;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class CatalanClientDTO {
    private String nif, name, email, direction, cardNum, zipCode, population;
    private int phoneNumber;

    public CatalanClientDTO(){

    }

    public CatalanClientDTO(String nif, String name, String email, 
    String direction, int phoneNumber, String cardNum,
    String zipCode, String population) {
        this.nif = nif; 
        this.name = name;
        this.email = email;
        this.direction = direction;
        this.phoneNumber = phoneNumber;
        this.cardNum = cardNum;
        this.zipCode = zipCode;
        this.population = population;
        
    }

    @JsonGetter("nif")
    public String getNif() {
        return nif;
    }

    @JsonGetter("nom")
    public String getName() {
        return name;
    }

    @JsonGetter("correu_electronic")
    public String getEmail() {
        return email;
    }

    @JsonGetter("adreça")
    public String getDirection() {
        return direction;
    }

    @JsonGetter("numero_targeta")
    public String getCardNum() {
        return cardNum;
    }

    @JsonGetter("codi_postal")
    public String getZipCode() {
        return zipCode;
    }

    @JsonGetter("població")
    public String getPopulation() {
        return population;
    }

    @JsonGetter("telefon")
    public int getPhoneNumber() {
        return phoneNumber;
    }

    //--------------------SETTERS--------------------


    @JsonSetter("nif")
    public String setNif() {
        return nif;
    }

    @JsonSetter("nom")
    public String setName() {
        return name;
    }

    @JsonSetter("correu_electronic")
    public String setEmail() {
        return email;
    }

    @JsonSetter("adreça")
    public String setDirection() {
        return direction;
    }

    @JsonSetter("numero_targeta")
    public String setCardNum() {
        return cardNum;
    }

    @JsonSetter("codi_postal")
    public String setZipCode() {
        return zipCode;
    }

    @JsonSetter("població")
    public String setPopulation() {
        return population;
    }

    @JsonSetter("telefon")
    public int setPhoneNumber() {
        return phoneNumber;
    }


    @Override
    public String toString() {
        return "ClientDTO [nif=" + nif + ", nom=" + name + ", correu_electronic=" + email + ", adreça=" + direction
                + ", numero_targeta=" + cardNum + ", codi_postal=" + zipCode + ", població=" + population + ", telefon="
                + phoneNumber + "]";
    }

    


    
}
