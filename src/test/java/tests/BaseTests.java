package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.HomePage;
import pages.TopBar;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseTests {
    protected static WebDriver driver;
    protected static TopBar topBar;
    private static String baseUrl = "";
    protected static String getMainUrl() {
        return System.getProperty("site.url");
    }
    @BeforeAll
    public static void setUp(){
        Properties props = System.getProperties();
        try {
            props.load(new FileInputStream(new File("resources/test.properties")));
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(getMainUrl());
        topBar = new TopBar(driver);
    }
    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
    @BeforeEach
    public void goHome(){
        driver.get(getMainUrl());
    }
}
