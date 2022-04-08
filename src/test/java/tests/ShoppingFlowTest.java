package tests;

import dataproviders.DataProvider;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import pages.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingFlowTest extends BaseTests {
    @Test
    public void ShopTest() {
        String[] credentials = DataProvider.UsersList().get(0);
        List<String[]> products = DataProvider.ProductsList();
        List<String> productsNames = DataProvider.ProductsNames();
        LoginPage loginPage = topBar.goToLoginPage();
        loginPage.fillCredentials(credentials[0], credentials[1]);
        loginPage.clickLoginButton();
        products.forEach(product -> {
                    CategoryResultPage categoryPage = topBar.goToShowAlCategory(product[0]);
                    ProductPage productPage = categoryPage.goToProduct(product[1]);
                    productPage.addToWishList();
                }
        );
        WishListPage wishPage = topBar.goToWishList();
        List<String> wishProducts = wishPage.getProductsNames();
        assertTrue(wishProducts.containsAll(productsNames));
        wishPage.addAllToCart();
        CartPage cartPage = topBar.goToCart();
        List<String> cartProducts = cartPage.getProductsNames();
        assertTrue(cartProducts.containsAll(productsNames));
    }
}
