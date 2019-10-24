package com.projeto.integrador.clientdesktop.collections;

public enum ProjectSeasonCollection {
  SUMMER("summer", "Verão"),
  WINTER("winter", "Inverno");

  private final String value, text;

  private ProjectSeasonCollection(String value, String text) {
    this.value = value;
    this.text = text;
  }

  public static ProjectSeasonCollection[] collection() {
    ProjectSeasonCollection[] options = {
      ProjectSeasonCollection.SUMMER,
      ProjectSeasonCollection.WINTER
    };

    return options;
  }

  public static ProjectSeasonCollection findByValue(String value) {
    ProjectSeasonCollection season = null;

    for (ProjectSeasonCollection _season : collection()) {
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
