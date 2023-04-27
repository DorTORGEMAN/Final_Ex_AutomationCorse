package Flow;

import PageObjects.BasePage;
import PageObjects.GiftPage;
import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;

import static PageObjects.BasePage.Click;

public class FlowGifts {
    HomePage homePage;
    GiftPage giftPage;
    public FlowGifts(WebDriver driver){
        super();
        giftPage=new GiftPage(driver);
        homePage=new HomePage(driver);}
    public void SelectCategoryGift(String Price,String Location,String Event) throws InterruptedException {
        Thread.sleep(15);
        homePage.pickPrice(Price)
                .pickLocation(Location).
                 PickCategory(Event);
        Click(homePage.HomeFindGift);
    }
}
