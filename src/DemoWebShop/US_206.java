package DemoWebShop;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class US_206 extends BaseDriver {
    @Test
    public void logInToAccount(){
        driver.get("https://demowebshop.tricentis.com");

        Actions actionDriver=new Actions(driver);
        WebDriverWait waitDuration = new WebDriverWait(driver, Duration.ofSeconds(120));

        WebElement logIn = driver.findElement(By.className("ico-login"));
        waitDuration.until(ExpectedConditions.visibilityOf(logIn));
        waitDuration.until(ExpectedConditions.elementToBeClickable(logIn));
        actionDriver.moveToElement(logIn).click().build().perform();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        WebElement emailPlaceholder = driver.findElement(By.id("Email"));
        waitDuration.until(ExpectedConditions.visibilityOf(emailPlaceholder));
        waitDuration.until(ExpectedConditions.elementToBeClickable(emailPlaceholder));
        actionDriver.moveToElement(emailPlaceholder).click().sendKeys("team006test@gmail.com").build().perform();
    }
}
