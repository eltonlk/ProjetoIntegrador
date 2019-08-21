package com.projeto.integrador.serverapi.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import com.projeto.integrador.serverapi.model.Role;

import java.io.IOException;

public class RoleSerializer extends StdSerializer<Role> {

  private static final long serialVersionUID = 1L;

  public RoleSerializer() {
    this(null);
  }

  protected RoleSerializer(Class<Role> t) {
    super(t);
  }

  @Override
  public void serialize(
    Role role,
    JsonGenerator generator,
    SerializerProvider provider)
  throws IOException, JsonProcessingException {
    generator.writeStartObject();
    generator.writeNumberField("id", role.getId());
    generator.writeStringField("name", role.getName());
    generator.writeEndObject();
  }

}
