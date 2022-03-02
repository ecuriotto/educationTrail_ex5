package org.camunda.education.EducationTrail.educationalTrailEx5AndLater.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PassBall implements JavaDelegate {

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    String parentBusinessKey = execution.getBusinessKey();
    execution.getProcessEngineServices().getRuntimeService().createMessageCorrelation("ballPassed")
        .processInstanceBusinessKey(parentBusinessKey).correlate();

  }

}
