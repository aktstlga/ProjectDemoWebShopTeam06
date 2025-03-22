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



    }
}
