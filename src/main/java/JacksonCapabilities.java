import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JacksonCapabilities {

    public static void main(String[] args) throws JsonProcessingException {

        List<Map<String, Object>> ordersMap = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            Map<String, Object> orderMap = getOrder();
            ordersMap.add(orderMap);
        }

        ObjectMapper objectMapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addSerializer(Data.class, new DataSerializer());
        objectMapper.registerModule(module);


        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        System.out.println("*******************Execution json********************");
        System.out.print(objectMapper.writeValueAsString(ordersMap));
        System.out.println("*******************Execution json********************");

        ObjectMapper objectMapper1 = new ObjectMapper();




        objectMapper1.enable(SerializationFeature.INDENT_OUTPUT);

        System.out.println("*******************UI json********************");
        System.out.print(objectMapper1.writeValueAsString(ordersMap));
        System.out.println("*******************UI json********************");


    }

    private static Map<String, Object> getOrder() {
        Map<String, Object> customerMap = new HashMap<>();
        customerMap.put("amount1", new Data(true, "tip1", 100));
        customerMap.put("amount2", new Data(false, "tip2", 200));

        List<Map<String, Object>> orderItemsList = new ArrayList<>();
        Map<String, Object> amountmap1 = new HashMap();
        Map<String, Object> amountmap2 = new HashMap();
        amountmap1.put("amount", new Data(true, "tip3", 100));
        amountmap2.put("amount", new Data(false, "tip4", 200));
        orderItemsList.add(amountmap1);
        orderItemsList.add(amountmap2);

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("customer", customerMap);
        orderMap.put("items", orderItemsList);
        orderMap.put("id", new Data(true, "tip5", 300));
        return orderMap;
    }
}
