package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GiftPage extends BasePage {
    protected  By Gift_BUYME_CHEF = By.cssSelector("a[href='https://buyme.co.il/supplier/752649?budget=6&category=16&query=&region=12']");
    protected  By Gift_BUYME_KOSHER = By.cssSelector("a[href='https://buyme.co.il/supplier/4299680?budget=6&category=16&query=&region=12']");
    protected   By Gift_chose = By.cssSelector("button[type='submit'][gtm='בחירה']");
    protected   By Gift_InputMONEY = By.cssSelector("input[placeholder='הכנס סכום'][type='tel']");
    protected   By WhoGet_Else = By.cssSelector("div.button-forSomeone");
    protected   By WhoGet_ME = By.cssSelector("div.button-forMyself");
    protected   By Gift_NameWhoGet = By.cssSelector("input[data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']");
    protected   By Gift_ForWhat = By.cssSelector("span[class='selected-text'][title='לאיזה אירוע?']");
    protected   By Gift_BlessingText=By.cssSelector("textarea[data-parsley-group='voucher-greeting']");
    public    By Gift_TakeSomeMediaFile=By.cssSelector("input[accept='image/png,image/jpeg,video/quicktime,video/mp4,.mov,.qt']");
    protected   By Gift_SubmitToNextStage1=By.cssSelector("button[type='submit'][gtm='המשך']");
    protected   By Gift_NameAGiverGift=By.cssSelector("input[placeholder='שם שולח המתנה'][required][type='text']");
    protected   By Gift_WayEmail=By.cssSelector("div.toggle-icon > div.circle-area > svg.method-icon[gtm='method-email']");
    protected   By Gift_WaySMS=By.cssSelector("div.toggle-icon > div.circle-area > svg.method-icon[gtm='method-sms']");
    protected   By Gift_InputEmail=By.id("email");
    protected   By Gift_InputSms=By.id("sms");
    protected   By Gift_InputYouPhone=By.cssSelector("input[placeholder='מספר נייד'][data-parsley-mobile='mobile']");
    protected   By Gift_SubmitToNextStage2=By.cssSelector("button[type='submit'][gtm='המשך לתשלום']");

    public GiftPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }
    public GiftPage() {
        super();
    }
    //------Methods-----//
    public  GiftPage PickBusinessGift(String GIFT) throws InterruptedException {
        switch (GIFT) {
            case "BuyME-CHEF": {
                Click(Gift_BUYME_CHEF);
            }
            break;
            case "BuyME-KOSHER": {
                Click(Gift_BUYME_KOSHER);
            }}
        return giftPage=new GiftPage();
    }

    public  GiftPage InputMoneyAndSubmit(String MONEY) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement elementToClick = wait.until(ExpectedConditions.elementToBeClickable(Gift_InputMONEY));
        elementToClick.sendKeys(MONEY);
        Click(Gift_chose);
        Thread.sleep(Duration.ofSeconds(15));
        return giftPage=new GiftPage();
    }

    public  GiftPage WhoGetAGift(String somebody) throws InterruptedException {
        switch (somebody) {
            case "Myself": {
                SelectCheckBox(WhoGet_ME);
            }
            break;
            case "Someone Else": {
                SelectCheckBox(WhoGet_Else);
            }
        }Thread.sleep(Duration.ofSeconds(5));
        return giftPage=new GiftPage();
    }

    public  GiftPage NameWhoGetAgift(String somebody) {
        ClearText(Gift_NameWhoGet);
        SendKEY(Gift_NameWhoGet, somebody);
        return giftPage=new GiftPage();
    }

    public  GiftPage WhatHisAEvent(String EVENT) throws InterruptedException {
        Thread.sleep(15);
        ClickElementClickable(Gift_ForWhat);
        switch (EVENT) {
            case "HappyBirthDay": {
                Click(By.cssSelector("li[value='10']"));
                Thread.sleep(Duration.ofSeconds(5));
            }
            break;
            case "marriage": {
                Click(By.cssSelector("li[value='13']"));
                Thread.sleep(Duration.ofSeconds(5));
            }break;
        }return giftPage=new GiftPage();}
    public  GiftPage BlessingText(String BlessingText){
        ClearText(Gift_BlessingText);
        SendKEY(Gift_BlessingText,BlessingText);
        return giftPage=new GiftPage();
    }
    public  GiftPage ClickONNextStageSubmit1(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement elementToClick = wait.until(ExpectedConditions.elementToBeClickable(Gift_SubmitToNextStage1));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", elementToClick);
        return giftPage=new GiftPage();}
    public  GiftPage NameASender(String name){
        ClearText(Gift_NameAGiverGift);
        SendKEY(Gift_NameAGiverGift,name);
        return giftPage=new GiftPage();
    }
    public  GiftPage ClickSms(String PhoneNumber){
        Click(Gift_WaySMS);
        ClearText(Gift_InputSms);
        SendKEY(Gift_InputSms,PhoneNumber);
        return giftPage=new GiftPage();
    }
    public  GiftPage ClickEmail(String Email){
        Click(Gift_WayEmail);
        ClearText(Gift_InputEmail);
        SendKEY(Gift_InputEmail,Email);
        return giftPage=new GiftPage();
    }
    public  GiftPage yourPhoneNumber(String Phone){
        ClearText(Gift_InputYouPhone);
        SendKEY(Gift_InputYouPhone,Phone);
        return giftPage=new GiftPage();
    }
    public  GiftPage ClickONNextStagePay2(){
        WebElement elementToClick = driver.findElement(Gift_SubmitToNextStage2);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", elementToClick);
        return giftPage=new GiftPage();}
    public GiftPage UploadPicture(String Picture){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement elementToSendKey = wait.until(ExpectedConditions.elementToBeClickable(Gift_TakeSomeMediaFile));
        By elementSendKey= (By) elementToSendKey;
        ClearText(elementSendKey);
        SendKEY(elementSendKey,Picture);
            return giftPage=new GiftPage();}


}

