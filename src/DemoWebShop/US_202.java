package DemoWebShop;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class US_202 extends BaseDriver {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    @Test
    public void negativeRegisterUser() {

        driver.get("https://demowebshop.tricentis.com/");

        WebElement registerButton = driver.findElement(By.className("ico-register"));
        waitForVisibilityAndClickThanClick(registerButton);

        wait.until(ExpectedConditions.urlContains("register"));

        WebElement firstName = driver.findElement(By.id("FirstName"));
        fillingThePlaceholderWithWait(firstName, "Testing");

        WebElement lastName = driver.findElement(By.id("LastName"));
        fillingThePlaceholderWithWait(lastName, "Tester");

        WebElement email = driver.findElement(By.id("Email"));
        fillingThePlaceholderWithWait(email, "team006test@gmail.com");

        WebElement password = driver.findElement(By.id("Password"));
        fillingThePlaceholderWithWait(password, "Password123");

        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        fillingThePlaceholderWithWait(confirmPassword, "Password123");

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Register'][@type='submit']")));
        submitButton.click();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-error")));

        String actualMessage = errorMessage.getText();
        String expectedMessage = "The specified email already exists";
        Assert.assertEquals(expectedMessage, actualMessage);

        driver.quit();
    }

    public void waitForVisibilityAndClickThanClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void fillingThePlaceholderWithWait(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }
}
