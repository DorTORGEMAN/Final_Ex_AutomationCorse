package Test;

import Flow.FlowGifts;
import Flow.FlowHome;
import Flow.LoginFlow;
import PageObjects.GiftPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;



import static PageObjects.BasePage.SendKEY;
import static PageObjects.BasePage.UserFromFile;
import static PageObjects.BasePage.driver;
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
    flowHome.AutomaticConnectedToUser();
    flowGifts.SelectCategoryGift("ils750Up","South","giftCard restaurant chef");
    String ActualUrl= driver.getCurrentUrl();
    String ExpectedUrl="https://buyme.co.il/search?budget=6&category=16&region=12";
    Assert.assertEquals(ExpectedUrl,ActualUrl);
    }
    @Test
    public void test_06_SelectBusinessAndHowMuchMoney() {
        giftPage.PickBusinessGift("BuyME-KOSHER").
                 InputMoneyAndSubmit("800");
    }
    @Test
    public void test_07_SelectWhoGetGiftAndEvent() {
        giftPage.WhoGetAGift("Someone Else").///Select Who get a gift
                    NameWhoGetAgift("Marsel")./// Name who get gift
                    WhatHisAEvent("HappyBirthDay")./// Select Event for Gift
                    BlessingText("מזל טוב 140 שיהיה מלא אושר ובריאות");///Field Text for Input Blessing
    }
    @Test
    public void test_08_MediaFile() throws InterruptedException {//Add Image and do Submit
        SendKEY(giftPage.Gift_TakeSomeMediaFile, "C:\\Users\\power play\\IdeaProjects\\Final_Ex_AutomationCorse\\HappyBirthDay\\BirthdayMeme2.jpg");
        Thread.sleep(3000);
        giftPage.ClickONNextStageSubmit1();
    }
    @Test
    public void test_09_WhoASenderAGiftAndHow() throws Exception {
        String emailFriend=UserFromFile("emailFriend");
        Thread.sleep(65);
        giftPage.ClickSms("0515411111").
                ClickEmail(emailFriend).
                NameASender("dodo");
        String yourPhoneNumber=UserFromFile("phonedemo");
        giftPage.yourPhoneNumber(yourPhoneNumber).
                ClickONNextStagePay2();
    }

    }

