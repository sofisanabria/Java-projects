package tests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.LoginPage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTests extends BaseTests {

    @ParameterizedTest
    @CsvFileSource(files = {"resources/userCredentials.csv"}, numLinesToSkip = 1)
    void successfulLogin(String email, String password) {
        LoginPage loginPage = topBar.goToLoginPage();
        loginPage.fillCredentials(email, password);
        loginPage.clickLoginButton();
    }
}
