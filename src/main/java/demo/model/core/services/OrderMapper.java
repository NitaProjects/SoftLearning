package demo.model.core.services;

import demo.exceptions.BuildException;
import demo.model.order.Order;

public class OrderMapper {

    public static Order orderFromDTO(OrderDTO cdto) throws BuildException {
        return Order.getInstanceOrder(
        cdto.getDeliveryId(),
        cdto.getDeliveryDirection(),
        cdto.getDeliveryPersonName(),
        cdto.getTypeOfDelivery(),
        cdto.getPhoneNumber(),
        cdto.getOperationId(),
        cdto.getOrderDate(),
        cdto.getFinishDate(),
        cdto.getInformation(),
        cdto.getAncho(),
        cdto.getLargo(),
        cdto.getAlto(),
        cdto.getPeso(),
        cdto.getFragil(),
        cdto.getShopCart(),
        cdto.getStatus(),
        cdto.getPayingMethod(),
        cdto.getDeliveryDate(),
        cdto.getPaymentDate()
        );
    }



    public static OrderDTO dtoFromOrder (Order o){
        return new OrderDTO(
                o.getDeliveryId(),
                o.getDeliveryDirection(),
                o.getDeliveryPersonName(),
                o.getTypeOfDelivery(),
                o.getPhoneNumber(),
                o.getOperationId(),
                o.getOrderDate(),
                o.getFinishDate(),
                o.getInformation(),
                o.getAncho(),
                o.getLargo(),
                o.getAlto(),
                o.getPeso(),
                o.getFragil(),
                o.getShopCartAsCSV(),
                o.getStatus(),
                o.getPayingMethod(),
                o.getDeliveryDate(),
                o.getPaymentDate()
        );
    }

}
