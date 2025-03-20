package demo.model.core.services.serializers;

import demo.model.core.services.BookDTO;
import demo.model.core.services.CatalanBookDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BookJsonSerializer {
    public static String serializer (BookDTO b) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        String jsonBook;
        try {
            jsonBook = mapper.writeValueAsString(b);
            return jsonBook;

        } catch (JsonProcessingException e) {
            throw new Exception(e.getMessage());
        }
    }

    public static BookDTO deserializer (String b) throws Exception{
        try{
            BookDTO bImported = new ObjectMapper().readValue(b, BookDTO.class);
            return bImported;
        } catch (JsonProcessingException e){
            throw new Exception(e.getMessage());
        }
    }
    
}
