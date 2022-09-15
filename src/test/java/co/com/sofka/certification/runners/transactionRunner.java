package co.com.sofka.certification.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(glue = "co.com.sofka.certification.stepdefinitions",
features = "src/test/resources/features/ExitoBuy.feature",
tags = "@run2",
snippets = CucumberOptions.SnippetType.CAMELCASE)

public class transactionRunner {
}
