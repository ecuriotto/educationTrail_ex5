package org.camunda.education.EducationTrail.educationalTrailEx5AndLater.delegates;

import javax.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Named("bookHike")
public class BookHike implements JavaDelegate {


  private final Logger LOGGER = LoggerFactory.getLogger(BookHike.class.getName());

  public void execute(DelegateExecution execution) throws Exception {

    execution.setVariable("paragliding", Boolean.FALSE);
    execution.setVariable("hike", Boolean.TRUE);
    LOGGER.info("Booking hike.........");
  }
}
