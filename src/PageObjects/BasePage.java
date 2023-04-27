package PageObjects;

import Flow.FlowHome;
import Flow.LoginFlow;
import Flow.SignUpFlow;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver;
    static WebDriverWait wait;
    static GiftPage giftPage;
    static SignUpPage signUpPage;
    static HomePage homePage;
    static LoginPage loginPage;


    public BasePage() {
        super();
    }

    public static void Browser(String Browser) throws Exception {

        switch (BrowserFromFile(Browser)) {
            case "firefox": {
                System.setProperty("web-driver.gecko.driver", "C:/קורס אוטומציה/firefox_driver/geckodriver.exe");
                driver = new FirefoxDriver();
            }
            break;
            case "chrome": {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
                driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            }
            break;
        }
    }

    public static String takeScreenShot(String ImagePath) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagePath + ".png");
        FileUtils.copyFile(screenShotFile, destinationFile);
        return ImagePath + ".png";
    }

    public static String BrowserFromFile(String keyData) throws Exception {
        File xmlFile = new File("C://Users//power play//IdeaProjects//Final_Ex_AutomationCorse//xml//browser.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyData).item(0).getTextContent();
    }

    public static String UserFromFile(String keyData) throws Exception {
        File xmlFile = new File("C://Users//power play//IdeaProjects//Final_Ex_AutomationCorse//xml//user.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyData).item(0).getTextContent();
    }

    public static void Click(By by) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        WebElement SomeElement = wait.until(ExpectedConditions.elementToBeClickable(by));
        SomeElement.click();
    }

    public static void SendKEY(By by, String Text) {
        WebElement SomeElement = driver.findElement(by);
        SomeElement.sendKeys(Text);
    }

    public static void ClearText(By by) {
        WebElement Cleartext = driver.findElement(by);
        Cleartext.clear();
    }

    public static void SelectCheckBox(By by) {
        boolean CheckBox = driver.findElement(by).isSelected();
        if (!CheckBox)
            driver.findElement(by).click();
    }

    public static void ClickLikeHuman(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    public static void SelectInList(By by, int text) {
        WebElement SelectedComboList = driver.findElement(by);
        Select Selectcombo = new Select(SelectedComboList);
        Selectcombo.selectByIndex(text);
    }

    public static void WaitForFindElementAndClick(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.click();
    }

    public static void WaitForFindElementAndSendKey(By by, String Text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.sendKeys(Text);
    }

    public static void WaitForFindElementAndPrintSize(By by, String sizeWhat) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().refresh();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        int height = element.getSize().getHeight();
        int width = element.getSize().getWidth();
        System.out.println("Height of "+sizeWhat+": "+height+"\n Width of "+sizeWhat+": "+width);
    }
    public static void WaitFindElementPrintColorAssert(By by,String rgb) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        String color = element.getCssValue("color");
        Assert.assertEquals(rgb, color);
        String Text = element.getText();
        System.out.println(Text+" Color is:"+color);
    }
    }
