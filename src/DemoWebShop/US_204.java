package DemoWebShop;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class US_204 extends BaseDriver {
    @Test
    public void Login() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement login = driver.findElement(By.className("ico-login"));
        login.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement emailPlaceholder = driver.findElement(By.id("Email"));
        emailPlaceholder.sendKeys("team006test@gmail.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement passwordPlaceHolder = driver.findElement(By.cssSelector("[type='password']"));
        passwordPlaceHolder.sendKeys("Password123");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.quit();


    }
}
