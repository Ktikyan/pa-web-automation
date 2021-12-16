    /*        Picsart Automation Task (Web)       */

    /*        Tests of Redirect Test Suite        */

    package tests;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.testng.Assert;
    import org.testng.annotations.Test;

    public class Redirect extends TestManager {

        @Test(retryAnalyzer = listeners.RetryAnalyzer.class)
        public void stayAtMainIfLoggedOut() {
            boolean redirected = false;
            if (driver != null) {
                driver.close();
                driver.quit();
            }
            driver = new ChromeDriver(options);
            driver.get("https://picsart.com/");
            try {
                wait.until(ExpectedConditions.urlToBe("https://picsart.com/create"));
                System.out.println(driver.getCurrentUrl());
                redirected = true;
            } catch (Exception exp) {
                System.out.println("Did not redirect");
            }
            Assert.assertFalse(redirected);
        }


        @Test(retryAnalyzer = listeners.RetryAnalyzer.class)
        public void redirectToCreateIfLoggedIn() {
            driver.get("https://picsart.com/");
            WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//button[@data-test='login-button']")));
            loginButton.click();
            WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//input[@name='username']")));
            WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//input[@name='password']")));
            WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//button[@data-test='login']")));
            usernameField.sendKeys("paqatask");
            passwordField.sendKeys("logintest1");
            login.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-test='logout-button']")));
            isLoggedIn = true;
            driver.get("https://picsart.com/");
            wait.until(ExpectedConditions.urlToBe("https://picsart.com/create"));
        }
    }
