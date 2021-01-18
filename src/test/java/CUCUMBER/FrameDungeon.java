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

public class FrameDungeon extends  TATOC{
    WebDriver driver;

    @Given("User is on FrameDungeon page")
    public void userIsOnFrameDungeonPage() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        OpenPageFrameDungeon(driver);
        Assert.assertEquals(UserIsOnFrameDungeonPage(driver),data.get("frame dungeon title"));
    }

    @When("Repaint Box 2 till Box 1 and Box 2 have the same colour")
    public void repaintBoxTillBoxAndBoxHaveTheSameColour() {
        String[] boxes = RepaintBoxTillBoxAndBoxHaveTheSameColour(driver);
        Assert.assertEquals(boxes[0],boxes[1]);
        
    }

    @And("Click on proceed button")
    public void clickOnProceedButton() {
        Assert.assertTrue(ClickOnProceedButton(driver));
    }

    @Then("User moves to Drag Around Page")
    public void userMovesToDragAroundPage() throws IOException {
        Assert.assertEquals(UserIsNavigatedToDragAroundPage(driver),data.get("drag around title"));
    }

}
