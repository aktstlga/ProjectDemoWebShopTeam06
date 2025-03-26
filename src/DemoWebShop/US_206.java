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
    public void ordering() {
        driver.get("https://demowebshop.tricentis.com");

        WebElement logIn = driver.findElement(By.className("ico-login"));
        waitForVisibilityAndClickThanClick(logIn);

        waitDuration.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/login"));

        WebElement emailPlaceholder = driver.findElement(By.id("Email"));
        fillingThePlaceholderWithWait(emailPlaceholder, "team006test@gmail.com");

        WebElement passwordPlaceholder = driver.findElement(By.id("Password"));
        fillingThePlaceholderWithWait(passwordPlaceholder, "Password123");

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
        countrySelectList.click();

        waitDuration.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[id='StateProvinceId'][name='StateProvinceId']")));
        WebElement stateSelectList = driver.findElement(By.cssSelector("select[id='StateProvinceId'][name='StateProvinceId']"));
        waitForVisibilityAndClickThanClick(stateSelectList);
        waitDuration.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("select[id='StateProvinceId'][name='StateProvinceId']"), "AA (Armed Forces Americas)"));
        new Select(stateSelectList).selectByVisibleText("Alabama");
        stateSelectList.click();

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
        fillingThePlaceholderWithWait(firstnameForAddressPlaceholder, "Testing");

        WebElement lastnameForAddressPlaceholder = driver.findElement(By.id("BillingNewAddress_LastName"));
        fillingThePlaceholderWithWait(lastnameForAddressPlaceholder, "Tester");

        WebElement emailForAddressPlaceholder = driver.findElement(By.id("BillingNewAddress_Email"));
        fillingThePlaceholderWithWait(emailForAddressPlaceholder, "team006test@gmail.com");

        WebElement companyNameForAddressPlaceholder = driver.findElement(By.id("BillingNewAddress_Company"));
        fillingThePlaceholderWithWait(companyNameForAddressPlaceholder, "TechnoStudy");

        WebElement countryForAddress = driver.findElement(By.id("BillingNewAddress_CountryId"));
        waitForVisibilityAndClickThanClick(countryForAddress);
        new Select(countryForAddress).selectByIndex(1);
        countryForAddress.click();

        WebElement stateForAddressPlaceholder = driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
        waitDuration.until(ExpectedConditions.textToBePresentInElementLocated(By.id("BillingNewAddress_StateProvinceId"), "AA (Armed Forces Americas)"));
        waitForVisibilityAndClickThanClick(stateForAddressPlaceholder);
        new Select(stateForAddressPlaceholder).selectByVisibleText("Alabama");
        stateForAddressPlaceholder.click();

        WebElement cityForFirstAddressPlaceholder = driver.findElement(By.id("BillingNewAddress_City"));
        fillingThePlaceholderWithWait(cityForFirstAddressPlaceholder, "Birmingham");

        WebElement addressForFirstPlaceholder = driver.findElement(By.id("BillingNewAddress_Address1"));
        fillingThePlaceholderWithWait(addressForFirstPlaceholder, "Alabama.City.C");

        WebElement addressForSecondPlaceholder = driver.findElement(By.id("BillingNewAddress_Address2"));
        fillingThePlaceholderWithWait(addressForSecondPlaceholder, "Alabama.City.C.V2");

        WebElement zipPostalCodePlaceholder = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        fillingThePlaceholderWithWait(zipPostalCodePlaceholder, "36043");

        WebElement phoneNumberPlaceholder = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        fillingThePlaceholderWithWait(phoneNumberPlaceholder, "123123123");

        WebElement faxNumberPlaceholder = driver.findElement(By.id("BillingNewAddress_FaxNumber"));
        fillingThePlaceholderWithWait(faxNumberPlaceholder, "(123)-456-7890");

        WebElement submitButtonForAddressFill = driver.findElement(By.xpath("//*[@id='billing-buttons-container']/input"));
        waitForVisibilityAndClickThanClick(submitButtonForAddressFill);
        waitDuration.until(ExpectedConditions.invisibilityOf(submitButtonForAddressFill));

        WebElement checkoutBoxShipping = driver.findElement(By.id("PickUpInStore"));
        waitForVisibilityAndClickThanClick(checkoutBoxShipping);

        WebElement shippingContinueButton = driver.findElement(By.cssSelector("input[title='Continue'][value='Continue'][onclick='Shipping.save()']"));
        shippingContinueButton.click();

        waitDuration.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='paymentmethod_2']")));
        WebElement creditCardPaymentMethod = driver.findElement(By.xpath("//*[@id='paymentmethod_2']"));
        waitForVisibilityAndClickThanClick(creditCardPaymentMethod);

        waitDuration.until(ExpectedConditions.elementToBeSelected(creditCardPaymentMethod));
        WebElement continueButtonPayment = driver.findElement(By.cssSelector("input[value='Continue'][onclick='PaymentMethod.save()"));
        continueButtonPayment.click();

        waitDuration.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCardType")));
        WebElement selectCreditCard = driver.findElement(By.id("CreditCardType"));
        waitForVisibilityAndClickThanClick(selectCreditCard);
        waitDuration.until(ExpectedConditions.textToBePresentInElementLocated(By.id("CreditCardType"), "Visa"));
        new Select(selectCreditCard).selectByVisibleText("Visa");
        selectCreditCard.click();

        WebElement cardholderNamePlaceholder = driver.findElement(By.id("CardholderName"));
        fillingThePlaceholderWithWait(cardholderNamePlaceholder, "Tester");

        WebElement cardNumberPlaceholder = driver.findElement(By.id("CardNumber"));
        fillingThePlaceholderWithWait(cardNumberPlaceholder, "4242 4242 4242 4242");

        waitDuration.until(ExpectedConditions.visibilityOfElementLocated(By.id("ExpireMonth")));
        WebElement selectMonth = driver.findElement(By.id("ExpireMonth"));
        waitForVisibilityAndClickThanClick(selectMonth);
        waitDuration.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ExpireMonth"), "01"));
        new Select(selectMonth).selectByVisibleText("01");
        selectMonth.click();

        waitDuration.until(ExpectedConditions.visibilityOfElementLocated(By.id("ExpireYear")));
        WebElement selectYear = driver.findElement(By.id("ExpireYear"));
        waitForVisibilityAndClickThanClick(selectYear);
        waitDuration.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ExpireYear"), "2025"));
        new Select(selectYear).selectByVisibleText("2032");
        selectYear.click();

        WebElement cardCodePlaceholder = driver.findElement(By.id("CardCode"));
        fillingThePlaceholderWithWait(cardCodePlaceholder, "123");

        WebElement continueButtonForPayment = driver.findElement(By.xpath("//*[@id='payment-info-buttons-container']/input"));
        continueButtonForPayment.click();

        waitDuration.until(ExpectedConditions.invisibilityOf(continueButtonForPayment));
        WebElement productOnTheBasket = driver.findElement(By.cssSelector("a[href='/141-inch-laptop'][class='product-name']"));
        Assert.assertTrue("Doğru ürün listede değil.", productOnTheBasket.getText().contains("14.1-inch Laptop"));

        WebElement productQuantity = driver.findElement(By.cssSelector("td[class='qty nobr']> *:nth-child(2)"));
        Assert.assertTrue("Üründen 1 adet yok.", productQuantity.getText().contains("1"));

        WebElement confirmOrderButton = driver.findElement(By.xpath("//*[@id='confirm-order-buttons-container']/input"));
        actionDriver.scrollToElement(confirmOrderButton).moveToElement(confirmOrderButton).click().build().perform();

        waitDuration.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/checkout/completed/"));
        WebElement confirmMesseage=driver.findElement(By.cssSelector("div[class='title']> *:nth-child(1)"));
        Assert.assertTrue("Başarılı onay mesajı alınamadı.",confirmMesseage.getText().contains("Your order has been successfully processed!"));
    }
}
