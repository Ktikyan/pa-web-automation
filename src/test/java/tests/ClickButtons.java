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
        boolean blogIsInLearn = false;
        try {
            WebElement learnDropDown = wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//strong[@data-test='navigation-learn']")));
            WebElement blogButton = wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//a[@data-test='blog-hypertext']")));
            blogIsInLearn = true;
            learnDropDown.click();
            blogButton.click();
        } catch (Exception ignored) {}
        if (!blogIsInLearn) {
            WebElement blogButton = wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//a[@data-test='blog-hypertext']")));
            blogButton.click();
        }
        wait.until(ExpectedConditions.urlToBe("https://picsart.com/blog"));
        WebElement designSchool = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.className("menu-navLink-0-2-29"))).get(0);
        designSchool.click();
        wait.until(ExpectedConditions.urlToBe("https://picsart.com/blog/category/design-school"));
        WebElement trends = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.className("menu-navLink-0-2-29"))).get(1);
        trends.click();
        wait.until(ExpectedConditions.urlToBe("https://picsart.com/blog/category/trends"));
        WebElement picsart_pro = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.className("menu-navLink-0-2-29"))).get(2);
        picsart_pro.click();
        wait.until(ExpectedConditions.urlToBe("https://picsart.com/blog/category/picsart-pro"));
        WebElement news = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.className("menu-navLink-0-2-29"))).get(3);
        news.click();
        wait.until(ExpectedConditions.urlToBe("https://picsart.com/blog/category/news"));
    }
}
