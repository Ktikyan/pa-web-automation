    /*          Picsart Automation Task (Web)         */

    /*  Retry Analyzer to rerun failed tests 3 times  */

    /*  For this to work a "(retryAnalyzer = listeners.RetryAnalyzer.class)" notation is required after @Test notation */

package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;                                            // creating a variable to track the number of times the test is retried
    private static final int maxRetryCount = 3;                            // defining the max number of times tests should be rerun

    @Override
    public boolean retry(ITestResult result) {                             // the return value of this method will decide whether rerun the test or not
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
