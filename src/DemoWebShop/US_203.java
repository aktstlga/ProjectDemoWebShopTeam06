package DemoWebShop;

import Utility.BaseDriver;
import Utility.Myfunc;
import com.google.common.annotations.VisibleForTesting;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

public class US_203 extends BaseDriver {
    @Test
    public void LogOut(){
        driver.get("https://demowebshop.tricentis.com/");
        loginMethodAccordingToUs_204();

        WebElement btnnLogOut = driver.findElement(By.xpath("//*[@class='ico-logout']"));
        actionDriver.moveToElement(btnnLogOut).click().build().perform();

        WebElement btnLogin = driver.findElement(By.xpath("//*[@class='ico-login']"));
        Assert.assertTrue("Ana Sayfaya Dönüş Olmadı.",btnLogin.getText().contains("Log in"));
        System.out.println("Ana sayfaya başarılı dönüş oldu.");
    }
}
