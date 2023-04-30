package Flow;

import PageObjects.GiftPage;
import Test.TestBase;
import Test.TestExtra;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import static PageObjects.BasePage.ClearText;
import static PageObjects.BasePage.driver;

public class FlowExtra {
    TestBase testBase;
    FlowExtra flowExtra;
    GiftPage giftPage;
    public FlowExtra (WebDriver driver){
        super();

     testBase =new TestBase();
     giftPage = new GiftPage(driver);
    }
    public void FillDetailReceiver(String SOMEONE,String BLESSING) throws InterruptedException, WebDriverException {
        giftPage.WhoGetAGift("Someone Else").///Select Who get a gift
                NameWhoGetAgift(SOMEONE)./// Name who get gift
                WhatHisAEvent("HappyBirthDay")./// Select Event for Gift /// Some Reason I have bug
                BlessingText(BLESSING);///Field Text for Input Blessing
        giftPage.GetNameReceiver().
        GetBlessing();

    }
}
