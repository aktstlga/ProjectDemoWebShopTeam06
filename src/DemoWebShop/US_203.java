package DemoWebShop;

import Utility.BaseDriver;
import Utility.Myfunc;
import com.google.common.annotations.VisibleForTesting;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class US_203 extends BaseDriver {
    @Test
    public void LogOut(){

        driver.get("https://demowebshop.tricentis.com/");
        Myfunc.wait(2);

        WebElement Register = driver.findElement(By.xpath("//*[@class='ico-register']"));
        Actions actions =new Actions(driver);
        actions.moveToElement(Register).click().build().perform();

        WebElement radioMale = driver.findElement(By.id("gender-male"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(radioMale).click().build().perform();

        WebElement firstName = driver.findElement(By.id("FirstName"));
        Actions action2 = new Actions(driver);
        action2.moveToElement(firstName).click().sendKeys("arif").build().perform();

        WebElement lastName = driver.findElement(By.id("LastName"));
        Actions action3 = new Actions(driver);
        action3.moveToElement(lastName).click().sendKeys("etili").build().perform();

        WebElement Email = driver.findElement(By.id("Email"));
        Actions action4 = new Actions(driver);
        action4.moveToElement(Email).click().sendKeys("etili7@hotmail.com").build().perform();

        WebElement Password = driver.findElement(By.id("Password"));
        Actions action5 = new Actions(driver);
        action5.moveToElement(Password).click().sendKeys("123456").build().perform();

        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        Actions action6 = new Actions(driver);
        action6.moveToElement(confirmPassword).click().sendKeys("123456").build().perform();

        WebElement btnRegister = driver.findElement(By.id("register-button"));
        Actions action7 = new Actions(driver);
        action7.moveToElement(btnRegister).click().build().perform();

        WebElement RegCnt = driver.findElement(By.xpath("//*[@class='button-1 register-continue-button']"));
        Actions actioncnt = new Actions(driver);
        actioncnt.moveToElement(RegCnt).click().build().perform();

        WebElement btnLogOut = driver.findElement(By.xpath("//*[@class='ico-logout']"));
        Actions action11 = new Actions(driver);
        action11.moveToElement(btnLogOut).click().build().perform();

        Myfunc.wait(5);








    }
}
