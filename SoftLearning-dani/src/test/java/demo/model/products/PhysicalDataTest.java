package demo.model.products;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demo.exceptions.BuildException;

public class PhysicalDataTest {

    private PhysicalData physicalData;

    @BeforeEach
    void createAPhysicalData() {
        try {
            this.physicalData = PhysicalData.getInstancePhysicalData(10.0, 20.0, 5.0, 0.8, "yes");
        } catch (BuildException ex) {
            ex.getMessage();
        }

    }

    @Test
    void testSetAltoZero() {
        int result = physicalData.setAlto(0.0);
        assertEquals(-3, result);
    }

    @Test
    void testSetAltoNegative() {
        int result = physicalData.setAlto(-1.0);
        assertEquals(-4, result);
    }

    @Test
    void testSetAltoTooLarge() {
        int result = physicalData.setAlto(50.0);
        assertEquals(-5, result);

    }

    @Test
    void testSetAltoOkay() {
        int result = physicalData.setAlto(13.0);
        assertEquals(0, result);
    }

    @Test
    void testSetAltoTooLow() {
        int result = physicalData.setAlto(2.0);
        assertEquals(-6, result);
    }

    @Test
    void testSetAnchoZero() {
        int result = physicalData.setAncho(0.0);
        assertEquals(-3, result);
    }

    @Test
    void testSetAnchoNegative() {
        int result = physicalData.setAncho(-1.0);
        assertEquals(-4, result);
    }

    @Test
    void testSetAnchoTooLarge() {
        int result = physicalData.setAncho(75.0);
        assertEquals(-5, result);
    }

    @Test
    void testSetAnchoTooLow() {
        int result = physicalData.setAncho(4.0);
        assertEquals(-6, result);
    } 

    @Test
    void testSetLargoZero() {
        int result = physicalData.setLargo(0.0);
        assertEquals(-3, result);
    }

    @Test
    void testSetLargoNegative() {
        int result = physicalData.setLargo(-1.0);
        assertEquals(-4, result);
    }

    @Test
    void testSetLargoTooLarge() {
        int result = physicalData.setLargo(120.0);
        assertEquals(-5, result);
    }

    @Test
    void testSetPesoZero() {
        int result = physicalData.setPeso(0.0);
        assertEquals(-3, result);
    }

    @Test
    void testSetLargoTooLow() {
        int result = physicalData.setLargo(9.0);
        assertEquals(-6, result);
    }

    @Test
    void testSetPesoNegative() {
        int result = physicalData.setPeso(-1.0);
        assertEquals(-4, result);
    }

    @Test
    void testSetPesoTooHeavy() {
        int result = physicalData.setPeso(25.0);
        assertEquals(-5, result);
    }

    @Test
    void testSetFragilNull() {
        int result = physicalData.setFragil(null);
        assertEquals(-1, result);
    }

    @Test
    void testSetPesoTooLow() {
        int result = physicalData.setPeso(0.3);
        assertEquals(-6, result);
    }

    @Test
    void testSetFragilBlanc() {
        int result = physicalData.setFragil("     ");
        assertEquals(-1, result);
    }

    @Test
    void testSetFragilPatata() {
        int result = physicalData.setFragil("patata");
        assertEquals(-8, result);
    }

    @Test
    void testGetAlto() {
        physicalData.setAlto(10.0);
        assertEquals(10.0, physicalData.getAlto());
    }

    @Test
    void testGetAncho() {
        physicalData.setAncho(15.0);
        assertEquals(15.0, physicalData.getAncho());
    }

    @Test
    void testGetLargo() {
        physicalData.setLargo(20.0);
        assertEquals(20.0, physicalData.getLargo());
    }

    @Test
    void testGetPeso() {
        physicalData.setPeso(5.0);
        assertEquals(5.0, physicalData.getPeso());
    }

    @Test
    void testGetFragil() {
        physicalData.setFragil("yes");
        assertEquals("yes", physicalData.getFragil());
    }

    @Test
    void testGetDimensions() {
        physicalData.setAlto(10.0);
        physicalData.setAncho(20.0);
        double expectedDimensions = 10.0 * 20.0;
        assertEquals(expectedDimensions, physicalData.getDimensions());
    }

    @Test
    void testGetVolumen() {
        physicalData.setAlto(5.0);
        physicalData.setAncho(10.0);
        physicalData.setLargo(20.0);
        double expectedVolumen = 5.0 * 10.0 * 20.0;
        assertEquals(expectedVolumen, physicalData.getVolumen());
    }


    @Test
    void testGetInstanceCorrect() {
        try {
            PhysicalData physicalData = PhysicalData.getInstancePhysicalData(10.0, 20.0, 5.0, 0.8, "yes");
            assertNotNull(physicalData);
        } catch (BuildException ex) {
            fail("No debería lanzar excepción con datos válidos");
        }
    }

    @Test
    void testGetInstanceAnchoBad() {
        try {
            PhysicalData.getInstancePhysicalData(0.0, 20.0, 5.0, 0.8, "yes");
            fail("Debía lanzar excepción por ancho inválido");
        } catch (BuildException ex) {
            assertEquals("This wide is not possible, ", ex.getMessage());
        }
    }

    @Test
    void testGetInstanceLargoBad() {
        try {
            PhysicalData.getInstancePhysicalData(10.0, 0.0, 5.0, 0.8, "yes");
            fail("Debía lanzar excepción por largo inválido");
        } catch (BuildException ex) {
            assertEquals("This large is not possible, ", ex.getMessage());
        }
    }
//ignorar
    @Test
    void testGetInstanceAltoBad() {
        try {
            PhysicalData.getInstancePhysicalData(10.0, 20.0, 0.0, 0.8, "yes");
            fail("Debía lanzar excepción por alto inválido");
        } catch (BuildException ex) {
            assertEquals("This high is not possible, ", ex.getMessage()); 
        }
    }

    @Test
    void testGetInstancePesoBad() {
        try {
            PhysicalData.getInstancePhysicalData(10.0, 20.0, 5.0, 0.0, "yes");
            fail("Debía lanzar excepción por peso inválido");
        } catch (BuildException ex) {
            assertEquals("This weight is not possible, ", ex.getMessage());
        }
    }

    @Test
    void testGetInstanceFragilBad() {
        try {
            PhysicalData.getInstancePhysicalData(10.0, 20.0, 5.0, 0.8, "patata");
            fail("Debía lanzar excepción por fragilidad inválida");
        } catch (BuildException ex) {
            assertEquals("This fragil is not possible, ", ex.getMessage());
        }
    }

    @Test
    void testGetInstanceAllBad() {
        try {
            PhysicalData.getInstancePhysicalData(0.0, 0.0, 0.0, 0.0, "patata");
            fail("Debía lanzar excepción por múltiples errores");
        } catch (BuildException ex) {
            assertEquals(
                    "This wide is not possible, This large is not possible, This high is not possible, This weight is not possible, This fragil is not possible, ",
                    ex.getMessage());
        }
    }

}
