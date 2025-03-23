package DemoWebShop;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class US_206 extends BaseDriver {
    @Test
    public void logInToAccount() {
        driver.get("https://demowebshop.tricentis.com");

        Actions actionDriver = new Actions(driver);
        WebDriverWait waitDuration = new WebDriverWait(driver, Duration.ofSeconds(120));

        WebElement logIn = driver.findElement(By.className("ico-login"));
        waitDuration.until(ExpectedConditions.visibilityOf(logIn));
        waitDuration.until(ExpectedConditions.elementToBeClickable(logIn));
        actionDriver.moveToElement(logIn).click().build().perform();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        WebElement emailPlaceholder = driver.findElement(By.id("Email"));
        waitDuration.until(ExpectedConditions.visibilityOf(emailPlaceholder));
        waitDuration.until(ExpectedConditions.elementToBeClickable(emailPlaceholder));
        actionDriver.moveToElement(emailPlaceholder).click().sendKeys("team006test@gmail.com").build().perform();

        WebElement passwordPlaceholder = driver.findElement(By.id("Password"));
        waitDuration.until(ExpectedConditions.visibilityOf(passwordPlaceholder));
        waitDuration.until(ExpectedConditions.elementToBeClickable(passwordPlaceholder));
        actionDriver.moveToElement(passwordPlaceholder).click().sendKeys("Password123").build().perform();

        WebElement submitButton = driver.findElement(By.cssSelector("input[value='Log in'][type='submit']"));
        waitDuration.until(ExpectedConditions.visibilityOf(submitButton));
        waitDuration.until(ExpectedConditions.elementToBeClickable(submitButton));
        actionDriver.moveToElement(submitButton).click().build().perform();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        Assert.assertTrue("Anasayfaya yönlendirildi.", driver.getCurrentUrl().contains("https://demowebshop.tricentis.com/"));

        WebElement loggedAccount = driver.findElement(By.cssSelector("a[href='/customer/info'][class='account']"));
        waitDuration.until(ExpectedConditions.visibilityOf(loggedAccount));
        Assert.assertTrue("Doğru hesaba giriş yapıldı", loggedAccount.getText().contains("team006test@gmail.com"));

        WebElement featuredProduct = driver.findElement(By.cssSelector("div[class='product-item'][data-productid='31']"));
        waitDuration.until(ExpectedConditions.visibilityOf(featuredProduct));
        actionDriver.moveToElement(featuredProduct).build().perform();

        WebElement featuredProductButton = driver.findElement(By.cssSelector("div[class='product-item'][data-productid='31']> *:nth-child(2)> *:nth-child(4)> *:nth-child(2)> *:nth-child(1)"));
        waitDuration.until(ExpectedConditions.elementToBeClickable(featuredProductButton));
        actionDriver.moveToElement(featuredProductButton).click().build().perform();

        WebElement addedNotification = driver.findElement(By.id("bar-notification"));
        waitDuration.until(ExpectedConditions.visibilityOf(addedNotification));
        Assert.assertTrue("Başarılı şekilde sepete eklendi.", addedNotification.getText().contains("The product has been added to your shopping cart"));

        WebElement closeNotification = driver.findElement(By.cssSelector("span[class='close'][title='Close']"));
        waitDuration.until(ExpectedConditions.visibilityOf(closeNotification));
        waitDuration.until(ExpectedConditions.elementToBeClickable(closeNotification));
        actionDriver.moveToElement(closeNotification).click().build().perform();

        WebElement shoppingCartButton = driver.findElement(By.cssSelector("a[href='/cart'][class='ico-cart']"));
        waitDuration.until(ExpectedConditions.visibilityOf(shoppingCartButton));
        waitDuration.until(ExpectedConditions.elementToBeClickable(shoppingCartButton));
        actionDriver.moveToElement(shoppingCartButton).click().build().perform();

        WebElement goToCartButton = driver.findElement(By.cssSelector("input[type='button'][value='Go to cart']"));
        waitDuration.until(ExpectedConditions.visibilityOf(goToCartButton));
        waitDuration.until(ExpectedConditions.elementToBeClickable(goToCartButton));
        actionDriver.moveToElement(goToCartButton).click().build().perform();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        Assert.assertTrue("Shopping Cart kısmına giremedi.",driver.getCurrentUrl().contains("https://demowebshop.tricentis.com/cart"));

        WebElement countrySelectList = driver.findElement(By.cssSelector("select[id='CountryId'][name='CountryId']"));
        waitDuration.until(ExpectedConditions.visibilityOf(countrySelectList));
        waitDuration.until(ExpectedConditions.elementToBeClickable(countrySelectList));
        actionDriver.moveToElement(countrySelectList).click().build().perform();
        new Select(countrySelectList).selectByIndex(1);

        WebElement stateSelectList = driver.findElement(By.cssSelector("select[id='StateProvinceId'][name='StateProvinceId']"));
        waitDuration.until(ExpectedConditions.visibilityOf(stateSelectList));
        waitDuration.until(ExpectedConditions.elementToBeClickable(stateSelectList));
        actionDriver.moveToElement(stateSelectList).click().build().perform();
        new Select(stateSelectList).selectByIndex(3);

        WebElement checkBoxForTermsOfService=driver.findElement(By.id("termsofservice"));
        waitDuration.until(ExpectedConditions.visibilityOf(checkBoxForTermsOfService));
        waitDuration.until(ExpectedConditions.elementToBeClickable(checkBoxForTermsOfService));
        actionDriver.moveToElement(checkBoxForTermsOfService).click().build().perform();
    }
}
