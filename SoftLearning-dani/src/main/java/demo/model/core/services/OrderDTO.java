package demo.model.core.services;

public class OrderDTO {



    private String deliveryId, deliveryDirection, deliveryPersonName, typeOfDelivery, payingMethod, paymentDate, deliveryDate, phoneNumber, operationId, orderDate, finishDate, information, fragil, shopCart,status;
    private double ancho, largo, alto, peso;

    public OrderDTO(){
        
    }

    public OrderDTO(String deliveryId, String deliveryDirection, String deliveryPersonName,
    String typeOfDelivery, String phoneNumber, String operationId, 
    String orderDate, String finishDate, String information, 
    double ancho, double largo, double alto, double peso, String fragil, String shopCart, String status, String payingMethod, 
    String deliveryDate, String paymentDate) {
        this.deliveryId = deliveryId;
        this.deliveryDirection = deliveryDirection;
        this.deliveryPersonName = deliveryPersonName;
        this.typeOfDelivery = typeOfDelivery;
        this.phoneNumber = phoneNumber;
        this.operationId =operationId;
        this.orderDate = orderDate;
        this.finishDate= finishDate;
        this.information = information;
        this.ancho = ancho;
        this.largo = largo;
        this.alto = alto;
        this.peso = peso;
        this.fragil = fragil;
        this.shopCart = shopCart;
        this.status = status;
        this.payingMethod = payingMethod;
        this.deliveryDate = deliveryDate;
        this.paymentDate = paymentDate;
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


    public String getPayingMethod() {
        return payingMethod;
    }


    public String getPaymentDate() {
        return paymentDate;
    }


    public String getDeliveryDate() {
        return deliveryDate;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getOperationId() {
        return operationId;
    }


    public String getOrderDate() {
        return orderDate;
    }


    public String getFinishDate() {
        return finishDate;
    }


    public String getInformation() {
        return information;
    }


    public String getFragil() {
        return fragil;
    }


    public String getShopCart() {
        return shopCart;
    }


    public String getStatus() {
        return status;
    }


    public double getAncho() {
        return ancho;
    }


    public double getLargo() {
        return largo;
    }


    public double getAlto() {
        return alto;
    }


    public double getPeso() {
        return peso;
    }




}
