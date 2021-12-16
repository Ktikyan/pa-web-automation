package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ClickButtons extends TestManager {

    @Test(retryAnalyzer = listeners.RetryAnalyzer.class)
    public void clickBlog() {
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
        } catch (Exception exp) {
            System.out.println("Blog button is not in \"Learn\" dropdown so is directly on the page");
        }
        if (!blogIsInLearn) {
            WebElement blogButton = wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//a[@data-test='blog-hypertext']")));
            blogButton.click();
        }
        List<WebElement> buttons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.className("menu-navLink-0-2-29")));
        Assert.assertEquals(driver.getCurrentUrl(), "https://picsart.com/blog");
    }
}
