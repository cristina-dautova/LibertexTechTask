package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class DriverFactory {

    public static String DRIVER_PATH = "src/test/resources/";

    public static WebDriver createDriver(Browser browser) {

        WebDriver driver = null;
        File file;

        switch (browser) {
            case CHROME:
                file = new File(DRIVER_PATH + "chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                file = new File(DRIVER_PATH + "geckodriver.exe");
                System.setProperty("webdriver.firefox.driver", file.getAbsolutePath());
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("The browser is not supported: " + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }

}
