package org.camunda.education.EducationTrail.educationalTrailEx5AndLater.delegates;

import javax.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Named("bookParagliding")
public class BookParagliding implements JavaDelegate {


  private final Logger LOGGER = LoggerFactory.getLogger(BookParagliding.class.getName());

  public void execute(DelegateExecution execution) throws Exception {

    execution.setVariable("paragliding", Boolean.TRUE);
    execution.setVariable("hike", Boolean.FALSE);
    LOGGER.info("Booking paragliding.........");
  }
}
