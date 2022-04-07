package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    protected void clickElement(By element){
        driver.findElement(element).click();
    }
    protected void clickLinkByTitle(String title){
        driver.findElement(By.xpath(String.format("//a[@title='%s']",title))).click();
    }
}
