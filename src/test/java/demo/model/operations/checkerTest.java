/*  no es necesario usar @BeforeEach ni crear un objeto porque:
Todos los métodos de checker son static, así que se llaman directamente:
checker.metodo(...)*/

package demo.model.operations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import demo.exceptions.BuildException;

public class checkerTest {

    @Test
    void testCheckDNIValid() {
        assertEquals(0, checker.checkDNI("12345678Z"));
    }

    @Test
    void testCheckDNILetraIncorrecta() {
        assertEquals(-23, checker.checkDNI("12345678X"));
    }

    @Test
    void testCheckDNINoNumeros() {
        assertEquals(-23, checker.checkDNI("ABCDEFGHZ"));
    }

    @Test
    void testCheckDate2Valid() throws BuildException {
        LocalDate result = checker.checkDate2("15-08-2023");
        assertEquals(LocalDate.of(2023, 8, 15), result);
    }

    @Test
    void testCheckDateAndTimeValid() throws BuildException {
        LocalDateTime result = checker.checkDateAndTime("15-08-2023 12:30:45");
        assertEquals(LocalDateTime.of(2023, 8, 15, 12, 30, 45), result);
    }

    @Test
    void testCheckDifficultyEasy() {
        assertEquals(0, checker.checkDifficulty("easy"));
    }

    @Test
    void testCheckDifficultyMedium() {
        assertEquals(0, checker.checkDifficulty("medium"));
    }

    @Test
    void testCheckDifficultyHard() {
        assertEquals(0, checker.checkDifficulty("hard"));
    }

    @Test
    void testCheckDifficultyInvalid() {
        assertEquals(-8, checker.checkDifficulty("extreme"));
    }

    @Test
    void testCheckStatusCancelled() {
        assertEquals(0, checker.checkStatus("cancelled"));
    }

    @Test
    void testCheckStatusCompleted() {
        assertEquals(0, checker.checkStatus("completed"));
    }

    @Test
    void testCheckStatusInvalid() {
        assertEquals(-16, checker.checkStatus("unknown"));
    }

    @Test
    void testComparePricesCorrect() {
        assertEquals(0, checker.comparePrices(100.0, 20.0));
    }

    @Test
    void testComparePricesInvalid() {
        assertEquals(-15, checker.comparePrices(50.0, 100.0));
    }

    @Test
    void testIsDateTimeGreaterThanTodayPast() {
        assertEquals(-9, checker.isDateTimeGreaterThanToday("2023-01-01 00:00:00"));
    }

    @Test
    void testIsDateTimeGreaterThanTodayFuture() {
        assertEquals(0, checker.isDateTimeGreaterThanToday("2123-01-01 00:00:00"));
    }

    @Test
    void testIsNullNull() {
        assertEquals(-1, checker.isNull(null));
    }

    @Test 
    void testIsNullBlank() {
        assertEquals(-1, checker.isNull(" "));
    }

    @Test
    void testIsNullValid() {
        assertEquals(0, checker.isNull("Test"));
    }

    @Test
    void testMaxLengthExceeds() {
        assertEquals(-10, checker.maxLenght(3, "hello"));
    }

    @Test
    void testMaxLengthOk() {
        assertEquals(0, checker.maxLenght(10, "text"));
    }

    @Test
    void testMaxValueIntExceeded() {
        assertEquals(-5, checker.maxValue(10, 5));
    }

    @Test
    void testMaxValueIntOk() {
        assertEquals(0, checker.maxValue(3, 10));
    }

    @Test
    void testMaxValueDoubleExceeded() {
        assertEquals(-5, checker.maxValue(10.5, 10.0));
    }

    @Test
    void testMaxValueDoubleOk() {
        assertEquals(0, checker.maxValue(9.9, 10.0));
    }

    @Test
    void testMaxValueCountExceeded() {
        assertEquals(-12, checker.maxValueCount(123456, 3));
    }

    @Test
    void testMaxValueCountOk() {
        assertEquals(0, checker.maxValueCount(123, 5));
    }

    @Test
    void testMinLengthShort() {
        assertEquals(-2, checker.minLength(5, "abc"));
    }

    @Test
    void testMinLengthOk() {
        assertEquals(0, checker.minLength(2, "abcd"));
    }

    @Test
    void testMinValueIntLow() {
        assertEquals(-7, checker.minValue(3, 5));
    }

    @Test
    void testMinValueIntOk() {
        assertEquals(0, checker.minValue(6, 5));
    }

    @Test
    void testMinValueDoubleLow() {
        assertEquals(-7, checker.minValue(3.5, 5.0));
    }

    @Test
    void testMinValueDoubleOk() {
        assertEquals(0, checker.minValue(6.1, 5.0));
    }

    @Test
    void testMinValueCountShort() {
        assertEquals(-11, checker.minValueCount(123, 5));
    }

    @Test
    void testMinValueCountOk() {
        assertEquals(0, checker.minValueCount(12345, 5));
    }

    @Test
    void testNonNegativeIntNegative() {
        assertEquals(-4, checker.nonNegative(-1));
    }

    @Test
    void testNonNegativeIntOk() {
        assertEquals(0, checker.nonNegative(0));
    }

    @Test
    void testNonNegativeDoubleNegative() {
        assertEquals(-4, checker.nonNegative(-2.0));
    }

    @Test
    void testNonNegativeDoubleOk() {
        assertEquals(0, checker.nonNegative(2.5));
    }

    @Test
    void testNonZeroIntZero() {
        assertEquals(-3, checker.nonZero(0));
    }

    @Test
    void testNonZeroIntOk() {
        assertEquals(0, checker.nonZero(10));
    }

    @Test
    void testNonZeroDoubleZero() {
        assertEquals(-3, checker.nonZero(0.0));
    }

    @Test
    void testNonZeroDoubleOk() {
        assertEquals(0, checker.nonZero(10.0));
    }

    @Test
    void testValidarCorreoOk() {
        assertEquals(0, checker.validarCorreo("testEmail@example.com"));
    }

    @Test
    void testValidarCorreoInvalid() {
        assertEquals(-22, checker.validarCorreo("invalid-email"));
    }

    @Test
    void testValidateISBN13Valid() {
        assertEquals(0, checker.validateISBN13("978-1-23-456789-7"));
    }

    @Test
    void testValidateISBN13Invalid() {
        assertEquals(-24, checker.validateISBN13("978-1-23-456789-0"));
    }

    @Test
    void testWhichPaymentMethodPaypal() {
        assertEquals(0, checker.whichPaymentMethod("Paypal"));
    }

    @Test
    void testWhichPaymentMethodInvalid() {
        assertEquals(-17, checker.whichPaymentMethod("Cash"));
    }

    @Test
    void testYesOrNoYes() {
        assertEquals(0, checker.yesOrNo("yes"));
    }

    @Test
    void testYesOrNoNo() {
        assertEquals(0, checker.yesOrNo("no"));
    }

    @Test
    void testYesOrNoInvalid() {
        assertEquals(-6, checker.yesOrNo("maybe"));
    }
}
