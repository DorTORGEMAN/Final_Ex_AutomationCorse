package Test;

import Flow.FlowGifts;
import Flow.FlowHome;
import Flow.LoginFlow;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static PageObjects.BasePage.driver;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestHome extends TestBase{
    FlowHome flowHome;
    LoginFlow loginFlow;
    FlowGifts flowGifts;
    public TestHome(){
        super();
        loginFlow= new LoginFlow(driver);
        flowHome = new FlowHome(driver);
        flowGifts=new FlowGifts(driver);
    }
    @Test
    public void test03_Login_to_USER() throws Exception {
        Thread.sleep(45);
        flowHome.OpenWindowToLogin();
        loginFlow.LoginToWebsite();}
    @Test
    public void test04_Pick_GIFT() throws InterruptedException {
        flowGifts.SelectCategoryGift("ils750Up","South","giftCard restaurant chef");
    }
}
