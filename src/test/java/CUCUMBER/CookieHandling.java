package CUCUMBER;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.IOException;

public class CookieHandling extends TATOC{

    WebDriver driver;
        
    @Given("User is on Cookie Handling page")
    public void userIsOnCookieHandlingPage() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        OpenPageCookieHandling(driver);
        Assert.assertEquals(UserIsOnCookieHandlingPage(driver),data.get("cookie handling title"));
        }

    @When("Click on Generate Token button")
    public void clickOnGenerateTokenButton() {
        Assert.assertFalse(ClickOnGenerateTokenButton(driver));
    }

    @And("Add the Token to the Cookie")
    public void addTheTokenToTheCookie() {
        Assert.assertTrue(AddTheTokenToTheCookie(driver));
    }

    @And("Click Proceed")
    public void clickProceed() {
        Assert.assertTrue(ClickProceed(driver));
    }

    @Then("User moves to the End page")
    public void userMovesToTheEndPage() throws IOException {
        Assert.assertEquals(UserMovesToTheEndPage(driver),data.get("end page title"));
    }

}
