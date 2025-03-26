package DemoWebShop;

import Utility.BaseDriver;
import com.google.common.annotations.VisibleForTesting;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class US_205 extends BaseDriver {
    WebDriverWait waitDuration = new WebDriverWait(driver, Duration.ofSeconds(120));

    @Test
    public void PleaseFillTheMissingField(){
        driver.get("https://demowebshop.tricentis.com/");

        WebElement login = driver.findElement(By.className("ico-login"));
        waitForVisibilityAndClickThanClick(login);

        waitDuration.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/login"));

        WebElement email = driver.findElement(By.className("email"));
        fillingThePlaceholderWithWait(email, "");

        WebElement password = driver.findElement(By.className("password"));
        fillingThePlaceholderWithWait(password,"");

        WebElement submitButton = driver.findElement(By.cssSelector("input[value='Log in'][type='submit']"));
        waitForVisibilityAndClickThanClick(submitButton);

        waitDuration.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com"));
        Assert.assertTrue("Aranan mesaj bulunamadı.",driver.getCurrentUrl().contains("https://demowebshop.tricentis.com"));

        driver.quit();
    }
    @Test
    public void falsePassword(){
        driver.get("https://demowebshop.tricentis.com/");

        WebElement login = driver.findElement(By.className("ico-login"));
        waitForVisibilityAndClickThanClick(login);

        waitDuration.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/login"));

        WebElement email = driver.findElement(By.className("email"));
        fillingThePlaceholderWithWait(email, "team006test@gmail.com");

        WebElement password = driver.findElement(By.className("password"));
        fillingThePlaceholderWithWait(password,"");

        WebElement submitButton = driver.findElement(By.cssSelector("input[value='Log in'][type='submit']"));
        waitForVisibilityAndClickThanClick(submitButton);

        waitDuration.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com"));
        Assert.assertTrue("Aranan mesaj bulunamadı.",driver.getCurrentUrl().contains("https://demowebshop.tricentis.com"));

        driver.quit();
    }
    @Test
    public void falseEmail(){
        driver.get("https://demowebshop.tricentis.com/");

        WebElement login = driver.findElement(By.className("ico-login"));
        waitForVisibilityAndClickThanClick(login);

        waitDuration.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/login"));

        WebElement email = driver.findElement(By.className("email"));
        fillingThePlaceholderWithWait(email, "");

        WebElement password = driver.findElement(By.className("password"));
        fillingThePlaceholderWithWait(password,"Password123");

        WebElement submitButton = driver.findElement(By.cssSelector("input[value='Log in'][type='submit']"));
        waitForVisibilityAndClickThanClick(submitButton);

        waitDuration.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com"));
        Assert.assertTrue("Aranan mesaj bulunamadı.",driver.getCurrentUrl().contains("https://demowebshop.tricentis.com"));

        driver.quit();
    }
}
