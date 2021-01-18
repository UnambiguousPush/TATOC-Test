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

public class DragAround extends  TATOC{
    WebDriver driver;

    @Given("User is on Drag Around page")
    public void userIsOnDragAroundPage() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        OpenPageDragAround(driver);
        Assert.assertEquals(UserIsOnDragAroundPage(driver),data.get("drag around title"));
    }

    @When("Perform Drag and Drop Action")
    public void performDragAndDropAction() {
        Assert.assertTrue(PerformDragAndDropAction(driver));
    }


    @And("Click proceed button")
    public void clickProceedButton() {
        Assert.assertTrue(ClickProceedButton(driver));
    }

    @Then("User moves to Popup Windows Page")
    public void userMovesToPopupWindowsPage() throws IOException {
        Assert.assertEquals(UserMovesToPopupWindowsPage(driver),data.get("popup windows title"));
    }

}
