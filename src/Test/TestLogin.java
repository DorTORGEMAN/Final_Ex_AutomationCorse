package Test;
import Flow.FlowHome;
import PageObjects.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Test;
import java.io.IOException;
import static PageObjects.BasePage.driver;
import static PageObjects.BasePage.takeScreenShot;

public class TestLogin extends TestBase{
    FlowHome flowHome;
    LoginPage loginPage;
    public TestLogin(){
        super();
        flowHome = new FlowHome(driver);
        loginPage = new LoginPage(driver);
    }


    @Test
    public void test02_Assert_Null_EmailAndPassword_Massager() throws IOException {
    MyTests=extent.startTest("Test#2 Assert Null error");
    MyTests.log(LogStatus.INFO,"test is start");
    MyTests.log(LogStatus.INFO,"Open login window");
    flowHome.OpenWindowToLogin();/////opening login window
    MyTests.log(LogStatus.INFO,"Click on Connected to User without fill Login Details");
    loginPage.ClickOnConnectedToUSER();//CLICK ON CONNECTED TO USER
    MyTests.log(LogStatus.INFO,"Check if Error is Displayed and Do Assert For check if they same ");
    loginPage.AssertErrorPassAndMail();//CHECK IF YOU GET ERROR IN EMAIL FIELD AND PASSWORD AND IF THEY SAME
    MyTests.log(LogStatus.PASS,MyTests.addScreenCapture(takeScreenShot("C:/Users/power play/IdeaProjects/Final_Ex_AutomationCorse/TestScreenShots/Test2 Assert Null")));
    loginPage.ClickOnClosePopLogin();//CLOSE WINDOW LOGIN
    }

}

