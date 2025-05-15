package demo.model.products;

import demo.exceptions.BuildException;

public class ProductObject extends Product{
    public static ProductObject getInstance(double price, String name, String tematic) throws BuildException {
        String message = "";

        ProductObject a = new ProductObject();
        try {
            a.checkDataProduct(price, name, tematic);
        }catch (BuildException e){
            message = e.getMessage();
        }


        if (message.length() > 0) {
            a = null;
            throw new BuildException(message);
        }
        return a;
    }

    @Override
    public String getDetails() {
        return "Este product cuesta " + price + ". Este producto se titula/tiene por nombre " + name + " y su tematica es " + tematic;
    }
}
