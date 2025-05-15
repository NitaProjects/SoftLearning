package demo.model.products;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demo.exceptions.BuildException;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    private Book book;

    @BeforeEach
    void setUp() {
        try {
            book = Book.getInstanceBook(
                10.00,
                    "Clean code",
                    "Este libro trata sobre como optimizar tu codigo en java",
                    "Penguin editorial",
                    "Español",
                    30,
                    "978-8-46-796674-9",
                    "2020-12-01 20:20:40",
                    "2020-12-01",
                    20,
                    20,
                    20.30,
                    20.30,
                    2.30,
                    "yes"
                  );
        } catch (BuildException ex) {
            ex.getMessage();
        }
    }

    @Test
    void testSetEditorialValid() {
        int result = book.setEditorial("McGraw-Hill");
        assertEquals(0, result);
    }

    @Test
    void testSetEditorialNull() {
        int result = book.setEditorial(null);
        assertEquals(-1, result);
    }

    @Test
    void testSetEditorialBlank() {
        int result = book.setEditorial("   ");
        assertEquals(-1, result);
    }

    @Test
    void testSetEditorialTooShort() {
        int result = book.setEditorial("abc");
        assertEquals(-2, result);
    }

    @Test
    void testSetEditorialTooLong() {
        int result = book.setEditorial("Editorial muy muy muy larga para test");
        assertEquals(-10, result);
    }

    @Test
    void testSetIdiomaValid() {
        int result = book.setIdioma("Inglés");
        assertEquals(0, result);
    }

    @Test
    void testSetIdiomaNull() {
        int result = book.setIdioma(null);
        assertEquals(-1, result);
    }

    @Test
    void testSetIdiomaBlank() {
        int result = book.setIdioma("   ");
        assertEquals(-1, result);
    }

    @Test
    void testSetIdiomaTooShort() {
        int result = book.setIdioma("abc");
        assertEquals(-2, result);
    }

    @Test
    void testSetIdiomaTooLong() {
        int result = book.setIdioma("Idioma extremadamente largo");
        assertEquals(-10, result);
    }

    @Test
    void testSetPaginasValid() {
        int result = book.setPaginas(200);
        assertEquals(0, result);
    }

    @Test
    void testSetPaginasZero() {
        int result = book.setPaginas(0);
        assertEquals(-3, result);
    }

    @Test
    void testSetPaginasNegative() {
        int result = book.setPaginas(-10);
        assertEquals(-4, result);
    }

    @Test
    void testSetPaginasTooLow() {
        int result = book.setPaginas(5);
        assertEquals(-6, result);
    }

    @Test
    void testSetISBNValid() {
        int result = book.setISBN("978-8-46-796674-9");
        assertEquals(0, result);
    }

    @Test
    void testSetISBNNull() {
        int result = book.setISBN(null);
        assertEquals(-1, result);
    }

    @Test
    void testSetISBNBlank() {
        int result = book.setISBN("   ");
        assertEquals(-1, result);
    }

    @Test
    void testSetISBNInvalid() {
        int result = book.setISBN("123-4-56-7891011-1");
        assertEquals(-24, result);
    }

    @Test
    void testSetFechaDeLanzamientoValid() {
        int result = book.setFechaDeLanzamiento("10-04-2023 12:00:00");
        assertEquals(0, result);
    }

    @Test
    void testSetFechaDeLanzamientoInvalid() {
        int result = book.setFechaDeLanzamiento("10-04-3 12:00:00");
        assertEquals(-22, result);
    }

    @Test
    void testSetFechaDeLanzamientoNull() {
        int result = book.setFechaDeLanzamiento(null);
        assertEquals(-22, result);
    }

    @Test
    void testSetFechaDeLanzamientoBlank() {
        int result = book.setFechaDeLanzamiento("   ");
        assertEquals(-22, result);
    }

    @Test
    void testSetFechaDeDisponibilidadValid() {
        int result = book.setFechaDeDisponibilidad("15-04-2023");
        assertEquals(0, result);
    }

    @Test
    void testSetFechaDeDisponibilidadInvalid() {
        int result = book.setFechaDeDisponibilidad("31-02-2025");
        assertEquals(-21, result);
    }

    @Test
    void testSetFechaDeDisponibilidadNull() {
        int result = book.setFechaDeDisponibilidad(null);
        assertEquals(-21, result);
    }

    @Test
    void testSetFechaDeDisponibilidadBlank() {
        int result = book.setFechaDeDisponibilidad("   ");
        assertEquals(-21, result);
    }

    @Test
    void testSetRecordatoriosDiasValid() {
        int result = book.setRecordatoriosDias(100);
        assertEquals(0, result);
    }

    @Test
    void testSetRecordatoriosDiasZero() {
        int result = book.setRecordatoriosDias(0);
        assertEquals(-3, result);
    }

    @Test
    void testSetRecordatoriosDiasNegative() {
        int result = book.setRecordatoriosDias(-1);
        assertEquals(-4, result);
    }

    @Test
    void testSetRecordatoriosDiasTooHigh() {
        int result = book.setRecordatoriosDias(367);
        assertEquals(-5, result);
    }

    // -------------------- GETTERS --------------------

    @Test
    void testGetEditorial() {
        assertEquals("Penguin editorial", book.getEditorial());
    }

    @Test
    void testGetIdioma() {
        assertEquals("Español", book.getIdioma());
    }

    @Test
    void testGetPaginas() {
        assertEquals(30, book.getPaginas());
    }

    @Test
    void testGetISBN() {
        assertEquals("978-8-46-796674-9", book.getISBN());
    }

    @Test
    void testGetFechaDeLanzamiento() {
        assertEquals("01-12-2020 20:20:40", book.getFechaDeLanzamiento());
    }

    @Test
    void testGetFechaDeDisponibilidad() {
        assertEquals("01-12-2020", book.getFechaDeDisponibilidad());
    }

    @Test
    void testGetRecordatoriosDias() {
        assertEquals(20, book.getRecordatoriosDias());
    }



    // -------------------- getDetails() --------------------

    @Test
    void testGetDetails() {
        String expected = "Este libro tiene el titulo de Clean code y es de la editorial Penguin editorial\n" +
                        "Este libro tiene 30 paginas y esta en el idioma Español\n" +
                        "Este libro tiene la tematica de Este libro trata sobre como optimizar tu codigo en java\n" +
                        "El precio de este libro es 10.0 euros \n" +
                        "Este libro mide de ancho 20.0cm, de largo 20.3cm, y de alto 20.3cm.\n" +
                        "Este libro yes es fragil y pesa un total de 2.3g.";

        assertEquals(expected, book.getDetails());
    }

    // --------------------- PhysicalData -------------------

    @Test
    void testSetAnchoZero() {
        int result = book.setAncho(0.0);
        assertEquals(-3, result);
    }

    @Test
    void testSetAnchoNegative() {
        int result = book.setAncho(-1.0);
        assertEquals(-4, result);
    }

    @Test
    void testSetAnchoTooLarge() {
        int result = book.setAncho(75.0);
        assertEquals(-5, result);
    }

    @Test
    void testSetAnchoTooLow() {
        int result = book.setAncho(4.0);
        assertEquals(-6, result);
    }

    @Test
    void testSetAltoZero() {
        int result = book.setAlto(0.0);
        assertEquals(-3, result);
    }

    @Test
    void testSetAltoNegative() {
        int result = book.setAlto(-1.0);
        assertEquals(-4, result);
    }

    @Test
    void testSetAltoTooLarge() {
        int result = book.setAlto(50.0);
        assertEquals(-5, result);
    }

    @Test
    void testSetAltoOkay() {
        int result = book.setAlto(13.0);
        assertEquals(0, result);
    }

    @Test
    void testSetAltoTooLow() {
        int result = book.setAlto(2.0);
        assertEquals(-6, result);
    }

    @Test
    void testSetLargoZero() {
        int result = book.setLargo(0.0);
        assertEquals(-3, result);
    }

    @Test
    void testSetLargoNegative() {
        int result = book.setLargo(-1.0);
        assertEquals(-4, result);
    }

    @Test
    void testSetLargoTooLarge() {
        int result = book.setLargo(120.0);
        assertEquals(-5, result);
    }

    @Test
    void testSetLargoTooLow() {
        int result = book.setLargo(9.0);
        assertEquals(-6, result);
    }

    @Test
    void testSetPesoZero() {
        int result = book.setPeso(0.0);
        assertEquals(-3, result);
    }

    @Test
    void testSetPesoNegative() {
        int result = book.setPeso(-1.0);
        assertEquals(-4, result);
    }

    @Test
    void testSetPesoTooHeavy() {
        int result = book.setPeso(25.0);
        assertEquals(-5, result);
    }

    @Test
    void testSetPesoTooLow() {
        int result = book.setPeso(0.3);
        assertEquals(-6, result);
    }

    @Test
    void testSetFragilNull() {
        int result = book.setFragil(null);
        assertEquals(-1, result);
    }

    @Test
    void testSetFragilBlank() {
        int result = book.setFragil("     ");
        assertEquals(-1, result);
    }

    @Test
    void testSetFragilPatata() {
        int result = book.setFragil("patata");
        assertEquals(-8, result);
    }

    @Test
    void testGetAncho() {
        assertEquals(20.0, book.getAncho());
    }

    @Test
    void testGetAlto() {
        assertEquals(20.3, book.getAlto());
    }

    @Test
    void testGetLargo() {
        assertEquals(20.3, book.getLargo());
    }

    @Test
    void testGetPeso() {
        assertEquals(2.3, book.getPeso());
    }

    @Test
    void testGetFragil() {
        assertEquals("yes", book.getFragil());
    }

    @Test
    void testGetDimensions() {
        String expectedDimensions = "Tus medidas son: 20.3x20.0x20.3";
        assertEquals(expectedDimensions, book.getDimensions());
    }

    @Test
    void testGetVolumen() {
        book.setAlto(5.0);
        book.setAncho(10.0);
        book.setLargo(20.0);
        double expectedVolumen = 5.0 * 10.0 * 20.0;
        assertEquals(expectedVolumen, book.getVolumen());
    }

    //---------------------------- getInstance -------------------

    @Test
