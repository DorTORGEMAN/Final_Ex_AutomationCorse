package Test;

import Flow.FlowGifts;
import Flow.FlowHome;
import Flow.LoginFlow;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

import static PageObjects.BasePage.driver;
import static PageObjects.BasePage.takeScreenShot;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestHome extends TestBase{
    FlowHome flowHome;
    LoginFlow loginFlow;
    FlowGifts flowGifts;
    public TestHome(){
        super();
        loginFlow= new LoginFlow(driver);
        flowHome = new FlowHome(driver);
        flowGifts=new FlowGifts(driver);
    }
    @Test
    public void test03_Login_to_USER() throws Exception {
        MyTests=extent.startTest("Start test #3:Login to website");
        Thread.sleep(45);
        MyTests.log(LogStatus.INFO,"Start test");
        flowHome.OpenWindowToLogin();
        MyTests.log(LogStatus.INFO,"Open login Window");
        loginFlow.LoginToWebsite();
        MyTests.log(LogStatus.INFO,"Fill details login");
        MyTests.log(LogStatus.PASS,MyTests.addScreenCapture(takeScreenShot("C:/Users/power play/IdeaProjects/Final_Ex_AutomationCorse/TestScreenShots/test3 LOGIN")));}
    @Test
    public void test04_Pick_GIFT() throws InterruptedException, IOException {
        MyTests=extent.startTest("Start test #4:Pick a Gift");
        MyTests.log(LogStatus.INFO,"PICK one from all 3 Categories");
        flowGifts.SelectCategoryGift("ils750Up","South","giftCard restaurant chef","Test 4 pick gift");// PICK one from all 3 Categories and take Screenshot
        Thread.sleep(35);}
}
