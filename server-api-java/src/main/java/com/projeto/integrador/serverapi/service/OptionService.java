package com.projeto.integrador.serverapi.service;

import javax.persistence.EntityManager;

import com.projeto.integrador.serverapi.auditor.BeanUtil;
import com.projeto.integrador.serverapi.model.Option;
// import com.projeto.integrador.serverapi.repository.OptionsRepository; // TODO:

// import org.springframework.beans.factory.annotation.Autowired; // TODO:
import org.springframework.stereotype.Service;

@Service
public class OptionService {

  // @Autowired
  // private OptionsRepository repository; // TODO:

  private static OptionService optionService;

  private OptionService() {
  }

  public Option getOptionByName(String name) {
    // return repository.findByName(name); // TODO:

    EntityManager entityManager = BeanUtil.getBean(EntityManager.class);

    // Option option = (Option) entityManager
    //   .createQuery("select o from Option o where o.name = :name")
    //   .setParameter("name", "audits")
    //   .getSingleResult(); // TODO:

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
