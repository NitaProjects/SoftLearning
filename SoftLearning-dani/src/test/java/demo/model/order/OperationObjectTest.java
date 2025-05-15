package demo.model.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demo.exceptions.BuildException;

public class OperationObjectTest extends Operation {

    private OperationObject operation;

    @BeforeEach
    void setup() {
        try{
            operation = OperationObject.getInstance( "D123456789", null, null, "Info");
        } catch (BuildException ex){
            fail("No deberia esta aqui" + ex.getMessage());
        }
    }

    @Test
    void testSetFechaDeDisponibilidadValid() {
        int result = operation.setFinishDateFromString("15-04-2023 00:00:00");
        assertEquals(0, result);
    }

    @Test
    void testSetFechaDeDisponibilidadInvalid() {
        int result = operation.setFinishDateFromString("31-02-2025");
        assertEquals(-21, result);
    }

    @Test
    void testSetFechaDeDisponibilidadNull() {
        int result = operation.setFinishDateFromString(null);
        assertEquals(-21, result);
    }

    @Test
    void testSetFechaDeDisponibilidadBlank() {
        int result = operation.setFinishDateFromString("   ");
        assertEquals(-21, result);
    }

    


}
