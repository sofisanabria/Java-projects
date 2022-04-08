package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{
    private final By addToWishList = By.xpath("//button[@data-original-title='Add to Wish List']");
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public void addToWishList(){
        clickElement(addToWishList);
    }
}
