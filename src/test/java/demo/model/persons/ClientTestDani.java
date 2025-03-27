package demo.model.persons;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import demo.exceptions.BuildException;

public class ClientTestDani {

    private Client client;

    @BeforeEach
    void setup() {
        try {
            this.client = Client.getInstantClient(
                "87967494S", "Ash", "ashgraunuriacefp@gmail.com", 
                "Carrer Valencia 20", 650285637, "24738724983292", 
                "08016", "Barcelona"
            );
        } catch (BuildException ex) {
            fail("Error al crear el cliente en setup()");
        }
    }

    /** ==========================
     *   Tests de Client
     *  ==========================
     */
    
    @Test
    void testGetCardNum() {
        assertEquals("24738724983292", client.getCardNum());
    }

    @Test
    void testSetCardNum() {
        client.setCardNum("12345678901234");
        assertEquals("12345678901234", client.getCardNum());
    }

    @Test
    void testGetContact() {
        String expected = "El contacto de este cliente es: 650285637 y su nombre es: Ash con su email: ashgraunuriacefp@gmail.com y dirección: Carrer Valencia 20";
        assertEquals(expected, client.getContact());
    }
    
    @Test
    void testGetZipCode() {
        assertEquals("08016", client.getZipCode());
    }

    @Test
    void testSetZipCode() {
        client.setZipCode("12345");
        assertEquals("12345", client.getZipCode());
    }

    @Test
    void testGetPopulation() {
        assertEquals("Barcelona", client.getPopulation());
    }

    @Test
    void testSetPopulation() {
        client.setPopulation("Madrid");
        assertEquals("Madrid", client.getPopulation());
    }

    @Test
    void testToString() {
        assertNotNull(client.toString());
    }

    /** ==========================
     *   Tests de Person
     *  ==========================
     */

    @Test
    void testGetData() {
        assertNotNull(client.getData());
    }

    @Test
    void testGetDirection() {
        assertEquals("Carrer Valencia 20", client.getDirection());
    }

    @Test
    void testSetDirection() {
        client.setDirection("Gran Via 100");
        assertEquals("Gran Via 100", client.getDirection());
    }

    @Test
    void testGetEmail() {
        assertEquals("ashgraunuriacefp@gmail.com", client.getEmail());
    }

    @Test
    void testSetEmail() {
        client.setEmail("nuevoemail@example.com");
        assertEquals("nuevoemail@example.com", client.getEmail());
    }

    @Test
    void testGetName() {
        assertEquals("Ash", client.getName());
    }

    @Test
    void testSetName() {
        client.setName("Red");
        assertEquals("Red", client.getName());
    }

    @Test
    void testGetNif() {
        assertEquals("87967494S", client.getNif());
    }

    @Test
    void testSetNif() {
        client.setNif("29032619H");
        assertEquals("29032619H", client.getNif());
    }

    @Test
    void testGetPhoneNumber() {
        assertEquals(650285637, client.getPhoneNumber());
    }

    @Test
    void testSetPhoneNumber() {
        client.setPhoneNumber(123456789);
        assertEquals(123456789, client.getPhoneNumber());
    }
}
