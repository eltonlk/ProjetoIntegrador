package com.projeto.integrador.serverapi.service;

import javax.persistence.EntityManager;

import com.projeto.integrador.serverapi.auditor.BeanUtil;
import com.projeto.integrador.serverapi.model.Option;

import org.springframework.stereotype.Service;

@Service
public class OptionService {

  private static OptionService optionService;

  private OptionService() {
  }

  public Option getOptionByName(String name) {
    EntityManager entityManager = BeanUtil.getBean(EntityManager.class);

    Long optionId = (long) 1;

    Option option = entityManager.find(Option.class, optionId);

    return option;
  }

  public static synchronized boolean auditsEnabled() {
    optionService = new OptionService();

    Option option = optionService.getOptionByName("audits");

    return "enabled".equals(option.getValue());
  }

}
