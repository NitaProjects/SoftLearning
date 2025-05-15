package demo.model.order;

import demo.model.products.PhysicalData;
import demo.model.operations.checker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import demo.exceptions.BuildException;
import demo.interfaces.Storable;

public class Order extends Operation implements Storable {
    protected String deliveryId;
    protected String deliveryDirection;
    protected String deliveryPersonName;
    protected String typeOfDelivery;
    protected PhysicalData packageDetails;
    protected ArrayList<OrderDetail> shopCart;
    protected String payingMethod;
    protected OrderStatus status;
    protected Set<String> phoneNumber;
    protected LocalDateTime paymentDate;
    protected LocalDateTime deliveryDate;

    public Order() {
        this.phoneNumber = new HashSet<String>();
        this.shopCart = new ArrayList<OrderDetail>();
        this.status = OrderStatus.CREATED;
    }

    public static Order getInstanceOrder(String deliveryId, String deliveryDirection,
            String deliveryPersonName, String typeOfDelivery, String phoneNumber, String operationId,
            String orderDate, String finishDate, String information) throws BuildException {
        String message = "";

        Order o = new Order();

        try {
            o.checkDataOperation(operationId, null, null, information);
        } catch (BuildException e) {
            message = e.getMessage();
        }

        if ((o.setTypeOfDelivery(typeOfDelivery) != 0)) {
            message += "This type of delivery is not correct, ";
        }
        if ((o.setDeliveryId(deliveryId) != 0)) {
            message += "This delivery ID is not correct, ";
        }
        if ((o.setDeliveryDirection(deliveryDirection) != 0)) {
            message += "This delivery direcction is not correct, ";
        }
        if ((o.setDeliveryPersonName(deliveryPersonName) != 0)) {
            message += "This delivery person name is not correct, ";
        }
        if ((o.setPhoneNumber(phoneNumber) != 0)) {
            message += "This phone number is not correct, ";
        }

        if (message.length() > 0) {
            o = null;
            throw new BuildException(message);
        }
        return o;

    }

    public String getStatus() {
        return status.toString();
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public String getDeliveryDirection() {
        return deliveryDirection;
    }

    public String getDeliveryPersonName() {
        return deliveryPersonName;
    }

    public String getTypeOfDelivery() {
        return typeOfDelivery;
    }

    public String getPhoneNumber() {
        return phoneNumber.toString();
    }

    private void makeSureStatusCreated() throws BuildException {
        if (this.status != OrderStatus.CREATED) {
            throw new BuildException("No se puede cambiar ese dato cuando estas en " + status + " estado");
        }
    }

    public String cancelledOrder() throws BuildException {
        makeSureStatusCreated();
        this.status = OrderStatus.CANCELLED;
        return "El pedido ha sido cancelado";
    }

    public int setDeliveryId(String deliveryId) throws BuildException {
        makeSureStatusCreated();
        if ((checker.isNull(deliveryId)) != 0)
            return -1;
        if ((checker.minLength(9, deliveryId)) != 0)
            return -2;
        if ((checker.maxLenght(11, deliveryId)) != 0)
            return -10;
        this.deliveryId = deliveryId;
        return 0;
    }

    public int setDeliveryDirection(String deliveryDirection) throws BuildException {
        makeSureStatusCreated();
        if ((checker.isNull(deliveryDirection)) != 0)
            return -1;
        if ((checker.minLength(6, deliveryDirection)) != 0)
            return -2;
        if ((checker.maxLenght(25, deliveryDirection)) != 0)
            return -10;
        this.deliveryDirection = deliveryDirection;
        return 0;
    }

    public int setDeliveryPersonName(String deliveryPersonName) throws BuildException {
        makeSureStatusCreated();
        if ((checker.isNull(deliveryPersonName)) != 0)
            return -1;
        if ((checker.minLength(2, deliveryPersonName)) != 0)
            return -2;
        if ((checker.maxLenght(15, deliveryPersonName)) != 0)
            return -10;
        this.deliveryPersonName = deliveryPersonName;
        return 0;
    }

    public int setTypeOfDelivery(String typeOfDelivery) throws BuildException {
        makeSureStatusCreated();
        if ((checker.isNull(typeOfDelivery)) != 0)
            return -1;
        if ((checker.minLength(2, typeOfDelivery)) != 0)
            return -2;
        if ((checker.maxLenght(15, typeOfDelivery)) != 0)
            return -10;
        this.typeOfDelivery = typeOfDelivery;
        return 0;
    }

    public int setPhoneNumber(String phoneNumber) throws BuildException {
        makeSureStatusCreated();
        if ((checker.isNull(phoneNumber)) != 0)
            return -1;
        if ((checker.minLength(8, phoneNumber)) != 0)
            return -2;
        if ((checker.maxLenght(13, phoneNumber)) != 0)
            return -10;
        this.phoneNumber.add(phoneNumber);
        return 0;
    }

    public int setOrderDate(LocalDateTime orderDate) {
        try {
            if (orderDate != null) {
                makeSureStatusDelivered();
                this.finishDate = orderDate;
                this.status = OrderStatus.CONFIRMED;
                return 0;
            } else {
                return 0;
            }

        } catch (BuildException e) {
            return -22;
        }
    }

    private void makeSureStatusConfirmed() throws BuildException {
        if (this.status != OrderStatus.CONFIRMED) {
            throw new BuildException("No se puede cambiar ese dato cuando estas en " + status + " estado");
        }
    }

    public static PhysicalData setPackDataFromString(String packageDetails) throws BuildException {
        if ((checker.isNull(packageDetails)) != 0) {
            throw new BuildException("The package details are not valid, they should have at least 12 characters");
        }
    
        if (packageDetails.length() < 12) {
            throw new BuildException("The package details are not valid, they should have at least 12 characters");
        }
    
        String[] myArray = packageDetails.split(",");
    
        String fragil = "";
        double alto = 0;
        double ancho = 0;
        double peso = 0;
        double largo = 0;
    
        for (String stringSinComas : myArray) {
            String[] keyValue = stringSinComas.split(":");
            String key = keyValue[0];
            String value = keyValue[1].trim();  // trim whitespace
    
            // Checking if the value can be parsed to a number
            switch (key) {
                case "f":
                    fragil = value;
                    break;
                case "h":
                    alto = parseDoubleOrDefault(value);
                    break;
                case "w":
                    ancho = parseDoubleOrDefault(value);
                    break;
                case "W":
                    peso = parseDoubleOrDefault(value);
                    break;
                case "d":
                    largo = parseDoubleOrDefault(value);
                    break;
                default:
                    throw new BuildException("Unknown key: " + key);
            }
        }
        return PhysicalData.getInstancePhysicalData(ancho, largo, alto, peso, fragil);
    }
    
    private static double parseDoubleOrDefault(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException ex) {
            return 0.0;
        }
    }

