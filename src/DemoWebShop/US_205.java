package DemoWebShop;

import Utility.BaseDriver;
import Utility.Myfunc;
import com.google.common.annotations.VisibleForTesting;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class US_205 extends BaseDriver {

    @Test()
    public void PleaseFillTheMissingField(){
        driver.get("https://demowebshop.tricentis.com/");

        WebElement login = driver.findElement(By.className("ico-login"));
        waitForVisibilityAndClickThanClick(login);

        wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/login"));

        WebElement email = driver.findElement(By.className("email"));
        fillingThePlaceholderWithWait(email, "");

        WebElement password = driver.findElement(By.className("password"));
        fillingThePlaceholderWithWait(password, "");

        WebElement submitButton = driver.findElement(By.cssSelector("input[value='Log in'][type='submit']"));
        waitForVisibilityAndClickThanClick(submitButton);

        wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com"));
        Assert.assertTrue("Aranan mesaj bulunamadı.", driver.getCurrentUrl().contains("https://demowebshop.tricentis.com"));

        Myfunc.wait(2);
    }
    @Test
    public void falsePassword(){
        Driver();
        driver.get("https://demowebshop.tricentis.com/");

        WebElement login = driver.findElement(By.className("ico-login"));
        waitForVisibilityAndClickThanClick(login);

        wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/login"));

        WebElement email = driver.findElement(By.className("email"));
        fillingThePlaceholderWithWait(email, "team006test@gmail.com");

        WebElement password = driver.findElement(By.className("password"));
        fillingThePlaceholderWithWait(password,"");

        WebElement submitButton = driver.findElement(By.cssSelector("input[value='Log in'][type='submit']"));
        waitForVisibilityAndClickThanClick(submitButton);

        wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com"));
        Assert.assertTrue("Aranan mesaj bulunamadı.",driver.getCurrentUrl().contains("https://demowebshop.tricentis.com"));

        Myfunc.wait(2);
    }
    @Test
    public void falseEmail(){
        driver.get("https://demowebshop.tricentis.com/");

        WebElement login = driver.findElement(By.className("ico-login"));
        waitForVisibilityAndClickThanClick(login);

        wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/login"));

        WebElement email = driver.findElement(By.className("email"));
        fillingThePlaceholderWithWait(email, "");

        WebElement password = driver.findElement(By.className("password"));
        fillingThePlaceholderWithWait(password,"Password123");

        WebElement submitButton = driver.findElement(By.cssSelector("input[value='Log in'][type='submit']"));
        waitForVisibilityAndClickThanClick(submitButton);

        wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com"));
        Assert.assertTrue("Aranan mesaj bulunamadı.",driver.getCurrentUrl().contains("https://demowebshop.tricentis.com"));

        Myfunc.wait(2);
    }
}
