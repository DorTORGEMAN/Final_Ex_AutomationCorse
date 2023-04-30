package Test;

import Flow.FlowGifts;
import Flow.FlowHome;
import Flow.LoginFlow;
import PageObjects.GiftPage;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import java.io.IOException;
import java.time.Duration;

import static PageObjects.BasePage.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGift extends TestBase{

    FlowHome  flowHome;
    GiftPage giftPage;
    LoginFlow loginFlow;
    FlowGifts flowGifts;
    public TestGift(){
        super();
        loginFlow= new LoginFlow(driver);
        flowHome = new FlowHome(driver);
        giftPage = new GiftPage(driver);
        flowGifts=new FlowGifts(driver);
    }
    @Test
    public void test_05_AssertUrl() throws Exception {
    MyTests=extent.startTest("Test 5 Assert url");
    MyTests.log(LogStatus.INFO,"Start test");
    MyTests.log(LogStatus.INFO,"Start fil detail to login to USER");
    //flowHome.AutomaticConnectedToUser();
    MyTests.log(LogStatus.INFO,"Select 1 From all 3 a Category");
    flowGifts.SelectCategorysGift("ils750Up","South","giftCard restaurant chef");
    String ActualUrl= driver.getCurrentUrl();
    String ExpectedUrl="https://buyme.co.il/search?budget=6&category=16&region=12";
    MyTests.log(LogStatus.INFO,"Do Assert to Url for check if she is change");
    Assert.assertEquals(ExpectedUrl,ActualUrl);
    MyTests.log(LogStatus.PASS,MyTests.addScreenCapture(takeScreenShot("C:/Users/power play/IdeaProjects/Final_Ex_AutomationCorse/TestScreenShots/Test 05 Assert Url")));
    }
    @Test
    public void test_06_SelectBusinessAndHowMuchMoney() throws IOException, InterruptedException {
        MyTests=extent.startTest("Test 6 Select Business And How Much Money You put for gift");
        MyTests.log(LogStatus.INFO,"Pick Business and Write How much Money ''Number''");
        giftPage.PickBusinessGift("BuyME-KOSHER").
                 InputMoneyAndSubmit("800");
        MyTests.log(LogStatus.PASS,MyTests.addScreenCapture(takeScreenShot("C:/Users/power play/IdeaProjects/Final_Ex_AutomationCorse/TestScreenShots/Test 06")));

    }
    @Test
    public void test_07_SelectWhoGetGiftAndEvent() throws IOException, TimeoutException, InterruptedException, NoSuchElementException  {
        MyTests=extent.startTest("Test 7 Select Who get Gift and What his A event");
        MyTests.log(LogStatus.INFO,"Select who get A gift (Yourself/Someone Else)");
        giftPage.WhoGetAGift("Someone Else").///Select Who get a gift
                    NameWhoGetAgift("Marsel")./// Name who get gift
                    WhatHisAEvent("HappyBirthDay")./// Select Event for Gift /// Some Reason I have bug
                    BlessingText("מזל טוב 140 שיהיה מלא אושר ובריאות");///Field Text for Input Blessing
        MyTests.log(LogStatus.INFO,"fill Details for to know who get gift and Write a greeting for the event");
        MyTests.log(LogStatus.PASS,MyTests.addScreenCapture(takeScreenShot("C:/Users/power play/IdeaProjects/Final_Ex_AutomationCorse/TestScreenShots/Test 07 Fill Details giver")));
        Thread.sleep(Duration.ofSeconds(16));
    }
    @Test
    public void test_08_MediaFile() throws InterruptedException, IOException {
        MyTests=extent.startTest("Test 8 upload Picture from pc to website");
        MyTests.log(LogStatus.INFO,"Pick some image from pc And do submit");
        SendKEY(giftPage.Gift_TakeSomeMediaFile,"C:\\Users\\power play\\IdeaProjects\\Final_Ex_AutomationCorse\\HappyBirthDay\\BirthdayMeme2.jpg");//Add Image and do Submit
        Thread.sleep(3000);
        MyTests.log(LogStatus.INFO,MyTests.addScreenCapture(takeScreenShot("C:/Users/power play/IdeaProjects/Final_Ex_AutomationCorse/TestScreenShots/Test 08 Upload Image to site")));
        giftPage.ClickONNextStageSubmit1();
        MyTests.log(LogStatus.PASS,"");
    }
    @Test
    public void test_09_WhoASenderAGiftAndHow() throws Exception {
        MyTests=extent.startTest("Test 9 Who A Sender and A way he send gift");
        MyTests.log(LogStatus.INFO,"Fill Detail ");
        MyTests.log(LogStatus.INFO,"Fill Email friend And Phone Number for send in Sms ");
        String emailFriend=UserFromFile("emailFriend");
        Thread.sleep(65);
        giftPage.ClickSms("0541111111").
                ClickEmail(emailFriend).
                NameASender("Joe Doe");
        MyTests.log(LogStatus.INFO,"Fill your name and you Phone Number's");
        String yourPhoneNumber=UserFromFile("phonedemo");
        giftPage.yourPhoneNumber(yourPhoneNumber).
                ClickONNextStagePay2();
        MyTests.log(LogStatus.INFO,MyTests.addScreenCapture(takeScreenShot("C:/Users/power play/IdeaProjects/Final_Ex_AutomationCorse/TestScreenShots/Test 09 details sender")));

    }

    }

