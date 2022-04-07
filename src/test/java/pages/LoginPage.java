package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void fillFieldById(String id, String text){
        driver.findElement(By.id(id)).sendKeys(text);
    }
    public AccountPage clickLoginButton(){
        driver.findElement(By.cssSelector("input.btn-primary")).click();
        return new AccountPage(driver);
    }
    public void fillCredentials(String email, String password){
        fillFieldById("input-email",email);
        fillFieldById("input-password", password);
    }
}
