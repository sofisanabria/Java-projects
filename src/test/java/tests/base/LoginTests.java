package tests.base;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.LoginPage;

public class LoginTests extends BaseTests {

    @ParameterizedTest
    @CsvFileSource(files = {"resources/userCredentials.csv"}, numLinesToSkip = 1)
    void successfulLogin(String email, String password) {
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.fillCredentials(email, password);
        loginPage.clickLoginButton();
    }
}
