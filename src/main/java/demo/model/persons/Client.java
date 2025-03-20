package demo.model.persons;

import demo.model.operations.checker;
import demo.exceptions.BuildException;
import demo.interfaces.Stakeholder;

public class Client extends Person implements Stakeholder {
    protected String cardNum;
    protected String zipCode;
    protected String population;

    protected Client(){
    }

    public static Client getInstantClient(String nif, String name, String email, 
    String direction, int phoneNumber, String cardNum,
    String zipCode, String population) throws BuildException{
        String message = "";
        Client c = new Client();

        try {
            c.checkDataPerson(nif, name, email, direction, phoneNumber); 
        }catch (BuildException e){
            message = e.getMessage();
        }

        if ((c.setCardNum(cardNum) != 0)){
            message += "This card number is not possible, ";
        }

        if ((c.setZipCode(zipCode) != 0)){
            message += "This zip code is not possible, ";
        }
        if ((c.setPopulation(population) != 0)){
            message += "This population is not possible, ";
        }
        

        if (message.length() > 0) {
            c = null;
            throw new BuildException(message);
        }
         return c;

    }

    public String getCardNum() {
        return cardNum;
    }

    public int setCardNum(String cardNum) {
        if ((checker.isNull(cardNum)) != 0) return -1;
        if ((checker.minLength(12, cardNum)) != 0) return -2;
        if ((checker.maxLenght(17, cardNum)) != 0) return -10;
        this.cardNum = cardNum;
        return 0;
    }

    public String getPopulation() {
        return population;
    }

    public int setPopulation(String population) {
        if ((checker.isNull(population)) != 0) return -1;
        if ((checker.minLength(3, population)) != 0) return -2;
        if ((checker.maxLenght(15, population)) != 0) return -10;
        this.population = population;
        return 0;
    }

    public String getZipCode() {
        return zipCode;
    }

    public int setZipCode(String zipCode) {
        if ((checker.isNull(zipCode)) != 0) return -1;
        if ((checker.minLength(4, zipCode)) != 0) return -2;
        if ((checker.maxLenght(6, zipCode)) != 0) return -10;
        this.zipCode = zipCode;
        return 0;
    }

    

    @Override
    public String toString() {
        return "Client [nif=" + nif + ", cardNum=" + cardNum + ", name=" + name + ", zipCode=" + zipCode + ", email="
                + email + ", population=" + population + ", direction=" + direction + ", phoneNumber=" + phoneNumber
                + "]";
    }

    @Override
    public String getContact() {
        return "El contacto de este cliente es: " + phoneNumber + " y su nombre es: " + name + " con su email: " + email + " y dirección: " + direction;
    }


}
