package demo.model.core.services.serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSerializer<T> implements Serializer<T>{

    private ObjectMapper mapper = new ObjectMapper();
    String jsonBook;

    @Override
    public String serializer(T object) throws Exception {
        try {
            return this.mapper.writeValueAsString(object);

        } catch (JsonProcessingException e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public T deserializer(String source, Class<T> object) throws Exception {
        try{
            return mapper.readValue(source, object);
        } catch (JsonProcessingException e){
            throw new Exception(e.getMessage());
        }
    }
}


