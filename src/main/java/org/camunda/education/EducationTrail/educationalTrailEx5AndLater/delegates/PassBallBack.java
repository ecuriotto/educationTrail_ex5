package org.camunda.education.EducationTrail.educationalTrailEx5AndLater.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PassBallBack implements JavaDelegate {

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    Integer goodPass = (Integer) execution.getVariable("goodPass");
    String childBusinessKey = execution.getBusinessKey();

    execution.getProcessEngineServices().getRuntimeService()
        .createMessageCorrelation("ballPassedBack").setVariable("goodPass", goodPass)
        .processInstanceBusinessKey(childBusinessKey).correlate();

  }

}
