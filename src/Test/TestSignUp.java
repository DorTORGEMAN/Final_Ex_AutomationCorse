package Test;

import Flow.FlowHome;
import Flow.SignUpFlow;
import PageObjects.SignUpPage;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Test;

import static PageObjects.BasePage.driver;
import static PageObjects.BasePage.takeScreenShot;

public class TestSignUp extends TestBase{
    FlowHome flowHome;
    SignUpPage signUpPage;
    SignUpFlow signUpFlow;
public TestSignUp(){
    super();
    flowHome =new FlowHome(driver);
    signUpPage=new SignUpPage(driver);
    signUpFlow=new SignUpFlow(driver);
}

@Test
public void Test01_Register_to_Buyme() throws Exception {
    MyTests=extent.startTest( " Test01:Register to Buyme");
    MyTests.log(LogStatus.INFO,"Open window register");
    flowHome.OpenWindowToLogin();/////opening login window
    MyTests.log(LogStatus.INFO,"fill details for signup");
    signUpFlow.SignUpToWebsite();//fill details for signup
    signUpPage.verifyPasswords()/// check if details they same like File XML ///
            .verifyFirstName("dor")///SAME NAME FROM FILE
            .SignUp_ClickOnAgreeBOX() ///CLICK ON AGREE
            .ClickOnCreateUser();// CLICK ON CREATE USER
    MyTests.log(LogStatus.PASS,"Click On create User -HIS Pass-");
    MyTests.log(LogStatus.PASS,MyTests.addScreenCapture(takeScreenShot("C:/Users/power play/IdeaProjects/Final_Ex_AutomationCorse/TestScreenShots/test1 register")));

}
}
