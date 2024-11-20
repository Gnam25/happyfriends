package sv.edu.ufg.happyfriends.happyfriends.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CustomTimeDeserializer extends JsonDeserializer<Time> {

    @Override
    public Time deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        // Deserializar la cadena de texto a LocalTime
        LocalTime localTime = LocalTime.parse(p.getText(), DateTimeFormatter.ofPattern("HH:mm:ss"));

        // Convertir LocalTime a Time
        return Time.valueOf(localTime);
    }
}