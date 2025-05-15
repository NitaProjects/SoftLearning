/*  no es necesario usar @BeforeEach ni crear un objeto porque:
Todos los métodos de checker son static, así que se llaman directamente:
checker.metodo(...)*/

package demo.model.operations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import demo.exceptions.BuildException;

public class checkerTest {

    // ********************* NIF *******************************//

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
    void testCheckDNINull() {
        assertEquals(-1, checker.checkDNI(null));
    }

    @Test
    void testCheckDNIBlank() {
        assertEquals(-1, checker.checkDNI("       "));
    }

    @Test
    void testCheckDNILongitudCorto() {
        assertEquals(-23, checker.checkDNI("1234Z"));
    }

    @Test
    void testCheckDNILongitudLargo() {
        assertEquals(-23, checker.checkDNI("123456789Z"));
    }

    @Test
    void testCheckDNICaracteresEspeciales() {
        assertEquals(-23, checker.checkDNI("1234567@Z"));
    }

    // ********************* DATES *******************************//

    @Test
    void testCheckDate2Valid() throws BuildException {
        LocalDate result = checker.checkDate2("15-08-2023");
        assertEquals(LocalDate.of(2023, 8, 15), result);
    }

    @Test
    void testCheckDate2Null() throws BuildException {
        try {
            checker.checkDate2(null);
        } catch (BuildException e) {
            assertEquals("La fecha no puede ser nula", e.getMessage());
        }
    }

    @Test
    void testCheckDate2Blank() throws BuildException {
        try {
            checker.checkDate2("    ");
        } catch (BuildException e) {
            assertEquals("La fecha no puede ser nula", e.getMessage());
        }
    }

    @Test
    void testCheckDate2SeparationsBad() throws BuildException {
        try {
            checker.checkDate2("15/08-2023");
        } catch (BuildException e) {
            assertEquals("La fecha no tiene las separaciones correctas o no sigue el formato", e.getMessage());
        }
    }

    @Test
    void testCheckDate2BadFormat() throws BuildException {
        try {
            checker.checkDate2("15-08-223");
        } catch (BuildException e) {
            assertEquals("La fecha no tiene las separaciones correctas o no sigue el formato", e.getMessage());
        }
    }

    @Test
    void testCheckDate2BadDay() throws BuildException {
        try {
            checker.checkDate2("34-08-2023");
        } catch (BuildException e) {
            assertEquals("El día de la fecha no es válido", e.getMessage());
        }
    }

    @Test
    void testCheckDate2BadMonth() throws BuildException {
        try {
            checker.checkDate2("31-13-2023");
        } catch (BuildException e) {
            assertEquals("El mes de la fecha no es válido", e.getMessage());
        }
    }

    @Test
    void testCheckDate2BadYear() throws BuildException {
        try {
            checker.checkDate2("31-12-4000");
        } catch (BuildException e) {
            assertEquals("El año de la fecha no es válido", e.getMessage());
        }
    }

    @Test
    void testCheckDate2FebraryBad() throws BuildException {
        try {
            checker.checkDate2("31-02-2024");
        } catch (BuildException e) {
            assertEquals("Febrero no puede tener más de 29 días", e.getMessage());
        }
    }

    @Test
    void testCheckDate2June31() throws BuildException {
        try {
            checker.checkDate2("31-06-2024");
        } catch (BuildException e) {
            assertEquals("El día 31 no es válido para el mes especificado", e.getMessage());
        }
    }

    @Test
    void testCheckDateBisiesto() throws BuildException {
        try {
            checker.checkDate2("29-02-2025");
        } catch (BuildException e) {
            assertEquals("El año no es bisiesto, febrero no puede tener 29 días", e.getMessage());
        }
    }

    @Test
    void testCheckDateAndTimeInvalidNullDateTime() throws BuildException {
        try {
            checker.checkDateAndTime(null);
        } catch (BuildException e) {
            assertEquals("La fecha no puede ser nula", e.getMessage());
        }
    }

