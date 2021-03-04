package com.sros.customannotation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CustomAnnotationApplicationTests {

    @Test
    void givenObjectNotSerializedThenExceptionThrown() throws JsonSerializationException {
        Object object = new Object();
        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        serializer.convertToJson(object);
        assertThrows(JsonSerializationException.class, () -> {
            serializer.convertToJson(object);
        });
    }

    @Test
    void givenObjectSerializedThenTrueReturned() throws JsonSerializationException {
        Person person = new Person("Sros", "Yort", "25", "PP");
        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        String jsonString = serializer.convertToJson(person);
        assertEquals("{\"personAge\":\"25\",\"firstName\":\"Sros\",\"lastName\":\"Yort\"}", jsonString);
    }

}
