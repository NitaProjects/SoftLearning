package demo.model.persons;

import demo.exceptions.BuildException;

public class PersonObject extends Person {

    public static PersonObject getInstant(String nif, String name, String email, 
    String direction, int phoneNumber) throws BuildException{
        String message = "";
        PersonObject c = new PersonObject();

        try {
            c.checkDataPerson(nif, name, email, direction, phoneNumber); 
        }catch (BuildException e){
            message = e.getMessage();
        }


        if (message.length() > 0) {
            c = null;
            throw new BuildException(message);
        }
        return c;
    }

    @Override
    public String getContact() {
        return "El nif de este person es: " + nif + " y su nombre es: " + name + " con su email: " + email + " y dirección: " + direction;
    }



}