    @Test
    void testCheckDateAndTimeInvalidEmptyDateTime() throws BuildException {
        try {
            checker.checkDateAndTime("");
        } catch (BuildException e) {
            assertEquals("La fecha no puede ser nula", e.getMessage());
        }
    }

    @Test
    void testCheckDateAndTimeInvalidFormat() throws BuildException {
        try {
            checker.checkDateAndTime("12-05-2025 14:30");
        } catch (BuildException e) {
            assertEquals("La fecha y hora no tienen el formato adecuado", e.getMessage());
        }
    }

    @Test
    void testCheckDateAndTimeInvalidTime() throws BuildException {
        try {
            checker.checkDateAndTime("12-05-2025 25:00:00");
        } catch (BuildException e) {
            assertEquals("La hora no es válida", e.getMessage());
        }
    }

    @Test
    void testCheckDateAndTimeInvalidSecond() throws BuildException {
        try {
            checker.checkDateAndTime("12-05-2025 14:30:60");
        } catch (BuildException e) {
            assertEquals("Los segundos no son válidos", e.getMessage());
        }
    }

    @Test
    void testCheckDateAndTimeInvalidMinute() throws BuildException {
        try {
            checker.checkDateAndTime("12-05-2025 14:99:00");
        } catch (BuildException e) {
            assertEquals("Los minutos no son válidos", e.getMessage());
        }
    }

    @Test
    void testCheckDateAndTimeInvalidDayTooHigh() throws BuildException {
        try {
            checker.checkDateAndTime("32-05-2025 14:30:45");
        } catch (BuildException e) {
            assertEquals("El día de la fecha no es válido", e.getMessage());
        }
    }

    @Test
    void testCheckDateAndTimeInvalidMonthTooHigh() throws BuildException {
        try {
            checker.checkDateAndTime("12-13-2025 14:30:45");
        } catch (BuildException e) {
            assertEquals("El mes de la fecha no es válido", e.getMessage());
        }
    }

    @Test
    void testCheckDateAndTimeInvalidFebruary29() throws BuildException {
        try {
            checker.checkDateAndTime("29-02-2023 14:30:45");
        } catch (BuildException e) {
            assertEquals("El año no es bisiesto, febrero no puede tener 29 días", e.getMessage());
        }
    }

    @Test
    void testCheckDateAndTimeInvalidDayInMonth() throws BuildException {
        try {
            checker.checkDateAndTime("31-04-2025 14:30:45");
        } catch (BuildException e) {
            assertEquals("El día 31 no es válido para el mes especificado", e.getMessage());
        }
    }

    @Test
    void testCheckDateAndTimeValid() throws BuildException {
        LocalDateTime result = checker.checkDateAndTime("15-08-2023 12:30:45");
        assertEquals(LocalDateTime.of(2023, 8, 15, 12, 30, 45), result);
    }

    // ********************* DIFFICULTY *******************************//

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
    void testCheckDifficultyNull() {
        assertEquals(-1, checker.checkDifficulty(null));
    }

    @Test
    void testCheckDifficultyBlank() {
        assertEquals(-1, checker.checkDifficulty("      "));
    }

    // ********************* Status *******************************//

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
    void testCheckStatusNull() {
        assertEquals(-1, checker.checkStatus( null));
    }

