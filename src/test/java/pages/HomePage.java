package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage clickLoginButton(){
        clickLinkByTitle("My Account");
        clickLink("Login");
        return new LoginPage(driver);
    }
    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
    private void clickLinkByTitle(String title){
        driver.findElement(By.xpath(String.format("//a[@title='%s']",title))).click();
    }
    private void clickYourStore(){

    }
}
