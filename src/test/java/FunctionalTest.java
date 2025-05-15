import demo.exceptions.BuildException;
import demo.model.persons.Client;
import demo.model.products.Book;

public class FunctionalTest {
    public static void main(String[] args) {
        try {
            // double price, String name, String tematic, String editorial, String
            // idioma,int paginas, String ISBN, String fechaDeLanzamiento, String
            // fechaDeDisponibilidad, int recordatoriosDias, double ancho, double largo,
            // double alto, double peso, String fragil
            Book b = Book.getInstanceBook(
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
                    "yes");

            // book d = book.getInstanceBook(0, null, null, null, null, 0, null, null, null,
            // 0, 0, 0, 0, 0, null);

            Client a = Client.getInstantClient(
                    "90533367P",
                    "Ash",
                    "ashGrau@gmail.com",
                    "Carrer Diputació 130",
                    630386250,
                    "1234567890123455",
                    "08013",
                    "Barcelona");

            // Client s = Client.getInstantClient(null, null, null, null, 0, null, null,
            // null);

            // System.out.println(s.toString());
            System.out.println(b.toString());
            System.out.println(a.toString());
            // System.out.println(d.toString());

            System.out.println(a.getContact());
            System.out.println(b.getDetails());

            // System.out.println("ola");

        } catch (BuildException ex) {
            System.out.println("Error al crear un objeto Client: " + ex.getMessage());
        }
    }
}
