import demo.model.products.PhysicalData;
import demo.model.order.Order;
import demo.model.order.OrderDetail;
import demo.exceptions.BuildException;


import java.util.ArrayList;


public class FinalFunctionalOrderTest {
    public static void main(String[] args) {
        try {

            Order o = Order.getInstanceOrder("1234567891", "Carrer Melcior palau 123", "Ash Grau Ayala",
             "Fedex", "637561389", "Operation", null, null, 
             "Este paquete contiene contenido fragil");
            System.out.println("String " + o);

            ArrayList<OrderDetail> CartShopping = new ArrayList<>();
            int result = o.setDetail("978-8-40-829707-9", 3, 10.10, 0.25);
            int result2 = o.setDetail("978-8-46-797142-2", 2, 20.40, 0.00);
            CartShopping.addAll(o.getShopCart());
            System.out.println("Order details: " + CartShopping);

            if (result == 0 || result2 == 0) {
                System.out.println("Order detail added successfully.");
            } else {
                System.out.println("Failed to add order detail, error code: " + result);
            }

            /*Ir a functional OrderTest */
            
            String probacsv = o.getShopCartAsCSV();
            System.out.println("Su carrito es " + probacsv);


            double price = o.getTotalPrice();
            System.out.println("El preu total es de " + price + " euros");


            o.setPayingMethod("CreditCard");
            System.out.println("El pago se hara con " + o.getPayingMethod());
            System.out.println("El estado de la orden es " + o.getStatus());

  
            o.setPaymentDate("2020-01-01 22:22:22");
            System.out.println("La data de pago es " + o.getPaymentDate());

            String packageDetails = "h:10.10,w:10.10,W:1.10,f:yes,d:10.10";
            PhysicalData physicalData = o.setPackDataFromString(packageDetails);
           
            //detalles del paquete
            System.out.println("Physical Data created: " + physicalData.toString());
            System.out.println("El estado de la orden es " + o.getStatus());

            
            //fecha de entrega
            o.setDeliveryDate("2020-04-04 22:22:22");
            System.out.println("La data de entrega es " + o.getDeliveryDate());
            //estado
            o.setFinishDateFromString("2020-05-04 22:22:22");
            System.out.println("El estado de la orden es " + o.getStatus());


        } catch (BuildException ex) {
            System.out.println("Error al crear un objeto Order: " + ex.getMessage());
        }


           
    }
}
