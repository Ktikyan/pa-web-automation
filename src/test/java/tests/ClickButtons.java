    /*          Picsart Automation Task (Web)     */

    /*           Clicking buttons Test Suite      */

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class ClickButtons extends TestManager {

    @Test(retryAnalyzer = listeners.RetryAnalyzer.class)
    public void clickButtons() {
        driver.get("https://picsart.com/");
        boolean blogIsInLearn = false;                                                          // It was weird to see that the "Blog" button is sometimes in "Learn" header sometimes directly on the bar, maybe I don't get something right
                                                                                                // that's why I created this flag to keep track of it
        try {                                                                                   // Trying to find the "Blog" button in "Learn" dropdown
            WebElement learnDropDown = wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//strong[@data-test='navigation-learn']")));
            learnDropDown.click();
            WebElement blogButton = wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//a[@data-test='blog-hypertext']")));
            blogIsInLearn = true;
            blogButton.click();
        } catch (Exception ignored) {}                                                          // this means it wasn't in the "Learn" dropdown
        if (!blogIsInLearn) {                                                                   // which means this will be executing, and it'll search the "Blog" button in headers section
            WebElement blogButton = wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//a[@data-test='blog-hypertext']")));
            blogButton.click();
        }
        wait.until(ExpectedConditions.urlToBe("https://picsart.com/blog"));                             // after clicking on "Blog" button the driver wait until it redirects to the corresponding page
        WebElement designSchool = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.className("menu-navLink-0-2-29"))).get(0);                                          // getting the "Design School" button
        designSchool.click();
        wait.until(ExpectedConditions.urlToBe("https://picsart.com/blog/category/design-school"));      // same as before
        WebElement trends = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.className("menu-navLink-0-2-29"))).get(1);                                          // getting the "Trends" button
        trends.click();
        wait.until(ExpectedConditions.urlToBe("https://picsart.com/blog/category/trends"));             // same
        WebElement picsart_pro = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.className("menu-navLink-0-2-29"))).get(2);                                          // getting the "Picsart Pro" button
        picsart_pro.click();
        wait.until(ExpectedConditions.urlToBe("https://picsart.com/blog/category/picsart-pro"));
        WebElement news = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.className("menu-navLink-0-2-29"))).get(3);                                          // getting the "News" button
        news.click();
        wait.until(ExpectedConditions.urlToBe("https://picsart.com/blog/category/news"));
    }
}
