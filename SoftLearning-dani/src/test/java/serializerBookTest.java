import demo.model.core.services.BookDTO;
import demo.model.core.services.CatalanBookDTO;
import demo.model.core.services.ClientDTO;
import demo.model.core.services.serializers.BookJsonSerializer;
import demo.model.core.services.serializers.JacksonSerializer;
import demo.model.core.services.serializers.Serializer;
import demo.model.core.services.serializers.JacksonXMLSerializer;


public class serializerBookTest {
   
   public static void main(String[] args) throws Exception {
   BookDTO b = new BookDTO(
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

      CatalanBookDTO bCat = new CatalanBookDTO(
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

      try {
         String jbook = BookJsonSerializer.serializer(b);
         System.out.println(jbook);
         BookDTO copyBookDTO = BookJsonSerializer.deserializer(jbook);
         System.out.println(copyBookDTO);
      } catch (Exception var4) {
         System.out.println(var4.getMessage());
      }

      try{
         Serializer formatter = new JacksonXMLSerializer();
         String xmlString = formatter.serializer(b);
         System.out.println(xmlString);

         BookDTO bookDTO = (BookDTO) formatter.deserializer(xmlString, BookDTO.class);
         System.out.println(bookDTO);
      } catch (Exception var4) {
         System.out.println(var4.getMessage());
      }

      

      try {
         Serializer formatterCatalan = new JacksonSerializer<CatalanBookDTO>();
         String jbookcat = formatterCatalan.serializer(bCat);
         System.out.println(jbookcat);
         
         CatalanBookDTO copyBookDTOcat = (CatalanBookDTO)formatterCatalan.deserializer(jbookcat, CatalanBookDTO.class);
         System.out.println(copyBookDTOcat);
      } catch (Exception var5) {
         System.out.println(var5.getMessage());
      }



   }
}