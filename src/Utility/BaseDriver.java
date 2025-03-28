package Utility;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseDriver {
    public static WebDriver driver;

    public  Actions actionDriver = new Actions(driver);
    public  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    static {

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("autofill.profile_enabled", false);
        prefs.put("autofill.credit_card_enabled", false);
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
        wait.until(ExpectedConditions.visibilityOf(locatedElement));
        wait.until(ExpectedConditions.elementToBeClickable(locatedElement));
        locatedElement.clear();
        actionDriver.moveToElement(locatedElement).click().sendKeys(sendkeysText).build().perform();
    }

    public void waitForVisibilityAndClickThanClick(WebElement foundLocator) {
        wait.until(ExpectedConditions.visibilityOf(foundLocator));
        wait.until(ExpectedConditions.elementToBeClickable(foundLocator));
        actionDriver.moveToElement(foundLocator).click().build().perform();
    }

    public void loginMethodAccordingToUs_204() {
        WebElement login = driver.findElement(By.className("ico-login"));
        waitForVisibilityAndClickThanClick(login);

        wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/login"));

        WebElement emailPlaceholder = driver.findElement(By.id("Email"));
        fillingThePlaceholderWithWait(emailPlaceholder, "team006test@gmail.com");

        WebElement passwordPlaceHolder = driver.findElement(By.cssSelector("[type='password']"));
        fillingThePlaceholderWithWait(passwordPlaceHolder, "Password123");

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        waitForVisibilityAndClickThanClick(loginButton);

        wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/"));
        Assert.assertTrue("Anasayfaya yönlendirilemedi.", driver.getCurrentUrl().contains("https://demowebshop.tricentis.com/"));

        WebElement loggedAccount = driver.findElement(By.cssSelector("a[href='/customer/info'][class='account']"));
        wait.until(ExpectedConditions.visibilityOf(loggedAccount));
        Assert.assertTrue("Doğru hesaba giriş yapılamadı.", loggedAccount.getText().contains("team006test@gmail.com"));
    }
}
