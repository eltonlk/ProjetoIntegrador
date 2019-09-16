package com.projeto.integrador.clientdesktop.resources;

import java.util.List;

public interface AbstractResource {

  public List<Object> all();
  public Object find();
  public Boolean create();
  public Boolean update();
  public Boolean delete();

}
