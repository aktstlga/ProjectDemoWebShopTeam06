package DemoWebShop;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class US_204 extends BaseDriver {
    Actions actionDriver = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

    @Test
    public void Login() {
        driver.get("https://demowebshop.tricentis.com/");

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

        driver.quit();
    }
}
