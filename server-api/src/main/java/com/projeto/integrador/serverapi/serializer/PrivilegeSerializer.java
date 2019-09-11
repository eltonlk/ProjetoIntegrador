package com.projeto.integrador.serverapi.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import com.projeto.integrador.serverapi.model.Privilege;

import java.io.IOException;

public class PrivilegeSerializer extends StdSerializer<Privilege> {

  private static final long serialVersionUID = 1L;

  public PrivilegeSerializer() {
    this(null);
  }

  protected PrivilegeSerializer(Class<Privilege> t) {
    super(t);
  }

  @Override
  public void serialize(
    Privilege privilege,
    JsonGenerator generator,
    SerializerProvider provider)
  throws IOException, JsonProcessingException {
    generator.writeStartObject();
    generator.writeNumberField("id", privilege.getId());
    generator.writeStringField("name", privilege.getName());
    generator.writeEndObject();
  }

}
