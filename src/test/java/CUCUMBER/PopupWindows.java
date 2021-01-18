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

public class PopupWindows extends TATOC{
    WebDriver driver;


    @Given("User is on Popup Windows page")
    public void userIsOnPopupWindowsPage() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        OpenPagePopUpWindows(driver);
        Assert.assertEquals(UserIsOnPopupWindowPage(driver),data.get("popup windows title"));
    }


    @When("click on launch window button and new window launches")
    public void clickOnLaunchWindowButton() {
        Assert.assertNotEquals(ClickOnLaunchWindowButton(driver),1);
    }

    @And("enter text on input box and click submit")
    public void enterTextOnInputBoxAndClickSubmit() {
        Assert.assertTrue(EnterTextOnInputBoxAndClickSubmit(driver));
    }

    @And("click on Proceed button")
    public void clickOnProceedButton() {
        Assert.assertTrue(ClickOnProceedButtonP(driver));
    }

    @Then("User moves to Cookie Handling page")
    public void userMovesToCookieHandlingPage() throws IOException {
        Assert.assertEquals(UserMovesToCookieHandlingPage(driver),data.get("cookie handling title"));
    }

}