    public double getAncho() {
        return packageDetails.getAncho();
    }

    public double getAlto() {
        return packageDetails.getAlto();
    }

    public double getLargo() {
        return packageDetails.getLargo();
    }

    public double getPeso() {
        return packageDetails.getPeso();
    }

    public String getFragil() {
        return packageDetails.getFragil();
    }

    public int setAncho(double ancho) throws BuildException {
        makeSureStatusConfirmed();
        return packageDetails.setAncho(ancho);
    }

    public int setLargo(double largo) throws BuildException {
        makeSureStatusConfirmed();
        return packageDetails.setLargo(largo);
    }

    public int setAlto(double alto) throws BuildException {
        makeSureStatusConfirmed();
        return packageDetails.setAlto(alto);
    }

    public int setPeso(double peso) throws BuildException {
        makeSureStatusConfirmed();
        return packageDetails.setPeso(peso);
    }

    public int setFragil(String fragil) throws BuildException {
        makeSureStatusNotCompleted();
        return packageDetails.setFragil(fragil);
    }

    public String getDimensions() {
        return packageDetails.getDimensions();
    }

    public double getVolumen() {
        return packageDetails.getVolumen();
    }

    public String getPayingMethod() {
        return payingMethod;
    }

    private void makeSureStatusNotCompleted() throws BuildException {
        if (this.status == OrderStatus.COMPLETED || this.status == OrderStatus.CANCELLED) {
            throw new BuildException("No se puede modificar una orden en estado " + status);
        }
    }

    public int setPayingMethod(String payingMethod) throws BuildException {
        makeSureStatusCreated();
        if ((checker.isNull(payingMethod)) != 0)
            return -1;
        if ((checker.whichPaymentMethod(payingMethod)) != 0)
            return -1;
        this.payingMethod = payingMethod;
        return 0;
    }

