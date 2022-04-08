package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopBar extends BasePage{
    private final By loginLink = By.linkText("Login");
    private final By myAccountDrop = By.xpath("//a[@title='My Account']");
    private final By wishListButton = By.id("wishlist-total");
    private final String shoppingCartButton = "Shopping Cart";
    private final String genericCategory = "//a[text()='%s' and @class='dropdown-toggle']";
    private final String genericShowAll = "Show All %s";
    public TopBar(WebDriver driver) {
        super(driver);
    }
    public LoginPage goToLoginPage(){
        clickElement(myAccountDrop);
        clickElement(loginLink);
        return new LoginPage(driver);
    }
    public void hoverCategory(String categoryName){
        this.hoverElementByLocator(By.xpath(String.format(genericCategory,categoryName)));
    }
    public CategoryResultPage goToShowAlCategory(String categoryName){
        hoverCategory(categoryName);
        By locator = By.linkText(String.format(genericShowAll,categoryName));
        this.ExplicitWaitElement(
                ExpectedConditions.visibilityOfElementLocated(locator),
                5
        ).click();
        return new CategoryResultPage(driver);
    }
    public WishListPage goToWishList(){
        clickElement(wishListButton);
        return new WishListPage(driver);
    }
    public CartPage goToCart(){
        clickLinkByTitle(shoppingCartButton);
        return new CartPage(driver);
    }
}
