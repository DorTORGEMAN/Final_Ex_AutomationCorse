package Flow;

import PageObjects.LoginPage;
import PageObjects.SignUpPage;
import org.openqa.selenium.WebDriver;

public class SignUpFlow {
    SignUpPage signUpPage;
    LoginPage loginPage;
    public SignUpFlow(WebDriver driver){
        super();
        signUpPage=new SignUpPage(driver);
        loginPage=new LoginPage(driver);}
    public  void SignUpToWebsite() throws Exception {
            loginPage.OpenRegister();
            signUpPage.SetUp_First_name();
            signUpPage.SetUp_Email();
            signUpPage.SetUp_Password();
            signUpPage.SetUp_Password2();
    }
}
