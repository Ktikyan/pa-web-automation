    /*          Picsart Automation Task (Web)     */

    /*    This class defines the setup and closure of each test      */

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
            if (!Objects.equals(test.getName(), "JSON Schema Validator")) {
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");    // setting the chromedriver.exe file's path
                options = new ChromeOptions();
                options.addArguments("--start-maximized");                                                  // this option makes the browser window maximized
                driver = new ChromeDriver(options);                                                         // initializing the Chrome Driver with desired options
                wait = new WebDriverWait(driver, 10);                                         // initializing the "wait" object with 10 second-duration timeout
                isLoggedIn = false;
            }
            Log4jLogger.logger.info(test.getName() + " test started");
        }

        @AfterTest                                                                                          // this notation tells testNG to run the quitDriver method after each test
        public void quitDriver(ITestContext test) {
            if (!Objects.equals(test.getName(), "JSON Schema Validator")) {
                driver.close();
                driver.quit();
            }
            Log4jLogger.logger.info(test.getPassedTests() + " passed");
            Log4jLogger.logger.fatal(test.getFailedTests() + " failed");
        }
    }
