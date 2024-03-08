package com.example.sakiladb;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com.example.sakiladb", // path to the features
        glue = "com.example.sakiladb", // the package where step definitions are located
        plugin = {"pretty", "html:target/cucumber-reports"}// plugins for reporting
)
public class RunCucumberTest {
}
