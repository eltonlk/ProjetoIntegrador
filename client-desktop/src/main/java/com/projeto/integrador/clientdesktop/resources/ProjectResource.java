package com.projeto.integrador.clientdesktop.resources;

import com.projeto.integrador.clientdesktop.config.RestTemplateResponseErrorHandler;
import com.projeto.integrador.clientdesktop.models.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProjectResource {

  final static String NAMESPACE = "/projects";

  private RestTemplate restTemplate;
  private RestTemplateResponseErrorHandler errorHandler;

  @Autowired
  public ProjectResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
    this.errorHandler = new RestTemplateResponseErrorHandler();

    this.restTemplate.setErrorHandler(errorHandler);
  }

  public Project[] getAll() {
    Project[] projects = restTemplate.getForObject(NAMESPACE, Project[].class);

    return projects;
  }

  public Project refresh(Project project) {
    return restTemplate.getForObject(NAMESPACE + "/{id}", Project.class, project.getId());
  }

  public Project create(Project project) {
    ResponseEntity<Project> responseEntity = restTemplate.postForEntity(NAMESPACE, project, Project.class);

    if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
      return responseEntity.getBody();
    } else {
      project.setErrors(errorHandler.getErrors());

      return project;
    }
  }

  public void update(Project project) {
    restTemplate.put(NAMESPACE + "/{id}", project, project.getId());

    if (errorHandler.getErrors() != null) {
      project.setErrors(errorHandler.getErrors());
    }
  }

  public void delete(Project project) {
    restTemplate.delete(NAMESPACE + "/{id}", project.getId());

    if (errorHandler.getErrors() != null) {
      project.setErrors(errorHandler.getErrors());
    }
  }

}
