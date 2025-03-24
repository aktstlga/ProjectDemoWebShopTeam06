package DemoWebShop;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class US_206 extends BaseDriver {
    Actions actionDriver = new Actions(driver);
    WebDriverWait waitDuration = new WebDriverWait(driver, Duration.ofSeconds(120));

    @Test
    public void logInToAccount() {
        driver.get("https://demowebshop.tricentis.com");

        WebElement logIn = driver.findElement(By.className("ico-login"));
        waitForVisibilityAndClickThanClick(logIn);

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
        waitForVisibilityAndClickThanClick(submitButton);

        waitDuration.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/"));
        Assert.assertTrue("Anasayfaya yönlendirilemedi.", driver.getCurrentUrl().contains("https://demowebshop.tricentis.com/"));

        WebElement loggedAccount = driver.findElement(By.cssSelector("a[href='/customer/info'][class='account']"));
        waitDuration.until(ExpectedConditions.visibilityOf(loggedAccount));
        Assert.assertTrue("Doğru hesaba giriş yapılamadı", loggedAccount.getText().contains("team006test@gmail.com"));

        WebElement featuredProduct = driver.findElement(By.cssSelector("div[class='product-item'][data-productid='31']"));
        waitDuration.until(ExpectedConditions.visibilityOf(featuredProduct));
        actionDriver.moveToElement(featuredProduct).build().perform();

        WebElement featuredProductButton = driver.findElement(By.cssSelector("div[class='product-item'][data-productid='31']> *:nth-child(2)> *:nth-child(4)> *:nth-child(2)> *:nth-child(1)"));
        waitDuration.until(ExpectedConditions.elementToBeClickable(featuredProductButton));
        actionDriver.moveToElement(featuredProductButton).click().build().perform();

        WebElement addedNotification = driver.findElement(By.id("bar-notification"));
        waitDuration.until(ExpectedConditions.visibilityOf(addedNotification));
        Assert.assertTrue("Başarılı şekilde sepete eklenemedi.", addedNotification.getText().contains("The product has been added to your shopping cart"));

        WebElement closeNotification = driver.findElement(By.cssSelector("span[class='close'][title='Close']"));
        waitForVisibilityAndClickThanClick(closeNotification);

        WebElement shoppingCartButton = driver.findElement(By.cssSelector("a[href='/cart'][class='ico-cart']"));
        waitForVisibilityAndClickThanClick(shoppingCartButton);

        WebElement goToCartButton = driver.findElement(By.cssSelector("input[type='button'][value='Go to cart']"));
        waitForVisibilityAndClickThanClick(goToCartButton);

        waitDuration.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/cart"));
        Assert.assertTrue("Shopping Cart kısmına giremedi.", driver.getCurrentUrl().contains("https://demowebshop.tricentis.com/cart"));

        WebElement countrySelectList = driver.findElement(By.cssSelector("select[id='CountryId'][name='CountryId']"));
        waitForVisibilityAndClickThanClick(countrySelectList);
        new Select(countrySelectList).selectByIndex(1);

        WebElement stateSelectList = driver.findElement(By.cssSelector("select[id='StateProvinceId'][name='StateProvinceId']"));
        waitForVisibilityAndClickThanClick(stateSelectList);
        new Select(stateSelectList).selectByIndex(2);

        WebElement checkBoxForTermsOfService = driver.findElement(By.id("termsofservice"));
        waitForVisibilityAndClickThanClick(checkBoxForTermsOfService);

        WebElement checkoutBox = driver.findElement(By.cssSelector("button[type='submit'][id='checkout'][name='checkout'][value='checkout']"));
        waitForVisibilityAndClickThanClick(checkoutBox);
        waitDuration.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/onepagecheckout"));
        Assert.assertTrue("Checkout'a başarılı şekilde geçemedi.", driver.getCurrentUrl().contains("https://demowebshop.tricentis.com/onepagecheckout"));

        WebElement newAddressSelect = driver.findElement(By.xpath("//*[@id='billing-address-select']"));
        waitForVisibilityAndClickThanClick(newAddressSelect);
        new Select(newAddressSelect).selectByVisibleText("New Address");

        WebElement firstnameForAddressPlaceholder = driver.findElement(By.id("BillingNewAddress_FirstName"));
        addressFill(firstnameForAddressPlaceholder, "Testing");

        WebElement lastnameForAddressPlaceholder = driver.findElement(By.id("BillingNewAddress_LastName"));
        addressFill(lastnameForAddressPlaceholder, "Tester");

        WebElement emailForAddressPlaceholder = driver.findElement(By.id("BillingNewAddress_Email"));
        addressFill(emailForAddressPlaceholder, "team006test@gmail.com");

        WebElement companyNameForAddressPlaceholder = driver.findElement(By.id("BillingNewAddress_Company"));
        addressFill(companyNameForAddressPlaceholder, "TechnoStudy");

        WebElement countryForAddress = driver.findElement(By.id("BillingNewAddress_CountryId"));
        waitForVisibilityAndClickThanClick(countryForAddress);
        new Select(countryForAddress).selectByIndex(1);

        WebElement stateForAddressPlaceholder = driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
        waitForVisibilityAndClickThanClick(stateForAddressPlaceholder);
        waitDuration.until(ExpectedConditions.visibilityOf(stateForAddressPlaceholder));
        waitDuration.until(ExpectedConditions.elementToBeClickable(stateForAddressPlaceholder));
        new Select(stateForAddressPlaceholder).selectByIndex(2);

        WebElement cityForFirstAdressPlaceholder = driver.findElement(By.id("BillingNewAddress_City"));
        addressFill(cityForFirstAdressPlaceholder, "Birmingham");

        WebElement addressForFirstPlaceholder = driver.findElement(By.id("BillingNewAddress_Address1"));
        addressFill(addressForFirstPlaceholder, "Alabama.City.C");

        WebElement addressForSecondPlaceholder = driver.findElement(By.id("BillingNewAddress_Address2"));
        addressFill(addressForSecondPlaceholder, "Alabama.City.C.V2");

        WebElement zipPostalCodePlaceholder = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        addressFill(zipPostalCodePlaceholder, "36043");

        WebElement phoneNumberPlaceholder = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        addressFill(phoneNumberPlaceholder, "123123123");

        WebElement faxNumberPlaceholder = driver.findElement(By.id("BillingNewAddress_FaxNumber"));
        addressFill(faxNumberPlaceholder, "(123)-456-7890");

        WebElement submitButtonForAddressFill = driver.findElement(By.xpath("//*[@id='billing-buttons-container']/input"));
        waitForVisibilityAndClickThanClick(submitButtonForAddressFill);
        waitDuration.until(ExpectedConditions.invisibilityOf(submitButtonForAddressFill));

        WebElement checkoutBoxShipping = driver.findElement(By.id("PickUpInStore"));
        waitForVisibilityAndClickThanClick(checkoutBoxShipping);

        WebElement continueButtonShipping = driver.findElement(By.xpath("//*[@id='shipping-buttons-container']/input"));
        waitForVisibilityAndClickThanClick(continueButtonShipping);
    }

    public void addressFill(WebElement locatedElement, String sendkeysText) {
        waitDuration.until(ExpectedConditions.visibilityOf(locatedElement));
        waitDuration.until(ExpectedConditions.elementToBeClickable(locatedElement));
        locatedElement.clear();
        actionDriver.moveToElement(locatedElement).click().sendKeys(sendkeysText).build().perform();
    }

    public void waitForVisibilityAndClickThanClick(WebElement foundLocator) {
        waitDuration.until(ExpectedConditions.visibilityOf(foundLocator));
        waitDuration.until(ExpectedConditions.elementToBeClickable(foundLocator));
        actionDriver.moveToElement(foundLocator).click().build().perform();
    }
}
