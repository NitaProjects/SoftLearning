package demo.model.persons;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demo.exceptions.BuildException;

public class PersonObjectTest {

    private PersonObject person;

    @BeforeEach
   void createClient(){
    try{
        this.person = PersonObject.getInstant("87967494S", "Ash", "ashgraunuriacefp@gmail.com", "Carrer Valencia 20", 650285637);
    }catch(BuildException ex){
        ex.getMessage();
    }
   } 


    /*** PERSON ***/

    @Test
    void testGoodNIF(){
        int result = person.setNif("29032619H");
        assertEquals(0, result);
    }

    @Test
    void testBlankNIF(){
        int result = person.setNif("    ");
        assertEquals(-1, result);
    }

    @Test
    void testNullNIF(){
        int result = person.setNif(null);
        assertEquals(-1, result);
    }

    @Test
    void testBadNIF(){
        int result = person.setNif("29391269H");
        assertEquals(-22, result);
    }

    @Test
    void testInvalidNIFFormat() {
        int result = person.setNif("29032619"); 
        assertEquals(-22, result);
    }


    @Test
    void testGoodName(){
        int result = person.setName("Dani");
        assertEquals(0, result);
    }

    @Test
    void testNullName(){
        int result = person.setName(null);
        assertEquals(-1, result);
    }

    @Test
    void testShortName(){
        int result = person.setName("A");
        assertEquals(-2, result);
    }

    @Test
    void testLongName(){
        int result = person.setName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        assertEquals(-10, result);
    }

    @Test
    void testBlankName(){
        int result = person.setName("   ");
        assertEquals(-1, result);
    }

    @Test
    void testGoodMail(){
        int result = person.setEmail("ashgraunuriacefp@gmail.com");
        assertEquals(0, result);
    }

    @Test
    void testInvalidMail(){
        int result = person.setEmail("ashgraunuriacefpmail.com");
        assertEquals(-22, result);
    }

    @Test
    void testGoodDirection(){
        int result = person.setDirection("Carrer Valencia 20");
        assertEquals(0, result);
    }

    @Test
    void testNullDirection(){
        int result = person.setDirection(null);
        assertEquals(-1, result);
    }

    @Test
    void testBlankDirection(){
        int result = person.setDirection("     ");
        assertEquals(-1, result);
    }

    @Test
    void testShortDirection(){
        int result = person.setDirection("A");
        assertEquals(-2, result);
    }

    @Test
    void testLongDirection(){
        int result = person.setDirection("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSSSSSHHHHHHHHHHHHHHHHHHH");
        assertEquals(-10, result);
    }

    @Test
    void testGoodPhone(){
        int result = person.setPhoneNumber(650285637);
        assertEquals(0, result);
    }

    @Test
    void testZeroPhone(){
        int result = person.setPhoneNumber(0);
        assertEquals(-3, result);
    }

    @Test
    void testNegativePhone(){
        int result = person.setPhoneNumber(-65028563);
        assertEquals(-4, result);
    }

    @Test
    void testShortPhone(){
        int result = person.setPhoneNumber(732);
        assertEquals(-6, result);
    }


    @Test
    void testGetPhoneNumber() {
        int phoneNumber = person.getPhoneNumber();
        assertEquals(650285637, phoneNumber);
    }


    @Test
    void testGetNif() {
        String nif = person.getNif();
        assertEquals("87967494S", nif); 
    }

    @Test
    void testGetName() {
        String name = person.getName();
        assertEquals("Ash", name); 
    }

    @Test
    void testGetEmail() {
        String email = person.getEmail();
        assertEquals("ashgraunuriacefp@gmail.com", email);
    }

    @Test
    void testGetDirection() {
        String direction = person.getDirection();
        assertEquals("Carrer Valencia 20", direction);
    }

    @Test
void testGetInstanceCorrect() {
    try {
        this.person = PersonObject.getInstant(
            "87967494S",
            "Ash",
            "ashgraunuriacefp@gmail.com",
            "Carrer Valencia 20",
            650285637
        );
        assertNotNull(person);
    } catch (Exception e) {
        fail("No se esperaba excepción: " + e.getMessage());
    }
}


    @Test
    void testGetInstanceNifBad() {
        try {
            this.person = PersonObject.getInstant(null, "Ash", "ashgraunuriacefp@gmail.com", "Carrer Valencia 20", 650285637);
        } catch (Exception e) {
            assertEquals("This NIF is not possible, ", e.getMessage());
        }
    }

    @Test
    void testGetInstanceNameBad() {
        try {
            this.person = PersonObject.getInstant("87967494S", null, "ashgraunuriacefp@gmail.com", "Carrer Valencia 20", 650285637);
        } catch (Exception e) {
            assertEquals("This name is not possible, ", e.getMessage());
        }

    }

    @Test
    void testGetInstanceEmailBad() {
        try {
            this.person = PersonObject.getInstant("87967494S", "Ash", null, "Carrer Valencia 20", 650285637);
        } catch (Exception e) {
            assertEquals("This email is not possible, ", e.getMessage());
        }

    }

    @Test
    void testGetInstanceDirectionBad() {
        try {
            this.person = PersonObject.getInstant("87967494S", "Ash", "ashgraunuriacefp@gmail.com", null, 650285637);
        } catch (Exception e) {
            assertEquals("This direction is not possible, ", e.getMessage());
        }

    }

    @Test
    void testGetInstancePhoneBad() {
        try {
            this.person = PersonObject.getInstant("87967494S", "Ash", "ashgraunuriacefp@gmail.com", "Carrer Valencia 20", 0);
        } catch (Exception e) {
            assertEquals("This phone number is not possible, ", e.getMessage());
        }

    }
    @Test
    void testGetInstanceAllBad() {
        try {
            this.person = PersonObject.getInstant(null, null, null, null, 0);
        } catch (Exception e) {
            assertEquals("This NIF is not possible, This name is not possible, This email is not possible, This direction is not possible, This phone number is not possible, ", e.getMessage());
        }

    }


    @Test
    void testGetContact() {
        String contact = person.getContact();
        String expectedContact = "El nif de este person es: 87967494S y su nombre es: Ash con su email: ashgraunuriacefp@gmail.com y dirección: Carrer Valencia 20";
        assertEquals(expectedContact, contact);
    }



}
