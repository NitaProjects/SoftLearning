package demo.model.core.services;

public class ClientDTO {
    private String nif, name, email, direction, cardNum, zipCode, population;
    private int phoneNumber;

    public ClientDTO(){

    }

    public ClientDTO(String nif, String name, String email, 
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

    public String getNif() {
        return nif;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDirection() {
        return direction;
    }

    public String getCardNum() {
        return cardNum;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPopulation() {
        return population;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "ClientDTO [nif=" + nif + ", name=" + name + ", email=" + email + ", direction=" + direction
                + ", cardNum=" + cardNum + ", zipCode=" + zipCode + ", population=" + population + ", phoneNumber="
                + phoneNumber + "]";
    }

    


    
}
