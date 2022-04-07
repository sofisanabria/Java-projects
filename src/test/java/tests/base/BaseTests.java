package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseTests {
    protected static WebDriver driver;
    protected static HomePage homePage;
    @BeforeClass
    public static void setUp(){
        Properties props = System.getProperties();
        try {
            props.load(new FileInputStream(new File("resources/test.properties")));
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(System.getProperty("site.url"));
        homePage = new HomePage(driver);
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
    @BeforeEach
    public void goHome(){
        driver.get(System.getProperty("site.url"));
    }
}
