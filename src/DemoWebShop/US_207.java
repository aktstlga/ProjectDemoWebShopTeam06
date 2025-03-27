package DemoWebShop;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class US_207 extends BaseDriver {
    Actions actionDriver = new Actions(driver);
    WebDriverWait waitDuration = new WebDriverWait(driver, Duration.ofSeconds(120));

    @Test
    public void unregisteredUserPoll() throws InterruptedException {
        driver.get("https://demowebshop.tricentis.com");
        waitDuration.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div[class='block block-poll']> *:nth-child(1)> *:nth-child(1)"), "COMMUNITY POLL"));

        WebElement excellentPollChoice = driver.findElement(By.id("pollanswers-1"));
        actionDriver.moveToElement(excellentPollChoice).click().build().perform();
        boolean controlExcellent = excellentPollChoice.isSelected();
        Assert.assertTrue("Excellent seçilemedi", controlExcellent);

        waitDuration.until(ExpectedConditions.elementToBeSelected(excellentPollChoice));
        WebElement goodPollChoice = driver.findElement(By.id("pollanswers-2"));
        actionDriver.moveToElement(goodPollChoice).click().build().perform();
        boolean controlGood = goodPollChoice.isSelected();
        Assert.assertTrue("Good seçilemedi", controlGood);

        waitDuration.until(ExpectedConditions.elementToBeSelected(goodPollChoice));
        WebElement poorPollChoice = driver.findElement(By.id("pollanswers-3"));
        actionDriver.moveToElement(poorPollChoice).click().build().perform();
        boolean controlPoor = poorPollChoice.isSelected();
        Assert.assertTrue("Poor seçilemedi", controlPoor);

        waitDuration.until(ExpectedConditions.elementToBeSelected(poorPollChoice));
        WebElement verybadPollChoice = driver.findElement(By.id("pollanswers-4"));
        actionDriver.moveToElement(verybadPollChoice).click().build().perform();
        boolean controlVerybad = verybadPollChoice.isSelected();
        Assert.assertTrue("Very bad seçilemedi", controlVerybad);

        waitDuration.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='Vote'][id='vote-poll-1']")));
        WebElement voteButton = driver.findElement(By.cssSelector("input[value='Vote'][id='vote-poll-1']"));
        actionDriver.moveToElement(voteButton).click().build().perform();

        waitDuration.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='poll-vote-error'][id='block-poll-vote-error-1']")));
        WebElement notMesseage=driver.findElement(By.cssSelector("div[class='poll-vote-error'][id='block-poll-vote-error-1']"));
        Assert.assertTrue("Uyarı mesajı görüntülenemedi",notMesseage.isDisplayed());

        loginMethodAccordingToUs_204();

        waitDuration.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div[class='block block-poll']> *:nth-child(1)> *:nth-child(1)"), "COMMUNITY POLL"));

        waitDuration.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='poll-total-votes']")));
        WebElement totalVotes = driver.findElement(By.cssSelector("span[class='poll-total-votes']"));
        Assert.assertTrue("Oy sonucu başarılı şekilde açıklandı.", totalVotes.getText().contains("vote(s)"));
    }
}
