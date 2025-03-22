package DemoWebShop;

import Utility.BaseDriver;
import org.junit.Assert;
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

        WebElement passwordPlaceholder=driver.findElement(By.id("Password"));
        waitDuration.until(ExpectedConditions.visibilityOf(passwordPlaceholder));
        waitDuration.until(ExpectedConditions.elementToBeClickable(passwordPlaceholder));
        actionDriver.moveToElement(passwordPlaceholder).click().sendKeys("Password123").build().perform();

        WebElement submitButton=driver.findElement(By.cssSelector("input[value='Log in'][type='submit']"));
        waitDuration.until(ExpectedConditions.visibilityOf(submitButton));
        waitDuration.until(ExpectedConditions.elementToBeClickable(submitButton));
        actionDriver.moveToElement(submitButton).click().build().perform();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        Assert.assertTrue("Anasayfaya yönlendirildi.",driver.getCurrentUrl().contains("https://demowebshop.tricentis.com/"));

        WebElement loggedAccount = driver.findElement(By.cssSelector("a[href='/customer/info'][class='account']"));
        waitDuration.until(ExpectedConditions.visibilityOf(loggedAccount));
        Assert.assertTrue("Doğru hesaba giriş yapıldı",loggedAccount.getText().contains("team006test@gmail.com"));
    }
}
