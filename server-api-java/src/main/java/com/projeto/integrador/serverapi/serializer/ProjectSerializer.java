package com.projeto.integrador.serverapi.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import com.projeto.integrador.serverapi.model.Project;

import java.io.IOException;

public class ProjectSerializer extends StdSerializer<Project> {

  private static final long serialVersionUID = 1L;

  public ProjectSerializer() {
    this(null);
  }

  protected ProjectSerializer(Class<Project> t) {
    super(t);
  }

  @Override
  public void serialize(
    Project project,
    JsonGenerator generator,
    SerializerProvider provider)
  throws IOException, JsonProcessingException {
    generator.writeStartObject();
    generator.writeNumberField("id", project.getId());
    generator.writeStringField("name", project.getName());

    if (project.getSolarRadiation() != null) {
      generator.writeObjectField("solarRadiation", project.getSolarRadiation());
    }

    if (project.getRooms() != null) {
      generator.writeArrayFieldStart("rooms");

      for (Object room : project.getRooms()) {
        generator.writeObject(room);
      }

      generator.writeEndArray();
    }

    generator.writeEndObject();
  }

}
