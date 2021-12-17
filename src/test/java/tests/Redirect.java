    /*        Picsart Automation Task (Web)       */

    /*             Redirect Test Suite            */

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Redirect extends TestManager {
     @Test(retryAnalyzer = listeners.RetryAnalyzer.class)
     public void stayAtMainIfLoggedOut() {                                          // checks to see if there is no redirection to "picsart.com/create" when the user is logged out
         boolean redirected = false;                                                // declaring a flag to keep track of redirections
         if (driver != null) {                                                      // making sure all drivers are quited as it might have been created in another method (this will assure us that the user is logged out)
             driver.close();
             driver.quit();
         }
         driver = new ChromeDriver(options);                                        // creating a brand new ChromeDriver
         driver.get("https://picsart.com/");
         try {
             wait.until(ExpectedConditions.urlToBe("https://picsart.com/create"));  // waits to see if the page will redirect to "create" (I know this is not the best way to do this as it's becoming an implicit wait when the test passes, but that's what I could think of)
             redirected = true;
         } catch (Exception ignored) {}
         Assert.assertFalse(redirected);                                            // asserts false when redirected otherwise ends the test successfully
     }


     @Test(retryAnalyzer = listeners.RetryAnalyzer.class)
     public void redirectToCreateIfLoggedIn() {
         driver.get("https://picsart.com/");

         // getting all the fields to log in
         WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated
                 (By.xpath("//button[@data-test='login-button']")));
         loginButton.click();
         WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated
                 (By.xpath("//input[@name='username']")));
         WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated
                 (By.xpath("//input[@name='password']")));
         WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated
                 (By.xpath("//button[@data-test='login']")));

         // inputting the credentials
         usernameField.sendKeys("paqatask");
         passwordField.sendKeys("logintest1");
         login.click();

         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-test='logout-button']")));          // waits for the presence of "Log out" button which assures the user is logged in
         isLoggedIn = true;
         driver.get("https://picsart.com/");                                                                            // going to the main again after successfully logging in
         wait.until(ExpectedConditions.urlToBe("https://picsart.com/create"));                                          // waits to see if it redirects to "create" page
     }
}
