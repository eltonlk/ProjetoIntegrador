package com.projeto.integrador.clientdesktop.utils;

import java.util.HashMap;
import java.util.Map;

public class I18n {

  public static String t(String text) {
    Map <String, String> i18n = new HashMap<String, String>();
    i18n.put("absorbability_index", "Índice de Absorvidade");
    i18n.put("active", "Ativo");
    i18n.put("april", "Abril");
    i18n.put("area", "Área");
    i18n.put("august", "Agosto");
    i18n.put("color_id", "ID Cor");
    i18n.put("color", "Cor");
    i18n.put("component_id", "ID Componente");
    i18n.put("component", "Componente");
    i18n.put("componentmaterial", "Material");
    i18n.put("create", "Adicionou");
    i18n.put("december", "Dezembro");
    i18n.put("destroy", "Excluiu");
    i18n.put("east_index", "Leste");
    i18n.put("email", "E-mail");
    i18n.put("enable", "Abilitado");
    i18n.put("enable", "Habilitado");
    i18n.put("external_temperature", "Tempertura Externa");
    i18n.put("face_id", "ID Face");
    i18n.put("face", "Face");
    i18n.put("february", "Fevereiro");
    i18n.put("heat_flow", "Fluxo de Calor");
    i18n.put("heat_load", "Carga de Calor");
    i18n.put("internal_temperature", "Tempertura Interna");
    i18n.put("january", "Janeiro");
    i18n.put("july", "Julho");
    i18n.put("june", "Junho");
    i18n.put("kind", "Tipo");
    i18n.put("march", "Março");
    i18n.put("material_id", "ID Material");
    i18n.put("material", "Material");
    i18n.put("may", "Maio");
    i18n.put("name", "Nome");
    i18n.put("north_east_index", "Nordeste");
    i18n.put("north_index", "Norte");
    i18n.put("north_west_index", "Noroeste");
    i18n.put("november", "Novembro");
    i18n.put("october", "Outubro");
    i18n.put("option", "Opção");
    i18n.put("orientation", "Orientação");
    i18n.put("password_digest", "Senha Criptografada");
    i18n.put("perpendicular_index", "Perpendicular");
    i18n.put("project_id", "ID Projeto");
    i18n.put("project", "Projeto");
    i18n.put("resistance", "Resistência");
    i18n.put("room_id", "ID Cômodo");
    i18n.put("room", "Cômodo");
    i18n.put("season", "Estação");
    i18n.put("september", "Setembro");
    i18n.put("solar_factor", "Fator Solar");
    i18n.put("solar_radiation_id", "ID Radiação Solar");
    i18n.put("solarradiation", "Radiação Solar");
    i18n.put("south_east_index", "Sudeste");
    i18n.put("south_index", "Sul");
    i18n.put("south_west_index", "Sudoeste");
    i18n.put("thermal_conductivity_index", "Índice de Condutividade Térmica");
    i18n.put("thermal_conductivity_index", "Índice de Condutividade Térmica");
    i18n.put("update", "Atualizou");
    i18n.put("user", "Usuário");
    i18n.put("username", "Usuário");
    i18n.put("userrole", "Permissão");
    i18n.put("value", "Valor");
    i18n.put("west_index", "Oeste");
    i18n.put("width", "Espessura");

    String local = i18n.get(text.toLowerCase());

    if (local != null) {
      return local;
    } else {
      System.out.println("not fount translation for " + text);
      return text;
    }
  }

}
