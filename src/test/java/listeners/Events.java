    /*      Picsart Automation Task (Web)            */

    /*              Custom events                    */

package listeners;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.function.Function;

    public class Events {
        public static Function<WebDriver, Boolean> pageIsLoaded(WebDriver webDriver) {
            return driver -> ((JavascriptExecutor) webDriver).
                    executeScript("return document.readyState").equals("complete");
        }
    }

