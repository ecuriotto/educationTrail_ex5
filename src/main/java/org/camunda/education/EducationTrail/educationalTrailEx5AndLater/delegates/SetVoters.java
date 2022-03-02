package org.camunda.education.EducationTrail.educationalTrailEx5AndLater.delegates;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Named("setVoters")
public class SetVoters implements JavaDelegate {


  private final Logger LOGGER = LoggerFactory.getLogger(SetVoters.class.getName());

  public void execute(DelegateExecution execution) throws Exception {

    List<String> voters = new ArrayList<String>();
    voters.add("Pedra");
    voters.add("Pabla");
    execution.setVariable("voters", voters);
    LOGGER.info("Voters set.........");
  }
}
