package Flow;

import PageObjects.BasePage;
import PageObjects.GiftPage;
import PageObjects.HomePage;
import Test.TestBase;
import Test.TestLogin;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.time.Duration;

import static PageObjects.BasePage.Click;
import static PageObjects.BasePage.takeScreenShot;


public class FlowGifts {
    HomePage homePage;
    GiftPage giftPage;
    TestBase testBase;
    public FlowGifts(WebDriver driver){
        super();
        giftPage=new GiftPage(driver);
        homePage=new HomePage(driver);
        testBase=new TestBase();
        }
    public void SelectCategoryGift(String Price,String Location,String Event,String namePicture) throws InterruptedException, IOException {
        Thread.sleep(15);
        homePage.pickPrice(Price)
                .pickLocation(Location).
                 PickCategory(Event);
        testBase.MyTests.log(LogStatus.PASS,testBase.MyTests.addScreenCapture(takeScreenShot("C:/Users/power play/IdeaProjects/Final_Ex_AutomationCorse/TestScreenShots/"+namePicture+"")));
                 Click(homePage.HomeFindGift);}
    public void SelectCategorysGift(String Price, String Location, String Event) throws InterruptedException{
        Thread.sleep(15);
        homePage.pickPrice(Price)
                .pickLocation(Location).
                PickCategory(Event);
        Click(homePage.HomeFindGift);
        Thread.sleep(Duration.ofSeconds(15));
    }
}
