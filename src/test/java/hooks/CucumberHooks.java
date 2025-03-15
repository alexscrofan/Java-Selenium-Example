package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class CucumberHooks {

    // Use a static WebDriver instance so that it can be accessed globally
    private static WebDriver webDriver;

    @Before
    public void setup() {
        String browser = System.getenv("browser");
        if (browser == null) {
            browser = "chrome";  // default browser is chrome
        }

        // Initialize WebDriver with the specified browser
        webDriver = BrowserFactory.initDriver(browser);
    }

    @After
    public void tearDown() {
        // Clean up WebDriver after each scenario
        BrowserFactory.quitDriver();
    }

    // Getter method for accessing the WebDriver in step definition classes
    public static WebDriver getWebDriver() {
        return webDriver;
    }
}