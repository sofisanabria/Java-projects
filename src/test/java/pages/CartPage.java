package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{
    public final By products = By.cssSelector("div.table-responsive td.text-left a");
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public List<WebElement> getProducts(){
        return driver.findElements(products);
    }
    public List<String> getProductsNames(){
        List<String> names = new ArrayList<String>();
        getProducts().forEach(x -> names.add(x.getText()));
        return names;
    }
}