    @Test
    void testCheckStatusBlank() {
        assertEquals(-1, checker.checkStatus( "       "));
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
    void testIsDateTimeGreaterThanTodayNull() {
        assertEquals( -1, checker.isDateTimeGreaterThanToday(null));
    }

    @Test
    void testIsDateTimeGreaterThanTodayBlank() {
        assertEquals( -1, checker.isDateTimeGreaterThanToday("          "));
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
    void testIsNullMultipleSpaces() {
        assertEquals(-1, checker.isNull("     "));
    }

    @Test
    void testIsNullNewLines() {
        assertEquals(-1, checker.isNull("\n\n\n"));
    }

    @Test
    void testIsNullTabs() {
        assertEquals(-1, checker.isNull("\t\t\t"));
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
    void testMaxLengthNull() {
        assertEquals(-1, checker.maxLenght(10, null));
    }

    @Test
    void testMaxLengthBlank() {
        assertEquals(-1, checker.maxLenght(1, "     "));
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
    void testMinLengthNull() {
        assertEquals(-1, checker.minLength(5, null));
    }

    @Test
    void testMinLengthBlank() {
        assertEquals(-1, checker.minLength(5, "       "));
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

    // ********************* EMAIL *******************************//

    @Test
    void testValidarCorreoOk() {
        assertEquals(0, checker.validarCorreo("testEmail@example.com"));
    }

    @Test
    void testValidarCorreoInvalid() {
        assertEquals(-22, checker.validarCorreo("testEmail@examplecom"));
    }

    @Test
    void testValidarCorreoBlank() {
        assertEquals(-1, checker.validarCorreo("       "));
    }

    @Test
    void testValidarCorreoNull() {
        assertEquals(-1, checker.validarCorreo(null));
    }

    // ********************* ISBN *******************************//

    @Test
    void testValidateISBN13Valid() {
        assertEquals(0, checker.validateISBN13("978-1-23-456789-7"));
    }

    @Test
    void testValidateISBN13Invalid() {
        assertEquals(-24, checker.validateISBN13("978-1-23-456789-0"));
    }

    @Test
    void testValidateISBN13InvalidFormat() {
        assertEquals(-24, checker.validateISBN13("978-1-23-45678-90"));
    }

    @Test
    void testValidateISBN13InvalidNull() {
        assertEquals(-1, checker.validateISBN13(null));
    }

    @Test
    void testValidateISBN13InvalidEmpty() {
        assertEquals(-1, checker.validateISBN13(""));
    }

    @Test
    void testValidateISBN13InvalidDigits() {
        assertEquals(-24, checker.validateISBN13("978-1-23-45A789-0"));
    }

    @Test
    void testValidateISBN13InvalidPrefix() {
        assertEquals(-24, checker.validateISBN13("988-1-23-456789-0")); // ISBN con un prefijo diferente a '97'
    }

    @Test
    void testValidateISBN13InvalidChecksum() {
        assertEquals(-24, checker.validateISBN13("978-1-23-456789-1"));
    }

    @Test
    void testValidateISBN13InvalidShortLength() {
        assertEquals(-24, checker.validateISBN13("978-1-23-45678-"));
    }

    @Test
    void testValidateISBN13InvalidLongLength() {
        assertEquals(-24, checker.validateISBN13("978-1-23-456789-00"));
    }

    @Test
    void testValidateISBN13InvalidWithSpaces() {
        assertEquals(-24, checker.validateISBN13("978 1 23 45678A 0"));
    }

    @Test
    void testValidateISBN13NoDashes() {
        assertEquals(-24, checker.validateISBN13("9781234567897"));
    }

    @Test
    void testValidateISBN13WrongDashPlacement() {
        assertEquals(-24, checker.validateISBN13("978-1234-5678-97"));
    }

    @Test
    void testValidateISBN13TooLong() {
        assertEquals(-24, checker.validateISBN13("978-1-23-456789-789"));
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
    void testWhichPaymentMethodnull() {
        assertEquals(-1, checker.whichPaymentMethod(null));
    }

    @Test
    void testWhichPaymentMethodBlank() {
        assertEquals(-1, checker.whichPaymentMethod("      "));
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

    @Test
    void testYesOrNoNull() {
        assertEquals(-1, checker.yesOrNo(null));
    }

    @Test
    void testYesOrNoBlank() {
        assertEquals(-6, checker.yesOrNo("     "));
    }
}