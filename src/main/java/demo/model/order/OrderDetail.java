package demo.model.order;

import demo.model.operations.checker;
import demo.exceptions.BuildException;

public class OrderDetail {
    protected String isbn;
    protected int quantity;
    protected double price;
    protected double discountPrice;


    public OrderDetail(){
    }

    public static OrderDetail getInstanceOrderDetail(String isbn, int quantity, double price, double discountPrice) throws BuildException{
        String message = "";
        OrderDetail od = new OrderDetail();

        if ((od.setIsbn(isbn) != 0)){
            message  += "This ISBN is not possible, ";
         }

         if ((od.setQuantity(quantity) != 0)){
            message  += "This quantity is not possible, ";
         }

         if ((od.setPrice(price) != 0)){
            message  += "This price is not possible, ";
         }

         if ((od.setDiscountPrice(discountPrice) != 0)){
            message  += "This price discount is not possible, ";
         }

         if (message.length() > 0) {
        od = null;
            throw new BuildException(message);
         }
         return od;
    }
    
    public String getIsbn() {
        return isbn;
    }
    public int setIsbn(String isbn) {
        if ((checker.isNull(isbn)) != 0) return -1;
        if ((checker.validateISBN13(isbn)) != 0) return -24;
        this.isbn = isbn;
        return 0;
    }
    public int getQuantity() {
        return quantity;
    }
    public int setQuantity(int quantity) {
        if ((checker.nonZero(quantity)) != 0)
            return -3;
        if ((checker.nonNegative(quantity)) != 0)
            return -4;
        if ((checker.maxValue(quantity, 6)) != 0) 
            return -5; 
        if ((checker.minValue(quantity, 1)) != 0)
            return -6;
        this.quantity = quantity;
        return 0;
    }
    public double getPrice() {
        return price;
    }
    public int setPrice(double price) {
        if ((checker.nonZero(price)) != 0)
            return -3;
        if ((checker.nonNegative(price)) != 0)
            return -4;
        if ((checker.minValue(price, 0.99)) != 0)
            return -6;
        this.price = price;
        return 0;
    }
    public double getDiscountPrice() {
        return discountPrice;
    }
    public int setDiscountPrice(double discountPrice) {
        if ((checker.nonNegative(discountPrice)) != 0)
            return -4;
        if ((checker.maxValue(discountPrice, 1.01)) != 0) 
            return -5; 
        this.discountPrice = discountPrice;
        return 0;
    }

    @Override
    public String toString() {
        return "OrderDetail [isbn=" + isbn + ", quantity=" + quantity + ", price=" + price + ", discountPrice="
                + discountPrice + "]";
    }


    public double getDetailCost() {
        double total = 0;
        double descuento = 0;

        descuento = (price * quantity) * discountPrice; 
        total = (price * quantity) - descuento; 
        return total;
    }
    
    



}
