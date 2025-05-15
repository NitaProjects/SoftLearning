package demo.model.products;


import demo.exceptions.BuildException;
import demo.model.operations.checker;

public abstract class Product {
    protected double price;
    protected String name;
    protected String tematic;


    protected Product(double price, String name, String tematic) throws BuildException {
        // Valida los datos con el método checkData
        checkDataProduct(price, name, tematic);
    }

    protected Product (){
    }

    protected void checkDataProduct(double price, String name, String tematic) throws BuildException{
        String message = "";
        if ((setPrice(price) != 0)){
            message  += "This price is not possible, ";
        }
        if ((setName(name) != 0)){
            message  += "This name is not possible, ";
        }
        if ((setTematic(tematic) != 0)){
            message  += "This tematic is not possible, ";
        }
        if (message.length() > 0) {
            throw new BuildException(message);
        }

    }

    public double getPrice() {
        return price;
    }

    public int setPrice(double price) {
        if ((checker.nonZero(price)) != 0) return -3;
        if ((checker.nonNegative(price)) != 0) return -4;
        if ((checker.maxValue(price, 100.00)) != 0) return -5; 
        if ((checker.minValue(price, 1.00)) != 0) return -6;
        this.price = price;
        return 0;
    }

    public String getName() {
        return name;
    }

    public int setName(String name) {
        if ((checker.isNull(name)) != 0) return -1;
        if ((checker.minLength(6, name)) != 0) return -2;
        if ((checker.maxLenght(200, name)) != 0) return -10;
        this.name = name;
        return 0;
    }

    public String getTematic() {
        return tematic;
    }

    public int setTematic(String tematic) {
        if ((checker.isNull(tematic)) != 0) return -1;
        if ((checker.minLength(20, tematic)) != 0) return -2;
        if ((checker.maxLenght(500, tematic)) != 0) return -10;
        this.tematic = tematic;
        return 0;
    }

    public abstract String getDetails();


}
