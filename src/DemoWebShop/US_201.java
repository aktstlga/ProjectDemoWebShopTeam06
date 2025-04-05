package DemoWebShop;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class US_201 extends BaseDriver {

    @Test
    public void registerUser() {
    driver.get("https://demowebshop.tricentis.com/");
        WebElement register = driver.findElement(By.className("ico-register"));
        waitForVisibilityAndClickThanClick(register);


    }

}
