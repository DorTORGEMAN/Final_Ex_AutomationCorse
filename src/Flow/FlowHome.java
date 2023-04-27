package Flow;

import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;

public class FlowHome {

        HomePage homePage;
        LoginFlow loginFlow;
    public FlowHome(WebDriver driver){
     super();
     homePage=new HomePage(driver);
     loginFlow=new LoginFlow(driver);
    }
public void OpenWindowToLogin(){
    homePage.OpenWindowLogin();
}
public void AutomaticConnectedToUser() throws Exception {
    OpenWindowToLogin();
    Thread.sleep(60);
    loginFlow.LoginToWebsite();
}






}
