package Test;

import Flow.FlowExtra;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


import java.io.IOException;
import java.time.Duration;

import static PageObjects.BasePage.driver;
import static PageObjects.BasePage.takeScreenShot;

public class TestExtra extends TestBase{
    FlowExtra flowExtra;
    public TestExtra(){
        super();
        flowExtra=new FlowExtra(driver);
    }
    @Test
    public void test00_dotEXTRA() throws IOException {////for catch dot you must refresh before it open website
        MyTests=extent.startTest("test00 extra 3 dot size");
        MyTests.log(LogStatus.INFO,"TRY TO CATCH 3 DOT IN START");
        basePage.WaitForFindElementAndPrintSize(By.cssSelector("div[class='bounce1']"),"3 dots");
        MyTests.log(LogStatus.PASS,MyTests.addScreenCapture(takeScreenShot("C:/Users/power play/IdeaProjects/Final_Ex_AutomationCorse/TestScreenShots/test0 EX 3DOT")));
    }
    @Test
    public void test01_ExtraColorToWhoSEND() throws InterruptedException, IOException {
        MyTests=extent.startTest("test01 Ex Color Who SEND");
        MyTests.log(LogStatus.INFO,"TRY TO CATCH COLOR OF ELEMENT ");
        driver.get("https://buyme.co.il/money/4299680?price=800");
        Thread.sleep(Duration.ofSeconds(15));
        basePage.WaitFindElementPrintColorAssert(By.cssSelector("div[class='label bottom-xs']"),"rgb(255, 161, 38)");
        MyTests.log(LogStatus.PASS,MyTests.addScreenCapture(takeScreenShot("C:/Users/power play/IdeaProjects/Final_Ex_AutomationCorse/TestScreenShots/test1")));

    }

  /*/  @Test   /////NOT WORK
    public void test02_ExtraDetailsGetAttributeAssert() throws InterruptedException {//Some reason every input is null But still all work
        PageFactory.initElements(driver,this);////find all element in website
        flowExtra.FillDetailReceiver("dor","MAZAL TOV");

    }/*/
}
