package Test;
import Flow.FlowHome;
import PageObjects.LoginPage;
import org.junit.Test;
import java.io.IOException;
import static PageObjects.BasePage.driver;

public class TestLogin extends TestBase{
    FlowHome flowHome;
    LoginPage loginPage;
    public TestLogin(){
        super();
        flowHome = new FlowHome(driver);
        loginPage = new LoginPage(driver);
    }


    @Test
    public void test02_Assert_Null_EmailandPassword_Massager() throws IOException {
    flowHome.OpenWindowToLogin();/////opening login window
    loginPage.ClickOnConnectedToUSER();//CLICK ON CONNECTED TO USER
    loginPage.AssertErrorPassAndMail();//CHECK IF YOU GET ERROR IN EMAIL FIELD AND PASSWORD AND IF THEY SAME
    loginPage.ClickOnClosePopLogin();//CLOSE WINDOW LOGIN
    }

}

