package com.projeto.integrador.serverapi.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import com.projeto.integrador.serverapi.model.Room;

import java.io.IOException;

public class RoomSerializer extends StdSerializer<Room> {

  private static final long serialVersionUID = 1L;

  public RoomSerializer() {
    this(null);
  }

  protected RoomSerializer(Class<Room> t) {
    super(t);
  }

  @Override
  public void serialize(
    Room room,
    JsonGenerator generator,
    SerializerProvider provider)
  throws IOException, JsonProcessingException {
    generator.writeStartObject();
    generator.writeNumberField("id", room.getId());
    generator.writeStringField("name", room.getName());
    generator.writeNumberField("heatLoad", room.getHeatLoad());

    if (room.getFaces() != null) {
      generator.writeArrayFieldStart("faces");

      for (Object face : room.getFaces()) {
        generator.writeObject(face);
      }

      generator.writeEndArray();
    }

    generator.writeEndObject();
  }

}
