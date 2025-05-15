package demo.model.persons;

import demo.exceptions.BuildException;
import demo.model.operations.checker;

public abstract class Person {
    protected String nif;
    protected String name;
    protected String email;
    protected String direction;
    protected int phoneNumber;

    protected Person(String nif, String name, String email, String direction, int phoneNumber) throws BuildException {
        checkDataPerson(nif, name, email, direction, phoneNumber);
    }

    protected Person() {

    }

    protected void checkDataPerson(String nif, String name, String email, String direction, int phoneNumber)
            throws BuildException {
        String message = "";
        if ((setNif(nif) != 0)) {
            message += "This NIF is not possible, ";
        }
        if ((setName(name) != 0)) {
            message += "This name is not possible, ";
        }
        if ((setEmail(email) != 0)) {
            message += "This email is not possible, ";
        }
        if ((setDirection(direction) != 0)) {
            message += "This direction is not possible, ";
        }
        if ((setPhoneNumber(phoneNumber) != 0)) {
            message += "This phone number is not possible, ";
        }

        if (message.length() > 0) {
            throw new BuildException(message);
        }
    }

    public String getNif() {
        return nif;
    }

    public int setNif(String nif) {
        if ((checker.isNull(nif)) != 0)
            return -1;
        if ((checker.checkDNI(nif) != 0)) return -22;
        this.nif = nif;
        return 0;
    }

    public String getName() {
        return name;
    }

    public int setName(String name) {
        if ((checker.isNull(name)) != 0)
            return -1;
        if ((checker.minLength(3, name)) != 0)
            return -2;
        if ((checker.maxLenght(10, name)) != 0)
            return -10;
        this.name = name;
        return 0;
    }

    public String getEmail() {
        return email;
    }

    public int setEmail(String email) {
        if ((checker.isNull(email)) != 0) return -1;
if ((checker.validarCorreo(email) != 0)) return -22;
        this.email = email;
        
        return 0;
    }

    public String getDirection() {
        return direction;
    }

    public int setDirection(String direction) {
        if ((checker.isNull(direction)) != 0)
            return -1;
        if ((checker.minLength(8, direction)) != 0)
            return -2;
        if ((checker.maxLenght(60, direction)) != 0)
            return -10;
        this.direction = direction;
        return 0;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int setPhoneNumber(int phoneNumber) {
        if ((checker.nonZero(phoneNumber)) != 0)
            return -3;
        if ((checker.nonNegative(phoneNumber)) != 0)
            return -4;
        if ((checker.maxValueCount(phoneNumber, 13)) != 0)
            return -5;
        if ((checker.minValueCount(phoneNumber, 8)) != 0)
            return -6;
        this.phoneNumber = phoneNumber;
        return 0;
    }

    public String getData() {
        return getName() + " es el nombre de esa persona\n" +
                getNif() + " es el NIF de esa persona\n" +
                getEmail() + " este es el mail de esa persona\n" +
                getDirection() + " esta es la direccion de la persona\n";
    }

    public abstract String getContact();

}
