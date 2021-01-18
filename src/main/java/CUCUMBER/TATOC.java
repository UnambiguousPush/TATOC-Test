package CUCUMBER;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;

public class TATOC {


    YamlDataProvider data = new YamlDataProvider();

    //-------------------------------GRID GATE ------------------------------------------//

    public void OpenPageGridGate(WebDriver driver) throws IOException {
        driver.get(data.get("grid gate url"));
    }

    public String CheckIfUserOnGridPage(WebDriver driver) {

        return (driver.getTitle());
    }

    public boolean GreenBoxVisible(WebDriver driver) {
        return driver.findElements(By.className("greenbox")).size() == 1;

    }

    public boolean UserClicksOnTheGreenBox(WebDriver driver) {
        try {
            driver.findElement(By.className("greenbox")).click();
            return true;
        } catch (ElementNotVisibleException e) {
            return false;
        }
    }

    public String UserIsNavigatedToFrameDungeonPage(WebDriver driver) {

        return driver.getTitle();
    }


    //-----------------------------------FRAME DUNGEON--------------------------------------------//

    public void OpenPageFrameDungeon(WebDriver driver) throws IOException {
        driver.get(data.get("frame dungeon url"));
    }

    public String UserIsOnFrameDungeonPage(WebDriver driver) {
        return (driver.getTitle());
    }

    public String[] RepaintBoxTillBoxAndBoxHaveTheSameColour(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("main")));
        String box1color = driver.findElement(By.id("answer")).getAttribute("className");
        String box2color;
        String[] boxes = new String[2];
        while (true) {
            driver.switchTo().frame("child");
            box2color = driver.findElement(By.id("answer")).getAttribute("className");
            if (box1color.equalsIgnoreCase(box2color)) {
                break;
            }
            driver.switchTo().parentFrame();
            driver.findElement(By.linkText("Repaint Box 2")).click();
        }
        driver.switchTo().parentFrame();

        boxes[0] = box1color;
        boxes[1] = box2color;
        return boxes;
    }

    public boolean ClickOnProceedButton(WebDriver driver) {
        try {
            driver.findElement(By.linkText("Proceed")).click();
            return true;
        } catch (ElementNotVisibleException e) {
            return false;
        }
    }

    public String UserIsNavigatedToDragAroundPage(WebDriver driver) {
        return driver.getTitle();
    }

    //----------------------------------DRAG AROUND-------------------------------------//

    public void OpenPageDragAround(WebDriver driver) throws IOException {
        driver.get(data.get("drag around url"));
    }

    public String UserIsOnDragAroundPage(WebDriver driver) {
        return (driver.getTitle());
    }

    public boolean PerformDragAndDropAction(WebDriver driver) {
        try {
            Actions newAction = new Actions(driver);
            WebElement dragbox = driver.findElement(By.id("dragbox"));
            WebElement dropbox = driver.findElement(By.id("dropbox"));
            newAction.dragAndDrop(dragbox, dropbox).build().perform();
            return true;
        } catch (ElementNotVisibleException e) {
            return false;
        }
    }

    public boolean ClickProceedButton(WebDriver driver) {
        try {
            driver.findElement(By.linkText("Proceed")).click();
            return true;
        } catch (ElementNotVisibleException e) {
            return false;
        }
    }

    public String UserMovesToPopupWindowsPage(WebDriver driver) {
        return (driver.getTitle());
    }


    //

    //-------------------------------POPUP WINDOWS--------------------------------------//

    ArrayList<String> tabs2;

    public void OpenPagePopUpWindows(WebDriver driver) throws IOException {
        driver.get(data.get("pop up url"));
    }

    public String UserIsOnPopupWindowPage(WebDriver driver) {
        return driver.getTitle();
    }

    public int ClickOnLaunchWindowButton(WebDriver driver) {
        driver.findElement(By.linkText("Launch Popup Window")).click();
        tabs2 = new ArrayList<String>(driver.getWindowHandles());
        return (tabs2.size());
    }

    public boolean EnterTextOnInputBoxAndClickSubmit(WebDriver driver) {
        try {
            driver.switchTo().window(tabs2.get(1));
            driver.findElement(By.id("name")).sendKeys("Test");
            driver.findElement(By.id("submit")).click();
            driver.switchTo().window(tabs2.get(0));
            return true;
        } catch (ElementNotVisibleException e) {
            return false;
        }

    }

    public boolean ClickOnProceedButtonP(WebDriver driver) {
        try {
            driver.findElement(By.linkText("Proceed")).click();
            return true;
        } catch (ElementNotVisibleException e) {
            return false;
        }
    }

    public String UserMovesToCookieHandlingPage(WebDriver driver) {
        return driver.getTitle();
    }

    //-----------------------Cookie Handling--------------------------------------//

    String cookieValue;

    public void OpenPageCookieHandling(WebDriver driver) throws IOException {
        driver.get(data.get("cookie handling url"));
    }

    public String UserIsOnCookieHandlingPage(WebDriver driver) {
        return driver.getTitle();
    }

    public boolean ClickOnGenerateTokenButton(WebDriver driver) {
        driver.findElement(By.linkText("Generate Token")).click();
        cookieValue = driver.findElement(By.id("token")).getText();
        return (cookieValue == null);
    }

    public boolean AddTheTokenToTheCookie(WebDriver driver) {
        try{
        Cookie cookie = new Cookie("Token", cookieValue.substring(7));
        driver.manage().addCookie(cookie);
        return true;}
        catch (ElementNotVisibleException e){
        return false;
        }
    }

    public boolean ClickProceed(WebDriver driver) {
        try {
            driver.findElement(By.linkText("Proceed")).click();
            return true;
        } catch (ElementNotVisibleException e) {
            return false;
        }
    }

    public String UserMovesToTheEndPage(WebDriver driver){
        return driver.getTitle();
    }
}




