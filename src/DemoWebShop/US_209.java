package DemoWebShop;

import Utility.BaseDriver;
import com.google.common.annotations.VisibleForTesting;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class US_209 extends BaseDriver {
    @Test
    public void US_209(){
        driver.get("https://demowebshop.tricentis.com/");
        WebElement logınbutton= driver.findElement(By.xpath("//a[@class='ico-login']"));
        wait.until(ExpectedConditions.visibilityOf(logınbutton));
        logınbutton.click();


    }
}
