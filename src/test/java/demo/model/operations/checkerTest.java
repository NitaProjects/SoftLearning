package demo.model.operations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class checkerTest {
    @Test
    void testCheckDNI() {

    }

    @Test
    void testCheckDate2() {

    }

    @Test
    void testCheckDateAndTime() {

    }

    @Test
    void testCheckDifficulty() {

    }

    @Test
    void testCheckStatus() {

    }

    @Test
    void testComparePrices() {

    }

    @Test
    void testIsDateTimeGreaterThanToday() {

    }


    @Test
    void testIsNull() {
        assertEquals(-1, checker.isNull(null), "Debe devolver -1 si el valor es null.");
    }
    @Test 
    void testIsNull2(){
        assertEquals(-1, checker.isNull(" "), "Debe devolver -1 si el valor es un espacio.");
    }

    @Test
    void testIsNull3(){
        assertEquals(0, checker.isNull("Test"), "Debe devolver 0 si el valor no es null.");
    }


    @Test
    void testMaxLenght() {

    }

    @Test
    void testMaxValue() {

    }

    @Test
    void testMaxValue2() {

    }

    @Test
    void testMaxValueCount() {

    }

    @Test
    void testMinLength() {

    }

    @Test
    void testMinValue() {

    }

    @Test
    void testMinValue2() {

    }

    @Test
    void testMinValueCount() {

    }

    @Test
    void testNonNegative() {

    }

    @Test
    void testNonNegative2() {

    }

    @Test
    void testNonZero() {

    }

    @Test
    void testNonZero2() {

    }

    @Test
    void testValidarCorreo() {

    }

    @Test
    void testValidateISBN13() {

    }

    @Test
    void testWhichPaymentMethod() {

    }

    @Test
    void testYesOrNo() {

    }
}
