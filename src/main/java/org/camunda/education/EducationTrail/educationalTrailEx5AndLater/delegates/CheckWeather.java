package org.camunda.education.EducationTrail.educationalTrailEx5AndLater.delegates;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import camundajar.impl.com.google.gson.Gson;
import camundajar.impl.com.google.gson.JsonObject;
import camundajar.impl.com.google.gson.JsonParser;


@Named("weather")
public class CheckWeather implements JavaDelegate {


  private final Logger LOGGER = LoggerFactory.getLogger(CheckWeather.class.getName());

  public void execute(DelegateExecution execution) throws Exception {

    List<String> myListOfStrings = new ArrayList<String>();
    myListOfStrings.add("firstElement");
    myListOfStrings.add("secondElement");

    Map<String, Integer> myMapOfIntegers = new HashMap<String, Integer>();
    myMapOfIntegers.put("Jenny", 35);
    myMapOfIntegers.put("Tobias", 12);

    execution.setVariable("weatherGood", Boolean.TRUE);
    execution.setVariable("thisIsDouble", Double.valueOf("3.0"));
    execution.setVariable("thisIsInteger", Integer.valueOf(34));
    execution.setVariable("thisIsList", myListOfStrings);
    execution.setVariable("thisIsMap", myMapOfIntegers);

    String json = "{ \"name\": \"Enrico\", \"guitar player\": true }";
    JsonObject personJson = new JsonParser().parse(json).getAsJsonObject();
    execution.setVariable("personJson", personJson);

    String content = "Hello World \r\nJava!\r\n";
    String path = "app.log";
    File myFile = null;
    try {

      // Java 7
      Files.write(Paths.get(path), content.getBytes());
      myFile = new File("app.log");
      execution.setVariable("myFile", myFile);
    } catch (IOException e) {
      e.printStackTrace();
    }


    LOGGER.info("Checking weather.........");
  }
}
