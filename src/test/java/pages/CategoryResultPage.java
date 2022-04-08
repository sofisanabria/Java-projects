package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CategoryResultPage extends BasePage{
    public String genericProduct = "//div[@class='product-thumb']//h4/a[text()='%s']";
    public CategoryResultPage(WebDriver driver) {
        super(driver);
    }
    public ProductPage goToProduct(String productName){
        this.clickElement(By.xpath(String.format(genericProduct,productName)));
        return new ProductPage(driver);
    }
}
