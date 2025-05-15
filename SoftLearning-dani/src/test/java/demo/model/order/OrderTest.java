package demo.model.order;

import demo.exceptions.BuildException;
import demo.model.products.PhysicalData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class OrderTest {

    private Order order;

    // ============================
    // TESTS PARA ORDEN EN CREATED
    // ============================
    @Nested
    class WhenOrderIsCreated {
        @BeforeEach
        void setup() {
            try {
                order = Order.getInstanceOrder(
                        "D123456789", "Calle Luna 45", "Carlos", "Express", "612345678",
                        "OP123456789", null, null, "Info");
            } catch (BuildException e) {
                fail("No se pudo crear la orden: " + e.getMessage());
            }
        }

        @Test
        void testInitialStatusIsCreated() {
            assertEquals("CREATED", order.getStatus());
        }

        @Test
        void testSetPayingMethodInCreated() throws BuildException {
            assertEquals(0, order.setPayingMethod("Paypal"));
        }

        @Test
        void testCancelledOrder() throws BuildException {
            assertEquals("El pedido ha sido cancelado", order.cancelledOrder());
        }

        @Test
        void testSetDeliveryId() throws BuildException {
            assertEquals(0, order.setDeliveryId("DEL1234567"));
        }

        @Test
        void testSetDeliveryDirection() throws BuildException {
            assertEquals(0, order.setDeliveryDirection("Calle Nueva"));
        }

        @Test
        void testSetDeliveryPersonName() throws BuildException {
            assertEquals(0, order.setDeliveryPersonName("Luis"));
        }

        @Test
        void testSetPhoneNumber() throws BuildException {
            assertEquals(0, order.setPhoneNumber("612345679"));
        }

        @Test
        void testSetTypeOfDelivery() throws BuildException {
            assertEquals(0, order.setTypeOfDelivery("Rápido"));
        }

        @Test
        void testSetDetail() throws BuildException {
            assertEquals(0, order.setDetail("978-1-23-456788-0", 2, 12.0, 0.2));
        }

        @Test
        void testDeleteDetail() throws BuildException {
            order.setDetail("978-1-23-456789-7", 1, 10.0, 0.1);
            assertEquals(0, order.deleteDetail(0));
        }

        @Test
        void testDeleteDetailInvalidISBN() {
            Exception ex = assertThrows(BuildException.class, () -> order.deleteDetail("no-existe"));
            assertTrue(ex.getMessage().contains("Invalid ISBN"));
        }

        @Test
        void testSetShopCartDetails() throws BuildException {
            assertEquals(0, order.setShopCartDetails("i:978-1-23-456789-7,q:2,p:10.0,d:0.1;"));
        }

        @Test
        void testSetPackDataFromString() throws BuildException {
            PhysicalData product = Order.setPackDataFromString("h:5,w:10,d:15,W:2,f:yes");
            assertNotNull(product);
        }

        @Test
        void testSetPackDataFromStringBad() throws BuildException {
            try{
                PhysicalData product = Order.setPackDataFromString("h:no,w:10,d:15,W:2,f:yes");
            } catch (BuildException ex){
                assertEquals("This high is not possible, ", ex.getMessage());
            }
        }

        @Test
        void testSetPackDataFromStringInvalid() {
            Exception e = assertThrows(BuildException.class, () -> {
                Order.setPackDataFromString("f:maybe,h:999,w:0,W:0.1,d:1");
            });
            assertTrue(e.getMessage().contains("wide"));
        }

        @Test
        void testSetFinishDateInCreated() {
            assertEquals(-22, order.setFinishDate(LocalDateTime.now()));
        }

        @Test
        void testSetDeliveryDateShouldFailInCreated() {
            assertThrows(BuildException.class, () -> order.setDeliveryDate("05-01-2024 12:00:00"));
        }

        @Test
        void testSetShopCartDetailsWrongFormat() {
            Exception ex = assertThrows(BuildException.class,
                    () -> order.setShopCartDetails("i:978-1-23-456789-7,q:x,p:10.0,d:0.1;"));
            assertTrue(ex.getMessage().contains("Invalid quantity value"));
        }

        @Test
        void testUpdateDetailWithoutDetailThrows() {
            assertThrows(BuildException.class, () -> order.updateDetail("978-9", 1));
        }

        @Test
        void testShopCartAsCSVEmptyInitially() {
            assertEquals("", order.getShopCartAsCSV());
        }

        @Test
        void testToStringIncludesKeyFields() {
            String s = order.toString();
            assertTrue(s.contains("Order [operationId="));
            assertTrue(s.contains("deliveryId=D123456789"));
        }

        @Test
        void testSetDetailDuplicateISBNThrows() throws BuildException {
            order.setDetail("978-1-23-456788-0", 1, 10.0, 0.1);
            assertThrows(BuildException.class, () -> order.setDetail("978-1-23-456788-0", 2, 12.0, 0.2));
        }

        @Test
        void testGetDetailInvalidIndexThrows() {
            assertThrows(BuildException.class, () -> order.getDetail(0));
        }

        @Test
        void testGetDetailByISBNThrowsWhenNotFound() {
            assertThrows(BuildException.class, () -> order.getDetail("999-9"));
        }

        @Test
        void testUpdateDetailWorksInCreated() throws BuildException {
            String isbn = "978-1-23-456788-0";
            order.setDetail(isbn, 1, 10.0, 0.1);
            assertEquals(0, order.updateDetail(isbn, 3));
        }

        @Test
        void testDeleteDetailInvalidIndexThrows() {
            assertThrows(BuildException.class, () -> order.deleteDetail(1));
        }

    }

    // ============================
    // TESTS PARA ORDEN EN CANCELLED
    // ============================
    @Nested
    class WhenOrderIsCancelled {

        @BeforeEach
        void setup() {
            try {
                order = Order.getInstanceOrder(
                        "D123456789", "Calle Luna 45", "Carlos", "Express", "612345678",
                        "OP123456789", null, null, "Info");
                order.cancelledOrder(); // ← fuerza estado CANCELLED
            } catch (BuildException e) {
                fail("No se pudo crear o cancelar la orden: " + e.getMessage());
            }
        }

        @Test
        void testStatusIsCancelled() {
            assertEquals("CANCELLED", order.getStatus());
        }

        @Test
        void testSetDeliveryIdFailsInCancelled() {
            assertThrows(BuildException.class, () -> order.setDeliveryId("NUEVOID123"));
        }

        @Test
        void testSetDetailFailsInCancelled() {
            assertThrows(BuildException.class, () -> order.setDetail("978-1-23-456789-7", 1, 10.0, 0.1));
        }

        @Test
        void testDeleteDetailFailsInCancelled() {
            assertThrows(BuildException.class, () -> order.deleteDetail(0));
        }

        @Test
        void testSetFinishDateFailsInCancelled() {
            assertEquals(-22, order.setFinishDate(LocalDateTime.now()));
        }

        @Test
        void testSetPaymentDateFailsInCancelled() {
            assertEquals(-22, order.setPaymentDate("10-01-2024 12:00:00"));
        }

        @Test
        void testGettersStillWorkInCancelled() {
            assertEquals("CANCELLED", order.getStatus());
            assertEquals("D123456789", order.getDeliveryId());
            assertTrue(order.getPhoneNumber().contains("612345678"));
        }

        @Test
        void testSetDeliveryPersonNameFailsInCancelled() {
            assertThrows(BuildException.class, () -> order.setDeliveryPersonName("Nuevo"));
        }

        @Test
        void testSetDeliveryDirectionFailsInCancelled() {
            assertThrows(BuildException.class, () -> order.setDeliveryDirection("Nueva Calle 12"));
        }

        @Test
        void testSetPhoneNumberFailsInCancelled() {
            assertThrows(BuildException.class, () -> order.setPhoneNumber("699999999"));
        }

        @Test
        void testSetPayingMethodFailsInCancelled() {
            assertThrows(BuildException.class, () -> order.setPayingMethod("Bizum"));
        }

        @Test
        void testToStringWorksInCancelled() {
            String output = order.toString();
            assertTrue(output.contains("Order [operationId="));
            assertTrue(output.contains("status=CANCELLED"));
        }

    }

    // ============================
    // TESTS PARA ORDEN EN FORTHCOMMING
    // ============================
    @Nested
    class WhenOrderIsForthcomming {
        @BeforeEach
        void setup() {
            try {
                order = Order.getInstanceOrder(
                        "D123456789", "Calle Luna 45", "Carlos", "Express", "612345678",
                        "OP123456789", "01-01-2024 12:00:00", "10-01-2024 12:00:00", "Info",
                        10.0, 15.0, 5.0, 2.0, "yes",
                        "i:978-1-23-456789-7,q:1,p:10.0,d:0.1;", "CREATED", "Paypal",
                        null, "05-01-2024 12:00:00");
            } catch (BuildException e) {
                fail("No se pudo crear la orden en FORTHCOMMING: " + e.getMessage());
            }
        }

        @Test
        void testStatusIsForthcomming() {
            assertEquals("FORTHCOMMING", order.getStatus());
        }

        @Test
        void testSetDeliveryDateShouldSucceedInForthcomming() throws BuildException {
            assertEquals(0, order.setDeliveryDate("10-01-2024 12:00:00"));
            assertEquals("DELIVERED", order.getStatus());
        }

        @Test
        void testSetFinishDateFailsInForthcomming() {
            assertEquals(-22, order.setFinishDate(LocalDateTime.now()));
        }

        @Test
        void testSetDeliveryIdFailsInForthcomming() {
            assertThrows(BuildException.class, () -> order.setDeliveryId("NUEVO456"));
        }

        @Test
        void testUpdateDetailWorksInForthcomming() throws BuildException {
            String isbn = order.getShopCart().get(0).getIsbn();
            assertEquals(0, order.updateDetail(isbn, 3));
        }

        @Test
        void testDeleteDetailWorksInForthcomming() throws BuildException {
            assertEquals(0, order.deleteDetail(0));
        }

        @Test
        void testSetDeliveryDateSecondCallFails() throws BuildException {
            // Primera llamada funciona
            assertEquals(0, order.setDeliveryDate("10-01-2024 12:00:00"));
            // Segunda llamada debería lanzar excepción porque ya está DELIVERED
            assertThrows(BuildException.class, () -> order.setDeliveryDate("11-01-2024 12:00:00"));
        }

        @Test
        void testSetPayingMethodFailsInForthcomming() {
            assertThrows(BuildException.class, () -> order.setPayingMethod("Tarjeta"));
        }

        @Test
        void testSetDetailFailsInForthcomming() {
            assertThrows(BuildException.class, () -> order.setDetail("978-1-23-000000-0", 1, 5.0, 0.0));
        }

        @Test
        void testSetDeliveryPersonNameFailsInForthcomming() {
            assertThrows(BuildException.class, () -> order.setDeliveryPersonName("Lucía"));
        }

        @Test
        void testSetPhoneNumberFailsInForthcomming() {
            assertThrows(BuildException.class, () -> order.setPhoneNumber("699999999"));
        }

    }

    // =============================
    // TESTS PARA ORDEN EN DELIVERED
    // =============================
    @Nested
    class WhenOrderIsDelivered {
        @BeforeEach
        void setup() {
            try {
                order = Order.getInstanceOrder(
                        "D123456789", "Calle Luna 45", "Carlos", "Express", "612345678",
                        "OP123456789", "01-01-2024 12:00:00", "10-01-2024 12:00:00", "Info",
                        10.0, 15.0, 5.0, 2.0, "yes",
                        "i:978-1-23-456789-7,q:1,p:10.0,d:0.1;", "CREATED", "Paypal",
                        "08-01-2024 12:00:00", "05-01-2024 12:00:00");
            } catch (BuildException e) {
                fail("No se pudo crear la orden: " + e.getMessage());
            }
        }

        @Test
        void testGetStatus() {
            assertEquals("DELIVERED", order.getStatus());
        }

        @Test
        void testGetAncho() {
            assertEquals(10.0, order.getAncho());
        }

        @Test
        void testGetAlto() {
            assertEquals(5.0, order.getAlto());
        }

        @Test
        void testGetLargo() {
            assertEquals(15.0, order.getLargo());
        }

        @Test
        void testGetPeso() {
            assertEquals(2.0, order.getPeso());
        }

        @Test
        void testGetFragil() {
            assertEquals("yes", order.getFragil());
        }

        @Test
        void testGetPhoneNumber() {
            assertTrue(order.getPhoneNumber().contains("612345678"));
        }

        @Test
        void testGetPayingMethod() {
            assertEquals("Paypal", order.getPayingMethod());
        }

        @Test
        void testGetTotalPrice() throws BuildException {
            assertTrue(order.getTotalPrice() > 0);
        }

        @Test
        void testGetShopCart() {
            assertEquals(1, order.getShopCart().size());
        }

        @Test
        void testToStringContainsOrder() {
            assertTrue(order.toString().contains("Order [operationId="));
        }

        @Test
        void testGetShopCartAsCSV() {
            assertTrue(order.getShopCartAsCSV().contains("i:"));
        }

        @Test
        void testGetPaymentDate() {
            assertTrue(order.getPaymentDate().contains("2024"));
        }

        @Test
        void testGetDeliveryDate() {
            assertTrue(order.getDeliveryDate().contains("2024"));
        }

        @Test
        void testGetDeliveryDirection() {
            assertEquals("Calle Luna 45", order.getDeliveryDirection());
        }

        @Test
        void testGetDeliveryId() {
            assertEquals("D123456789", order.getDeliveryId());
        }

        @Test
        void testGetDeliveryPersonName() {
            assertEquals("Carlos", order.getDeliveryPersonName());
        }

        @Test
        void testGetTypeOfDelivery() {
            assertEquals("Express", order.getTypeOfDelivery());
        }

        @Test
        void testGetDetailByIndex() throws BuildException {
            assertTrue(order.getDetail(0).contains("OrderDetail"));
        }

        @Test
        void testGetDetailByIsbn() throws BuildException {
            String isbn = order.getShopCart().get(0).getIsbn();
            assertTrue(order.getDetail(isbn).contains(isbn));
        }

        @Test
        void testUpdateDetailByIsbn() throws BuildException {
            String isbn = order.getShopCart().get(0).getIsbn();
            assertEquals(0, order.updateDetail(isbn, 3));
        }

        @Test
        void testUpdateDetailByIndex() throws BuildException {
            assertEquals(0, order.updateDetail(0, 2));
        }

        @Test
        void testUpdateDetailInvalidIndex() {
            assertThrows(BuildException.class, () -> order.updateDetail(99, 2));
        }

        @Test
        void testDeleteDetailByIndex() throws BuildException {
            assertEquals(0, order.deleteDetail(0));
        }

        @Test
        void testDeleteDetailByIsbn() throws BuildException {
            String isbn = order.getShopCart().get(0).getIsbn();
            assertEquals(0, order.deleteDetail(isbn));
        }

        @Test
        void testSetDeliveryIdShouldFailInDelivered() {
            assertThrows(BuildException.class, () -> order.setDeliveryId("NUEVO123"));
        }

        @Test
        void testSetOrderDateShouldFail() {
            assertEquals(0, order.setOrderDate(LocalDateTime.now()));
        }

        @Test
        void testSetFinishDateShouldWorkInDelivered() {
            assertEquals(0, order.setFinishDate(LocalDateTime.now()));
        }

        @Test
        void testStatusChangesToCompleted() {
            order.setFinishDate(LocalDateTime.now());
            assertEquals("COMPLETED", order.getStatus());
        }

        @Test
        void testGetDimensions() {
            assertEquals(50.0, order.getDimensions());
        }

        @Test
        void testGetVolumen() {
            assertEquals(750.0, order.getVolumen());
        }

        @Test
        void testSetDetailDuplicateISBNThrows() {
            assertThrows(BuildException.class, () -> {
                String isbn = order.getShopCart().get(0).getIsbn();
                order.setDetail(isbn, 1, 10.0, 0.1);
            });
        }

        @Test
        void testClearShopCartByDeletingAll() throws BuildException {
            while (order.getShopCart().size() > 0) {
                order.deleteDetail(0);
            }
            assertEquals(0, order.getShopCart().size());
            assertEquals("", order.getShopCartAsCSV());
        }

        @Test
        void testCancelledOrderFailsInDelivered() {
            assertThrows(BuildException.class, () -> order.cancelledOrder());
        }

        @Test
        void testSetAnchoFailsInDelivered() {
            assertThrows(BuildException.class, () -> order.setAncho(99.9));
        }

        @Test
        void testSetAltoFailsInDelivered() {
            assertThrows(BuildException.class, () -> order.setAlto(7.5));
        }

        @Test
        void testSetLargoFailsInDelivered() {
            assertThrows(BuildException.class, () -> order.setLargo(15.5));
        }

        @Test
        void testSetPesoFailsInDelivered() {
            assertThrows(BuildException.class, () -> order.setPeso(4.0));
        }

        @Test
        void testSetFragilWorksInDelivered() throws BuildException {
            assertEquals(0, order.setFragil("no")); // <- permitido si no es COMPLETED aún
        }

    }

    // ============================
    // TESTS PARA ORDEN EN CONFIRMED
    // ============================

    @Nested
    class WhenOrderIsConfirmed {

        @BeforeEach
        void setup() {
            try {
                order = Order.getInstanceOrder(
                        "D123456789", "Calle Luna 45", "Carlos", "Express", "612345678",
                        "OP123456789", "01-01-2024 12:00:00", "10-01-2024 12:00:00", "Info",
                        10.0, 15.0, 5.0, 2.0, "yes",
                        "i:978-1-23-456789-7,q:1,p:10.0,d:0.1;", "CREATED", "Paypal",
                        "08-01-2024 12:00:00", "05-01-2024 12:00:00");
                order.setOrderDate(LocalDateTime.now()); // pasa a CONFIRMED
            } catch (BuildException e) {
                fail("No se pudo crear ni confirmar la orden: " + e.getMessage());
            }
        }

        @Test
        void testStatusIsConfirmed() {
            assertEquals("CONFIRMED", order.getStatus());
        }

        @Test
        void testSetAnchoInConfirmed() throws BuildException {
            assertEquals(0, order.setAncho(20.0));
            assertEquals(20.0, order.getAncho());
        }

        @Test
        void testSetAltoInConfirmed() throws BuildException {
            assertEquals(0, order.setAlto(7.0));
            assertEquals(7.0, order.getAlto());
        }

        @Test
        void testSetLargoInConfirmed() throws BuildException {
            assertEquals(0, order.setLargo(25.0));
            assertEquals(25.0, order.getLargo());
        }

        @Test
        void testSetPesoInConfirmed() throws BuildException {
            assertEquals(0, order.setPeso(3.5));
            assertEquals(3.5, order.getPeso());
        }

        @Test
        void testSetFragilInConfirmed() throws BuildException {
            assertEquals(0, order.setFragil("no"));
            assertEquals("no", order.getFragil());
        }

        @Test
        void testSetDeliveryDateShouldFailInConfirmed() {
            assertThrows(BuildException.class, () -> order.setDeliveryDate("12-01-2024 12:00:00"));
        }

        @Test
        void testSetFinishDateShouldFailInConfirmed() {
            assertEquals(-22, order.setFinishDate(LocalDateTime.now()));
        }

        @Test
        void testUpdateDetailInConfirmed() throws BuildException {
            String isbn = order.getShopCart().get(0).getIsbn();
            assertEquals(0, order.updateDetail(isbn, 5));
        }

        @Test
        void testDeleteDetailInConfirmed() throws BuildException {
            assertEquals(0, order.deleteDetail(0));
        }

        @Test
        void testSetDeliveryIdFailsInConfirmed() {
            assertThrows(BuildException.class, () -> order.setDeliveryId("NUEVO999"));
        }

        @Test
        void testSetPhoneNumberFailsInConfirmed() {
            assertThrows(BuildException.class, () -> order.setPhoneNumber("600111222"));
        }

        @Test
        void testSetPayingMethodFailsInConfirmed() {
            assertThrows(BuildException.class, () -> order.setPayingMethod("Card"));
        }

        @Test
        void testSetTypeOfDeliveryFailsInConfirmed() {
            assertThrows(BuildException.class, () -> order.setTypeOfDelivery("Standard"));
        }

        @Test
        void testSetDeliveryPersonNameFailsInConfirmed() {
            assertThrows(BuildException.class, () -> order.setDeliveryPersonName("Pepe"));
        }

        @Test
        void testSetDeliveryDirectionFailsInConfirmed() {
            assertThrows(BuildException.class, () -> order.setDeliveryDirection("Calle Nueva"));
        }

        @Test
        void testCancelledOrderFailsInConfirmed() {
            assertThrows(BuildException.class, () -> order.cancelledOrder());
        }

    }

    // ============================
    // TESTS PARA ORDEN EN COMPLETED
    // ============================

    @Nested
    class WhenOrderIsCompleted {
        @BeforeEach
        void setup() {
            try {
                order = Order.getInstanceOrder(
                        "D123456789", "Calle Luna 45", "Carlos", "Express", "612345678",
                        "OP123456789", "01-01-2024 12:00:00", "10-01-2024 12:00:00", "Info",
                        10.0, 15.0, 5.0, 2.0, "yes",
                        "i:978-1-23-456789-7,q:1,p:10.0,d:0.1;", "CREATED", "Paypal",
                        null, // ✅ no deliveryDate todavía
                        "05-01-2024 12:00:00" // ✅ paymentDate
                );

                // ⚠️ Transiciones manuales y ordenadas
                order.setDeliveryDate("08-01-2024 12:00:00"); // pasa a DELIVERED
                order.setFinishDate(LocalDateTime.now()); // pasa a COMPLETED

            } catch (BuildException e) {
                fail("Setup falló: " + e.getMessage());
            }
        }

        @Test
        void testStatusIsCompleted() {
            assertEquals("COMPLETED", order.getStatus());
        }

        @Test
        void testSetFragilThrowsInCompleted() {
            assertThrows(BuildException.class, () -> order.setFragil("no"));
        }

        @Test
        void testUpdateDetailThrowsInCompleted() {
            assertThrows(BuildException.class, () -> order.updateDetail(0, 1));
        }

        @Test
        void testDeleteDetailThrowsInCompleted() {
            assertThrows(BuildException.class, () -> order.deleteDetail(0));
        }

        @Test
        void testCancelledOrderFailsInCompleted() {
            assertThrows(BuildException.class, () -> order.cancelledOrder());
        }

        @Test
        void testSetPayingMethodFailsInCompleted() {
            assertThrows(BuildException.class, () -> order.setPayingMethod("Bizum"));
        }

    }

}
