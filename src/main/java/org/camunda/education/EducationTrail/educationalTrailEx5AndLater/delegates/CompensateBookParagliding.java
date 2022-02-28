package org.camunda.education.EducationTrail.educationalTrailEx5AndLater.delegates;

import javax.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Named("compensateBookParagliding")
public class CompensateBookParagliding implements JavaDelegate {


  private final Logger LOGGER = LoggerFactory.getLogger(CompensateBookParagliding.class.getName());

  public void execute(DelegateExecution execution) throws Exception {

    execution.setVariable("paragliding", Boolean.FALSE);
    execution.setVariable("hike", Boolean.FALSE);
    LOGGER.info("Compensate Booking paragliding.........");
  }
}


