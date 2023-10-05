package br.com.irrah.bigchatbrasil.infra.http.controller;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.irrah.bigchatbrasil.domain.models.PlanModel;
import br.com.irrah.bigchatbrasil.domain.usecases.plan.CreatePlan;

@RestController
@RequestMapping("plan")
public class PlanController {

  public final CreatePlan createPlan;

  public PlanController(CreatePlan createPlan) {
    this.createPlan = createPlan;
  }

  @PostMapping
  public ResponseEntity create(@RequestBody PlanModel plan) {

    try {
      createPlan.exec(plan);
      return new ResponseEntity(plan, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
    }

  }

}
