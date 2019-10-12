package com.projeto.integrador.serverapi.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.projeto.integrador.serverapi.model.observer.AuditListener;

@Entity
@EntityListeners(AuditListener.class)
@Table(name = "solar_radiations")
public class SolarRadiation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotEmpty
  private String name;

  @NotNull
  private int northIndex, northEastIndex, eastIndex, southEastIndex, southIndex, southWestIndex, westIndex, northWestIndex;

  public SolarRadiation(Long id, String name, int northIndex, int northEastIndex, int eastIndex, int southEastIndex,
    int southIndex, int southWestIndex, int westIndex, int northWestIndex) {

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

  @Override
  public String toString() {
    return "SolarRadiation{" +
      "id=" + id +
      ", name=\'" + name + "\'" +
      ", north_index=" + northIndex +
      ", north_east_index=" + northEastIndex +
      ", east_index=" + eastIndex +
      ", south_east_index=" + southEastIndex +
      ", south_index=" + southIndex +
      ", south_west_index=" + southWestIndex +
      ", west_index=" + westIndex +
      ", north_west_index=" + northWestIndex +
      "}";
  }

}
