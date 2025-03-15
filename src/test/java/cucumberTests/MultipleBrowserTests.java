package cucumberTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import hooks.CucumberHooks;

public class MultipleBrowserTests {

    private WebDriver webDriver;

    public MultipleBrowserTests() {
        this.webDriver = CucumberHooks.getWebDriver();
    }

    @Given("I open the Google homepage")
    public void openHomePage() {
        webDriver.get("http://www.google.com");
    }

    @Then("I should see the page title {string}")
    public void validatePageTitle(final String expectedTitle) {
        final String actualTitle = webDriver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle, "Page title is not correct !");
    }
}