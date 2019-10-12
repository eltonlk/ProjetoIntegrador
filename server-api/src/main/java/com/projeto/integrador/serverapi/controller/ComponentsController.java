package com.projeto.integrador.serverapi.controller;

import com.projeto.integrador.serverapi.model.Component;
import com.projeto.integrador.serverapi.model.ComponentMaterial;
import com.projeto.integrador.serverapi.model.Face;
import com.projeto.integrador.serverapi.repository.ComponentsRepository;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping({"/components"})
@PreAuthorize("hasRole('ROLE_COMPONENTS')")
public class ComponentsController {

  private ComponentsRepository repository;

  ComponentsController(ComponentsRepository componentsRepository) {
    this.setRepository(componentsRepository);
  }

  public ComponentsRepository getRepository() {
    return repository;
  }

  public void setRepository(ComponentsRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
  public List<Component> findAll(){
    return repository.findAll();
  }

  @GetMapping(path = {"/{id}"})
  @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
  public ResponseEntity<Component> findById(@PathVariable long id) {
    return repository.findById(id)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasAuthority('CREATE_PRIVILEGE')")
  public Component create(@RequestBody Component component) {
    return repository.save(component);
  }

  @PutMapping(value="/{id}")
  @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE')")
  public ResponseEntity<Component> update(@PathVariable("id") long id, @RequestBody Component component) {
    return repository.findById(id)
      .map(record -> {
        record.setName(component.getName());
        record.setArea(component.getArea());
        record.setHeatFlow(component.getHeatFlow());
        record.setFace(component.getFace());
        record.setColor(component.getColor());

        // record.setHeatFlow(heatFlowCalculatedFor(record));

        Component updated = repository.save(record);

        return ResponseEntity.ok().body(updated);
      }).orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping(path ={"/{id}"})
  @PreAuthorize("hasAuthority('DELETE_PRIVILEGE')")
  public ResponseEntity<?> delete(@PathVariable long id) {
    return repository.findById(id)
      .map(record -> {
        repository.delete(record);

        return ResponseEntity.ok().build();
      }).orElse(ResponseEntity.notFound().build());
  }

  private double heatFlowCalculatedFor(Component component) {
    double resistance = 0;
    resistance += 0.04; // TODO: External Surface Resistance;
    resistance += 0.13; // TODO: Internal Surface Resistance, get flow by user params;

    if (component.getComponentMaterials() != null) {
      for (ComponentMaterial componentMaterial : component.getComponentMaterials()) {
        resistance += componentMaterial.getResistance();
      }
    }

    double thermalTransmittance = component.getArea() / resistance;

    double u = thermalTransmittance;
    double a = component.getColor().getAbsorbabilityIndex();
    double i = getSolarRadiationOrientationIndex(component.getFace());
    double rse = 0.04;
    double te = component.getFace().getRoom().getProject().getExternalTemperature();
    double ti = component.getFace().getRoom().getProject().getInternalTemperature();

    String season = component.getFace().getRoom().getProject().getSeason();

    // TODO: check if it is a glass;
    // u * ( te - ti ) + fs * i;

    if ("winter".equals(season)) {
      return  u * ( te - ti );
    } else if ("summer".equals(season)) {
      return u * ( a * i * rse + te - ti );
    } else {
      return 0;
    }
  }

  private int getSolarRadiationOrientationIndex(Face face) {
    switch(face.getOrientation()) {
      case "north":
        return face.getRoom().getProject().getSolarRadiation().getNorthIndex();
      case "north_east":
        return face.getRoom().getProject().getSolarRadiation().getNorthEastIndex();
      case "east":
        return face.getRoom().getProject().getSolarRadiation().getEastIndex();
      case "south_east":
        return face.getRoom().getProject().getSolarRadiation().getSouthEastIndex();
      case "south":
        return face.getRoom().getProject().getSolarRadiation().getSouthIndex();
      case "south_west":
        return face.getRoom().getProject().getSolarRadiation().getSouthWestIndex();
      case "west":
        return face.getRoom().getProject().getSolarRadiation().getWestIndex();
      case "north_west":
        return face.getRoom().getProject().getSolarRadiation().getNorthWestIndex();
      default:
        return 0;
    }
  }

}
