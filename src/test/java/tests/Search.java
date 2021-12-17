    /*        Picsart Automation Task (Web)       */

    /*             Search Test Suite              */

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Search extends TestManager {

    @Test(retryAnalyzer = listeners.RetryAnalyzer.class)
    public void search() {
        driver.get("https://picsart.com/blog");
        WebElement searchButton = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.className("search-form-searchButton-0-2-135"))).get(0);
        searchButton.click();
        WebElement form = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.className("search-form-searchInput-0-2-134"))).get(0);                                                    // getting the form which contains the "Search" button and the input field
        Assert.assertTrue(form.getCssValue("transform") != null && form.getCssValue("transition") != null);           // checking to see if its "transform" and "transition" style values are set
        form.sendKeys("kids");
        form.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.urlToBe("https://picsart.com/blog/search?s=kids"));                                     // waiting for it to redirect to the "Search" page
        WebElement image = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.className("image-with-overlay-overlay-0-2-40"))).get(0);
        WebElement postLink = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[3]/div/div[1]/div/div/div[1]/div/div[1]/div[1]/a")));       // I know this not a good way to do this, but I couldn't think of any other solution for now
        String href = postLink.getAttribute("href");                                                                       // getting the href attribute of the chosen post which then will be the required redirection url to check with
        image.click();
        wait.until(ExpectedConditions.urlToBe(href));
        WebElement secondPostLink = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy                              // doing the same thing with a second post
                (By.className("related-post-root-0-2-255"))).get(0);
        String href2 = secondPostLink.getAttribute("href");
        secondPostLink.click();
        wait.until(ExpectedConditions.urlToBe(href2));
    }
}
