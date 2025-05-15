package demo.model.order;

import demo.exceptions.BuildException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderDetailTest {

    @Test
    void testGetInstanceOrderDetailReturnsValidObject() throws BuildException {
        OrderDetail od = OrderDetail.getInstanceOrderDetail("978-1-23-456789-7", 2, 10.0, 0.1);
        assertNotNull(od);
    }

    @Test
    void testGetInstanceOrderDetailCorrectIsbn() throws BuildException {
        OrderDetail od = OrderDetail.getInstanceOrderDetail("978-1-23-456789-7", 2, 10.0, 0.1);
        assertEquals("978-1-23-456789-7", od.getIsbn());
    }

    @Test
    void testGetDetailCostCorrectCalculation() throws BuildException {
        OrderDetail od = OrderDetail.getInstanceOrderDetail("978-1-23-456789-7", 2, 50.0, 0.1);
        assertEquals(90.0, od.getDetailCost());
    }

    @Test
    void testGetDiscountPriceCorrectValue() throws BuildException {
        OrderDetail od = OrderDetail.getInstanceOrderDetail("978-1-23-456789-7", 1, 10.0, 0.2);
        assertEquals(0.2, od.getDiscountPrice());
    }

    @Test
    void testGetIsbnReturnsCorrectValue() throws BuildException {
        OrderDetail od = OrderDetail.getInstanceOrderDetail("978-1-23-456789-7", 1, 10.0, 0.1);
        assertEquals("978-1-23-456789-7", od.getIsbn());
    }

    @Test
    void testGetPriceReturnsCorrectValue() throws BuildException {
        OrderDetail od = OrderDetail.getInstanceOrderDetail("978-1-23-456789-7", 1, 20.0, 0.1);
        assertEquals(20.0, od.getPrice());
    }

    @Test
    void testGetQuantityReturnsCorrectValue() throws BuildException {
        OrderDetail od = OrderDetail.getInstanceOrderDetail("978-1-23-456789-7", 3, 15.0, 0.1);
        assertEquals(3, od.getQuantity());
    }

    @Test
    void testSetDiscountPriceAcceptsValidValue() {
        OrderDetail od = new OrderDetail();
        assertEquals(0, od.setDiscountPrice(0.5));
    }

    @Test
    void testSetDiscountPriceStoresValue() {
        OrderDetail od = new OrderDetail();
        od.setDiscountPrice(0.5);
        assertEquals(0.5, od.getDiscountPrice());
    }

    @Test
    void testSetIsbnAcceptsValidIsbn() {
        OrderDetail od = new OrderDetail();
        assertEquals(0, od.setIsbn("978-1-23-456789-7"));
    }

    @Test
    void testSetIsbnStoresValue() {
        OrderDetail od = new OrderDetail();
        od.setIsbn("978-1-23-456789-7");
        assertEquals("978-1-23-456789-7", od.getIsbn());
    }

    @Test
    void testSetPriceAcceptsValidValue() {
        OrderDetail od = new OrderDetail();
        assertEquals(0, od.setPrice(12.5));
    }

    @Test
    void testSetPriceStoresValue() {
        OrderDetail od = new OrderDetail();
        od.setPrice(12.5);
        assertEquals(12.5, od.getPrice());
    }

    @Test
    void testSetQuantityAcceptsValidValue() {
        OrderDetail od = new OrderDetail();
        assertEquals(0, od.setQuantity(2));
    }

    @Test
    void testSetQuantityStoresValue() {
        OrderDetail od = new OrderDetail();
        od.setQuantity(2);
        assertEquals(2, od.getQuantity());
    }

    @Test
    void testToStringReturnsExpectedFormat() throws BuildException {
        OrderDetail od = OrderDetail.getInstanceOrderDetail("978-1-23-456789-7", 1, 10.0, 0.1);
        String expected = "OrderDetail [isbn=978-1-23-456789-7, quantity=1, price=10.0, discountPrice=0.1]";
        assertEquals(expected, od.toString());
    }
}
