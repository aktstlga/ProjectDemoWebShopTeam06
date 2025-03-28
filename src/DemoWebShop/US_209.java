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
        WebElement logın= driver.findElement(By.xpath("//a[@class='ico-login']"));
        wait.until(ExpectedConditions.visibilityOf(logın));
        logın.click();
        WebElement email= driver.findElement(By.xpath("//input[@class='email']"));
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys("team006test@gmail.com");
        WebElement password= driver.findElement(By.xpath("//input[@class='password']"));
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys("Password123");
        WebElement logınbutton= driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        wait.until(ExpectedConditions.visibilityOf(logınbutton));
        logınbutton.click();
        WebElement account= driver.findElement(By.xpath("(//a[@class='account'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(account));
        account.click();
        WebElement orders= driver.findElement(By.xpath("(//*[text()='Orders'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(orders));
        orders.click();
        WebElement details= driver.findElement(By.xpath("(//input[@value='Details'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(details));
        details.click();
        WebElement pdfbutton= driver.findElement(By.xpath("//a[@class='button-2 pdf-order-button']"));
        wait.until(ExpectedConditions.visibilityOf(pdfbutton));
        pdfbutton.click();

    }
}
