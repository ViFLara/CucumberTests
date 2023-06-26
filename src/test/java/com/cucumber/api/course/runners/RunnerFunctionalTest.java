package com.cucumber.api.course.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/"},
        glue = {"com.cucumber.api.course.steps", "com.cucumber.api.course.config"},
        tags = {"@functionals"},
        plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
        monochrome = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = true,
        strict = false)
public class RunnerFunctionalTest {

    @BeforeClass
    public static void reset() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me");
        driver.findElement(By.id("email")).sendKeys("a@a");
        driver.findElement(By.name("email")).sendKeys("a");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("reset")).click();
        driver.quit();
    }
}
