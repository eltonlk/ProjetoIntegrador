package com.projeto.integrador.serverapi.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import com.projeto.integrador.serverapi.model.ComponentMaterial;

import java.io.IOException;

public class ComponentMaterialSerializer extends StdSerializer<ComponentMaterial> {

  private static final long serialVersionUID = 1L;

  public ComponentMaterialSerializer() {
    this(null);
  }

  protected ComponentMaterialSerializer(Class<ComponentMaterial> t) {
    super(t);
  }

  @Override
  public void serialize(
    ComponentMaterial componentMaterial,
    JsonGenerator generator,
    SerializerProvider provider)
  throws IOException, JsonProcessingException {
    generator.writeStartObject();
    generator.writeNumberField("id", componentMaterial.getId());
    generator.writeNumberField("width", componentMaterial.getWidth());
    generator.writeNumberField("thermalConductivityIndex", componentMaterial.getThermalConductivityIndex());
    generator.writeNumberField("resistance", componentMaterial.getResistance());

    if (componentMaterial.getMaterial() != null) {
      generator.writeObjectField("material", componentMaterial.getMaterial());
    }

    generator.writeEndObject();
  }

}
