package Test;

import Flow.FlowHome;
import Flow.SignUpFlow;
import PageObjects.SignUpPage;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.devtools.v109.log.model.ViolationSetting;

import static PageObjects.BasePage.driver;

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
    MyTests.log(LogStatus.INFO,"fil details for signup");
    signUpFlow.SignUpToWebsite();//fil details for signup
    signUpPage.verifyPasswords()/// check if details they same like File XML ///
            .verifyFirstName("dor")///SAME NAME FROM FILE
            .SignUp_ClickOnAgreeBOX() ///CLICK ON AGREE
            .ClickOnCreateUser();// CLICK ON CREATE USER
}
}
