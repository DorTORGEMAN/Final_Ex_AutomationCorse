package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public By EmailLogin=By.cssSelector("input[placeholder='מייל']");
    public By PasswordLogin=By.cssSelector("input[type='password']");
    public By CloseLogin=By.cssSelector("span[alt='סגירה'][title='סגירה']");
    public By LoginToUSER=By.cssSelector("button[type='submit'][gtm='כניסה ל-BUYME']");
    public By RegisterLogin=By.cssSelector("span[class='text-link theme']");
    public By MassageNullPasswordLogin=By.cssSelector("input[placeholder='סיסמה']+.parsley-errors-list");//if you put input something invalid you get some red error massage and elemant get tag ul .parsley-errors-list
    public By MassageNullEmailLogin=By.cssSelector("input[placeholder='מייל']+.parsley-errors-list");//if you put input something invalid you get some red error massage and elemant get tag ul .parsley-errors-list

    public LoginPage(WebDriver driver) {
        super();
    }
    public LoginPage ClickOnConnected(){
    Click(LoginToUSER);
    return loginPage=new LoginPage(driver);
    }

    public LoginPage OpenRegister(){
        Click(RegisterLogin);
        return loginPage=new LoginPage(driver);
    }
    public  LoginPage SetUp_Email() throws Exception {
        final String EMAIL = UserFromFile("email");
        //SendKEY(EmailLogin,EMAIL);
        WaitForFindElementAndSendKey(EmailLogin,EMAIL);
        return loginPage=new LoginPage(driver);
    }

    public  LoginPage SetUp_Password() throws Exception {
        final String PASSWORD =UserFromFile("password");
        //SendKEY(PasswordLogin,PASSWORD);
        WaitForFindElementAndSendKey(PasswordLogin,PASSWORD);
        return loginPage=new LoginPage(driver);
    }
    public void ClickOnConnectedToUSER(){
        Click(LoginToUSER);
    }
    public  LoginPage AssertErrorPassAndMail(){
        String emailErrorMessage = driver.findElement(MassageNullEmailLogin).getText();
        String passwordErrorMessage = driver.findElement(MassageNullPasswordLogin).getText();
        Assert.assertEquals(emailErrorMessage,"כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה");
        Boolean ErrorMail=driver.findElement(MassageNullEmailLogin).isDisplayed();
        System.out.println("Mail Error is Displayed:"+ErrorMail+"\nMail Error:"+emailErrorMessage);
        Assert.assertEquals(passwordErrorMessage,"כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה");
        Boolean ErrorPassword=driver.findElement(MassageNullPasswordLogin).isDisplayed();
        System.out.println("password Error is Displayed:"+ErrorPassword+"\npassword Error:"+passwordErrorMessage);
        return loginPage=new LoginPage(driver);}
    public void ClickOnClosePopLogin(){
        Click(CloseLogin);
    }
}
