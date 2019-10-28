package com.projeto.integrador.clientdesktop.collections;

public enum MaterialKindCollection {
  OPAQUE("opaque", "Opaco"),
  TRANSLUCENT("translucent", "Translúcido"),
  AIR("air", "Ar");

  private final String value, text;

  private MaterialKindCollection(String value, String text) {
    this.value = value;
    this.text = text;
  }

  public static MaterialKindCollection[] collection() {
    MaterialKindCollection[] options = {
      MaterialKindCollection.OPAQUE,
      MaterialKindCollection.TRANSLUCENT,
      MaterialKindCollection.AIR
    };

    return options;
  }

  public static MaterialKindCollection findByValue(String value) {
    MaterialKindCollection kind = null;

    for (MaterialKindCollection _kind : collection()) {
      if (_kind.getValue().equals(value)) {
        kind = _kind;
      }
    }

    return kind;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return this.text;
  }
}
