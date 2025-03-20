import demo.model.core.services.BookMapper;
import demo.model.core.services.BookDTO;
import demo.model.core.services.ClientDTO;
import demo.model.core.services.ClientMapper;
import demo.model.persons.Client;
import demo.model.products.Book;



import demo.exceptions.BuildException;

public class DTOFunctionalsTest {
    public static void main(String[] args) {
        try {
            Client c = Client.getInstantClient(
                    "90533367P",
                    "Ash",
                    "ashGrau@gmail.com",
                    "Carrer Diputació 130",
                    630386250,
                    "1234567890123455",
                    "08013",
                    "Barcelona");
            System.out.println(c.toString());

            ClientDTO cdto = ClientMapper.dtoFromClient(c);
            System.out.println("ID Cliente: " + cdto.getNif());

            Client ccopy = ClientMapper.clientFromDTO(cdto);
            System.out.println(ccopy.toString());
        } catch (BuildException ex) {
            System.out.println("Error al crear un objeto Client: " + ex.getMessage());
        }

        try {
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
            System.out.println(b.toString());

            BookDTO cdto = BookMapper.dtoFromBook(b);
            System.out.println("ID Cliente: " + cdto.getISBN());

            Book ccopy = BookMapper.bookFromDTO(cdto);
            System.out.println(ccopy.toString());


        } catch (BuildException ex) {
            System.out.println("Error al crear un objeto Book: " + ex.getMessage());
        }

    }
}
