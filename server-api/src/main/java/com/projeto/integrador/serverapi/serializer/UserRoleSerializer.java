package com.projeto.integrador.serverapi.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import com.projeto.integrador.serverapi.model.UserRole;

import java.io.IOException;

public class UserRoleSerializer extends StdSerializer<UserRole> {

  private static final long serialVersionUID = 1L;

  public UserRoleSerializer() {
    this(null);
  }

  protected UserRoleSerializer(Class<UserRole> t) {
    super(t);
  }

  @Override
  public void serialize(
    UserRole userRole,
    JsonGenerator generator,
    SerializerProvider provider)
  throws IOException, JsonProcessingException {
    generator.writeStartObject();
    generator.writeNumberField("id", userRole.getId());
    generator.writeNumberField("userId", userRole.getUser().getId());
    generator.writeNumberField("roleId", userRole.getRole().getId());
    generator.writeNumberField("privilegeId", userRole.getPrivilege().getId());
    generator.writeBooleanField("enable", userRole.isEnable());
    generator.writeStringField("role", userRole.getRole().getName());
    generator.writeStringField("privilege", userRole.getPrivilege().getName());
    generator.writeEndObject();
  }

}
