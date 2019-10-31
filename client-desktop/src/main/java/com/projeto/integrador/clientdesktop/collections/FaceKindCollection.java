package com.projeto.integrador.clientdesktop.collections;

public enum FaceKindCollection {
  WALL("wall", "Parede"),
  SLAB("slab", "Laje");

  private final String value, text;

  private FaceKindCollection(String value, String text) {
    this.value = value;
    this.text = text;
  }

  public static FaceKindCollection[] collection() {
    FaceKindCollection[] options = {
      FaceKindCollection.WALL,
      FaceKindCollection.SLAB
    };

    return options;
  }

  public static FaceKindCollection findByValue(String value) {
    FaceKindCollection kind = null;

    for (FaceKindCollection _kind : collection()) {
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
