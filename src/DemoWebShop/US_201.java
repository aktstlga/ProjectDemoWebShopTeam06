package DemoWebShop;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class US_201 extends BaseDriver {

    @Test
    public void registerUser() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement register = driver.findElement(By.className("ico-register"));
        waitForVisibilityAndClickThanClick(register);

        wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/register"));

        WebElement gender = driver.findElement(By.id("gender-male"));
        waitForVisibilityAndClickThanClick(gender);

        WebElement firstName = driver.findElement(By.id("FirstName"));
        fillingThePlaceholderWithWait(firstName, "Baris");

        WebElement lastName = driver.findElement(By.id("LastName"));
        fillingThePlaceholderWithWait(lastName, "Sancar");

        WebElement emailPlaceholder = driver.findElement(By.id("Email"));
        fillingThePlaceholderWithWait(emailPlaceholder, "bariss.sancarr@gmail.com");


    }

}
