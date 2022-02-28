package org.camunda.education.EducationTrail.educationalTrailEx5AndLater.delegates;

import javax.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Named("weather")
public class CheckWeather implements JavaDelegate {


  private final Logger LOGGER = LoggerFactory.getLogger(CheckWeather.class.getName());

  public void execute(DelegateExecution execution) throws Exception {

    execution.setVariable("weatherGood", Boolean.FALSE);

    LOGGER.info("Checking weather.........");
  }
}
