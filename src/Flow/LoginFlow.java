package Flow;

import PageObjects.BasePage;
import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static PageObjects.BasePage.driver;

public class LoginFlow {
    LoginPage loginPage;

    public LoginFlow(WebDriver driver){
    super();
      loginPage=new LoginPage(driver);}

    public void LoginToWebsite() throws Exception {
            loginPage.SetUp_Email()
                     .SetUp_Password()
                     .ClickOnConnected();
       }
}
