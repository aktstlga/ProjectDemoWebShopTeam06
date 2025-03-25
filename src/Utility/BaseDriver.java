package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseDriver {
    public static WebDriver driver;
    Actions actionDriver = new Actions(driver);
    WebDriverWait waitDuration = new WebDriverWait(driver, Duration.ofSeconds(120));
    static {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("autofill.profile_enabled", false);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public static void Driver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void fillingThePlaceholderWithWait(WebElement locatedElement, String sendkeysText) {
        waitDuration.until(ExpectedConditions.visibilityOf(locatedElement));
        waitDuration.until(ExpectedConditions.elementToBeClickable(locatedElement));
        locatedElement.clear();
        actionDriver.moveToElement(locatedElement).click().sendKeys(sendkeysText).build().perform();
    }
    public void waitForVisibilityAndClickThanClick(WebElement foundLocator) {
        waitDuration.until(ExpectedConditions.visibilityOf(foundLocator));
        waitDuration.until(ExpectedConditions.elementToBeClickable(foundLocator));
        actionDriver.moveToElement(foundLocator).click().build().perform();
    }
}
