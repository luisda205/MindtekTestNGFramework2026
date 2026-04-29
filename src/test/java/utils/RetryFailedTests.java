package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

    int retry = 1;              // Retry counter
    int numberOfRetrys = 3;     //  max number of retry

    @Override
    public boolean retry(ITestResult iTestResult){
        if (retry < numberOfRetrys){
            retry++;            // incrementing counter
            return true;        // continue re-run
        }
        return false;           // stop re-run
    }
}
