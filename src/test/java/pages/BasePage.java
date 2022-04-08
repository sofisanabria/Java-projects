package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected Actions builder;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.builder = new Actions(driver);
    }

    protected void clickElement(By element) {
        driver.findElement(element).click();
    }

    protected void clickLinkByTitle(String title) {
        clickElement(By.xpath(String.format("//a[@title='%s']", title)));
    }

    protected void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public WebElement ExplicitWaitElement(ExpectedCondition<WebElement> expectedCondition, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(expectedCondition);
    }

    public void hoverElementByLocator(By locator) {
        WebElement element = driver.findElement(locator);
        builder.moveToElement(element).build().perform();
    }

}
