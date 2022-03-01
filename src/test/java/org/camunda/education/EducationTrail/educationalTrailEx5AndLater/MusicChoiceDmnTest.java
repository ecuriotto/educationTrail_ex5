package org.camunda.education.EducationTrail.educationalTrailEx5AndLater;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.*;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.assertThat;
import java.util.HashMap;
import java.util.Map;
import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.extension.process_test_coverage.junit5.ProcessEngineCoverageExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
@ExtendWith(ProcessEngineCoverageExtension.class)
public class MusicChoiceDmnTest {

  @Test
  // @Deployment(resources = "tweetApproval.dmn")
  @Deployment(resources = {"musicChoice.dmn"})
  public void moodHappyAndTime8ShouldReturnSantana() {
    Map<String, Object> variables = withVariables("mood", "happy", "timeInDay", 8);
    DmnDecisionTableResult decisionResult =
        decisionService().evaluateDecisionTableByKey("musicChoice", variables);
    assertThat(decisionResult.getFirstResult()).containsEntry("singer", "Santana");
  }

  @Test
  @Deployment(resources = {"musicChoiceProcess.bpmn", "musicChoice.dmn"})
  public void testHappyPath() {
    Map<String, Object> variables = new HashMap();
    variables.put("mood", "happy");
    variables.put("timeInDay", 8);

    ProcessInstance processInstance =
        runtimeService().startProcessInstanceByKey("musicChoiceProcess", variables);

    assertThat(processInstance).isStarted();

    // Execute ht
    complete(task());

    // execute dmn table
    job();

    assertThat(processInstance).isEnded();
  }

}
