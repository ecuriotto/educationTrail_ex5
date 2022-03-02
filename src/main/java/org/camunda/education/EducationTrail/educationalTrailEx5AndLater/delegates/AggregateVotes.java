package org.camunda.education.EducationTrail.educationalTrailEx5AndLater.delegates;

import java.util.ArrayList;
import java.util.List;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

public class AggregateVotes implements TaskListener {

  @Override
  public void notify(DelegateTask delegateTask) {
    Boolean result = (Boolean) delegateTask.getVariable("voteVar");
    List<Boolean> resultAggregate = (List) delegateTask.getVariable("resultAggregate");
    if (resultAggregate == null) {
      resultAggregate = new ArrayList<Boolean>();
    }
    resultAggregate.add(result);
    delegateTask.setVariable("resultAggregate", resultAggregate);
    delegateTask.removeVariable("voteVar");
  }
}
