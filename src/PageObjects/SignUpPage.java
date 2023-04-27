package PageObjects;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {
    public By SignUPFirstName = By.cssSelector("input[placeholder='שם פרטי']");
    protected  By SignUp_Email = By.cssSelector("input[placeholder='מייל']");
    public   By SignUpPassWORD = By.cssSelector("input[placeholder='סיסמה']");
    protected  By SignUpPassWordSecond = By.cssSelector("input[placeholder='אימות סיסמה'][data-parsley-equalto-message='הסיסמאות לא זהות, אולי זה מהתרגשות :)']");
    protected  By SignUpAgreeBox = By.cssSelector("div[class='login-options grid register-text']");

    static By SignUpNewUser = By.cssSelector("button[type='submit'][gtm='הרשמה ל-BUYME']");

    public SignUpPage(WebDriver driver) {
        super();
    }

    public  SignUpPage SetUp_First_name() throws Exception {
        final String FIRST_NAME = UserFromFile("firstname");
        SendKEY(SignUPFirstName,FIRST_NAME);
        return signUpPage=new SignUpPage(driver);
    }

    public  SignUpPage SetUp_Email() throws Exception {
        final String EMAIL = UserFromFile("email");
        SendKEY(SignUp_Email,EMAIL);
        return signUpPage=new SignUpPage(driver);
    }

    public  SignUpPage SetUp_Password() throws Exception {
        final String PASSWORD = UserFromFile("password");
        SendKEY(SignUpPassWORD,PASSWORD);
        return signUpPage=new SignUpPage(driver);
    }

    public  SignUpPage SetUp_Password2() throws Exception {
        final String PASSWORD2 = UserFromFile("password2");
        SendKEY(SignUpPassWordSecond,PASSWORD2);
        return signUpPage=new SignUpPage(driver);
    }

    public  SignUpPage SignUp_ClickOnAgreeBOX() {
        BasePage.SelectCheckBox(SignUpAgreeBox);
        return signUpPage=new SignUpPage(driver);
    }

    public  SignUpPage verifyFirstName(String TEXT) throws Exception {//////NOT WORK RIGHT ONLY FROM FILE IT WORK
        final String ExpectedFN = UserFromFile("firstname");
        String actualFN =TEXT;
        Assert.assertEquals(ExpectedFN,actualFN);
        return signUpPage=new SignUpPage(driver);
    }
    public  SignUpPage verifyPasswords() throws Exception {//NOT WORK RIGHT ONLY FROM FILE IT WORK
        //  String ExpectedPassword1=driver.findElement(SignUpPage.SignUpPassWORD).getAttribute("");
        //  String actualPassword2=driver.findElement(SignUpPage.SignUpPassWordSecond).getAttribute("");
        String ExpectedPassword1 = UserFromFile("password");
        String actualPassword2 = UserFromFile("password2");
        Assert.assertEquals(ExpectedPassword1,actualPassword2);
        System.out.println("PASSWORD1:"+ExpectedPassword1+"\nPassword2:"+actualPassword2);
        return signUpPage=new SignUpPage(driver);}

    public  SignUpPage ClickOnCreateUser(){
        Click(SignUpPage.SignUpNewUser);
        return signUpPage=new SignUpPage(driver);
    }
}