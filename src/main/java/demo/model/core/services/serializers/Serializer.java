package demo.model.core.services.serializers;


public interface Serializer<T> {
    public String serializer (T object) throws Exception;
    public T deserializer (String source, Class<T> object) throws Exception;
}
