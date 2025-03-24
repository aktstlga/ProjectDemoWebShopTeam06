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

        WebElement emailPlaceholder=driver.findElement(By.id("Email"));
        emailPlaceholder.sendKeys("team006test@gmail.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.quit();


    }
}
