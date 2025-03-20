package demo.model.persons;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import demo.exceptions.BuildException;
import demo.model.products.PhysicalData;

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

    @Test
    void testGoodNIF(){
        int result = client.setNif("29032619H");
        assertEquals(0, result);
    }

    @Test
    void testBlankNIF(){
        int result = client.setNif("    ");
        assertEquals(-1, result);
    }

    @Test
    void testNullNIF(){
        int result = client.setNif(null);
        assertEquals(-1, result);
    }

    @Test
    void testBadNIF(){
        int result = client.setNif("29391269H");
        assertEquals(-22, result);
    }

    @Test
    void testGoodName(){
        int result = client.setName("David");
        assertEquals(0, result);
    }

    @Test
    void testNullName(){
        int result = client.setName(null);
        assertEquals(-1, result);
    }
}