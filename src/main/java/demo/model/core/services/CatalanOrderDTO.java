package demo.model.core.services;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class CatalanOrderDTO {
    
    private String deliveryId, deliveryDirection, deliveryPersonName, typeOfDelivery, payingMethod, paymentDate, deliveryDate, phoneNumber, operationId, orderDate, finishDate, information, fragil, shopCart,status;
    private double ancho, largo, alto, peso;

    public CatalanOrderDTO(){
        
    }

    public CatalanOrderDTO(String deliveryId, String deliveryDirection, String deliveryPersonName,
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


    @JsonGetter("num_lliurament")
    public String getDeliveryId() {
        return deliveryId;
    }


    @JsonGetter("direccio_lliurament")
    public String getDeliveryDirection() {
        return deliveryDirection;
    }


    @JsonGetter("nom_persona_lliurament")
    public String getDeliveryPersonName() {
        return deliveryPersonName;
    }


    @JsonGetter("tipus_lliurament")
    public String getTypeOfDelivery() {
        return typeOfDelivery;
    }


    @JsonGetter("tipus_pagament")
    public String getPayingMethod() {
        return payingMethod;
    }


    @JsonGetter("dia_pagament")
    public String getPaymentDate() {
        return paymentDate;
    }


    @JsonGetter("dia_lliurament")
    public String getDeliveryDate() {
        return deliveryDate;
    }


    @JsonGetter("telefon_persona_lliurament")
    public String getPhoneNumber() {
        return phoneNumber;
    }


    @JsonGetter("num_operació")
    public String getOperationId() {
        return operationId;
    }


    @JsonGetter("data_inici_operació")
    public String getOrderDate() {
        return orderDate;
    }


    @JsonGetter("data_final_operació")
    public String getFinishDate() {
        return finishDate;
    }


    @JsonGetter("informació")
    public String getInformation() {
        return information;
    }


    @JsonGetter("fragil")
    public String getFragil() {
        return fragil;
    }


    @JsonGetter("carro_compra")
    public String getShopCart() {
        return shopCart;
    }


    @JsonGetter("estat")
    public String getStatus() {
        return status;
    }


    @JsonGetter("amplada")
    public double getAncho() {
        return ancho;
    }


    @JsonGetter("llargada")
    public double getLargo() {
        return largo;
    }


    @JsonGetter("alçada")
    public double getAlto() {
        return alto;
    }


    @JsonGetter("pes")
    public double getPeso() {
        return peso;
    }


    //-----------------Settters----------------

    @JsonSetter("num_lliurament")
    public String setDeliveryId() {
        return deliveryId;
    }


    @JsonSetter("direccio_lliurament")
    public String setDeliveryDirection() {
        return deliveryDirection;
    }


    @JsonSetter("nom_persona_lliurament")
    public String setDeliveryPersonName() {
        return deliveryPersonName;
    }


    @JsonSetter("tipus_lliurament")
    public String setTypeOfDelivery() {
        return typeOfDelivery;
    }


    @JsonSetter("tipus_pagament")
    public String setPayingMethod() {
        return payingMethod;
    }


    @JsonSetter("dia_pagament")
    public String setPaymentDate() {
        return paymentDate;
    }


    @JsonSetter("dia_lliurament")
    public String setDeliveryDate() {
        return deliveryDate;
    }


    @JsonSetter("telefon_persona_lliurament")
    public String setPhoneNumber() {
        return phoneNumber;
    }


    @JsonSetter("num_operació")
    public String setOperationId() {
        return operationId;
    }


    @JsonSetter("data_inici_operació")
    public String setOrderDate() {
        return orderDate;
    }


    @JsonSetter("data_final_operació")
    public String setFinishDate() {
        return finishDate;
    }


    @JsonSetter("informació")
    public String setInformation() {
        return information;
    }


    @JsonSetter("fragil")
    public String setFragil() {
        return fragil;
    }


    @JsonSetter("carro_compra")
    public String setShopCart() {
        return shopCart;
    }


    @JsonSetter("estat")
    public String setStatus() {
        return status;
    }


    @JsonSetter("amplada")
    public double setAncho() {
        return ancho;
    }


    @JsonSetter("llargada")
    public double setLargo() {
        return largo;
    }


    @JsonSetter("alçada")
    public double setAlto() {
        return alto;
    }


    @JsonGetter("pes")
    public double setPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "CatalanOrderDTO [num_lliurament=" + deliveryId + ", direccio_lliurament=" + deliveryDirection
                + ", nom_persona_lliurament=" + deliveryPersonName + ", tipus_lliurament=" + typeOfDelivery
                + ", tipus_pagament=" + payingMethod + ", dia_pagament=" + paymentDate + ", dia_lliurament=" + deliveryDate
                + ", telefon_persona_lliurament=" + phoneNumber + ", num_operació=" + operationId + ", data_inici_operació=" + orderDate
                + ", data_final_operació=" + finishDate + ", informació=" + information + ", fragil=" + fragil + ", carro_compra="
                + shopCart + ", estat=" + status + ", amplada=" + ancho + ", llargada=" + largo + ", alçada=" + alto
                + ", pes=" + peso + "]";
    }

    


}
