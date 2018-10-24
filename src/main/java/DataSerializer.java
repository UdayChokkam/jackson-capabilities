import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class DataSerializer extends StdSerializer<Data> {

    public DataSerializer() {
        this(null);
    }

    public DataSerializer(Class<Data> t) {
        super(t);
    }

    @Override
    public void serialize(
            Data data, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {


        jgen.writeObject(data.getValue().toString());


    }
}