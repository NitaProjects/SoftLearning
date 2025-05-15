package demo.model.order;

public enum OrderStatus {
    CREATED, //solo se ha creado el order, pendiente de confirmacion  
    CANCELLED, //order cancelado
    CONFIRMED, //carrito validado
    FORTHCOMMING, //paquete preparado y almacenado pendoente de envio
    DELIVERED, //envio iniciado con destino al cliente
    COMPLETED //emvio envidado al cliente
}