void testGetInstancePriceNull() {
    try {
        this.book = Book.getInstanceBook(0, "Clean Code", "Este libro trata sobre buenas prácticas en programación.", 
            "Penguin Editorial", "Español", 30, "978-8-46-796674-9", "2025-04-10 00:00:00", "2025-04-15", 10, 20.0, 20.3, 20.3, 2.3, "yes");
    } catch (BuildException e) {
        assertEquals("This price is not possible, ", e.getMessage());
    }
}

@Test
void testGetInstanceNameNull() {
    try {
        this.book = Book.getInstanceBook(25.00, null, "Este libro trata sobre buenas prácticas en programación.", 
            "Penguin Editorial", "Español", 30, "978-8-46-796674-9", "2025-04-10 00:00:00", "2025-04-15", 10, 20.0, 20.3, 20.3, 2.3, "yes");
    } catch (BuildException e) {
        assertEquals("This name is not possible, ", e.getMessage());
    }
}

@Test
void testGetInstanceTematicNull() {
    try {
        this.book = Book.getInstanceBook(25.00, "Clean Code", null, 
            "Penguin Editorial", "Español", 30, "978-8-46-796674-9", "2025-04-10 00:00:00", "2025-04-15", 10, 20.0, 20.3, 20.3, 2.3, "yes");
    } catch (BuildException e) {
        assertEquals("This tematic is not possible, ", e.getMessage());
    }
}

