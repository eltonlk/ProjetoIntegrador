package com.projeto.integrador.clientdesktop.collections;

public enum FaceOrientationCollection {
  NORTH("north", "Norte"),
  SOUTH("south", "Sul"),
  EAST("east", "Leste"),
  WEST("west", "Oeste"),
  NORTH_EAST("north_east", "Nordeste"),
  NORHT_WEST("north_west", "Noroeste"),
  SOUTH_EAST("south_east", "Sudeste"),
  SOUTH_WEST("south_west", "Sudoeste");

  private final String value, text;

  private FaceOrientationCollection(String value, String text) {
    this.value = value;
    this.text = text;
  }

  public static FaceOrientationCollection[] collection() {
    FaceOrientationCollection[] options = {
      FaceOrientationCollection.NORTH,
      FaceOrientationCollection.SOUTH,
      FaceOrientationCollection.EAST,
      FaceOrientationCollection.WEST,
      FaceOrientationCollection.NORTH_EAST,
      FaceOrientationCollection.NORHT_WEST,
      FaceOrientationCollection.SOUTH_EAST,
      FaceOrientationCollection.SOUTH_WEST
    };

    return options;
  }

  public static FaceOrientationCollection findByValue(String value) {
    FaceOrientationCollection season = null;

    for (FaceOrientationCollection _season : collection()) {
      if (_season.getValue().equals(value)) {
        season = _season;
      }
    }

    return season;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return this.text;
  }
}
