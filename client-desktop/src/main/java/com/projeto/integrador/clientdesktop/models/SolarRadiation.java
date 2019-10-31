package com.projeto.integrador.clientdesktop.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolarRadiation {

  private Long id;

  private String name;

  @JsonProperty("north_index")
  private int northIndex;

  @JsonProperty("north_east_index")
  private int northEastIndex;

  @JsonProperty("east_index")
  private int eastIndex;

  @JsonProperty("south_east_index")
  private int southEastIndex;

  @JsonProperty("south_index")
  private int southIndex;

  @JsonProperty("south_west_index")
  private int southWestIndex;

  @JsonProperty("west_index")
  private int westIndex;

  @JsonProperty("north_west_index")
  private int northWestIndex;

  @JsonProperty("perpendicular_index")
  private int perpendicularIndex;

  public SolarRadiation(Long id, String name, int northIndex, int northEastIndex, int eastIndex,
    int southEastIndex, int southIndex, int southWestIndex, int westIndex, int northWestIndex, int perpendicularIndex) {

    this.id = id;
    this.name = name;
    this.northIndex = northIndex;
    this.northEastIndex = northEastIndex;
    this.eastIndex = eastIndex;
    this.southEastIndex = southEastIndex;
    this.southIndex = southIndex;
    this.southWestIndex = southWestIndex;
    this.westIndex = westIndex;
    this.northWestIndex = northWestIndex;
    this.perpendicularIndex = perpendicularIndex;
  }

  public SolarRadiation() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNorthIndex() {
    return northIndex;
  }

  public void setNorthIndex(int northIndex) {
    this.northIndex = northIndex;
  }

  public int getNorthEastIndex() {
    return northEastIndex;
  }

  public void setNorthEastIndex(int northEastIndex) {
    this.northEastIndex = northEastIndex;
  }

  public int getEastIndex() {
    return eastIndex;
  }

  public void setEastIndex(int eastIndex) {
    this.eastIndex = eastIndex;
  }

  public int getSouthEastIndex() {
    return southEastIndex;
  }

  public void setSouthEastIndex(int southEastIndex) {
    this.southEastIndex = southEastIndex;
  }

  public int getSouthIndex() {
    return southIndex;
  }

  public void setSouthIndex(int southIndex) {
    this.southIndex = southIndex;
  }

  public int getSouthWestIndex() {
    return southWestIndex;
  }

  public void setSouthWestIndex(int southWestIndex) {
    this.southWestIndex = southWestIndex;
  }

  public int getWestIndex() {
    return westIndex;
  }

  public void setWestIndex(int westIndex) {
    this.westIndex = westIndex;
  }

  public int getNorthWestIndex() {
    return northWestIndex;
  }

  public void setNorthWestIndex(int northWestIndex) {
    this.northWestIndex = northWestIndex;
  }

  public int getPerpendicularIndex() {
    return perpendicularIndex;
  }

  public void setPerpendicularIndex(int perpendicularIndex) {
    this.perpendicularIndex = perpendicularIndex;
  }

  @Override
  public String toString() {
    return name;
  }

}