@Test
void testGetInstanceEditorialNull() {
    try {
        this.book = Book.getInstanceBook(25.00, "Clean Code", "Este libro trata sobre buenas prácticas en programación.", 
            null, "Español", 30, "978-8-46-796674-9", "2025-04-10 00:00:00", "2025-04-15", 10, 20.0, 20.3, 20.3, 2.3, "yes");
    } catch (BuildException e) {
        assertEquals("This editorial is not possible, ", e.getMessage());
    }
}

@Test
void testGetInstanceIdiomaNull() {
    try {
        this.book = Book.getInstanceBook(25.00, "Clean Code", "Este libro trata sobre buenas prácticas en programación.", 
            "Penguin Editorial", null, 30, "978-8-46-796674-9", "2025-04-10 00:00:00", "2025-04-15", 10, 20.0, 20.3, 20.3, 2.3, "yes");
    } catch (BuildException e) {
        assertEquals("This idioma is not possible, ", e.getMessage());
    }
}

@Test
void testGetInstancePaginasNull() {
    try {
        this.book = Book.getInstanceBook(25.00, "Clean Code", "Este libro trata sobre buenas prácticas en programación.", 
            "Penguin Editorial", "Español", -1, "978-8-46-796674-9", "2025-04-10 00:00:00", "2025-04-15", 10, 20.0, 20.3, 20.3, 2.3, "yes");
    } catch (BuildException e) {
        assertEquals("This pages is not possible, ", e.getMessage());
    }
}

@Test
void testGetInstanceISBNNull() {
    try {
        this.book = Book.getInstanceBook(25.00, "Clean Code", "Este libro trata sobre buenas prácticas en programación.", 
            "Penguin Editorial", "Español", 30, null, "2025-04-10 00:00:00", "2025-04-15", 10, 20.0, 20.3, 20.3, 2.3, "yes");
    } catch (BuildException e) {
        assertEquals("This ISBN is not possible, ", e.getMessage());
    }
}

