package com.projeto.integrador.clientdesktop.collections;

public enum FaceOrientationCollection {
  NORTH("north", "Norte"),
  SOUTH("south", "Sul"),
  EAST("east", "Leste"),
  WEST("west", "Oeste"),
  NORTH_EAST("north_east", "Nordeste"),
  NORHT_WEST("north_west", "Noroeste"),
  SOUTH_EAST("south_east", "Sudeste"),
  SOUTH_WEST("south_west", "Sudoeste"),
  PERPENDICULAR("perpendicular", "Perpendicular");

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
      FaceOrientationCollection.SOUTH_WEST,
      FaceOrientationCollection.PERPENDICULAR
    };

    return options;
  }

  public static FaceOrientationCollection findByValue(String value) {
    FaceOrientationCollection orientation = null;

    for (FaceOrientationCollection _orientation : collection()) {
      if (_orientation.getValue().equals(value)) {
        orientation = _orientation;
      }
    }

    return orientation;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return this.text;
  }
}
