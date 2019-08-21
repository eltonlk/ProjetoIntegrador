package com.projeto.integrador.serverapi.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import com.projeto.integrador.serverapi.model.User;

import java.io.IOException;

public class UserSerializer extends StdSerializer<User> {

  private static final long serialVersionUID = 1L;

  public UserSerializer() {
    this(null);
  }

  public UserSerializer(Class<User> t) {
    super(t);
  }

  @Override
  public void serialize(
    User user,
    JsonGenerator generator,
    SerializerProvider provider)
  throws IOException, JsonProcessingException {
    generator.writeStartObject();
    generator.writeNumberField("id", user.getId());
    generator.writeStringField("name", user.getName());
    generator.writeStringField("email", user.getEmail());
    generator.writeStringField("username", user.getUsername());
    generator.writeBooleanField("admin", user.isAdmin());
    generator.writeBooleanField("active", user.isActive());
    generator.writeArrayFieldStart("roles");

    for (Object role : user.getRoles()) {
      generator.writeObject(role);
    }

    generator.writeEndArray();
    generator.writeEndObject();
  }

}
