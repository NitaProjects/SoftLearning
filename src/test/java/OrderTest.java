
import demo.model.order.Order;
import demo.exceptions.BuildException;


public class OrderTest {

    public static void main(String[] args) {
        try{
        Order o = Order.getInstanceOrder( "12345678901", "Calle de kk", "Ash Grau", 
        "Fedex", "630241216", "aaaaaaaaa", null,
        null, "Info");

        System.out.println(o.toString());
        } catch (BuildException e) {
            System.out.println("Error al crear un objeto Order: " + e.getMessage());
        }

        try {
            Order o = Order.getInstanceOrder( "12345678901", "Calle de kk", "Ash Grau", 
            "Fedex", "630241216", "aaaaaaaaa", "2020-11-01 20:20:40",
            "2020-11-01 20:20:40", "Info",  20,20.30,20.30,2.30,
            "yes", "i:978-8-40-829707-9,q:3,p:20.2,d:0.25;i:978-8-46-797142-2,q:2,p:22.95,d:0.0;", 
            "COMPLETED", "CreditCard", "2020-12-01 20:20:40", "2020-12-01 20:20:40");

            System.out.println(o.toString());
        } catch (Exception e) {
            System.out.println("Error al crear un objeto Order: " + e.getMessage());
        }
        

     
    }
}



