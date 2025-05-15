package demo.model.persons;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import demo.exceptions.BuildException;


public class ClientTest {
   private Client client;

   @BeforeEach
   void createClient(){
    try{
        this.client = Client.getInstantClient("87967494S", "Ash", "ashgraunuriacefp@gmail.com", "Carrer Valencia 20", 650285637, "24738724983292", 
        "08016", "Barcelona");
    }catch(BuildException ex){
        ex.getMessage();
    }
   } 


    /*** CLIENT ***/

    @Test
    void testValidCardNum() {
        int result = client.setCardNum("24738724983292");
        assertEquals(0, result); 
    }

    @Test
    void testShortCardNum() {
        int result = client.setCardNum("1234");
        assertEquals(-2, result);
    }

    @Test
    void testNullCardNum() {
        int result = client.setCardNum(null);
        assertEquals(-1, result);
    }

    @Test
    void testBlankCardNum() {
        int result = client.setCardNum("       ");
        assertEquals(-1, result);
    }


    @Test
    void testLongCardNum() {
        int result = client.setCardNum("12345678901234567890");
        assertEquals(-10, result); 
    }

    @Test
    void testValidPopulation() {
        int result = client.setPopulation("Barcelona");
        assertEquals(0, result);
    }

    @Test
    void testShortPopulation() {
        int result = client.setPopulation("BN");
        assertEquals(-2, result);
    }

    @Test
    void testNullPopulation() {
        int result = client.setPopulation(null);
        assertEquals(-1, result);
    }

    @Test
    void testBlankPopulation() {
        int result = client.setPopulation("        ");
        assertEquals(-1, result);
    }

    @Test
    void testLongPopulation() {
        int result = client.setPopulation("TEXTOLARGOPARAQUESUPERELOSCARACTERESPERMITIDOS");
        assertEquals(-10, result);
    }

    @Test
    void testValidZipCode() {
        int result = client.setZipCode("08016");
        assertEquals(0, result);
    }

    @Test
    void testLongZipCode() {
        int result = client.setZipCode("12345678");
        assertEquals(-10, result); 
    }

    @Test
    void testBlankZipCode() {
        int result = client.setZipCode("          ");
        assertEquals(-1, result); 
    }
    

    @Test
    void testNullZipCode() {
        int result = client.setZipCode(null);
        assertEquals(-1, result); 
    }

    @Test
    void testShortZipCode() {
        int result = client.setZipCode("2");
        assertEquals(-2, result); 
    }

    @Test
    void testGetCardNum() {
        String cardNum = client.getCardNum();
        assertEquals("24738724983292", cardNum);
    }

    @Test
    void testGetZipCode() {
        String zipCode = client.getZipCode();
        assertEquals("08016", zipCode);
    }

    @Test
    void testGetPopulation() {
        String population = client.getPopulation();
        assertEquals("Barcelona", population);
    }

    @Test 
    void testToString(){
        assertNotNull(client.toString());
    }


    @Test
    void testGetContact() {
        String contact = client.getContact();
        String expectedContact = "El contacto de este cliente es: 650285637 y su nombre es: Ash con su email: ashgraunuriacefp@gmail.com y dirección: Carrer Valencia 20";
        assertEquals(expectedContact, contact);
    }

    @Test
    void testGetInstanceAllGood() {
        try {
            this.client = Client.getInstantClient("87967494S", "Ash", "ashgraunuriacefp@gmail.com", "Carrer Valencia 20", 650285637, "24738724983292", 
            "08016", "Barcelona");
        } catch (Exception e) {
            assertEquals("", e.getMessage());
        }

    }

    @Test
    void testGetInstanceNifBad() {
        try {
            this.client = Client.getInstantClient(null, "Ash", "ashgraunuriacefp@gmail.com", "Carrer Valencia 20", 650285637, "24738724983292", 
            "08016", "Barcelona");
        } catch (Exception e) {
            assertEquals("This NIF is not possible, ", e.getMessage());
        }

    }

    @Test
    void testGetInstanceNameBad() {
        try {
            this.client = Client.getInstantClient("87967494S", null, "ashgraunuriacefp@gmail.com", "Carrer Valencia 20", 650285637, "24738724983292", 
            "08016", "Barcelona");
        } catch (Exception e) {
            assertEquals("This name is not possible, ", e.getMessage());
        }

    }

    @Test
    void testGetInstanceEmailBad() {
        try {
            this.client = Client.getInstantClient("87967494S", "Ash", null, "Carrer Valencia 20", 
                                                650285637, "24738724983292", "08016", "Barcelona");
        } catch (Exception e) {
            assertEquals("This email is not possible, ", e.getMessage());
        }
    }

    @Test
    void testGetInstanceDirectionBad() {
        try {
            this.client = Client.getInstantClient("87967494S", "Ash", "ashgraunuriacefp@gmail.com", 
                                                null, 650285637, "24738724983292", "08016", "Barcelona");
        } catch (Exception e) {
            assertEquals("This direction is not possible, ", e.getMessage());
        }
    }

    @Test
    void testGetInstancePhoneNumberBad() {
        try {
            this.client = Client.getInstantClient("87967494S", "Ash", "ashgraunuriacefp@gmail.com", 
                                                "Carrer Valencia 20", 0, "24738724983292", 
                                                "08016", "Barcelona");
        } catch (Exception e) {
            assertEquals("This phone number is not possible, ", e.getMessage());
        }
    }

    @Test
    void testGetInstanceCardNumBad() {
        try {
            this.client = Client.getInstantClient("87967494S", "Ash", "ashgraunuriacefp@gmail.com", 
                                                "Carrer Valencia 20", 650285637, null, "08016", "Barcelona");
        } catch (Exception e) {
            assertEquals("This card number is not possible, ", e.getMessage());
        }
    }

    @Test
    void testGetInstanceZipCodeBad() {
        try {
            this.client = Client.getInstantClient("87967494S", "Ash", "ashgraunuriacefp@gmail.com", 
                                                "Carrer Valencia 20", 650285637, "24738724983292", 
                                                null, "Barcelona");
        } catch (Exception e) {
            assertEquals("This zip code is not possible, ", e.getMessage());
        }
    }

    @Test
    void testGetInstancePopulationBad() {
        try {
            this.client = Client.getInstantClient("87967494S", "Ash", "ashgraunuriacefp@gmail.com", 
                                                "Carrer Valencia 20", 650285637, "24738724983292", 
                                                "08016", null);
        } catch (Exception e) {
            assertEquals("This population is not possible, ", e.getMessage());
        }
    }

    @Test
    void testGetInstanceAllBad() {
        try {
            this.client = Client.getInstantClient(null, null, null, null, 0, null, null, null);
        } catch (Exception e) {
            assertEquals("This NIF is not possible, This name is not possible, This email is not possible, " +
                        "This direction is not possible, This phone number is not possible, " +
                        "This card number is not possible, This zip code is not possible, " +
                        "This population is not possible, ", e.getMessage());
        }
    }








}