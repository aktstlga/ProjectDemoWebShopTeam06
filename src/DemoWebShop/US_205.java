package DemoWebShop;

import Utility.BaseDriver;
import com.google.common.annotations.VisibleForTesting;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class US_205 extends BaseDriver {

    @Test
    public void PleaseFillTheMissingField(){
        driver.get("https://demowebshop.tricentis.com/");

        WebElement login = driver.findElement(By.className("ico-login"));
        login.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

        WebElement email = driver.findElement(By.className("email"));
        email.sendKeys("");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        password.sendKeys("");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();

        WebElement demoWebShop = driver.findElement(By.cssSelector("div[class='header-logo]'"));
        Assert.assertTrue("Aranan mesaj bulunamadı",demoWebShop.getText().contains("Demo Web Shop"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

        driver.quit();
    }
}
