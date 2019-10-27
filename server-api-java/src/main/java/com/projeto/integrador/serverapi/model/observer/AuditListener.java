package com.projeto.integrador.serverapi.model.observer;

import javax.persistence.EntityManager;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.transaction.Transactional;

import com.projeto.integrador.serverapi.auditor.BeanUtil;
import com.projeto.integrador.serverapi.model.Audit;
import com.projeto.integrador.serverapi.model.Option;
import com.projeto.integrador.serverapi.service.OptionService;

import static javax.transaction.Transactional.TxType.MANDATORY;

public class AuditListener {

  @PrePersist
  public void prePersist(Object auditable) {
    perform(auditable, "CREATED");
  }

  @PreUpdate
  public void preUpdate(Object auditable) {
    perform(auditable, "UPDATED");
  }

  @PreRemove
  public void preRemove(Object auditable) {
    perform(auditable, "DELETED");
  }

  @Transactional(MANDATORY)
  private void perform(Object auditable, String action) {
    if (OptionService.auditsEnabled() || auditable.getClass().equals(Option.class)) {

        EntityManager entityManager = BeanUtil.getBean(EntityManager.class);

        entityManager.persist(new Audit(auditable, action));
    }
  }

}
