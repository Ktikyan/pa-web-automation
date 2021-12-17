    /*          Picsart Automation Task (Web)     */

    /*    This class defines the setup and closure of each test      */

    /*    All created test classes extend this class      */

package tests;

import listeners.Log4jLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Objects;

public class TestManager {

    WebDriver driver;
    WebDriverWait wait;
    ChromeOptions options;
    Boolean isLoggedIn;

    @BeforeTest                                                                                         // this notation tells testNG to run the setup method before each test
    public void setup(ITestContext test) {
        if (!Objects.equals(test.getName(), "JSON Schema Validator")) {                              // checking this condition to make sure no ChromeDriver instance will be created for no reason for JSON Schema Validator
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");    // setting the chromedriver.exe file's path
            options = new ChromeOptions();
            options.addArguments("--start-maximized");                                                  // this option makes the browser window maximized
            driver = new ChromeDriver(options);                                                         // initializing the Chrome Driver with desired options
            wait = new WebDriverWait(driver, 10);                                         // initializing the "wait" object with 10 second-duration timeout
            isLoggedIn = false;
        }
        Log4jLogger.logger.info("\n" + test.getName() + " test started");                                      // log4j instance logger prints the given message and saves in the logs/logs.log file
    }

    @AfterTest                                                                                          // this notation tells testNG to run the quitDriver method after each test
    public void quitDriver(ITestContext test) {
        if (!Objects.equals(test.getName(), "JSON Schema Validator")) {                              // as no driver is created for JSON Schema Validator making sure we won't get a Null pointer Exception
            driver.close();
            driver.quit();
        }
        System.out.println("\n" + "Passed tests: ");
        Log4jLogger.logger.info("\n" + test.getPassedTests() + "\n");                                                 // prints and saves the Result map of passed tests as info (I know it'd be better if I could separate value, but I didn't find a way to do so for now)
        System.out.println("Failed tests: ");
        Log4jLogger.logger.fatal("\n" + test.getFailedTests() + "\n");                                                // prints and saves the Result map of failed tests as fatal error
    }
}