
import demo.model.order.Order;
import demo.model.order.OrderDetail;
import demo.exceptions.BuildException;


import java.util.ArrayList;

public class FunctionalOrderTest {
    public static void main(String[] args) {
        try {

            Order o = Order.getInstanceOrder("1234567891", "Carrer Melcior palau 123", "Ash Grau Ayala",
             "Fedex", "637561389", "Operation", null, null, 
             "Este paquete contiene contenido fragil");
            System.out.println("String " + o);

            
            ArrayList<OrderDetail> CartShopping = new ArrayList<>();
            int result = o.setDetail("978-8-40-829707-9", 3, 20.20, 0.25);
            int result2 = o.setDetail("978-8-46-797142-2", 2, 22.95, 0.00);
            CartShopping.addAll(o.getShopCart());
            System.out.println("Order details: " + CartShopping);

            if (result == 0 || result2 == 0) {
                System.out.println("Order detail added successfully.");
            } else {
                System.out.println("Failed to add order detail, error code: " + result);
            }


            String hola = o.getShopCartAsCSV();
            System.out.println("String " + hola);

            String resultatPosString = o.getDetail("978-8-46-797142-2");
            System.out.println("Detalls per string: " + resultatPosString);

            String resultatPosNum = o.getDetail(0);
            System.out.println("Detalls per pos: " + resultatPosNum);

            int quantsHiHa = o.getNumDetails();
            System.out.println("Hi ha " + quantsHiHa + " llibres al carrito");

            double price = o.getTotalPrice();
            System.out.println("El preu total es de " + price + " euros");

            int updateUno = o.updateDetail(0, 1);
            if (updateUno == 0) {
                System.out.println("Order detail updated successfully.");
                System.out.println(o.getDetail(0));
            } else {
                System.out.println("Failed to update order detail, error code: " + result);
            }

            int updateDos = o.updateDetail(1, 5);
            if (updateDos == 0) {
                System.out.println("Order detail updated successfully.");
                System.out.println(o.getDetail(1));
            } else {
                System.out.println("Failed to update order detail, error code: " + result);
            }

            double priceAfter = o.getTotalPrice();
            System.out.println("El preu total es de " + priceAfter + " euros");

            String csv = "i:978-8-40-829707-9,q:4,p:30.30,d:0.00;i:978-8-46-797142-2,q:4,p:30.30,d:0.00"; 

            Order orderDetail = new Order();  
            int jjjj = orderDetail.setShopCartDetails(csv);
            if (jjjj == 0) {
                System.err.println("Se ha hecho el carrito correctamente");
            } else {
                System.out.println("Algo ha salido mal al hacer este carrito");
            }
        } catch (BuildException ex) {
            System.out.println("Error al crear un objeto Order: " + ex.getMessage());
        }


           
    }
}

