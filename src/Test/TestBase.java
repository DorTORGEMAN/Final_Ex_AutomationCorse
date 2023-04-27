package Test;

import Flow.FlowHome;
import Flow.LoginFlow;
import Flow.SignUpFlow;
import PageObjects.BasePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.time.Duration;

import static PageObjects.BasePage.*;

public class TestBase {
   protected static ExtentReports extent;
   protected static ExtentTest MyTests;
   protected static String reportFilePath="C:/Users/power play/IdeaProjects/Final_Ex_AutomationCorse/extent-report.html";


    public TestBase() {
    }
    static BasePage basePage;
    static TestGift testGift;
    static TestHome testHome;
    static TestLogin testLogin;
    static TestSignUp testSignUp;
    static TestExtra testExtra;
    static LoginFlow loginFlow;
    static SignUpFlow signUpFlow;
    static FlowHome flowHome;
    @BeforeClass
    public static void SetUp() throws Exception {
        extent =new ExtentReports(reportFilePath);
        MyTests = extent.startTest("Ready To start");
        Browser("Browser");
        final String URL_WEBSITE= BrowserFromFile("url");
        driver.get(URL_WEBSITE);
        driver.manage().window().maximize();

    }

    @AfterClass
    public static void FinishTest() throws InterruptedException {
        extent.endTest(MyTests);
        extent.flush();
        Thread.sleep(Duration.ofSeconds(10));
        driver.quit();
    }
}