@Test
void testGetInstanceFechaDeLanzamientoNull() {
    try {
        this.book = Book.getInstanceBook(25.00, "Clean Code", "Este libro trata sobre buenas prácticas en programación.", 
            "Penguin Editorial", "Español", 30, "978-8-46-796674-9", null, "2025-04-15", 10, 20.0, 20.3, 20.3, 2.3, "yes");
    } catch (BuildException e) {
        assertEquals("This fechaDeLanzamiento is not possible, ", e.getMessage());
    }
}

@Test
void testGetInstanceFechaDeDisponibilidadNull() {
    try {
        this.book = Book.getInstanceBook(25.00, "Clean Code", "Este libro trata sobre buenas prácticas en programación.", 
            "Penguin Editorial", "Español", 30, "978-8-46-796674-9", "2025-04-10 00:00:00", null, 10, 20.0, 20.3, 20.3, 2.3, "yes");
    } catch (BuildException e) {
        assertEquals("This fechaDeDisponibilidad is not possible, ", e.getMessage());
    }
}

@Test
void testGetInstanceRecordatoriosDiasNull() {
    try {
        this.book = Book.getInstanceBook(25.00, "Clean Code", "Este libro trata sobre buenas prácticas en programación.", 
            "Penguin Editorial", "Español", 30, "978-8-46-796674-9", "2025-04-10 00:00:00", "2025-04-15", 0, 20.0, 20.3, 20.3, 2.3, "yes");
    } catch (BuildException e) {
        assertEquals("This recordatoriosDias is not possible, ", e.getMessage());
    }
}

    @Test
    void testGetInstanceAnchoNull() {
        try {
            this.book = Book.getInstanceBook(25.00, "Clean Code", "Este libro trata sobre buenas prácticas en programación.", 
                "Penguin Editorial", "Español", 30, "978-8-46-796674-9", "2025-04-10 00:00:00", "2025-04-15", 10, 0, 20.3, 20.3, 2.3, "yes");
        } catch (BuildException e) {
            assertEquals("This wide is not possible, ", e.getMessage());
        }
    }

    @Test
    void testGetInstanceLargoNull() {
        try {
            this.book = Book.getInstanceBook(25.00, "Clean Code", "Este libro trata sobre buenas prácticas en programación.", 
                "Penguin Editorial", "Español", 30, "978-8-46-796674-9", "2025-04-10 00:00:00", "2025-04-15", 10, 20.0, 0, 20.3, 2.3, "yes");
        } catch (BuildException e) {
            assertEquals("This large is not possible, ", e.getMessage());
        }
    }

    @Test
    void testGetInstanceAltoNull() {
        try {
            this.book = Book.getInstanceBook(25.00, "Clean Code", "Este libro trata sobre buenas prácticas en programación.", 
                "Penguin Editorial", "Español", 30, "978-8-46-796674-9", "2025-04-10 00:00:00", "2025-04-15", 10, 20.0, 20.3, 0, 2.3, "yes");
        } catch (BuildException e) {
            assertEquals("This high is not possible, ", e.getMessage());
        }
    }

    @Test
    void testGetInstancePesoNull() {
        try {
            this.book = Book.getInstanceBook(25.00, "Clean Code", "Este libro trata sobre buenas prácticas en programación.", 
                "Penguin Editorial", "Español", 30, "978-8-46-796674-9", "2025-04-10 00:00:00", "2025-04-15", 10, 20.0, 20.3, 20.3, 0, "yes");
        } catch (BuildException e) {
            assertEquals("This weight is not possible, ", e.getMessage());
        }
    }

    @Test
    void testGetInstanceFragilNull() {
        try {
            this.book = Book.getInstanceBook(25.00, "Clean Code", "Este libro trata sobre buenas prácticas en programación.", 
                "Penguin Editorial", "Español", 30, "978-8-46-796674-9", "2025-04-10 00:00:00", "2025-04-15", 10, 20.0, 20.3, 20.3, 2.3, null);
        } catch (BuildException e) {
            assertEquals("This fragil is not possible, ", e.getMessage());
        }
    }

    @Test
    void testGetInstanceAllNull() {
        try {
            this.book = Book.getInstanceBook(0.00, null, null, 
                null, null, 0, null, null, null, 0, 0.00, 0.00, 0.00, 0.00, null);
        } catch (BuildException e) {
            assertEquals("This price is not possible, This name is not possible, This tematic is not possible, This editorial is not possible, This idioma is not possible, This pages is not possible, This ISBN is not possible, This fechaDeLanzamiento is not possible, This fechaDeDisponibilidad is not possible, This recordatoriosDias is not possible, This wide is not possible, This large is not possible, This high is not possible, This weight is not possible, This fragil is not possible, ", e.getMessage());
        }
    }

}
