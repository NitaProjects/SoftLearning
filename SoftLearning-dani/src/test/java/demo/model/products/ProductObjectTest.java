package demo.model.products;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demo.exceptions.BuildException;

public class ProductObjectTest {

    private ProductObject product;

    @BeforeEach
    void setUp() {
        try {
            this.product = ProductObject.getInstance(10.00, "Clean code", "Este libro trata sobre como optimizar tu codigo en java");
        } catch (BuildException ex) {
            ex.getMessage();
        }
    }

    @Test
    void testSetPriceOkay() {
        int result = product.setPrice(13.0);
        assertEquals(0, result);
    }

    @Test
    void testSetPriceTooLow() {
        int result = product.setPrice(0.5);
        assertEquals(-6, result);
    }

    @Test
    void testSetPriceZero() {
        int result = product.setPrice(0.0);
        assertEquals(-3, result);
    }

    @Test
    void testSetPriceNegative() {
        int result = product.setPrice(-1.0);
        assertEquals(-4, result);
    }

    @Test
    void testSetNameNull() {
        int result = product.setName(null);
        assertEquals(-1, result);
    }

    @Test
    void testSetNameTooShort() {
        int result = product.setName("Java");
        assertEquals(-2, result);
    }

    @Test
    void testSetNameBlank() {
        int result = product.setName("   ");
        assertEquals(-1, result);
    }

    @Test
    void testSetNameTooLong() {
        String longName = "a".repeat(201);
        int result = product.setName(longName);
        assertEquals(-10, result);
    }

    @Test
    void testSetNameValid() {
        int result = product.setName("Effective Java");
        assertEquals(0, result);
    }

    @Test
    void testSetTematicNull() {
        int result = product.setTematic(null);
        assertEquals(-1, result);
    }

    @Test
    void testSetTematicTooShort() {
        int result = product.setTematic("Muy corto");
        assertEquals(-2, result);
    }

    @Test
    void testSetTematicBlank() {
        int result = product.setTematic("   ");
        assertEquals(-1, result);
    }

    @Test
    void testSetTematicTooLong() {
        String longTematic = "a".repeat(501);
        int result = product.setTematic(longTematic);
        assertEquals(-10, result);
    }

    @Test
    void testSetTematicValid() {
        int result = product.setTematic("Este libro trata sobre patrones de diseño en software moderno.");
        assertEquals(0, result);
    }

     @Test
     void testGetPrice() {
         assertEquals(10.00, product.getPrice());
     }
 
     @Test
     void testGetName() {
         assertEquals("Clean code", product.getName());
     }
 
     @Test
     void testGetTematic() {
         assertEquals("Este libro trata sobre como optimizar tu codigo en java", product.getTematic());
     }

     @Test
    void testGetDetails() {
        String expected = "Este product cuesta 10.0. Este producto se titula/tiene por nombre Clean code y su tematica es Este libro trata sobre como optimizar tu codigo en java";
        String actual = product.getDetails();
        assertEquals(expected, actual);
    }

    @Test
    void testGetInstanceCorrect() {
        try {
            this.product = ProductObject.getInstance(25.00, "Clean Code", "Este libro trata sobre buenas prácticas en programación.");
        } catch (BuildException e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }

    @Test
    void testGetInstancePriceZero() {
        try {
            this.product = ProductObject.getInstance(0.0, "Clean Code", "Este libro trata sobre buenas prácticas en programación.");
        } catch (BuildException e) {
            assertEquals("This price is not possible, ", e.getMessage());
        }
    }

    @Test
    void testGetInstanceNameNull() {
        try {
            this.product = ProductObject.getInstance(25.00, null, "Este libro trata sobre buenas prácticas en programación.");
        } catch (BuildException e) {
            assertEquals("This name is not possible, ", e.getMessage());
        }
    }

    @Test
    void testGetInstanceTematicNull() {
        try {
            this.product = ProductObject.getInstance(25.00, "Clean Code", null);
        } catch (BuildException e) {
            assertEquals("This tematic is not possible, ", e.getMessage());
        }
    }

    @Test
    void testGetInstanceAllBad() {
        try {
            this.product = ProductObject.getInstance(0.0, null, null);
        } catch (BuildException e) {
            assertEquals("This price is not possible, This name is not possible, This tematic is not possible, ", e.getMessage());
        }
    }
}