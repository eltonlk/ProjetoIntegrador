package com.projeto.integrador.serverapi.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import com.projeto.integrador.serverapi.model.Face;

import java.io.IOException;

public class FaceSerializer extends StdSerializer<Face> {

  private static final long serialVersionUID = 1L;

  public FaceSerializer() {
    this(null);
  }

  protected FaceSerializer(Class<Face> t) {
    super(t);
  }

  @Override
  public void serialize(
    Face face,
    JsonGenerator generator,
    SerializerProvider provider)
  throws IOException, JsonProcessingException {
    generator.writeStartObject();
    generator.writeNumberField("id", face.getId());
    generator.writeStringField("name", face.getName());
    generator.writeNumberField("heatFlow", face.getHeatFlow());

    if (face.getComponents() != null) {
      generator.writeArrayFieldStart("components");

      for (Object component : face.getComponents()) {
        generator.writeObject(component);
      }

      generator.writeEndArray();
    }

    generator.writeEndObject();
  }

}
