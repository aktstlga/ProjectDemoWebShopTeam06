package DemoWebShop;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class US_208 extends BaseDriver {

    @Test
    public void negativeUsingCoupons(){
        driver.get("https://demowebshop.tricentis.com");

        loginMethodAccordingToUs_204();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[class='top-menu']> *:nth-child(2)")));
        WebElement computerSection=driver.findElement(By.cssSelector("ul[class='top-menu']> *:nth-child(2)"));
        actionDriver.moveToElement(computerSection).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[class='top-menu']> *:nth-child(2)> *:nth-child(3)> *:nth-child(2)> *:nth-child(1)")));
        WebElement computerNotebookSection =driver.findElement(By.cssSelector("ul[class='top-menu']> *:nth-child(2)> *:nth-child(3)> *:nth-child(2)> *:nth-child(1)"));
        waitForVisibilityAndClickThanClick(computerNotebookSection);

        wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/notebooks"));
        WebElement addToCartNotebook= driver.findElement(By.cssSelector("div[class='add-info']> *:nth-child(2) >*:nth-child(1)"));
        waitForVisibilityAndClickThanClick(addToCartNotebook);

        WebElement addedNotification = driver.findElement(By.id("bar-notification"));
        wait.until(ExpectedConditions.visibilityOf(addedNotification));
        Assert.assertTrue("Başarılı şekilde sepete eklenemedi.", addedNotification.getText().contains("The product has been added to your shopping cart"));

        WebElement closeNotification = driver.findElement(By.cssSelector("span[class='close'][title='Close']"));
        waitForVisibilityAndClickThanClick(closeNotification);

        WebElement shoppingCartButton = driver.findElement(By.cssSelector("a[href='/cart'][class='ico-cart']"));
        wait.until(ExpectedConditions.visibilityOf(shoppingCartButton));
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartButton));
        actionDriver.moveToElement(shoppingCartButton).build().perform();

        WebElement goToCartButton = driver.findElement(By.cssSelector("input[type='button'][value='Go to cart']"));
        waitForVisibilityAndClickThanClick(goToCartButton);

        wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/cart"));
        Assert.assertTrue("Shopping Cart kısmına giremedi.", driver.getCurrentUrl().contains("https://demowebshop.tricentis.com/cart"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("applydiscountcouponcode")));
        WebElement applyCoupon=driver.findElement(By.name("applydiscountcouponcode"));
        waitForVisibilityAndClickThanClick(applyCoupon);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        WebElement couponError= driver.findElement(By.className("message"));
        Assert.assertTrue("Coupon hatası başarılı verilemedi.",couponError.getText().contains("The coupon code you entered couldn't be applied to your order"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("applygiftcardcouponcode")));
        WebElement applyGiftCard=driver.findElement(By.name("applygiftcardcouponcode"));
        waitForVisibilityAndClickThanClick(applyGiftCard);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        WebElement giftCardError=driver.findElement(By.className("message"));
        Assert.assertTrue("Coupon hatası başarılı verilemedi.",giftCardError.getText().contains("The coupon code you entered couldn't be applied to your order"));
    }
}
