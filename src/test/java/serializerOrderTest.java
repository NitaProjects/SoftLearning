import demo.model.core.services.CatalanOrderDTO;
import demo.model.core.services.ClientDTO;
import demo.model.core.services.OrderDTO;
import demo.model.core.services.serializers.JacksonSerializer;
import demo.model.core.services.serializers.JacksonXMLSerializer;
import demo.model.core.services.serializers.Serializer;


public class serializerOrderTest {

    public static void main(String[] args) throws Exception {
    
    OrderDTO o = new OrderDTO( "12345678901", "Calle de kk", "Ash Grau", 
            "Fedex", "630241216", "aaaaaaaaa", "2020-11-01 20:20:40",
            "2020-11-01 20:20:40", "Info",  20,20.30,20.30,2.30,
            "yes", "i:978-8-40-829707-9,q:3,p:20.2,d:0.25;i:978-8-46-797142-2,q:2,p:22.95,d:0.0;", 
            "COMPLETED", "CreditCard", "2020-11-01 20:20:40", "2020-12-01 20:20:40");

    CatalanOrderDTO oCat = new CatalanOrderDTO( "12345678901", "Calle de kk", "Ash Grau", 
        "Fedex", "630241216", "aaaaaaaaa", "2020-11-01 20:20:40",
        "2020-11-01 20:20:40", "Info",  20,20.30,20.30,2.30,
        "yes", "i:978-8-40-829707-9,q:3,p:20.2,d:0.25;i:978-8-46-797142-2,q:2,p:22.95,d:0.0;", 
        "COMPLETED", "CreditCard", "2020-11-01 20:20:40", "2020-12-01 20:20:40");

    try {
        Serializer formatter1 = new JacksonSerializer<>();
        String jOrder = formatter1.serializer(o);
        System.out.println(jOrder);

        OrderDTO copyOrderDTO = (OrderDTO) formatter1.deserializer(jOrder, OrderDTO.class);
        System.out.println(copyOrderDTO);
      } catch (Exception var4) {
         System.out.println(var4.getMessage());
      }

      try{
         Serializer formatter = new JacksonXMLSerializer();
         String xmlString = formatter.serializer(o);
         System.out.println(xmlString);

         OrderDTO orderDTO = (OrderDTO) formatter.deserializer(xmlString, OrderDTO.class);
         System.out.println(orderDTO);
      } catch (Exception var4) {
         System.out.println(var4.getMessage());
      }


      try {
         Serializer formatterCat = new JacksonSerializer<>();
         String jorderCat = formatterCat.serializer(oCat);
         System.out.println(jorderCat);
 
         CatalanOrderDTO copyOrderDTOCat = (CatalanOrderDTO) formatterCat.deserializer(jorderCat, CatalanOrderDTO.class);
         System.out.println(copyOrderDTOCat);
       } catch (Exception var4) {
          System.out.println(var4.getMessage());
       }

       try {
         Serializer formatterCatXML = new JacksonXMLSerializer();
         String XmlorderCat = formatterCatXML.serializer(oCat);
         System.out.println(XmlorderCat);
 
         CatalanOrderDTO XMLOrderDTOCat = (CatalanOrderDTO) formatterCatXML.deserializer(XmlorderCat, CatalanOrderDTO.class);
         System.out.println(XMLOrderDTOCat);
       } catch (Exception var4) {
          System.out.println(var4.getMessage());
       }

    }

}
 