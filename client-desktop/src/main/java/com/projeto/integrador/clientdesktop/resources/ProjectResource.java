package com.projeto.integrador.clientdesktop.resources;

import com.projeto.integrador.clientdesktop.models.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProjectResource {

  final static String NAMESPACE = "/projects";

  private RestTemplate restTemplate;

  @Autowired
  public ProjectResource(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
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

    Project createdProject = null;

    if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
      createdProject = responseEntity.getBody();
    }

    return createdProject;
  }

  public void update(Project project) {
    restTemplate.put(NAMESPACE + "/{id}", project, project.getId());
  }

  public void delete(Project project) {
    restTemplate.delete(NAMESPACE + "/{id}", project.getId());
  }

  public void sendMail(Project project, String email) {
    String uri = NAMESPACE + "/" + project.getId() + "/send_mail?email=" + email;

    restTemplate.execute(uri, HttpMethod.POST, null, null);
  }

}
