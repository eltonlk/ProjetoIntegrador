package com.projeto.integrador.serverapi.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import com.projeto.integrador.serverapi.model.Component;

import java.io.IOException;

public class ComponentSerializer extends StdSerializer<Component> {

  private static final long serialVersionUID = 1L;

  public ComponentSerializer() {
    this(null);
  }

  protected ComponentSerializer(Class<Component> t) {
    super(t);
  }

  @Override
  public void serialize(
    Component component,
    JsonGenerator generator,
    SerializerProvider provider)
  throws IOException, JsonProcessingException {
    generator.writeStartObject();
    generator.writeNumberField("id", component.getId());
    generator.writeStringField("name", component.getName());
    generator.writeNumberField("area", component.getArea());
    generator.writeNumberField("heatFlow", component.getHeatFlow());

    if (component.getColor() != null) {
      generator.writeObjectField("color", component.getColor());
    }

    if (component.getComponentMaterials() != null) {
      generator.writeArrayFieldStart("componentMaterials");

      for (Object componentMaterial : component.getComponentMaterials()) {
        generator.writeObject(componentMaterial);
      }

      generator.writeEndArray();
    }

    generator.writeEndObject();
  }

}
