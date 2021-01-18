package CUCUMBER;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;


public class GridGate extends TATOC {

    WebDriver driver;

    @Given("User is on GridGate Page")
    public void userIsOnGridGatePage() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        OpenPageGridGate(driver);
        String title = CheckIfUserOnGridPage(driver);
        Assert.assertEquals(title,data.get("grid gate title"));
    }

    @And("Green Box is visible")
    public void greenBoxIsVisible() {
        Assert.assertTrue(GreenBoxVisible(driver));

    }

    @When("User Clicks on the Green Box")
    public void userClicksOnTheGreenBox() {
        Assert.assertTrue(UserClicksOnTheGreenBox(driver));
    }


    @Then("User moves to Frame Dungeon Page")
    public void userMovesToFrameDungeonPage() throws IOException {
        Assert.assertEquals(UserIsNavigatedToFrameDungeonPage(driver),data.get("frame dungeon title"));

    }


}

