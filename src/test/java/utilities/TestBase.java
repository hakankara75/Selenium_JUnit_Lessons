package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class TestBase {
/*TestBase class'ından Obje oluşturmanın önüne geçilmesi için abstract yapılabilir
    Orn: TestBase base = new TestBase()
    Bu class'a extends ettiğimiz test classlarından ulaşabiliriz
 */

    protected static WebDriver driver;

    protected static ExtentReports extentReports; //Raporlamayı başlatır
    protected static ExtentHtmlReporter extentHtmlReporter;//Raporu HTML formatında düzenler
    protected static ExtentTest extentTest;//Tüm test aşamalarında extentTest objesi ile bilgi ekleriz
    @Before
    public void setUp() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();

        //Extent Report icin asagisi
        //----------------------------------------------------------------------------------------
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/reports/extentReport_"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);
        //Raporda gözükmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Hakan");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("HerokuApp Sayfasi Test Raporu");
        extentTest=extentReports.createTest("ExtentTest","Test Raporu");
    }

    @After
    public void tearDown() throws InterruptedException {
        extentReports.flush(); //extent report u olusturur.
        Thread.sleep(2000);
        //driver.quit();

    }

    public static void wait(int seconds) {

        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * bu metot ile bir alert gorunene kadar kodlar bekletilir
     * @param saniye yerine beklenicek sure int degeri olarak atanmali
     */
    public static void alertWait(int saniye) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    /**
     * alertten gelen texti dogrulamak icin kullanilir
     * @param str expected metindir
     * @param atr actual metindir
     */
    public static void assertTextContainsAssertTrue(String str, String atr){
        assertTrue(str.contains(atr));
        //assertEquals(str,atr);
    }

    /**
     * alerte text gondermek icin kullanilir
     * @param str alertin icine gonderilecek metindir
     */
    public static void sendKeyToAlert(String str){
        driver.switchTo().alert().sendKeys(str);

    }

    /**
     * alerti kabul edecek metot
     */
    public static void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    /**
     * alerti reddedecek metot
     */
    public static void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    /**
     * bu metot ile açık olan pencerelerden indexi verilene geçiş yapılır
     * @param window geçilmek istenen pencerenin indexi
     */
    public static void switchToWindow(int window){
        List<String> allWindowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(allWindowHandles.get(window));

    }

    /**
     * tum sayfanin screenshoot alinmasini saglar
     */
    public static void tumSayfaScreenShoot(){
        String tarih= new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu= "TestOutput/screenshot"+ tarih+ ".png";

        TakesScreenshot ts= (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    /** Bir web elementin screenshoot alinmasini saglar
     * @param element screenshoot alinacak olan elementin locate verilir
     */
    public  static void webElementScreenShoot(WebElement element){

        String tarih= new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu= "TestOutput/screenshot"+ tarih+ ".png";

        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void scrollToElementWithActions(WebDriver driver, WebElement element){
        Actions actions= new Actions(driver);
        actions.scrollToElement(element).perform();
    }
}
