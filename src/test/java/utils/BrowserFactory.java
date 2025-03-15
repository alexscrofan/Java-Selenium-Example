package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    // Make the WebDriver static to share across tests
    private static WebDriver driver;

    /**
     * Instantiates specific browser object and opens the browser maximizing the window
     *
     * @param browser String browserType - chrome or safari
     * @return WebDriver instance
     */
    public static WebDriver initDriver(final String browser) {
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser type: " + browser);
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    /**
     * Quit the WebDriver instance
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}