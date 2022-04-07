package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopBar extends BasePage{
    private final By loginLink = By.linkText("Login");
    private final By myAccountDrop = By.xpath("//a[@title='My Account']");
    public TopBar(WebDriver driver) {
        super(driver);
    }
    public LoginPage clickLoginLink(){
        clickElement(myAccountDrop);
        clickElement(loginLink);
        return new LoginPage(driver);
    }

}
