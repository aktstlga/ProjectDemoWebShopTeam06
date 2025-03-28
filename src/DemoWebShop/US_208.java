package DemoWebShop;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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

        WebElement countrySelectList = driver.findElement(By.cssSelector("select[id='CountryId'][name='CountryId']"));
        waitForVisibilityAndClickThanClick(countrySelectList);
        new Select(countrySelectList).selectByIndex(1);
        countrySelectList.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[id='StateProvinceId'][name='StateProvinceId']")));
        WebElement stateSelectList = driver.findElement(By.cssSelector("select[id='StateProvinceId'][name='StateProvinceId']"));
        waitForVisibilityAndClickThanClick(stateSelectList);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("select[id='StateProvinceId'][name='StateProvinceId']"), "AA (Armed Forces Americas)"));
        new Select(stateSelectList).selectByVisibleText("Alabama");
        stateSelectList.click();

        WebElement checkBoxForTermsOfService = driver.findElement(By.id("termsofservice"));
        waitForVisibilityAndClickThanClick(checkBoxForTermsOfService);

        WebElement checkoutBox = driver.findElement(By.cssSelector("button[type='submit'][id='checkout'][name='checkout'][value='checkout']"));
        waitForVisibilityAndClickThanClick(checkoutBox);
        wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/onepagecheckout"));
        Assert.assertTrue("Checkout'a başarılı şekilde geçemedi.", driver.getCurrentUrl().contains("https://demowebshop.tricentis.com/onepagecheckout"));

        WebElement addressChoice = driver.findElement(By.cssSelector("select[name='billing_address_id']> *:nth-child(1)"));

        if (!addressChoice.getAttribute("value").isEmpty()) {
            WebElement submitButtonForAddressFill = driver.findElement(By.xpath("//*[@id='billing-buttons-container']/input"));
            waitForVisibilityAndClickThanClick(submitButtonForAddressFill);
            wait.until(ExpectedConditions.invisibilityOf(submitButtonForAddressFill));
        }

        if (addressChoice.getAttribute("value").isEmpty()) {
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
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("BillingNewAddress_StateProvinceId"), "AA (Armed Forces Americas)"));
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
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PickUpInStore")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("PickUpInStore")));
        WebElement checkoutBoxShipping = driver.findElement(By.id("PickUpInStore"));
        waitForVisibilityAndClickThanClick(checkoutBoxShipping);

        WebElement shippingContinueButton = driver.findElement(By.cssSelector("input[title='Continue'][value='Continue'][onclick='Shipping.save()']"));
        shippingContinueButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='paymentmethod_2']")));
        WebElement creditCardPaymentMethod = driver.findElement(By.xpath("//*[@id='paymentmethod_2']"));
        waitForVisibilityAndClickThanClick(creditCardPaymentMethod);

        wait.until(ExpectedConditions.elementToBeSelected(creditCardPaymentMethod));
        actionDriver.scrollByAmount(0, 300);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='Continue'][onclick='PaymentMethod.save()")));
        WebElement continueButtonPayment = driver.findElement(By.cssSelector("input[value='Continue'][onclick='PaymentMethod.save()"));
        continueButtonPayment.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCardType")));
        WebElement selectCreditCard = driver.findElement(By.id("CreditCardType"));
        waitForVisibilityAndClickThanClick(selectCreditCard);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("CreditCardType"), "Visa"));
        new Select(selectCreditCard).selectByVisibleText("Visa");
        selectCreditCard.click();

        WebElement cardholderNamePlaceholder = driver.findElement(By.id("CardholderName"));
        fillingThePlaceholderWithWait(cardholderNamePlaceholder, "Tester");

        WebElement cardNumberPlaceholder = driver.findElement(By.id("CardNumber"));
        fillingThePlaceholderWithWait(cardNumberPlaceholder, "4242 4242 4242 4242");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ExpireMonth")));
        WebElement selectMonth = driver.findElement(By.id("ExpireMonth"));
        waitForVisibilityAndClickThanClick(selectMonth);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ExpireMonth"), "01"));
        new Select(selectMonth).selectByVisibleText("01");
        selectMonth.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ExpireYear")));
        WebElement selectYear = driver.findElement(By.id("ExpireYear"));
        waitForVisibilityAndClickThanClick(selectYear);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ExpireYear"), "2025"));
        new Select(selectYear).selectByVisibleText("2032");
        selectYear.click();

        WebElement cardCodePlaceholder = driver.findElement(By.id("CardCode"));
        fillingThePlaceholderWithWait(cardCodePlaceholder, "123");

        WebElement continueButtonForPayment = driver.findElement(By.xpath("//*[@id='payment-info-buttons-container']/input"));
        continueButtonForPayment.click();

        wait.until(ExpectedConditions.invisibilityOf(continueButtonForPayment));
        WebElement productOnTheBasket = driver.findElement(By.cssSelector("a[href='/141-inch-laptop'][class='product-name']"));
        Assert.assertTrue("Doğru ürün listede değil.", productOnTheBasket.getText().contains("14.1-inch Laptop"));

        WebElement productQuantity = driver.findElement(By.cssSelector("td[class='qty nobr']> *:nth-child(2)"));
        Assert.assertTrue("Üründen 1 adet yok.", productQuantity.getText().contains("1"));
        String quantityOfProductOnPayment = productQuantity.getAttribute("value");

        WebElement confirmOrderButton = driver.findElement(By.xpath("//*[@id='confirm-order-buttons-container']/input"));
        actionDriver.scrollToElement(confirmOrderButton).moveToElement(confirmOrderButton).click().build().perform();

        wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/checkout/completed/"));
        WebElement confirmMesseage = driver.findElement(By.cssSelector("div[class='title']> *:nth-child(1)"));
        Assert.assertTrue("Başarılı onay mesajı alınamadı.", confirmMesseage.getText().contains("Your order has been successfully processed!"));

        WebElement continueButtonAtCheckout = driver.findElement(By.cssSelector("input[value='Continue']"));
        actionDriver.moveToElement(continueButtonAtCheckout).click().build().perform();
        wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/"));
        Assert.assertTrue("İşlem başarıyla tamamlanamadı.", wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/")));
    }
}
