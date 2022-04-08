package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{
    public AccountPage(WebDriver driver) {
        super(driver);
    }
    public HomePage clickYourStoreTitle(){
        this.clickLink("Your Store");
        return new HomePage(driver);
    }

}