    public String getPaymentDate() {
        return paymentDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    public int setPaymentDate(String paymentDate) {
        try {
            makeSureStatusCreated();
            this.paymentDate = checker.checkDateAndTime(paymentDate);
        } catch (BuildException e) {
            return -22;
        }
        this.status = OrderStatus.FORTHCOMMING;
        return 0;
    }

    private void makeSureStatusForthcomming() throws BuildException {
        if (this.status != OrderStatus.FORTHCOMMING) {
            throw new BuildException("No se puede cambiar ese dato cuando estas en " + status + " estado");
        }
    }

    public String getDeliveryDate() {
        return deliveryDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    public int setDeliveryDate(String deliveryDate) throws BuildException {
        makeSureStatusForthcomming();
        try {
            this.deliveryDate = checker.checkDateAndTime(deliveryDate);
        } catch (BuildException e) {
            return -22;
        }
        this.status = OrderStatus.DELIVERED;
        return 0;
    }

    private void makeSureStatusDelivered() throws BuildException {
        if (this.status != OrderStatus.DELIVERED) {
            throw new BuildException("No se puede cambiar ese dato cuando estas en " + status + " estado");
        }

    }

    public int setFinishDate(LocalDateTime finishDate) {
        try {
            if (finishDate != null) {
                makeSureStatusDelivered();
                this.status = OrderStatus.COMPLETED;
                this.finishDate = finishDate;
                return 0;
            } else {
                return 0;
            }

        } catch (BuildException e) {
            return -22;
        }
    }

    public String getShopCartAsCSV() {
        StringBuilder csvShopCart = new StringBuilder();

        for (OrderDetail orderDetail : shopCart) {
            csvShopCart.append("i:").append(orderDetail.getIsbn())
                    .append(",q:").append(orderDetail.getQuantity())
                    .append(",p:").append(orderDetail.getPrice())
                    .append(",d:").append(orderDetail.getDiscountPrice())
                    .append(";");
        }

        return csvShopCart.toString();
    }

    public ArrayList<OrderDetail> getShopCart() {
        return shopCart;
    }

    public void setShopCart(ArrayList<OrderDetail> shopCart) {
        this.shopCart = shopCart;
    }

    public int getNumDetails() {
        int itemCount = shopCart.size();
        return itemCount;
    }

    public int setDetail(String isbn, int quantity, double price, double discountPrice) throws BuildException {
        makeSureStatusNotCompleted(); 
        for (OrderDetail detail : shopCart) {
            if (detail.getIsbn().equals(isbn)) {
                throw new BuildException("Este isbn ya existe");
            }
        }
        OrderDetail newDetail = OrderDetail.getInstanceOrderDetail(isbn, quantity, price, discountPrice);
        shopCart.add(newDetail);
        return 0;
    }

    public String getDetail(int pos) throws BuildException {
        if (pos < 0 || pos >= shopCart.size()) {
            throw new BuildException("Invalid position");
        }

        OrderDetail detail = shopCart.get(pos);
        return detail.toString();
    }

    public String getDetail(String isbn) throws BuildException {
        for (OrderDetail detail : shopCart) {
            if (detail.getIsbn().equals(isbn)) {
                return detail.toString();
            }
        }
        throw new BuildException("Invalid ISBN: " + isbn);
    }

    public double getTotalPrice() throws BuildException {
        double totalPrice = 0;
        for (OrderDetail detail : shopCart) {
            totalPrice += detail.getDetailCost();
        }
        return totalPrice;
    }

    public int updateDetail(String isbn, int quantity) throws BuildException {
        makeSureStatusNotCompleted();
        for (OrderDetail detail : shopCart) {
            if (detail.getIsbn().equals(isbn)) {
                detail.setQuantity(quantity);
                return 0;
            }
        }
        throw new BuildException("Invalid isbn");
    }

    public int updateDetail(int position, int quantity) throws BuildException {
        makeSureStatusNotCompleted();
        if (position < 0 || position >= shopCart.size()) {
            throw new BuildException("Invalid position");
        }
        OrderDetail detail = shopCart.get(position);
        detail.setQuantity(quantity);
        return 0;
    }

    public int deleteDetail(int position) throws BuildException {
        makeSureStatusNotCompleted();
        if (position < 0 || position >= shopCart.size()) {
            throw new BuildException("Invalid position");
        }
        shopCart.remove(position);
        return 0;
    }

    public int deleteDetail(String isbn) throws BuildException {
        makeSureStatusNotCompleted();
        for (int i = 0; i < shopCart.size(); i++) {
            if (shopCart.get(i).getIsbn().equals(isbn)) {
                shopCart.remove(i);
                return 0;
            }
        }
        throw new BuildException("Invalid ISBN: " + isbn);
    }

    public int setShopCartDetails(String csvShopCart) throws BuildException {
        if (csvShopCart == null || csvShopCart.length() < 12) {
            throw new BuildException("The package details are not valid, they should have at least 12 characters");
        }

        String[] arrayLibro = csvShopCart.split(";");

        for (String libro : arrayLibro) {
            String[] detallesOrden = libro.split(",");
            String isbn = "";
            int quantity = 0;
            double price = 0.00;
            double discountPrice = 0.00;

            for (String detalle : detallesOrden) {
                String[] keyValue = detalle.split(":");

                if (keyValue.length != 2) {
                    throw new BuildException("Invalid detail format: " + detalle);
                }

                String key = keyValue[0].trim();
                String value = keyValue[1].trim();

                switch (key) {
                    case "i":
                        isbn = value;
                        break;
                    case "q":
                        try {
                            quantity = Integer.parseInt(value);
                        } catch (NumberFormatException e) {
                            throw new BuildException("Invalid quantity value: " + value);
                        }
                        break;
                    case "d":
                        try {
                            discountPrice = Double.parseDouble(value);
                        } catch (NumberFormatException e) {
                            throw new BuildException("Invalid discount price value: " + value);
                        }
                        break;
                    case "p":
                        try {
                            price = Double.parseDouble(value);
                        } catch (NumberFormatException e) {
                            throw new BuildException("Invalid price value: " + value);
                        }
                        break;
                    default:
                        throw new BuildException("Unknown key: " + key);
                }

            }
            try {
                this.shopCart.add(OrderDetail.getInstanceOrderDetail(isbn, quantity, price, discountPrice));
            } catch (BuildException e) {
                throw new BuildException("Failed to create order detail: " + e);
            }

        }
        return 0;
    }

    public static Order getInstanceOrder(String deliveryId, String deliveryDirection, String deliveryPersonName,
            String typeOfDelivery, String phoneNumber, String operationId,
            String orderDate, String finishDate, String information,
            double ancho, double largo, double alto, double peso, String fragil, String shopCart, String status,
            String payingMethod,
            String deliveryDate, String paymentDate) throws BuildException {

        String message = "";

        Order o = new Order();

        try {
            o.checkDataOperation(operationId, orderDate, finishDate, information);
        } catch (BuildException e) {
            message = e.getMessage();
        }

        if ((o.setPayingMethod(payingMethod) != 0)) {
            message += "This type of paying method is not correct, ";
        }
        if ((o.setDeliveryId(deliveryId) != 0)) {
            message += "This delivery ID is not correct, ";
        }
        if ((o.setDeliveryDirection(deliveryDirection) != 0)) {
            message += "This delivery direction is not correct, ";
        }
        if ((o.setDeliveryPersonName(deliveryPersonName) != 0)) {
            message += "This delivery person name is not correct, ";
        }
        if ((o.setTypeOfDelivery(typeOfDelivery) != 0)) {
            message += "This type of delivery is not correct, ";
        }
        if ((o.setPhoneNumber(phoneNumber) != 0)) {
            message += "This phone number is not correct, ";
        }

        if ((o.setShopCartDetails(shopCart)) != 0) {
            message += "This type of shop cart is not correct, ";
        }
        if ((o.setPaymentDate(paymentDate)) != 0) {
            message += "This type of payment date is not correct, ";
        }
        if (deliveryDate != null) {
            if ((o.setDeliveryDate(deliveryDate)) != 0) {
                message += "This type of delivery date is not correct, ";
            }
        }

        try {
            o.packageDetails = PhysicalData.getInstancePhysicalData(ancho, largo, alto, peso, fragil);
        } catch (BuildException ex) {
            message += ex.getMessage();
        }

        if (message.length() > 0) {
            o = null;
            throw new BuildException(message);
        }

        return o;
    }

    @Override
    public String toString() {
        return "Order [operationId=" + operationId + ", orderDate=" + orderDate + ", finishDate=" + finishDate
                + ", information=" + information + ", deliveryId=" + deliveryId + ", deliveryDirection="
                + deliveryDirection + ", deliveryPersonName=" + deliveryPersonName + ", typeOfDelivery="
                + typeOfDelivery + ", packageDetails=" + packageDetails + ", shopCart=" + shopCart + ", payingMethod="
                + payingMethod + ", status=" + status + ", phoneNumber=" + phoneNumber + ", paymentDate=" + paymentDate
                + ", deliveryDate=" + deliveryDate + "]";
    }

}
