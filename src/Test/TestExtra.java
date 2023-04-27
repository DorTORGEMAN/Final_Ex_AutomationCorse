package Test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


import java.time.Duration;

import static PageObjects.BasePage.driver;

public class TestExtra extends TestBase{
    @Test
    public void test00_dotEXTRA(){////for catch dot you must refresh before it open website
        basePage.WaitForFindElementAndPrintSize(By.cssSelector("div[class='bounce1']"),"3 dots");
    }
    @Test
    public void test01_ColorToWhoSEND() throws InterruptedException {
        driver.get("https://buyme.co.il/money/4299680?price=800");
        Thread.sleep(Duration.ofSeconds(15));
        basePage.WaitFindElementPrintColorAssert(By.cssSelector("div[class='label bottom-xs']"),"rgb(255, 161, 38)");
    }


    public void test02() {//Some reason every input is null But still all work
        PageFactory.initElements(driver,this);////find all element in website

    }
}
